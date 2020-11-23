package duolingo.lib.model;
import java.util.List;

import javax.persistence.*;
@Entity
@Table (name = "lang")
public class LangModel {
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
