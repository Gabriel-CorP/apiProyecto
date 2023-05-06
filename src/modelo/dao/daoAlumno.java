
package modelo.dao;

import java.util.List;
import modelo.entidad.Alumno;
import modelo.helper.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class daoAlumno {
    
    public List<Alumno> getAll(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query al = sesion.createQuery("FROM Alumno");
        List<Alumno> a= al.list();
        
        return a;
    }
    public List<Alumno> getAlumno(int id ){
        System.out.println(id);
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query al = sesion.createQuery("FROM Alumno A Where A.numMatricula="+id);
        List<Alumno> a= al.list();
        
        return a;
    }
    public int agregarAlumno(Alumno a){
        System.out.println(a);
        String hql= "INSERT INTO Alumno(nombre,fechaNacimiento, telefono)"+"values ('"+a.getNombre()+"','"+a.getFechaNacimiento()+"','"+a.getTelefono()+"')";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query al = sesion.createQuery(hql);
        return al.executeUpdate();
    }
    public int modificarAlumno(Alumno a, int id){
        System.out.println(a);
        String hql= "UPDATE Alumno SET nombre= :nom, fechaNacimiento=:fecha, telefono =:tel WHERE numMatricula=:id ";        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query al = sesion.createQuery(hql);
        al.setParameter("nom", a.getNombre());
        al.setParameter("fecha", a.getFechaNacimiento());
        al.setParameter("tel", a.getTelefono());
        al.setParameter("id", id);
        int result= al.executeUpdate();
        System.err.println(result);
        return result;
    }
    public int eliminarAlumno(int id ){
        System.out.println(id);
        String hql="DELETE FROM Alumno WHERE numMatricula=:id";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query al = sesion.createQuery(hql);
        al.setParameter("id", id);
                
        return al.executeUpdate();
    }
            
}
