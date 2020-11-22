package controllers.company;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Company;
import models.validators.CompanyValidator;
import utils.DBUtil;

/**
 * Servlet implementation class CompanysCreateServlet
 */
@WebServlet("/companys/create")
public class CompanysCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanysCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Company c = new Company();

            Date contract_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("contract_date");
            if(rd_str != null && !rd_str.equals("")) {
                contract_date = Date.valueOf(request.getParameter("contract_date"));
            }
            c.setContract_date(contract_date);

            c.setCompany_name(request.getParameter("company_name"));
            c.setPresident(request.getParameter("president"));
            c.setTellnumber(request.getParameter("tellnumber"));


            List<String> errors = CompanyValidator.validate(c);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("company", c);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/companys/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/companys/index");
            }
        }
    }
}