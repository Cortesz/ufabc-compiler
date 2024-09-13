package io.compiler.core.ast;

import io.compiler.types.Types;

public class AttributeCommand extends Command{
    private String varId;
    private Types varType;
    private String content;

    public String getVarId() {
        return varId;
    }

    public void setVarId(String varId) {
        this.varId = varId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
    public Types getVarType() {
        return varType;
    }

    public void setVarType(Types varType) {
        this.varType = varType;
    }

    public AttributeCommand(String varId,Types varType, String content) {
        this.varId = varId;
        this.varType = varType;
        this.content = content;
    }

    public AttributeCommand(String varId) {
        this.varId = varId;
    }

    public AttributeCommand(String varId, Types varType){
        this.varId = varId;
        this.varType = varType;
    }

    public AttributeCommand() {
    }

    @Override
    public String generateTargetJava() {
        return this.getVarId() + " = "+ this.getContent() + ";\n";
    }

    @Override
    public String generateTargetC() {
            if (varType == Types.TEXT) {
                return "strcpy("+this.varId+","+this.getContent()+");\n";
            }
            return this.getVarId() + " = "+ this.getContent() + ";\n";
    }


}
