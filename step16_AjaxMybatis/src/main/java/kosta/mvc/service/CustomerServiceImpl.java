package kosta.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kosta.mvc.dto.CustomerDTO;
import kosta.mvc.repository.CustomerDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;
	
	@Override
	public String idCheck(String id) {
		if(customerDAO.idCheck(id)==null) {
			return "가능합니다";
		}else {
			return "중복입니다";
		}
	}

	@Override
	public int insert(CustomerDTO customerDTO) {
		return customerDAO.insert(customerDTO);
	}

	@Override
	public List<CustomerDTO> selectAll() {
		
		return customerDAO.selectAll();
	}

	@Override
	public int delete(String id) {
		return customerDAO.delete(id);
	}

	@Override
	public int update(CustomerDTO customerDTO) {
		return customerDAO.update(customerDTO);
	}

}
