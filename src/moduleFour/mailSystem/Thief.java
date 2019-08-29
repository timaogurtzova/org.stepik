package moduleFour.mailSystem;
/*Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
  Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
  Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок,
  которые он своровал.
 Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же,
  только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */

public class Thief implements MailService {
    private int sumStolen = 0;
    private int readyToSteal = 0;
    public Thief(int readyToSteal){
        this.readyToSteal = readyToSteal;
    }
    public int getStolenValue(){
        return sumStolen;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            MailPackage mail2 = (MailPackage)mail;
            String from = mail2.getFrom();
            String to = mail2.getTo();
            Package packag = mail2.getContent();
            String message = packag.getContent();
            int price = packag.getPrice();
            if (readyToSteal<=price){
                sumStolen += price;
                String messageInPack = "\"stones instead of "+message+"\"";   //????
                Package packagToo = new Package (messageInPack, 0);
                return new MailPackage (from, to,packagToo);
            }else {System.out.println ("Я не буду воровать - мало денег");}
        }else {
            System.out.println ("Я не буду воровать - это письмо");
        }
        return mail;
    }
}
