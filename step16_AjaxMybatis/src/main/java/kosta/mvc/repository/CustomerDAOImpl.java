package kosta.mvc.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SqlSession session;
	
	private CustomerMapper mapper;
	
	public CustomerDAOImpl() {
		System.out.println("CustomerDAOImpl 생성자......");
		System.out.println("session = " + session); //null. 여기선 mapper초기화 못한다.
	}
	@PostConstruct
	public void init() {
		System.out.println("***************************");
		System.out.println("session = " + session);
		mapper = session.getMapper(CustomerMapper.class);
	}
	
	
	@Override
	public String idCheck(String id) {
		
		return session.selectOne("customerMapper.idCheck", id);
	}

	@Override
	public int insert(CustomerDTO customerDTO) {
		
		return session.update("customerMapper.insert", customerDTO);
	}

	@Override
	public List<CustomerDTO> selectAll() {
		List<CustomerDTO> list = session.selectList("customerMapper.selectAll");
		
		return list;
	}

	@Override
	public int delete(String id) {
		//CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		return mapper.delete(id);
	}

	@Override
	public int update(CustomerDTO customerDTO) {
		//CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		return mapper.update(customerDTO);
	}

}
