package moduleFour.mailSystem;
/*
    Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
    Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
    Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
    (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
    2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение
        с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
    2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private Logger logger = Logger.getLogger ( "LogerZero" );

    public Spy (Logger logger){
        this.logger = logger;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage){
            MailMessage mail2 = (MailMessage) mail;
            String from = mail2.getFrom();
            String to = mail2.getTo();
            String message = mail2.getMessage();
            if ("Austin Powers".equals(from) || "Austin Powers".equals(to)){
                logger.log ( Level.WARNING,"Detected target mail correspondence: from {0} to {1} \"{2}\"",new Object[]{from, to, message});

            }
            else {
                logger.log (Level.INFO, "Usual correspondence: from {0} to {1}",new Object[]{from, to});

            }
        }
        return mail;
    }
}