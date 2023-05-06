/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidad.Profesor;
import modelo.helper.HibernateUtil;
import org.hibernate.Session;


public class daoProfesor {
    
    public List<Profesor> getAll(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Profesor").list();
    }
}