import java.util.ArrayList;

/*
Type Abstraction for equals boolean operation
 */
public class TAEquals extends TABool implements TAFormula {

    private Boolean value_equals;
    private TANumber operand1, operand2;
    private String name = null;

    TAEquals(TAInt a, TAInt b){
        operand1 = a;
        operand2 = b;
    }

    TAEquals(TADouble a, TADouble b){

        operand1 = a;
        operand2 = b;
    }

    TAEquals(String s, TAInt a, TAInt b){

        operand1 = a;
        operand2 = b;
        name = s;

    }

    TAEquals(String s, TADouble a, TADouble b){

        operand1 = a;
        operand2 = b;
        name = s;

    }

    public Boolean getValue(){

        return value_equals;
    }

    public void printState(){

        System.out.println(value_equals);
    }

    public void list() {

        if (name == null)
        {
            System.out.print("(= ");
            operand1.list();
            System.out.println(" ");
            operand2.list();
            System.out.print(")");
        }

        else
            System.out.print(name);

    }

    @Override
    public TAPrimitive getValueTA() {
        return new TABool(value_equals);
    }

    public ArrayList getOperands(){
        ArrayList opList = new ArrayList();
        opList.addAll(operand1.getOperands());
        opList.addAll(operand2.getOperands());
        return opList;
    }

}
