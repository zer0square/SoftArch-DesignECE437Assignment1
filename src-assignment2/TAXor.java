import java.lang.reflect.Array;
import java.util.ArrayList;

/*
Type Abstraction for xor operator
*/
public class TAXor extends TABool implements TAFormula {

    private Boolean value_xor;
    private TABool operand1, operand2;
    private String name = null;

    TAXor(TABool a, TABool b){

        operand1 = a;
        operand2 = b;
    }

    TAXor(String s, TABool a, TABool b) throws Exception {

        NamesChecker.check(s);
        name = s;
        operand1 = a;
        operand2 = b;
    }

    public Boolean getValue() {

        return value_xor;
    }

    public void evaluate(){

        value_xor = operand1.getValue() ^ operand2.getValue();
    }

    @Override
    public TAPrimitive getValueTA() {
        return new TABool(value_xor);
    }

    public void list(){
        if(name == null) {
            System.out.print("(xor ");
            operand1.list();
            System.out.print(" ");
            operand2.list();
            System.out.print(" )");
        }
        else
            System.out.print(name);
    }

    public void printState(){
        System.out.println(value_xor);

    }

    public ArrayList getOperands(){
        ArrayList opList = new ArrayList();
        opList.addAll(operand1.getOperands());
        opList.addAll(operand2.getOperands());
        return opList;
    }
}
