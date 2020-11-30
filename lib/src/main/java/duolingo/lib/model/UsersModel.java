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
	/*
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
	
	public int getId()
	{
		return this.id;
	}*/
	
	//Getters y setters comienza aqui....
	
	public void resolvedCategory(CatModel cat)
	{
		this.categoriesRvd.add(cat);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AvtModel getAvt() {
		return avt;
	}
	public void setAvt(AvtModel avt) {
		this.avt = avt;
	}
	public LangModel getAppLang() {
		return appLang;
	}
	public void setAppLang(LangModel appLang) {
		this.appLang = appLang;
	}
	public CrsModel getActualCourse() {
		return actualCourse;
	}
	public void setActualCourse(CrsModel actualCourse) {
		this.actualCourse = actualCourse;
	}
	public LeagueModel getLeague() {
		return league;
	}
	public void setLeague(LeagueModel league) {
		this.league = league;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname1() {
		return surname1;
	}
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}
	public String getSurname2() {
		return surname2;
	}
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public int getExp_points() {
		return exp_points;
	}
	public void setExp_points(int exp_points) {
		this.exp_points = exp_points;
	}
	public boolean isStreak_protector() {
		return streak_protector;
	}
	public void setStreak_protector(boolean streak_protector) {
		this.streak_protector = streak_protector;
	}
	public int getLifes() {
		return lifes;
	}
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	public List<CatModel> getCategoriesRvd() {
		return categoriesRvd;
	}
	public void setCategoriesRvd(List<CatModel> categoriesRvd) {
		this.categoriesRvd = categoriesRvd;
	}
	public List<LvlModel> getLevelsResolved() {
		return levelsResolved;
	}
	public void setLevelsResolved(List<LvlModel> levelsResolved) {
		this.levelsResolved = levelsResolved;
	}
	public List<ExsModel> getExercicesResolved() {
		return exercicesResolved;
	}
	public void setExercicesResolved(List<ExsModel> exercicesResolved) {
		this.exercicesResolved = exercicesResolved;
	}
	public List<ShopItemsModel> getDressesAdquired() {
		return dressesAdquired;
	}
	public void setDressesAdquired(List<ShopItemsModel> dressesAdquired) {
		this.dressesAdquired = dressesAdquired;
	}
	public List<CrsModel> getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(List<CrsModel> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	public List<UsersModel> getFollowers() {
		return followers;
	}
	public void setFollowers(List<UsersModel> followers) {
		this.followers = followers;
	}
	public List<UsersModel> getFollowing() {
		return following;
	}
	public void setFollowing(List<UsersModel> following) {
		this.following = following;
	}
	
	//acaba aqui ...
	
	public void resolvedLevel(LvlModel lvl)
	{
		this.levelsResolved.add(lvl);
	}
	public void resolvedExercice(ExsModel exs)
	{
		this.exercicesResolved.add(exs);
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
