package com.korit.servlet_study.servlet;

import com.korit.servlet_study.datas.DataList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.io.ObjectInputFilter;

@WebServlet("/product/register")
public class ProductRegisterPageServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("severName" , "서블릿학습");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        System.out.println("상품으로 페이지 doGet 호출");
        HttpSession session = req.getSession();
        session.setAttribute("username" , "soyoul");

        req.setAttribute("categories" , DataList.getCategoryList());
        req.getRequestDispatcher("/WEB-INF/product_register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("category"));
        System.out.println(req.getParameter("productName"));
        System.out.println(req.getParameter("price"));
        System.out.println(req.getParameter("registerDate"));
        resp.setContentType("text/plain");
        resp.getWriter().println(
                "<script>"
                         +"alert(\"등록이 완료되었습니다.\");"
                        + "location.href='http://localhost:8080/servlet_study_war/product/register';"
                         +"</script>"
        );
    }

}


