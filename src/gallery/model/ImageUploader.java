package gallery.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.file.FileManager;

public class ImageUploader {
	ServletFileUpload upload;
	Gallery gallery;
	InputStream is;
	FileOutputStream fos;
	ServletContext context;
	String savePath; //���� ������
	String filename;
	FileItem image;
	
	//�� �޼��带 ȣ���ϸ� DTO�� ä���� ��ȯ���ش�.
	public Gallery makeDTO(HttpServletRequest request){	
		context = request.getServletContext();
		upload = new ServletFileUpload(new DiskFileItemFactory());
		gallery = new Gallery();
		try {
			List<FileItem> list = upload.parseRequest(request);
			
			for(int i=0;i<list.size();i++){
				FileItem item = list.get(i);
				String name = item.getFieldName(); //�Ķ���͸�
				String value = item.getString("utf-8"); //�Ķ���Ͱ�
				if(item.isFormField()){//text ���
					switch(name){
					case "writer":gallery.setWriter(value); break;
					case "title":gallery.setTitle(value); break;
					case "content":gallery.setContent(value); break;
					}
				}else{//���̳ʸ� �Ķ����
					filename = item.getName();
					gallery.setUser_filename(filename);//�����̸�
					image=item;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return gallery;
	}
	
	public void save(int seq){
		savePath=context.getRealPath("/data")+File.separator+seq+"."+FileManager.getExt(filename);
		
		try {
			is = image.getInputStream();
			fos = new FileOutputStream(savePath);
			byte[] b = new byte[1024];
			while(true){
				int flag = is.read(b);
				if(flag==-1)break;
				fos.write(b);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
