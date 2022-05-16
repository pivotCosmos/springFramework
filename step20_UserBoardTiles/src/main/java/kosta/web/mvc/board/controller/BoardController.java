package kosta.web.mvc.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.board.dto.ElectronicsDTO;
import kosta.web.mvc.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	private static final String PATH_SAVE="C:\\EDU\\Spring\\fileSave";
	
	/**
	 * ��ü�˻�
	 * */
	@RequestMapping("/list")
	public void selectAll(/*HttpSession session,*/ Model model) {
		List<ElectronicsDTO> list = boardService.selectAll();
		model.addAttribute("list", list);
	}
	
	/**
	 * �����
	 * */
	@RequestMapping("/write")
	public void write(/*HttpSession session,*/) {}
	
	/**
	 * ����ϱ�
	 * */
	@RequestMapping("/insert")
	public String insert(/*HttpSession session,*/ ElectronicsDTO electronics) throws IOException, RuntimeException{
		
		//������ ÷�εǾ��ٸ� ����������, fname,fsize�� �����Ѵ�.
		MultipartFile mfile = electronics.getFile();
		if(mfile.getSize() > 0 ) { //÷�ε� ���Ͽ� �뷮�� �ִٸ�
			mfile.transferTo(new File(PATH_SAVE + "/" + mfile.getOriginalFilename()));//������ ����
		
			electronics.setFname(mfile.getOriginalFilename());
			electronics.setFsize(mfile.getSize());
		}
		
		boardService.insert(electronics);
		
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value="/read/{modelNum}")
	public ModelAndView selectByModelNum(/*HttpSession session,*/ @PathVariable String modelNum) {
		ElectronicsDTO elec = boardService.selectByModelNum(modelNum, true);
		return new ModelAndView("board/read","elec", elec);
	}
	
	
	@RequestMapping("/down")
	public ModelAndView down(/*HttpSession session,*/ String fname) { //get���� �޾ƿ´�
		File file = new File(PATH_SAVE+"/"+fname);
		 
		return new ModelAndView("downLoadView", "fname", file);
	}
	 
	/**
	 * ������. modelNum�� �޾Ƽ� �ش��ϴ� ������ ã�Ƽ� �������� ����ش�.
	 * */
	@RequestMapping("/updateForm")
	public String updateForm(/*HttpSession session,*/ String modelNum, Model model) {
		ElectronicsDTO dto = boardService.selectByModelNum(modelNum, false); //false�� ��ȸ������x
		model.addAttribute("elec", dto);
		return "board/update";
	}
	
	@RequestMapping("/update")
	public ModelAndView update(/*HttpSession session,*/ ElectronicsDTO electronics) throws RuntimeException{
		boardService.update(electronics);
		ElectronicsDTO dbElec = boardService.selectByModelNum(electronics.getModelNum(), false);
		
		return new ModelAndView("/board/read","elec",dbElec);
	}
	
	@RequestMapping("/delete")
	public String delete(/*HttpSession session,*/ String modelNum, String password) {
		boardService.delete(modelNum, password);
		return "redirect:/board/list";
	}
	
	
}
