package mvc.model;

public class BloodAdviser {
	
	public String getAdvice(String blood){
		String msg = null;
		
		switch(blood){
		case "A": msg="�����ϰ� �İ��ؿ�";
		break;
		case "B": msg="�ְ��� �ѷ��ؿ�";
		break;
		case "AB": msg="�����Ұ�";
		break;
		case "O": msg="������ ���ƿ�";
		break;
		}
		
		return msg;
	}

}
