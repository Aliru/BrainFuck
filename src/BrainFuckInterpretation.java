/**
 * Created by Руслан on 03.10.2014.
 */
public class BrainFuckInterpretation {
    private final int STACK = 200;
    private char [] message = new char[STACK];
    private int pointer;
    private int incomeStrPointer;
    public BrainFuckInterpretation ()
    {
        pointer = 0;
        incomeStrPointer = 0;
    }
    public void brainFuckInterpretation(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            switch (str.charAt(i))
            {
                case '>':
                    if (pointer + 1 < STACK)
                        pointer++;
                    break;
                case '<':
                    if (pointer - 1 >= 0)
                        pointer--;
                    break;
                case '+':
                    message[pointer]++;
                    break;
                case '-':
                    message[pointer]--;
                    break;
                case '.':
                    System.out.print( message[pointer] );
                    break;
                case '[':
                    incomeStrPointer = i;
                    break;
                case ']':
                    if ( message[pointer] != 0) {
                        i = incomeStrPointer;
                    }
                    break;
            }
        }
    }
}
