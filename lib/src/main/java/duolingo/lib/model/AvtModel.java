package duolingo.lib.model;

import javax.persistence.*;


@Entity
@Table (name = "avt")
public class AvtModel {
	
	@Id
	@OneToOne
	@JoinColumn (name = "usr_id")
	private UsersModel user;
	
	@Column
	private String image;

}
