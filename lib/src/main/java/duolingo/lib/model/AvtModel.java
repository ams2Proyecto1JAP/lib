package duolingo.lib.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table (name = "avt")
public class AvtModel implements Serializable { 
	// Da error porque no implementa Serializable, diciendo que los objetos con clave compuesta
	// deben implementarla, pero este modelo no tiene clave compuesta (solo tiene una etiqueta @Id)
	// y el modelo al que hace referencia (UsersModel), tampoco tiene clave compuesta.
	// Implementandola se soluciona el error, pero no tiene sentido.
	@Id
	@OneToOne
	@JoinColumn (name = "usr_id")
	private UsersModel user;
	
	@Column
	private String image;
	
	public AvtModel (UsersModel user, String imagePath)
	{
		this.image = imagePath;
		this.user = user;
	}

}
