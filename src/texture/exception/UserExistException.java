package texture.exception;

/**
 * 自定义异常处理类
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
