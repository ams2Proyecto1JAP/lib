package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import duolingo.lib.model.id.CatId;


@Entity
@Table (name = "cat")
@IdClass(CatId.class)
public class CatModel {
	
	@Id
	@Column (name = "cat_index")
	private int index;
	
	@Id
	@ManyToOne
	@JoinColumn (name = "crs_id")
	private CrsModel crs;	
	
	@Column
	private String name; 
	@Column
	private String image;
	
	@OneToMany (mappedBy = "cat")
	private List<LvlModel> levels;
	
	@ManyToMany(mappedBy = "categoriesRvd")
	private List<UsersModel> usersRvd;
	
	public CatModel(CrsModel crs, int index, String name, String image) {
		super();
		this.crs = crs;
		this.index = index;
		this.name = name;
		this.image = image;
		this.levels = new ArrayList<LvlModel>();
		this.usersRvd = new ArrayList<UsersModel>();
	}
	
	public void addLevel(LvlModel lvl) {
		this.levels.add(lvl);
	}
	
	public void addUserRvd(UsersModel usr)
	{
		this.usersRvd.add(usr);
	}
}
