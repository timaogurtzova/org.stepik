package moduleFour.loggerTest;
/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:

Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java",
 независимо от серьезности сообщения, печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам
на уровнях "org.stepic", "org" и "".
Не упомянутые здесь настройки изменяться не должны.
 */
import java.util.logging.*;

public class LoggerTest {
    public static void main (String [] args){
        configureLogging ();
    }
    private static void configureLogging() {
        Logger logOne = Logger.getLogger("org.stepic.java.logging.ClassA");
        logOne.setLevel ( Level.ALL);

        Logger logTwo = Logger.getLogger("org.stepic.java.logging.ClassB");
        logTwo.setLevel (Level.WARNING);

        Logger loggerSrc = Logger.getLogger("org.stepic.java");
        loggerSrc.setLevel ( Level.OFF);
        loggerSrc.setUseParentHandlers ( false );
        Handler handler = new ConsoleHandler ();
        handler.setLevel (Level.ALL);
        handler.setFormatter (new XMLFormatter ());
        loggerSrc.addHandler(handler);

    }

}
