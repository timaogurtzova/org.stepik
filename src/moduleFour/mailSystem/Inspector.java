package moduleFour.mailSystem;
/*
 Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
  если была обнаружена подобная посылка. Если он находит посылку, состоящую из камней (содержит слово "stones"),
  то тревога прозвучит в виде StolenPackageException.
  Если он заметил запрещенную посылку с одним из запрещенных содержимым ("weapons" и "banned substance"),
  то он бросает IllegalPackageException
 */
public class Inspector  implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            MailPackage mail2 = (MailPackage)mail;
            Package packag = mail2.getContent();
            String message = packag.getContent();
            if(message.contains("weapons") || message.contains("banned substance")){
                throw new IllegalPackageException ();
            }
            if (message.contains("stones")){
                throw new StolenPackageException ();
            }
        }
        return mail;
    }
}