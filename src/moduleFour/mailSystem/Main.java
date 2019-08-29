package moduleFour.mailSystem;

import java.util.logging.Logger;

public class Main {
    public static void main (String [] args){
       Sendable mailMessage = new MailMessage ( "Cat","Dog","Nya" );
       Package pack = new Package ( "Я в коробке", 100 );
       Sendable mailPackage = new MailPackage ( "Cat", "Human", pack );


       RealMailService realMailService = new RealMailService ();
       realMailService.processMail ( mailMessage );
       realMailService.processMail ( mailPackage );


        //проверим шпиона
        Logger logger = Logger.getLogger ("");
        Spy spy = new Spy ( logger );
        Sendable mailMessageToSpy = new MailMessage ( "Cat","Dog","Nya" );
        Sendable mailMessageAustin  = new MailMessage ( "Austin Powers","Cat","Ты мне нравишься больше собаки" );
        spy.processMail ( mailMessageToSpy );
        spy.processMail ( mailMessageAustin );
        //шпиону неважны mailPackage
        spy.processMail ( mailPackage );


        //проверим вора
        Thief thief = new Thief ( 10000 );
        Sendable mailMessageToThief = new MailMessage ( "Dog","Cat","Уйди с дивана" );
        thief.processMail ( mailMessageToThief );
        Package packagesack = new Package ( "Пакеты для кота", 10 );
        Sendable mailPackageToThief = new MailPackage ( "Cat", "Human", packagesack );
        thief.processMail ( mailPackageToThief );

        //другой воришка, готов воровать более дешевое
        Thief thiefTwo = new Thief ( 10 );
        /*
        Воровство происходит следующим образом: вместо посылки,
        которая пришла вору, он отдает новую, такую же, только с нулевой ценностью
        и содержимым посылки "stones instead of {content}"
         */

        MailPackage packageToThiefTwo = (MailPackage)thiefTwo.processMail ( mailPackageToThief );
        StringBuilder rezult = new StringBuilder ("getFrom ").append ( packageToThiefTwo.getFrom ()).append ( " " ).append ( "getTo " ).
                append ( packageToThiefTwo.getTo () ).append ( " "  ).append ( packageToThiefTwo.getContent ().
                getContent () ).append ( " price " ).append ( packageToThiefTwo.getContent ().getPrice () );
        System.out.println (rezult);

        //проверим инспектора
        Inspector inspector = new Inspector ();
        //если инспектор возьмет MailPackage после воришки, будет исключение StolenPackageException
        inspector.processMail ( packageToThiefTwo );

        //IllegalPackageException
        Package packDog = new Package ( "weapons", 10 );
        MailPackage mailPackageWeapons = new MailPackage ( "Cat" , "Dog", packDog);
        inspector.processMail ( mailPackageWeapons );
    }
}