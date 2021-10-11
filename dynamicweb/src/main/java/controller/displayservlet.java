package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class displayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public displayservlet() {
        super();
      
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String height=request.getParameter("height");
		String weight=request.getParameter("weight");
		int i=Integer.parseInt(height.trim());  
		int j=Integer.parseInt(weight.trim());
		System.out.println(username);
		System.out.println(height);
		System.out.println(weight);
		
		request.setAttribute("name",username);
		request.setAttribute("height", i);
		request.setAttribute("weight", j);
		double bmi=Calculate(i,j);
		System.out.println(bmi);
		request.setAttribute("bmi1", bmi);
		String cate=printBMICategory(bmi);
		request.setAttribute("cate1", cate);
		RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

	public static double Calculate(int height,int weight)
	{
		System.out.println(height);
		System.out.println(weight);
		double bmi=(weight*1.0*100*100)/(height*height*1.0);
		System.out.println(bmi);
		
		return bmi;
	}
	public static String printBMICategory(double bmi) {
		if(bmi<18.5) {
		return "Under Weight";
		}
		else if(bmi>= 18.5 && bmi<24.9) {
		return "Normal";
		}
		else if(bmi >= 25 && bmi<29.9) {
		return "Over Weight";
		}
		else if(bmi >= 30 && bmi<34.9) {
		return "Obese";
		}
		else {
		return "Extremly Obese";
		}
		}
		
}