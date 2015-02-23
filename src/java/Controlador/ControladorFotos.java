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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 *
 * @author Antonio
 */
@WebServlet(name = "ControladorFotos", urlPatterns = {"/controlfotos"})
@MultipartConfig
public class ControladorFotos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino = "index.html";
        boolean forward = false;
        String target, op, action, view;
        target = request.getParameter("target");
        op = request.getParameter("op");
        action = request.getParameter("action");
        if (target.equals("foto")
                && op.equals("select")
                && action.equals("view")) {
            forward = true;
            request.setAttribute("fotos", ModeloFoto.get());
            destino = "WEB-INF/inmueble/vistaFotos.jsp";
        } else if (target.equals("foto")
                && op.equals("delete")
                && action.equals("op")) {
            forward = false;
            String id = request.getParameter("id");
            Foto foto = ModeloFoto.get(id);
            ModeloFoto.delete(id);
            request.setAttribute("fotos", ModeloFoto.get());
            destino = "controlfotos?target=foto&op=select&action=view";
        } else if(target.equals("foto")
                && op.equals("insert")
                && action.equals("view")){
            forward = true;
            request.setAttribute("id", request.getParameter("id"));
            Inmueble i = ModeloInmueble.get(request.getParameter("id"));
            request.setAttribute("fotos", ModeloFoto.get());
            request.setAttribute("id", i.getId()+"");
            destino = "WEB-INF/inmueble/insertFoto.jsp";
        } else if(target.equals("foto")
                && op.equals("insert")
                && action.equals("op")){
            
            System.out.println("llega");
            forward = false;
            String id = request.getParameter("id");
            destino = "control?target=inmueble&op=select&action=view";
            Part filePart = request.getPart("archivo"); 
            InputStream fileContent = filePart.getInputStream();
            String fecha = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
            String fileName = "recursos/fotos/"+id+"_"+fecha+".jpg";
            response.setContentType("application/json;charset=UTF-8");
            try {
                FileOutputStream fos = new FileOutputStream( getServletContext().getRealPath("/") + fileName);
                byte[] array = new byte[1000]; // buffer temporal de lectura.
                int leido = fileContent.read(array);
                while (leido > 0) {
                    fos.write(array, 0, leido);
                    leido = fileContent.read(array);
                }
                fileContent.close();
                fos.close();
                Foto f = new Foto();
                f.setInmueble(ModeloInmueble.get(id));
                f.setRuta(fileName);
                System.out.println("foto"+f.getRuta().toString());
                ModeloFoto.insert(f);
            } catch (Exception e) {
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}