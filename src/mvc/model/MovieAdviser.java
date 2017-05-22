package mvc.model;

public class MovieAdviser {
	
	public String getAdvice(String movie){
		String msg = null;
		
		switch(movie){
		case "겟아웃": msg="전미 박스오피스 1위 스릴러";
		break;
		case "보스베이비": msg="코믹 애니메이션";
		break;
		case "킹아서": msg="액션 어드벤처";
		break;
		case "에이리언 커버넌트": msg="SF";
		break;
		}
		
		return msg;
	}

}
