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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	public List<UsersModel> getUsers() {
		return users;
	}
	public void setUsers(List<UsersModel> users) {
		this.users = users;
	}
}
