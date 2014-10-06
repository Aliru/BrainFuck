/**
 * Created by Руслан on 03.10.2014.
 */
public class BrainFuckInterpretation {
    private final int STACK = 200;
    private char [] message = new char[STACK];
    private int pointer;
    private int incomeStrPointer;
    private int beginSubStringIndex;
    private int endSubStringIndex;
    public BrainFuckInterpretation ()
    {
        pointer = 0;
        incomeStrPointer = 0;
        beginSubStringIndex = 0;
        endSubStringIndex = 0;
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
                    System.out.print( (int) message[pointer] );
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

    public void brainFuckInterpretation_3(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
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
                    System.out.print(message[pointer]);
                    break;
                case '[':
                    //look for end of cycle
                    beginSubStringIndex = i + 1;
                    int index = 1;
                    int j;
                    System.out.println(beginSubStringIndex + " " + endSubStringIndex + str);
                    for (j = beginSubStringIndex; (j < str.length() && (index != 0) ); j++)
                    {
                        if (str.charAt(j) == '[')
                            index++;
                        if (str.charAt(j) == ']')
                            index--;
                    }
                    endSubStringIndex = j-1;
                    System.out.println(beginSubStringIndex + " " + endSubStringIndex + str);
                    System.out.println(str.substring(beginSubStringIndex,endSubStringIndex));
                    while (message[pointer] != 0)
                    {
                        brainFuckInterpretation_3(str.substring(beginSubStringIndex,endSubStringIndex));
                        //System.out.println("!!!");
                        System.out.println(beginSubStringIndex + " " + endSubStringIndex + str + "!!!" + (int)message[pointer] + "###" + (str.substring(beginSubStringIndex,endSubStringIndex).length()));
                        //endSubStringIndex = str.substring(beginSubStringIndex,endSubStringIndex).length() + beginSubStringIndex;
                        int indexInside = 1;
                        int jj;
                        System.out.println(beginSubStringIndex + " " + endSubStringIndex + str);
                        for (jj = beginSubStringIndex; (jj < str.length() && (indexInside != 0) ); jj++)
                        {
                            if (str.charAt(jj) == '[')
                                indexInside++;
                            if (str.charAt(jj) == ']')
                                indexInside--;
                        }
                        endSubStringIndex = jj - 1;
                    }
                    i = endSubStringIndex;
                    System.out.println(str);
                    break;
                case ']':
                    //if (message[pointer] != 0) {
                      //  i = incomeStrPointer;
                    //}
                    break;
            }
        }
    }

    public void brainFuckInterpretation_2(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
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
                    System.out.print((int)message[pointer]);
                    break;
                case '[':
                    beginSubStringIndex = i + 1;
                    endSubStringIndex = str.lastIndexOf(']');
                    System.out.println(beginSubStringIndex + " " + endSubStringIndex + str);
                    System.out.println(str.substring(beginSubStringIndex,endSubStringIndex));
                    while (message[pointer] != 0)
                    {
                        brainFuckInterpretation_2(str.substring(beginSubStringIndex,endSubStringIndex));
                        System.out.println("!!!");
                        System.out.println(beginSubStringIndex + " " + endSubStringIndex + str + "!!!" + (int)message[pointer]);
                        endSubStringIndex = str.lastIndexOf(']');
                    }
                    i = endSubStringIndex;
                    System.out.println(str);
                    break;
                case ']':
                    //if (message[pointer] != 0) {
                    //  i = incomeStrPointer;
                    //}
                    break;
            }
        }
    }
}
