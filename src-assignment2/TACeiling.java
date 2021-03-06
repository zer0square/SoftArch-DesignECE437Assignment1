import java.util.ArrayList;

import static java.lang.StrictMath.ceil;
/*
Type Abstraction for ceiling operation
*/
public class TACeiling extends TAInt implements TATerm {

    private int value_ceiling;
    private TADouble operand;
    private String name = null;

    TACeiling(TADouble d){

        operand = d;
    }

    TACeiling(String s, TADouble d) throws Exception {

        NamesChecker.check(s);
        name = s;
        operand = d;
    }

    public Integer getValue(){

        return value_ceiling;
    }

    public void evaluate(){

        value_ceiling = (int)(ceil((double)operand.getValue()));
    }

    @Override
    public TAPrimitive getValueTA() {
        return new TAConstant(value_ceiling);
    }

    public void list(){

        if(name == null)
        {
            System.out.print("( ceiling ");
            operand.list();
            System.out.print(" )");
        }

        else
            System.out.print(name);
    }

    public ArrayList getOperands(){
        ArrayList opList = new ArrayList();
        opList.add(operand.getOperands());
        return opList;
    }

}
