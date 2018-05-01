
package compiler.pkg5;

import java.util.Scanner;

public class DFA {
    static char DfaTable[][];
    static int noOfStates;
    static int noOfTransitions;
    static String[] finalStates;
    public static void GetDFATable() {
        //local scanner
        Scanner dFAScanner = new Scanner(System.in);
        Scanner getValues = new Scanner(System.in);
        Scanner finalStateScanner = new Scanner(System.in);
        //getting the DFA states to initialize the array
        System.out.println("Enter the no. of DFA states");
        noOfStates = getValues.nextInt()+1;
        System.out.println("Enter the no. of DFA Transitions");
        noOfTransitions = getValues.nextInt()+1;
        
        DfaTable = new char[noOfStates][noOfTransitions];
        
        //storing elements into the DFA table
        System.out.println("Enter all the elements in the DFA table");
        for(int i=0;i<noOfStates;i++){
            for(int j=0;j<noOfTransitions;j++){
                if(i==0 && j==0){DfaTable[0][0] = ' ';continue;}
                DfaTable[i][j] = dFAScanner.next().charAt(0);
            }
        }
        
        System.out.println("Enter all the final states seprated by space");
        finalStates = finalStateScanner.nextLine().split(" ");
//        finalStates = DFAScanner.nextLine();
        
    }
    
    public static char InitialState() {
        return DfaTable[1][0];
    }
    
    public static char NextState(char currentstate,char currentchar){
        for(int i=0;i<noOfStates;i++){
            if(currentstate == DfaTable[i][0]){
                if(currentchar == DfaTable[0][1]){
                    return DfaTable[i][1];
                }else if(currentchar == DfaTable[0][2]){
                    return DfaTable[i][2];
                }
            }
        }
        return '$';
    }

//        return DfaTable[noOfStates-1][0];
    
    public static boolean FinalState(char currentState) {
        for(String value : finalStates){
            char charValue = value.charAt(0);
            if(charValue == currentState){
                return true;
            }
        }
        return false;
    }
}