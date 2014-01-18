/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package itec3110;

import java.util.Scanner; //to read input from console

/**
 *
 * @author jmass_000
 */
public class ITEC3110 {

    public static final int TUITION = 2890; //constant
    public static int creditU = 0; //track CU
    public static Scanner in = new Scanner(System.in); //to read input
    public static int perTerm = 0; //CU per term
    
    public static void main(String[] args) {
        int[] classes; //Array created for # of classes
        int classInput; //how many classes?
        
        System.out.println("How many classes do you need to take to graduate? ");
        classInput = in.nextInt();//record number of classes
        if (classInput < 0){// check for a negative integer
            do{
            System.out.println("Enter a positive number: ");
            classInput = in.nextInt();
            }while(classInput < 0);
        }
        classes = new int[classInput-1]; //create an array based on number of classes entered
        
        System.out.println("How many Credits is the first class");
        creditU = in.nextInt(); //collect CU for each class
        if (creditU < 0){
            do{
                System.out.println("Enter a positive number: ");
                creditU = in.nextInt();
            }while(creditU < 0);
        }
        
        for(int i = 0; i <= classes.length-1; i++){
            System.out.println("How many Credits is the next class");
            creditU += in.nextInt();
        }
      
        System.out.println("How many CU's will be completed per term? ");
        perTerm = in.nextInt();
        
        lessThan(perTerm); //check if CU per term is less than 12
        terms(creditU, perTerm); //calculate how many terms to graduation, total tuition, and months
    }
    
    public static void lessThan(int termSchedule){ //check for term less than 12
    if (termSchedule <= 11){
            do{
            System.out.println("You must complete a minimum of 12 CU's per term");
            System.out.println("How many CU's will be completed per term? ");
            termSchedule = in.nextInt();
            }while (termSchedule <= 11);
        }
    }
    
    public static void terms(int credits, int perTerm){ //calculate # of terms, tuition, and months
        int total = credits/perTerm;
        if (credits % perTerm != 0){
            total++;
        }
        int finalTuition = total*TUITION;
        int totalMonths = 6*total;
        System.out.println("It will take you " + total + " term(s) to graduate");
        System.out.println("Your total cost for attending school by the time you graduate is $" + finalTuition + ".");
        System.out.println("It will take you " + totalMonths + " months to graduate.");
    }
}
