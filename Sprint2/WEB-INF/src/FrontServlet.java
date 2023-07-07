package etu1888.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import etu1888.framework.Mapping;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.Utility;

public class FrontServlet extends HttpServlet {

  HashMap<String, Mapping> mappingUrls;

  protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.println(Utility.getUrl(String.valueOf(req.getRequestURL())));
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      processRequest(req, resp);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      processRequest(req, resp);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
