package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import entity.admin;
import entity.fangchanjingjiren;
import entity.guke;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
    	String jiese = request.getParameter("jiese");
        String idc = request.getParameter("id");
        String password = request.getParameter("password");
        if(("1".equals(jiese))) {
        	admin admin = new admin(idc,password);
        	if(Dao.admin(admin.getId(),admin.getPassword()))
        		{
        		request.setAttribute("message", "登录成功");
        		Cookie cookie = new Cookie("id",admin.getId());
        		response.addCookie(cookie);
        		response.sendRedirect("menu1.jsp");
        		}
        	else{
        		request.setAttribute("message", "用户名或密码错误！");
        		response.sendRedirect("begin.jsp");
        		}
        }
        else if(("2".equals(jiese)))
        	{
        	fangchanjingjiren fangchanjingjiren = new fangchanjingjiren(idc,password);
        	if(Dao.fangchanjingjiren(fangchanjingjiren.getAgentID(),fangchanjingjiren.getPassword()))
        		{
        		request.setAttribute("message", "登录成功");
        		Cookie cookie = new Cookie("id",fangchanjingjiren.getAgentID());
        		response.addCookie(cookie);
        		response.sendRedirect("menu2.jsp");
        		}
        	else{
        		request.setAttribute("message", "用户名或密码错误！");
        		response.sendRedirect("begin.jsp");
        		}
        	}
        else if(("3".equals(jiese)))
        	{
        	guke guke = new guke(idc,password);
        	if(Dao.fangchanjingjiren(guke.getUserid(),guke.getPassword()))
        		{
        		request.setAttribute("message", "登录成功");
        		Cookie cookie = new Cookie("id",guke.getUserid());
        		response.addCookie(cookie);
        		response.sendRedirect("menu3.jsp");
        		}
        	else{
        		request.setAttribute("message", "用户名或密码错误！");
        		response.sendRedirect("begin.jsp");
        		}
        	}
        else {
        	request.setAttribute("message", "登陆失败！");
    		response.sendRedirect("begin.jsp");
        }
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
