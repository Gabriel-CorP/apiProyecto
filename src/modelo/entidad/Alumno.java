package modelo.entidad;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="alumno" ,catalog="escuela")
public class Alumno  implements java.io.Serializable {
     private Integer numMatricula;
     private String nombre;
     private Date fechaNacimiento;
     private String telefono;
     private Set<Recibe> recibes = new HashSet(0);

    public Alumno() {
    }

    public Alumno(String nombre, Date fechaNacimiento, String telefono) {
       this.nombre = nombre;
       this.fechaNacimiento = fechaNacimiento;
       this.telefono = telefono;      
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)   
    @Column(name="NumMatricula", unique=true, nullable=false)
    public Integer getNumMatricula() {
        return this.numMatricula;
    }    
    public void setNumMatricula(Integer numMatricula) {
        this.numMatricula = numMatricula;
    }
    
    @Column(name="Nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaNacimiento", length=10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    @Column(name="Telefono", length=10)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="alumno")
    public Set<Recibe> getRecibes() {
        return this.recibes;
    }
    
    public void setRecibes(Set<Recibe> recibes) {
        this.recibes = recibes;
    }




}


