package modelo.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor" ,catalog="escuela")
public class Profesor  implements java.io.Serializable {
     private Integer idProfesor;
     private String nombre;
     private String especialidad;
     private String telefono;
     private Set<Asignatura> asignaturas = new HashSet(0);

    public Profesor() {
    }

    public Profesor(String nombre, String especialidad, String telefono) {
       this.nombre = nombre;
       this.especialidad = especialidad;
       this.telefono = telefono;      
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="IdProfesor", unique=true, nullable=false)
    public Integer getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    
    @Column(name="Nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="Especialidad", length=100)
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    @Column(name="Telefono", length=10)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="profesor")
    public Set<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }
    
    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }




}


