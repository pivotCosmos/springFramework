package kosta.main;

import kosta.dao.JoinDAO;

public class JoinMainApp {

	public static void main(String[] args) {
		System.out.println("1. 1 : 1인 경우 ---------------------");
		//JoinDAO.associationTest();
		
		System.out.println("2. 1 : 다인 경우 ---------------------");
		//JoinDAO.collectionTest();
		
		System.out.println("3. 1 : 다인 경우 (회원 + 게시물)---------------------");
		JoinDAO.userCollection();
	}

}
