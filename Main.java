import java.beans.Expression;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main( String[] args ) {



        resizedQueueTest();
    }
    public static void resizedQueueTest(  ){
       ResizedArrayQueueOfStrings rz = new ResizedArrayQueueOfStrings(  );
       // Create a Random object to generate random function calls
       Random random = new Random(  );

       // Perform 100 random function calls
       for ( int i = 0; i < 100; i++ ) {
          // Generate a random number between 0 and 1
          int randomNumber = random.nextInt( 2 );

          // If randomNumber is 0, enqueue a random number
          if ( randomNumber == 0 ) {
             int randomValue = random.nextInt( 100 ); // Generate a random number between 0 and 99
             rz.enqueue( String.valueOf( randomValue ) );
             System.out.println( "Enqueue : " + randomValue + ", N = " + rz.N + ", eqPos = " + rz.eqPos + ", dqPos = " + rz.dqPos  );
             System.out.println( rz.s.length + " : " + Arrays.toString( rz.s ) + "\n" );
          }
          // If randomNumber is 1 and the queue is not empty, dequeue
          else if ( !rz.isEmpty(  ) ) {
             rz.dequeue(  );
             System.out.println( "Dequeue, N = " + rz.N + ", eqPos = " + rz.eqPos + ", dqPos = " + rz.dqPos  );
             System.out.println( rz.s.length + " : " + Arrays.toString( rz.s ) + "\n" );
          }
       }
    }
    public static void expressionTest(){
        Evaluate evaluate = new Evaluate(  );
        InfixToPostfix infixToPostfix = new InfixToPostfix(  );
        InfixToPrefix infixToPrefix = new InfixToPrefix(  );

        String[] infixExpressions = {
                "5 * 8 / 16 + 3",
                "2 / 2 * 10 + 10",
                "14 * 1 - 4 * 5",
                "17 - 7 / 10 + 14",
                "11 + 19 + 19 - 16",
                "16 / 12 / 7 + 1",
                "4 * 5 * 15 + 0",
                "11 + 9 - 19 * 4",
                "12 + 14 - 15 / 10",
                "9 * 1 + 8 * 15"
        };

        // Print each infix expression
        for ( String expression : infixExpressions ) {
            System.out.println( "Expression: " + expression );

            String[] postfixExp = infixToPostfix.getPostFixExp( expression );
            System.out.println( "Postfix: " + String.join( " ", postfixExp ) );

            String[] prefixExp = infixToPrefix.getPreFixExp( expression );
            System.out.println( "Prefix: " + String.join( " ", prefixExp ) );

            System.out.println( "PostFix Eval: " + evaluate.getEvalResult( postfixExp ) );
            System.out.println( "PreFix Eval: " + evaluate.getEvalResult( prefixExp ) );

            System.out.println( "" );
        }
    }
}