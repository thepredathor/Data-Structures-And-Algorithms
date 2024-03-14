
package data_structures.stack.problems;

import java.lang.reflect.Array;

import java.util.Stack;


public class ProperlyClosingParenthesis {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Static fields/initializers 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static final String OPEN_CURLY_PARENTHESIS = "{";
    public static final String CLOSING_CURLY_PARENTHESIS = "}";
    public static final String OPEN_SQUARE_PARENTHESIS = "[";
    public static final String CLOSING_SQUARE_PARENTHESIS = "]";
    public static final String OPEN_NORM_PARENTHESIS = "(";
    public static final String CLOSING_NORM_PARENTHESIS = ")";

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Tell if all brackets in a string close properly
    // Eg: "(var x = [1, 2, 3)];" => false
    // Eg2: "var x = 2;)" => false
    // Eg3: "( var x = { y: [1, 2, 3] } )" => true

    public static void main(String[] args) {
        String jsCode = "(var x = [1, 2, 3)];";
        String jsCode2 = "var x = 2;)";
        String jsCode3 = "( var x = { y: [1, 2, 3] } )";

        System.out.println(areParenthesesClosedProperly(jsCode));
        System.out.println(areParenthesesClosedProperly(jsCode2));
        System.out.println(areParenthesesClosedProperly(jsCode3));
    }

    public static boolean areParenthesesClosedProperly(String jsCode) {
        //J-
        Stack<String> stack = new Stack<>();                    // create a stack
        String[] splitJsCode = jsCode.split("");          // split string to get each character

        for (String s : splitJsCode) {                          // for each character
            switch (s) {
                case OPEN_CURLY_PARENTHESIS:
                case OPEN_SQUARE_PARENTHESIS:
                case OPEN_NORM_PARENTHESIS:
                    stack.push(s);                              // if it's an opening bracket push onto the stack
                    break;
                case CLOSING_CURLY_PARENTHESIS:                 // if it's a closing bracket,
                    if(stack.isEmpty()) {                       // if the stack is empty => the stack should have had an opening bracket => false
                        return false;
                    }
                    String s1 = stack.pop();                    // if the stack is not empty => pop element
                    if (!s1.equals(OPEN_CURLY_PARENTHESIS)) {   // if element is the appropriate open bracket type do nothing as element is already popped
                        return false;                           // else return false
                    }
                    break;
                case CLOSING_SQUARE_PARENTHESIS:
                    if(stack.isEmpty()) {
                        return false;
                    }
                    String s2 = stack.pop();
                    if (!s2.equals(OPEN_SQUARE_PARENTHESIS)) {
                        return false;
                    }
                    break;
                case CLOSING_NORM_PARENTHESIS:
                    if(stack.isEmpty()) {
                        return false;
                    }
                    String s3 = stack.pop();
                    if (!s3.equals(OPEN_NORM_PARENTHESIS)) {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
        //J+
    }
}
