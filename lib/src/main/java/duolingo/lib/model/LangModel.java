package duolingo.lib.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table (name = "lang")
public class LangModel {
	
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
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "app_lang_id")
	private List<UsersModel> users;
	
}
