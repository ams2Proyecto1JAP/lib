package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class UsersModel {
	
	
	@Id
	@Column (name = "usr_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@OneToOne (mappedBy = "user")
	private AvtModel avt;
		
	@ManyToOne
	@JoinColumn (name = "app_lang_id")
	private LangModel appLang;
	
	@ManyToOne
	@JoinColumn (name = "actual_crs")
	private CrsModel actualCourse;
	
	@ManyToOne
	@JoinColumn (name = "league_id")
	private LeagueModel league;
	
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
	
	public UsersModel(){}
	public UsersModel(String username) {
		super();
		this.username = username;
		this.followers = new ArrayList<UsersModel>();
		this.following = new ArrayList<UsersModel>();
		this.registeredCourses = new ArrayList<CrsModel>();
		this.dressesAdquired = new ArrayList<ShopItemsModel>();
		this.categoriesRvd = new ArrayList<CatModel>();
		this.levelsResolved = new ArrayList<LvlModel>();
		this.exercicesResolved = new ArrayList<ExsModel>();
		
	}
	
	public void setAvt(AvtModel avt)
	{
		this.avt = avt;
	}
	public void setAppLang(LangModel lang) {
		this.appLang = lang;
	}
	public void setActualCourse(CrsModel crs)
	{
		this.actualCourse = crs;
	}
	public void setLeague (LeagueModel league)
	{
		this.league = league;
	}
	
	public void resolvedCategory(CatModel cat)
	{
		this.categoriesRvd.add(cat);
	}
	
	public void resolvedLevel(LvlModel lvl)
	{
		this.levelsResolved.add(lvl);
	}
	public void resolvedExercice(ExsModel exs)
	{
		this.exercicesResolved.add(exs);
	}
	public int getId()
	{
		return this.id;
	}
	

	

	
	// Resolved funcionalities

	
		// Categories
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="cat_rvd", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={                		
                			        @JoinColumn(name="cat_index", referencedColumnName="cat_index"),
                			        @JoinColumn(name="crs_id", referencedColumnName="crs_id")
                			        })
	private List<CatModel> categoriesRvd;
	
	
	

		// Levels
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="lvl_rvd", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={ 
                					@JoinColumn(name="lvl_index", referencedColumnName="lvl_index"),
                			        @JoinColumn(name="cat_index", referencedColumnName="cat_index"),
                			        @JoinColumn(name="crs_id", referencedColumnName="crs_id")
                			        })
	private List<LvlModel> levelsResolved;
	
		// Exercices
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="exs_rvd", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={ 
                					@JoinColumn(name="exs_index", referencedColumnName="exs_index"),
                					@JoinColumn(name="lvl_index", referencedColumnName="lvl_index"),
                			        @JoinColumn(name="cat_index", referencedColumnName="cat_index"),
                			        @JoinColumn(name="crs_id", referencedColumnName="crs_id")
                			        })
	private List<ExsModel> exercicesResolved;
	
	
	
	
	// Compra de vestidos
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="usr_dresses", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={@JoinColumn(name="item_id")})
	private List<ShopItemsModel> dressesAdquired;
	
	public void buyDress(ShopItemsModel dress)
	{
		this.dressesAdquired.add(dress);
	}
	
	// Courses registrados
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="users_crs", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={@JoinColumn(name="crs_id")})
	private List<CrsModel> registeredCourses;
	
	public void registerCourse(CrsModel crs)
	{
		this.registeredCourses.add(crs);
	}
	
	// Follower functionality
	
	@ManyToMany(mappedBy = "following", cascade = CascadeType.ALL)
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
