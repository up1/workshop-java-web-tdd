package demo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.service.LoginService;

@SuppressWarnings("serial")
@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String user = req.getParameter("user");
		String pin = req.getParameter("pin");

		LoginService loginService = new LoginService();
		boolean isvalid = loginService.checkUser(user, pin);
		if( isvalid ) {
			out.write("สวัสดีจ๊ะ".getBytes("UTF-8"));
		} else {
			out.write("ผิดนะ เข้าไม่ได้".getBytes("UTF-8"));
		}
		out.flush();
		out.close();
	}
}
