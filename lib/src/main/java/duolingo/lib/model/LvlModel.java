package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import duolingo.lib.model.id.LvlId;

@Entity
@Table (name = "lvl")
@IdClass(LvlId.class)
public class LvlModel {
	
	@Id
	@Column (name = "lvl_index")
	private int index;
	
	
	@Id
	@ManyToOne
	@JoinColumns(
		    {
		        @JoinColumn(name="cat_index", referencedColumnName="cat_index"),
		        @JoinColumn(name="crs_id", referencedColumnName="crs_id")
		    })
	private CatModel cat;	
	
	
	@OneToMany (mappedBy = "lvl")
	private List<ExsModel> exercices;
	
	@ManyToMany(mappedBy = "levelsResolved")
	private List<UsersModel> usersRvd;
	
	public LvlModel(){}
	public LvlModel(CatModel cat, int index) {
		super();
		this.cat = cat;
		this.index = index;
		this.exercices = new ArrayList<ExsModel>();
		this.usersRvd = new ArrayList<UsersModel>();
		
	}
	
	public void addUserRvd(UsersModel usr)
	{
		this.usersRvd.add(usr);
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public CatModel getCat() {
		return cat;
	}
	public void setCat(CatModel cat) {
		this.cat = cat;
	}
	public List<ExsModel> getExercices() {
		return exercices;
	}
	public void setExercices(List<ExsModel> exercices) {
		this.exercices = exercices;
	}
	public List<UsersModel> getUsersRvd() {
		return usersRvd;
	}
	public void setUsersRvd(List<UsersModel> usersRvd) {
		this.usersRvd = usersRvd;
	}
}
