/*
 * �������̽��� ���� ��Ʈ�ѷ����� ��� �����ؾ��ϴ� �޼��带 ������ �ֻ��� ��ü�� �����Ѵ�!
 * �ֻ��� ��ü�� �����ϸ� ���� ���� �Ӿƴ϶� �ϳ��� �ڷ������� ���� �� �ִ�.
 * */

package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public boolean isForward();
}
