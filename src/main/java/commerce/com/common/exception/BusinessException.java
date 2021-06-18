package commerce.com.common.exception;

import java.util.Map;

import lombok.Getter;

/**
 * <pre>
 * BusinessException  클래스.
 *
 * commerce.com.exception
 *   └ BusinessException.java
 *
 * History : 2016. 10. 10., yhkim, 최초 생성
 * </pre>
 *
 * @since : 2016. 10. 10.
 * @version : 1.0
 */
@Getter
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -7679097301912719868L;
    
    private int code;
    private String sCode;
    
	private Map<String,Object> params;

    public BusinessException() {
        super( "BusinessException." );
    }

    public BusinessException( String message ) {
        super( message );
    }
    
    public BusinessException( int code,String message ) {
        super( message );
        this.code = code;
    } 
    
    public BusinessException( String sCode, String message ,Map<String,Object> params) {
        super( message );
        this.sCode = sCode;
        this.params = params;
    } 
}