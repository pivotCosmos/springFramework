package kosta.web.mvc.user.repository;

import kosta.web.mvc.user.dto.UserDTO;

public interface UserDAO {
  /**
   * �α��� ���
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
