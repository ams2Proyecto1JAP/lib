package duolingo.lib.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class UsersModel {
	
	
	@Id
	@Column (name = "lang_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	
	public UsersModel( String username) {
		super();
		this.username = username;
	}
/*
	@Column
	private String password;
	@Column
	private String name;

	@Column
	private String surname1;

	@Column
	private String surname2;

	@Column
	private int coins;

	@Column
	private int exp_points;

	@Column
	private boolean streak_protector;	

	@Column
	private int lifes;

	@ManyToOne
	@JoinColumn (name = "league_id")
	private LeagueModel league;

	@ManyToOne
	@JoinColumn (name = "app_lang_id")
	private LangModel lang;

	@ManyToOne
	@JoinColumn (name = "actual_crs")
	private CrsModel actualCourse;
	
	@OneToOne (mappedBy = "user")
	private AvtModel avt;*/
	
	@ManyToMany(mappedBy = "following", cascade = CascadeType.ALL)
	@JoinTable(name="users_follow", 
	                joinColumns={@JoinColumn(name="followed_id")}, 
	                inverseJoinColumns={@JoinColumn(name="follower_id")})
	private List<UsersModel> followers;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="users_follow", 
                joinColumns={@JoinColumn(name="follower_id")}, 
                inverseJoinColumns={@JoinColumn(name="followed_id")})
	private List<UsersModel> following;
	
	public void followUser(UsersModel following)
	{
		this.following.add(following);
		following.getFollowd(this);
		
	}
	
	public void getFollowd(UsersModel follower)
	{
		this.followers.add(follower);
	}
}
