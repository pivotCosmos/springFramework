package sample02;

public class MemberService {
	
	private MemberDAO memberDAO;
	private Member member;
	
	public MemberService() {
		System.out.println("MemberService의 기본생성자 호출됨...");
	}
	
	public MemberService(MemberDAO memberDAO, Member member) {
		System.out.println("MemberService(MemberDAO memberDAO, Member member) 생성자 호출됨...");
		System.out.println("memberDAO : " + memberDAO);
		System.out.println("member : " + member);
		
		this.memberDAO = memberDAO;
		this.member = member;
	}
	
	public void serviceInsert() {
		System.out.println("MemberService의 serviceInsert 호출됨...");
		
		memberDAO.insert(member);
	}
}
