package duolingo.lib.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table (name = "lang")
public class LangModel {
	
	public LangModel() {}
	public LangModel(String nombre, String locale) {
		super();
		this.nombre = nombre;
		this.locale = locale;
		users = new ArrayList<UsersModel>();
		crsLangOrigin = new ArrayList<CrsModel>();
		crsLangDestiny = new ArrayList<CrsModel>();
	}
	

	@Id
	@Column (name = "lang_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;

	@Column
	private String locale;
	
	@OneToMany (mappedBy = "appLang")
	private List<UsersModel> users;
	
	@OneToMany (mappedBy = "langOrigin")
	private List<CrsModel> crsLangOrigin;
	
	@OneToMany (mappedBy = "langDestiny")
	private List<CrsModel> crsLangDestiny;
	
	public void addUser(UsersModel usr)
	{
		this.users.add(usr);
	}
	public int getId()
	{
		return this.id;
	}
	
	public List<CrsModel> getCrsLangOrigin() {
		return crsLangOrigin;
	}
	
	public void setCrsLangOrigin(List<CrsModel> crsLangOrigin) {
		this.crsLangOrigin = crsLangOrigin;
	}
	
	public List<CrsModel> getCrsLangDestiny() {
		return crsLangDestiny;
	}
	
	public void setCrsLangDestiny(List<CrsModel> crsLangDestiny) {
		this.crsLangDestiny = crsLangDestiny;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public List<UsersModel> getUsers() {
		return users;
	}
	public void setUsers(List<UsersModel> users) {
		this.users = users;
	}
	public void setId(int id) {
		this.id = id;
	}
}
