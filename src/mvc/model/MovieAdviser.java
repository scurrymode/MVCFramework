package mvc.model;

public class MovieAdviser {
	
	public String getAdvice(String movie){
		String msg = null;
		
		switch(movie){
		case "�پƿ�": msg="���� �ڽ����ǽ� 1�� ������";
		break;
		case "�������̺�": msg="�ڹ� �ִϸ��̼�";
		break;
		case "ŷ�Ƽ�": msg="�׼� ��庥ó";
		break;
		case "���̸��� Ŀ����Ʈ": msg="SF";
		break;
		}
		
		return msg;
	}

}
