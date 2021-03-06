/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChartsServlet;

import dao.ChartsDAO;
import dao.EmployeeDAO;
import entity.Charts;
import entity.PerformanceReviewScores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

/**
 *
 * @author see_h
 */
public class viewPerformanceClientBar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            ArrayList<Charts> charts;
            
            ChartsDAO chartsDAO = new ChartsDAO();
            
            charts = chartsDAO.getSSERAverage();
            
            JSONArray jarrayChartsDAO = new JSONArray();
            JSONObject ObjectAll = new JSONObject();
            
            
//            String[] sb = new String["96-100", "91-95", "86-90", "81-85", "76-80", "71-75", "66-70", "61-65"];
                    
            
//            ArrayList<Charts> scoresbracket;
//            String[] scoresBracket = new String[charts.size()];
//            for(int i = 0; i < scoresBracket.length;i++){
//                scoresBracket
//            }
            
            for(int i = 0; i < charts.size(); i++){
                JSONObject objChartsDAO = new JSONObject();
                
                
                objChartsDAO.put("clientName", charts.get(i).getClientName());
                objChartsDAO.put("clientScore", charts.get(i).getSserAverage());
                objChartsDAO.put("clientID", charts.get(i).getClientID());
                
                objChartsDAO.put("type", charts.get(i).getClientType());
                
//                objChartsDAO.put("empID", 3);
                jarrayChartsDAO.put(objChartsDAO);
            }
            
            ObjectAll.put("series", jarrayChartsDAO);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("["+ObjectAll.toString()+"]");
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(viewPerformanceD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(viewPerformanceD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
