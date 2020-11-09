package org.glassfish.jersey.archetypes.jersey_quickstart_webapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.glassfish.jersey.archetypes.jersey_quickstart_webapp.Survey;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	private static SessionFactory factory; 
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces("application/json")
    public List<Survey> getSurvey() {
    	
    	  try {
 	         factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
 	      } catch (Throwable ex) { 
 	         System.err.println("Failed to create sessionFactory object." + ex);
 	         throw new ExceptionInInitializerError(ex); 
 	      }
    	  List<Survey> surveys = null;
    	  Session session = factory.openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         surveys = session.createQuery("FROM SURVEY").list(); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close();
	         
	      }
	     return surveys;
    }
    
    @POST
    @Path("/create")
    @Consumes("application/x-www-form-urlencoded")
    public Response addEmployee(@FormParam("FirstName") String FirstName, @FormParam("Lastname") String Lastname,@FormParam("Street_Addr") String Street_Addr,@FormParam("City") String City,@FormParam("State") String State,@FormParam("Zip") int Zip,@FormParam("Tel_NO") int Tel_NO,@FormParam("E_Mail") String E_Mail,@FormParam("Dat") String Dat,@FormParam("Abt_Campus") String Abt_Campus,@FormParam("Uni_Ist") String Uni_Ist,@FormParam("Recommendation") String Recommendation ){
                
        try {
	         factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
   	 
   	 Session session = factory.openSession();
	      Transaction tx = null;
	      Integer SurveyID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Survey survey = new Survey(FirstName,Lastname,Street_Addr,City,State,Zip,Tel_NO,E_Mail,Dat,Abt_Campus,Uni_Ist,Recommendation);
	         SurveyID = (Integer) session.save(survey); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
   	 
        
        return Response.ok().build();
    }
    
    
}
