package sample10;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component //<bean class="" id="boardServiceImpl">
@Service
public class BoardServiceImpl implements BoardService {

	//@Autowired //byType -> byName 찾기
	@Resource(name="boardDAOImpl")
	private BoardDAO boardDAO;
	
	@Resource(name="mybatisDAO")
	private BoardDAO boardMyBatisDAOImpl;
	
	@Override
	public void select() {
		System.out.println("BoardServiceImpl의 select() 호출됨...");
		System.out.println("boardDAO = " + boardDAO);
		System.out.println("boardMyBatisDAOImpl = " + boardMyBatisDAOImpl);
		
		boardDAO.select();
		System.out.println("------------------");
		boardMyBatisDAOImpl.select();
	}

}
