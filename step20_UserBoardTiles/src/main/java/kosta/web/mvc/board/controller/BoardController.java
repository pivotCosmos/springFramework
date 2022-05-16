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
	 * 전체검색
	 * */
	@RequestMapping("/list")
	public void selectAll(/*HttpSession session,*/ Model model) {
		List<ElectronicsDTO> list = boardService.selectAll();
		model.addAttribute("list", list);
	}
	
	/**
	 * 등록폼
	 * */
	@RequestMapping("/write")
	public void write(/*HttpSession session,*/) {}
	
	/**
	 * 등록하기
	 * */
	@RequestMapping("/insert")
	public String insert(/*HttpSession session,*/ ElectronicsDTO electronics) throws IOException, RuntimeException{
		
		//파일이 첨부되었다면 폴더에저장, fname,fsize를 설정한다.
		MultipartFile mfile = electronics.getFile();
		if(mfile.getSize() > 0 ) { //첨부된 파일에 용량이 있다면
			mfile.transferTo(new File(PATH_SAVE + "/" + mfile.getOriginalFilename()));//폴더에 저장
		
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
	public ModelAndView down(/*HttpSession session,*/ String fname) { //get으로 받아온다
		File file = new File(PATH_SAVE+"/"+fname);
		 
		return new ModelAndView("downLoadView", "fname", file);
	}
	 
	/**
	 * 수정폼. modelNum을 받아서 해당하는 정보를 찾아서 수정폼에 띄워준다.
	 * */
	@RequestMapping("/updateForm")
	public String updateForm(/*HttpSession session,*/ String modelNum, Model model) {
		ElectronicsDTO dto = boardService.selectByModelNum(modelNum, false); //false는 조회수증가x
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
