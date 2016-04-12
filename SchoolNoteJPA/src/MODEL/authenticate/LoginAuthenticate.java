package MODEL.authenticate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MODEL.entities.UserHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginAuthenticate.
 * 
 * @author Martin Özgun
 */
public class LoginAuthenticate {  
	
	
  /**
   * Validate user parameters.
   *
   * @author Martin Özgun
   */
  public static boolean validate(String username, String password) {          
   
	  if(UserHandler.validation(username, password) == "success"){
		  return true;
	  }
	  
	  return false;
  }  
}  