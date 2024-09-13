package io.compiler.core.ast;

import java.util.HashMap;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class WriteCommand extends Command{
    private String content;
    private HashMap<String, Var> symbolTable;

    @Override
    public String generateTargetC() {

    for (Var v : symbolTable.values()) {
        if (content.equals(v.getId())) {
            if (v.getType() == Types.NUMBER) {
                return "printf(\"%f\\n\","+content+");\n";
            }
            return "printf(\"%s\\n\","+content+");\n";
        }
    }
        return "printf("+content+");\n";
    }


    @Override
    public String generateTargetJava() {
        return "System.out.println("+content+");\n";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WriteCommand(String content) {
        super();
        this.content = content;
    }

    public WriteCommand() {
        super();
    }


    public WriteCommand(String content, HashMap<String, Var> symbolTable) {
        this.content = content;
        this.symbolTable = symbolTable;
    }

    
    
}
