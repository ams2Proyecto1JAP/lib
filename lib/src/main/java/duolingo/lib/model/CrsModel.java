package duolingo.lib.model;
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
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "actual_crs")
	private List<UsersModel> users;
}
