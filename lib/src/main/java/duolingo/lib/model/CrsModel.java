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
	
	@OneToOne
	@JoinColumn (name = "lang_id")
	private LangModel lang;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "crs_id")
	private List<CatModel> categories;
	
	@OneToMany (mappedBy = "actualCourse")
	private List<UsersModel> actualUsers;
	
	@ManyToMany(mappedBy = "registeredCourses", cascade = CascadeType.ALL)
	private List<UsersModel> registeredUsers;

	public CrsModel(LangModel lang) {
		super();
		this.lang = lang;
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
}
