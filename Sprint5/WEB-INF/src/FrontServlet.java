package etu1888.framework.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import etu1888.framework.*;

public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> mapping_url = null;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ServletContext ctx = getServletContext();
            String path = ctx.getRealPath("/WEB-INF/classes/models");
            this.mapping_url = Utilitaire.getHashMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("Url: " + req.getRequestURL());
        out.println("Contexte: " + req.getContextPath());

        Utilitaire.afficher_MappingUrls(this.mapping_url, out);

        String url = String.valueOf(req.getRequestURL());
        String apres_contexte = Utilitaire.getUrl(url);

        out.println(apres_contexte);
        out.println(
                mapping_url.get(apres_contexte).getClassName() + "///" + mapping_url.get(apres_contexte).getMethod());

        try {

            if (apres_contexte.compareToIgnoreCase("/") == 0) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            }

            ModelView view = ModelView.loadView(apres_contexte, this.mapping_url);
            out.println("////// le fichier jsp //////: " + view.getView());

            RequestDispatcher dispatcher = req.getRequestDispatcher(view.getView());
            dispatcher.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }
}
