package com.brownpanther.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   static {
	   System.out.println("In DemoServlet static block");
	   
   }
	
    public DemoConfigServlet() {
    	System.out.println("In DemoServlet Constructor");
        
    }
    @Override
    public void init() {
    	System.out.println("In DemoServlet life cycle method init");
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doGet Method of Demo Servlet ..");
		ServletConfig servletConfig = getServletConfig();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>ConnfigObjectDetails..</title></head>");
		
		out.println("<body align ='center'>");
		
		out.println("<table border='1'");
		out.println("<tbody align='center'>");
		
		//Getting Servlet context
		
		
		//servletContext.setAttribute("apikey", "xxxxx");
		
		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        
		out.println("<tr><th>Init Pram Name</th><th>Init Pram Value</th></tr>");
		
        while (initParameterNames.hasMoreElements()){
			String inintParamName = initParameterNames.nextElement();
			String initParameter = servletConfig.getInitParameter(inintParamName);
			out.println("<tr><td>"+inintParamName+"</td><td>"+initParameter+"</td></tr>");
			
		}
       
        
       
        out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	@Override
	public void destroy() {
		System.out.println("In DemoServlet life cycle method destroy");
		
	}
	

}
