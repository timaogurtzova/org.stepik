package moduleFour.mailSystem;
/*
  Если Inspector заметил запрещенную посылку с одним из запрещенных содержимым
  ("weapons" и "banned substance"),
  то он бросает IllegalPackageException
 */

public class IllegalPackageException extends RuntimeException{
}
