package controlador;

import com.mysql.cj.protocol.a.authentication.Sha256PasswordPlugin;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

public class MiSesionCTO extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
      String accion = request.getParameter("accion");
      UsuarioDAO dao= new UsuarioDAO();
        switch (accion) {
            case "validar":
                String usuario = request.getParameter("txtUser");
                String clave = this.cifrar(request.getParameter("txtPss")); 
                UsuarioDTO dto= new UsuarioDTO(usuario,clave);
                dto= dao.valSesion(dto);
                if (dto!= null) {
                    HttpSession session= request.getSession();
                    session.setAttribute("usActual", dto);
                    request.getRequestDispatcher("ProductoCTO?accion=listar_datos").forward(request, response);
                }else{
                    System.out.println("No valido");
                }
                break;
            case "salir":

                break;

            default:
                throw new AssertionError();
        }
    }

    
    
    
    
    private String cifrar(String clave) {
        String clave2 = "";
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.reset();
            sha256.update(clave.getBytes("utf8"));
            clave2=Base64.getEncoder().encodeToString(sha256.digest());
            System.out.println("Clave2: "+clave2);
            System.out.println("tamaño: "+clave2.length());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Errar al cifrar");
//Logger.getLogger(MiSesionCTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clave2;

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
    }// </editor-fold>

}
