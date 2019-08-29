package moduleFour.mailSystem;
/*UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
  чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
  набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
  У UntrustworthyMailWorker должен быть конструктор от массива MailService
    ( результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
   и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.
 */

public class UntrustworthyMailWorker implements MailService {
    private MailService [] mailService;
    private RealMailService rms = new RealMailService();
    public UntrustworthyMailWorker (MailService [] mailService){
        this.mailService = mailService;
    }
    public RealMailService getRealMailService(){
        return rms;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService mailService:mailService){
            mail = mailService.processMail ( mail );
        }
        return rms.processMail(mail);
    }
}