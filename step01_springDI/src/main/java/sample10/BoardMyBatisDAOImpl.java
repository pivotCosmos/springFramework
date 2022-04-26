package sample10;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("mybatisDAO") //<bean class="" id="mybatisDAO"> 대신
@Repository("mybatisDAO")
public class BoardMyBatisDAOImpl implements BoardDAO {

	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl의 select() 호출됨...");
	}

}
