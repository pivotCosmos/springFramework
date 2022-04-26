package sample07;

public class MemberController {
	private MemberVO memberVO;
	
	private MemberVO member;
	
	public MemberController() {
		System.out.println("MemberController 기본생성자...");
	}

	public MemberController(MemberVO memberVO, MemberVO m) {
		this.memberVO = memberVO;
		this.member = m;
		
		System.out.println("MemberController(MemberVO memberVO, MemberVO member) 생성자 호출...");
		System.out.println("memberVO = " + memberVO + " , memberVO.getName() = " + memberVO.getName());
		System.out.println("member = " + m + " , member.getName() = " + m.getName());
	}
	
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
		System.out.println("setMemberVO(MemberVO memberVO) 호출됨 , memberVO = " + memberVO + " , memberVO.getName() = "+memberVO.getName());
	}
	
	public void setMember(MemberVO member) {
		this.member = member;
		System.out.println("setMember(MemberVO member) 호출됨 , member = " + member + " , member.getName() = "+member.getName());
	}
}
