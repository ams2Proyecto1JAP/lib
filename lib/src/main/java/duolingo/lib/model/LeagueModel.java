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
	
	@OneToMany (mappedBy = "league")
	private List<UsersModel> users;
	
	public LeagueModel(){}
	public LeagueModel (String name, int maxPoints)
	{
		this.name = name;
		this.maxPoints = maxPoints;
	}
	
	
	
}
