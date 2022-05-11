package kosta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.CommentbDTO;
import kosta.dto.ReplyDTO;
import kosta.dto.UserDTO;
import kosta.util.DbUtil;

public class JoinDAO {
	/**
	 * 1 : 1의 관계 (게시물정보 + 작성자정보)
	 */
	public static void associationTest() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<CommentbDTO> list = session.selectList("joinMapper.joinAssociation");
			System.out.println("개수 : " + list.size());
			for(CommentbDTO commentbDTO:list) {
				System.out.print(commentbDTO.getCommentNo() + " | ");
				System.out.print(commentbDTO.getCommentContent() + " | ");
				System.out.print(commentbDTO.getRegDate() + " | ");
				
				System.out.print(commentbDTO.getUsers().getUserId() + " | ");
				System.out.print(commentbDTO.getUsers().getUserName() + "\n");
			}
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 1 : 다의 관계 (게시물정보 + 댓글)
	 */
	public static void collectionTest() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			
			List<CommentbDTO> list = session.selectList("joinMapper.joinCollection");
			System.out.println("개수 : " + list.size());
			
			for(CommentbDTO commentbDTO:list) {
				System.out.print(commentbDTO.getCommentNo() + " | ");
				System.out.print(commentbDTO.getCommentContent() + " | ");
				System.out.print(commentbDTO.getRegDate() + "\n");
				
				System.out.println(commentbDTO.getCommentNo()+ "의 Reply의 정보( " + list.size()+"개) ----");
				for(ReplyDTO reply:commentbDTO.getReplies()) {
					System.out.print("  ▶ "+reply.getCommentNo()+" | ");
					System.out.print(reply.getReplyContent()+" | ");
					System.out.print(reply.getUserId()+" | ");
					System.out.print(reply.getRegDate()+"\n");
				}
				System.out.println();
				
			}
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	
	public static void userCollection() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			
			//List<UserDTO> list = session.selectList("joinMapper.userCollection");
			List<UserDTO> list = session.selectList("joinMapper.userCollection", "jang");
			System.out.println("개수 : " + list.size());
			
			for(UserDTO userDTO:list) {
				System.out.print(userDTO.getUserId() + " | ");
				System.out.print(userDTO.getUserName() + "\n");
				
				System.out.println(userDTO.getUserId()+ "가 작성한 글 정보( " + userDTO.getCommentbList().size()+"개) ----");
				for(CommentbDTO commentbDTO:userDTO.getCommentbList()) {
					System.out.print("  ▶ "+commentbDTO.getCommentNo()+" | ");
					System.out.print(commentbDTO.getCommentContent()+" | ");
					System.out.print(commentbDTO.getRegDate()+"\n");
				}
				System.out.println();
				
			}
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	
}
