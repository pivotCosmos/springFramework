package kosta.web.mvc.user.repository;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.web.mvc.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession session;
	
	private UserMapper mapper;
	
	@PostConstruct
	public void init() {
		mapper = session.getMapper(UserMapper.class);
	}
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) {

		return mapper.loginCheck(userDTO);
	}

}
