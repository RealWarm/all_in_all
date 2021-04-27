package egovframework.com.cmm;

import egovframework.com.utl.sim.service.EgovFileScrty;

public class MakePW {

	public static void main(String[] args) throws Exception {
		
		String id = "USER003";
		String pw = "rhdxhd12";
		
		EgovFileScrty efs = new EgovFileScrty();
		String fpw =efs.encryptPassword(pw,id);
		
		System.out.println("id :: " + id);		
		System.out.println("pw :: " + pw);
		System.out.println("final :: " + fpw);
		

	}//main

}//end class
