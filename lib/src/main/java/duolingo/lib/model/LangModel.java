package duolingo.lib.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table (name = "lang")
public class LangModel {
	
	public LangModel() {}
	public LangModel(String cod) {
		super();
		this.cod = cod;
		users = new ArrayList<UsersModel>();
	}
	
	public void setCrs(CrsModel crs)
	{
		this.crs = crs;
	}

	@Id
	@Column (name = "lang_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String cod;
	
	@OneToOne (mappedBy = "lang")
	private CrsModel crs;
	
	@OneToMany (mappedBy = "appLang")
	private List<UsersModel> users;
	
	
	public void addUser(UsersModel usr)
	{
		this.users.add(usr);
	}
	public int getId()
	{
		return this.id;
	}
	
}
