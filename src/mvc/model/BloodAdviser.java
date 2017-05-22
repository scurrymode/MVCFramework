package mvc.model;

public class BloodAdviser {
	
	public String getAdvice(String blood){
		String msg = null;
		
		switch(blood){
		case "A": msg="세심하고 꼼곰해요";
		break;
		case "B": msg="주관이 뚜렷해요";
		break;
		case "AB": msg="예측불가";
		break;
		case "O": msg="성격이 좋아요";
		break;
		}
		
		return msg;
	}

}
