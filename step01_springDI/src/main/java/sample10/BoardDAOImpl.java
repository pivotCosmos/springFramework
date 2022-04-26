package sample10;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component //<bean class="" id="boardDAOImpl"> 대신 , 기본id는 클래스이름의 첫글자만 소문자로 만들어진다.
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Override
	public void select() {
		System.out.println("BoardDAOImpl의 select()호출됨...");
	}

}
