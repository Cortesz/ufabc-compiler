from flask import Flask, request, jsonify, send_file
import subprocess
import os
import uuid
import shutil

app = Flask(__name__)

# Dictionary to store file_id and original filename
file_info = {}

@app.route('/files', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return jsonify({'error': 'No file part'}), 400
    file = request.files['file']
    if file.filename == '':
        return jsonify({'error': 'No selected file'}), 400

    file_id = str(uuid.uuid4())
    original_filename = file.filename
    file_path = os.path.join(os.getcwd(), original_filename)
    file.save(file_path)

    file_info[file_id] = original_filename

    subprocess.run(['java', '-cp', 'target/ufabc-compiler-1.0-SNAPSHOT.jar:antlr-4.13.2-complete.jar', 'src/main/java/io/compiler/main/MainClass.java', file_path])

    return jsonify({'file_id': file_id, 'filename': original_filename}), 202

@app.route('/files/<file_id>', methods=['GET'])
def get_file_status(file_id):
    java_file = os.path.join(os.getcwd(), 'compilerTest.java')
    c_file = os.path.join(os.getcwd(), 'compilerTest.c')

    print(f"Checking for files: {java_file}, {c_file}")

    if os.path.exists(java_file) and os.path.exists(c_file):
        return jsonify({'status': 'completed', 'java_file': java_file, 'c_file': c_file})
    else:
        return jsonify({'status': 'processing'}), 202

@app.route('/files/<file_id>/<file_type>', methods=['GET'])
def download_file(file_id, file_type):
    file_path = os.path.join(os.getcwd(), f'compilerTest.{file_type}')

    print(f"Attempting to send file: {file_path}")

    if os.path.exists(file_path):
        response = send_file(file_path, as_attachment=True)
        os.remove(file_path)

        original_file_path = os.path.join(os.getcwd(), file_info[file_id])
        if os.path.exists(original_file_path):
            os.remove(original_file_path)

        uploads_dir = os.path.join(os.getcwd(), 'uploads')
        if os.path.exists(uploads_dir):
            shutil.rmtree(uploads_dir)

        return response
    else:
        return jsonify({'error': 'File not found'}), 404

if __name__ == '__main__':
    app.run(debug=True)
