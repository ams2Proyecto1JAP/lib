package duolingo.lib.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "league")
public class LeagueModel {

	@Id
	@Column (name = "league_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column (name = "max_points")
	private int maxPoints;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "league_id")
	private List<UsersModel> users;
	
	
	
}
