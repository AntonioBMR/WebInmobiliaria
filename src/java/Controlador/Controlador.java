/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloFoto;
import Modelo.ModeloInmueble;
import hibernate.Foto;
import hibernate.Inmueble;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

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
            throws ServletException, IOException {
        String destino = "index.html";
        boolean forward = false;
        String target, op, action, view;
        target = request.getParameter("target");
        op = request.getParameter("op");
        action = request.getParameter("action");
        if (target.equals("inmueble")
                && op.equals("select")
                && action.equals("view")) {
            forward = true;
            destino = "WEB-INF/inmueble/index.jsp";
            request.setAttribute("datos", ModeloInmueble.get());
        } else if (target.equals("inmueble")
                && op.equals("delete")
                && action.equals("op")) {
            forward = false;
            ModeloInmueble.delete(request.getParameter("id"));
            destino = "control?target=inmueble&op=select&action=view";
        } else if (target.equals("inmueble")
                && op.equals("insert")
                && action.equals("view")) {
            forward = true;
            request.getAttribute("falso");
            request.getAttribute("nulos");
            destino = "WEB-INF/inmueble/insert.jsp";
        } else if (target.equals("inmueble")
                && op.equals("insert")
                && action.equals("op")) {
            if (!request.getParameter("precio").isEmpty() & !request.getParameter("localidad").isEmpty()
                    & !request.getParameter("direccion").isEmpty() & !request.getParameter("tipo").isEmpty()
                    & !request.getParameter("usuario").isEmpty()) {
                if (esNumero(request.getParameter("precio"))) {
                    forward = false;
                    destino = "control?target=inmueble&op=select&action=view";
                    Inmueble inmueble = new Inmueble();
                    inmueble.setTipo(request.getParameter("tipo"));
                    inmueble.setDireccion(request.getParameter("direccion"));
                    inmueble.setLocalidad(request.getParameter("localidad"));
                    inmueble.setUsuario(request.getParameter("usuario"));
                    inmueble.setPrecio(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precio"))));
                    ModeloInmueble.insert(inmueble);
                } else {
                    forward = true;
                    request.setAttribute("falso", "introduzca precio válido");
                    destino = "control?target=inmueble&op=insert&action=view";
                }
            } else {

                forward = true;
                request.setAttribute("nulos", "no deje campos vacios");
                destino = "control?target=inmueble&op=insert&action=view";
            }
        } else if (target.equals("inmueble")
                && op.equals("edit")
                && action.equals("view")) {
            forward = true;
            //request.setAttribute("id", request.getParameter("id"));
            request.getAttribute("falso");
            request.getAttribute("nulos");
            request.setAttribute("inmueble", ModeloInmueble.get(request.getParameter("id")));
            destino = "WEB-INF/inmueble/edit.jsp";
        } else if (target.equals("inmueble")
                && op.equals("edit")
                && action.equals("op")) {
            if (!request.getParameter("precio").isEmpty() & !request.getParameter("localidad").isEmpty()
                    & !request.getParameter("direccion").isEmpty() & !request.getParameter("tipo").isEmpty()
                    & !request.getParameter("usuario").isEmpty()) {
                if (esNumero(request.getParameter("precio"))) {
                    forward = false;
                    destino = "control?target=inmueble&op=select&action=view";
                    Inmueble inmueble = new Inmueble();
                    inmueble.setTipo(request.getParameter("tipo"));
                    inmueble.setDireccion(request.getParameter("direccion"));
                    inmueble.setLocalidad(request.getParameter("localidad"));
                    inmueble.setUsuario(request.getParameter("usuario"));
                    inmueble.setPrecio(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precio"))));
                    inmueble.setId(Integer.parseInt(request.getParameter("id")));
                    ModeloInmueble.edit(inmueble);
                } else {
                    forward = true;
                    request.setAttribute("falso", "introduzca precio válido");
                    destino = "control?target=inmueble&op=edit&action=view";
                }
            } else {

                forward = true;
                request.setAttribute("nulos", "no deje campos vacios");
                destino = "control?target=inmueble&op=edit&action=view";
            }
        }
        if (forward) {
            request.getRequestDispatcher(destino).forward(request, response);
        } else {
            response.sendRedirect(destino);
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private static boolean esNumero(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
