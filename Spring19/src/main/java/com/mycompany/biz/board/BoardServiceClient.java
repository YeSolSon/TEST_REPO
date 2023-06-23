package com.mycompany.biz.board;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.biz.board.impl.BoardService;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
														/* 게시판 관리하는 서비스를 호출 */
		BoardService boardService = (BoardService)factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("금요일");
		vo.setWriter("홍길동");
		vo.setContent("내일모레 휴무");
		boardService.insertBoard(vo);
		
		ArrayList<BoardVO> boardList = (ArrayList)boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println(board.toString());
		}
		factory.close();
	}
}
