package modelo.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignatura" ,catalog="escuela")
public class Asignatura  implements java.io.Serializable {
     private int codAsignatura;
     private Profesor profesor;
     private String nombre;
     private Set<Recibe> recibes = new HashSet(0);

    public Asignatura() {
    }	
    public Asignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }
    public Asignatura(int codAsignatura, Profesor profesor, String nombre) {
       this.codAsignatura = codAsignatura;
       this.profesor = profesor;
       this.nombre = nombre;       
    }
   
     @Id   
    @Column(name="CodAsignatura", unique=true, nullable=false)
    public int getCodAsignatura() {
        return this.codAsignatura;
    }
    
    public void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdProfesor")
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
    @Column(name="Nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="asignatura")
    public Set<Recibe> getRecibes() {
        return this.recibes;
    }
    
    public void setRecibes(Set<Recibe> recibes) {
        this.recibes = recibes;
    }




}


