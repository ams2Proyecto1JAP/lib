package duolingo.lib.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "crs")
public class CrsModel {
	@Id
	@Column (name = "crs_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn (name = "lang_origin_id")
	private LangModel langOrigin;
	
	@ManyToOne
	@JoinColumn (name = "lang_destiny_id")
	private LangModel langDestiny;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "crs_id")
	private List<CatModel> categories;
	
	@OneToMany (mappedBy = "actualCourse")
	private List<UsersModel> actualUsers;
	
	@ManyToMany(mappedBy = "registeredCourses", cascade = CascadeType.ALL)
	private List<UsersModel> registeredUsers;

	public CrsModel() {}
	public CrsModel(LangModel langOrigin, LangModel langDestiny) {
		super();
		this.langOrigin = langOrigin;
		this.langDestiny = langDestiny;
		this.categories = new ArrayList<CatModel>();
		this.actualUsers = new ArrayList<UsersModel>();
		this.registeredUsers = new ArrayList<UsersModel>();		
	}
	
	public void addCategory(CatModel cat)
	{
		this.categories.add(cat);
	}
	
	public void registerUser(UsersModel usr)
	{
		this.registeredUsers.add(usr);
	}
	public LangModel getLangOrigin() {
		return langOrigin;
	}
	public void setLangOrigin(LangModel langOrigin) {
		this.langOrigin = langOrigin;
	}
	public LangModel getLangDestiny() {
		return langDestiny;
	}
	public void setLangDestiny(LangModel langDestiny) {
		this.langDestiny = langDestiny;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CatModel> getCategories() {
		return categories;
	}
	public void setCategories(List<CatModel> categories) {
		this.categories = categories;
	}
	public List<UsersModel> getActualUsers() {
		return actualUsers;
	}
	public void setActualUsers(List<UsersModel> actualUsers) {
		this.actualUsers = actualUsers;
	}
	public List<UsersModel> getRegisteredUsers() {
		return registeredUsers;
	}
	public void setRegisteredUsers(List<UsersModel> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}
}
