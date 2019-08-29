package moduleFour.mailSystem;

public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        if (mail instanceof MailMessage){
            System.out.println ("Обработка письма");
        }else {
            System.out.println ("Обработка посылки");
        }


        return mail;
    }
}