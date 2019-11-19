package moduleFive;

import java.io.IOException;
import java.io.InputStream;

/**
 *  Программа, которая будет преобразовывать переводы строк из формата Windows в формат Unix.
 *  Данные в формате Windows подаются программе в System.in,
 *  преобразованные данные должны выводиться в System.out.
 *  На Unix-системах конец строки обозначается символом с кодом 10 ('\n'),
 *  на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').
 */
public class FromWindowsToUnix {

    private static final byte UNIX_END = 10; //'\n'
    private static final byte WIN_END = 13; //'\r'

    public static void main (String [] args){
        try (InputStream inputStream = System.in){
            int byteFromIS = inputStream.read ();
            int nextByteFromIS;
            while (byteFromIS != -1){
                nextByteFromIS = inputStream.read ();
                if (byteFromIS != WIN_END || nextByteFromIS != UNIX_END){
                    System.out.write ( byteFromIS );
                }
                byteFromIS = nextByteFromIS;
            }
            System.out.flush ();
        }catch (IOException e){
            e.printStackTrace ();
        }

    }
}
