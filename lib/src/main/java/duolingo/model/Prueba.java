package duolingo.model;
import javax.persistence.*;

@Entity
@Table (name = "prueba")
public class Prueba {
	
	@Id
	@Column (name = "idGato")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column 
	private String nombre; 
	
	private int getId() {
		return this.id;
	}
	public Prueba(String nombre) {
		this.nombre = nombre;
	}
}
