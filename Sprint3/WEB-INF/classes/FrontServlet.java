package etu1888.framework.servlet;

import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import etu1888.framework.*;

public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> mapping_url = null;

    public void init(){
        try {
            ServletContext ctx = getServletContext() ;
            String path =  ctx.getRealPath("/WEB-INF/classes/models");
            this.mapping_url = Utility.getHashMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("Url: " + req.getRequestURL());
        out.println("Contexte: " + req.getContextPath());
        out.println(req.getServletPath());
        out.println(req.getQueryString());

        Utility.afficher_MappingUrls(this.mapping_url,out);
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }
}
