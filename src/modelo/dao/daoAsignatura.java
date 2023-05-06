
package modelo.dao;

import java.util.List;
import modelo.entidad.Asignatura;
import modelo.helper.HibernateUtil;
import org.hibernate.Session;


public class daoAsignatura {
    
    public List<Asignatura> getAll(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Asignatura").list();
    }
}