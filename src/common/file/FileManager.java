package common.file;

public class FileManager {
	
	//Ȯ���� �����ϱ�
	public static String getExt(String path){
		// a.b.c.d.jpg�� ������
		int lastIndex = path.lastIndexOf(".");
		return path.substring(lastIndex+1, path.length());
	}

}
