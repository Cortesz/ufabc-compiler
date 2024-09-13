package io.compiler.core.ast;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class ReadCommand extends Command{
    private Var var;


    public ReadCommand(Var var) {
        this.var = var;
    }

    public ReadCommand() {
    }

    public Var getVar() {
        return var;
    }


    public void setVar(Var var) {
        this.var = var;
    }
       

    @Override
    public String generateTargetJava() {
        return var.getId() +"="+ ((var.getType()==Types.NUMBER)?" _scTrx.nextInt();":"_scTrx.nextLine();")+"\n";
    }

    @Override
    public String generateTargetC() {
        if (var.getType() == Types.NUMBER) {
            return "scanf(\"%lf\",&"+var.getId()+");\n";
        }
        return "scanf(\"%s\",&"+var.getId()+");\n";
    }

}
