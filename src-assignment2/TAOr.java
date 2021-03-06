import java.util.ArrayList;

/*
Type Abstraction of or operation
*/
public class TAOr extends TABool implements TAFormula {

    private Boolean value_or;
    private TABool operand1, operand2;
    private String name = null;

    TAOr(TABool a, TABool b){

        operand1 = a;
        operand2 = b;
    }

    TAOr(String s, TABool a, TABool b) throws Exception {

        NamesChecker.check(s);
        name = s;
        operand1 = a;
        operand2 = b;
    }

    public Boolean getValue() {

        return value_or;
    }

    public void evaluate(){

        value_or = operand1.getValue() || operand2.getValue();
    }

    @Override
    public TAPrimitive getValueTA() {
        return new TABool(value_or);
    }

    public void list(){
        if(name == null) {

            System.out.print("(or ");
            operand1.list();
            System.out.print(" ");
            operand2.list();
            System.out.print(" )");
        }

        else
            System.out.print(name);

    }

    public ArrayList getOperands(){
        ArrayList opList = new ArrayList();
        opList.addAll(operand1.getOperands());
        opList.addAll(operand2.getOperands());
        return opList;
    }

    public void printState(){
        System.out.println(value_or);
    }


}
