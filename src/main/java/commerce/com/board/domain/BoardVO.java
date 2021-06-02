package commerce.com.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;



//@Getter
//@Setter
@Data
@ToString
@Alias("boardVO")
public class BoardVO {
  private int docNo;
  private String title;
  private String content;
  private String writer;
  private String regDttm;
  private int view;
  private int reply;

  private int startNo;
  private int endNo;
  private String[] sort;

  private String schType;
  private String schVal;


}
