package egovframework.com.cmm;

import egovframework.com.utl.sim.service.EgovFileScrty;

public class MakePW_Multi {
	
	public static String makeUserNumber(int nn) {
		// 들어온 정수를 4자리 정수로 만든다.
		// 1. 들어온 숫자의 자리수를 파악한다 >> 부족한 부분을 00으로 채운다
		// 2. 반환한다.		
		int sleng=3;
		int tmp = nn;	// 원본데이터 저장을 위해서
		int zari=0; 	// 숫자의 자리를 말함
		
		while((tmp/10)!=0) {
			zari++;
			tmp/=10;
		}//while
		
		String front="";		
		for(int i=0; i<sleng-zari; i++) {
			front+="0";
		}//for-i
		
		return "USER"+front+Integer.toString(nn);
				
	}//makeUserNumber
	

	public static void main(String[] args) throws Exception {
		
		for(int i=1; i<10000; i++) {
			String id = makeUserNumber(i);
			String pw = "rhdxhd12";
			
			EgovFileScrty efs = new EgovFileScrty();
			String fpw =efs.encryptPassword(pw,id);
			
			System.out.println("id :: " + id);		
			System.out.println("pw :: " + pw);
			System.out.println("final :: " + fpw);
			System.out.println("=============================");
			
		}//for-i

	}//main
	
}//end class



// "User" + "번호" >> 아이디만들기
// "아이디" + 비밀번호 만들기 >> 최종비번만들기