package kosta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentbDTO {
	private int commentNo;
	private String userId; //JPA에서는 필요없지만 아직은 게시물만 가져올때 필요하다.
	private String commentContent;
	private String regDate;
	
	//1 : 1의 관계
	private UserDTO users;
	
	//1 : 다의 관계
	private List<ReplyDTO> replies;
	
	
}
