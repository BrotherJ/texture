package texture.exception;

/**
 * �Զ����쳣������
 * @author jiong.sun
 *
 */
public class UserExistException extends Exception
{
  
	private static final long serialVersionUID = 1L;

	public UserExistException(String errorMsg)
    {
        super(errorMsg);
    }
}
