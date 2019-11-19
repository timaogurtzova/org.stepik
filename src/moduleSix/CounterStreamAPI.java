package moduleSix;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
 * и в конце выводящую 10 наиболее часто встречающихся слов.
 * Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
 * Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 * Выводите слова в нижнем регистре.
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 */

public class CounterStreamAPI {
    public static void main(String [] args) {
        BufferedReader src = new BufferedReader (new InputStreamReader (new BufferedInputStream (System.in),
                java.nio.charset.StandardCharsets.UTF_8 ) );

        Map<String, Integer> result = new HashMap<> ( );

        src.lines()
                .map ( s -> s.split ( "[^\\p{L}\\p{Digit}]+" ) )
                .flatMap ( Arrays::stream )
                .forEach (s -> result.merge (s.toLowerCase(), 1, Integer::sum));

        result.entrySet ()
                .stream ()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit ( 10 )
                .map(Map.Entry::getKey)
                .forEach ( System.out::println );
    }

}
