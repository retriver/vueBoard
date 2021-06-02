package commerce.com.board.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;


//@Getter
//@Setter
@Data
@ToString
@Alias("replyVO")
public class ReplyVO {
  private int replyNo;
  private int docNo;
  private String writer;
  private String content;
  private String regDttm;

}
