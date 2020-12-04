package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import duolingo.lib.model.id.ExsId;

@Entity
@Table (name = "exs")
@IdClass(ExsId.class)
public class ExsModel {
	
	@Id
	@Column (name = "exs_index")
	private int index;
	
	
	@Id
	@ManyToOne
	@JoinColumns(
		    {
		        @JoinColumn(name="cat_index", referencedColumnName="cat_index"),
		        @JoinColumn(name="crs_id", referencedColumnName="crs_id"),
		        @JoinColumn(name="lvl_index", referencedColumnName="lvl_index")
		    })
	private LvlModel lvl;	
	
	@Column 
	private String content;
	
	
	@ManyToOne 
	@JoinColumn (name = "exs_type")
	private ExsTypeModel exsType;
	
	@ManyToMany(mappedBy = "exercicesResolved")
	private List<UsersModel> usersRvd;
	
	public ExsModel(){}
	public ExsModel(LvlModel lvl, int index, ExsTypeModel exsType, String content) {
		super();
		this.lvl = lvl;
		this.index = index;
		this.exsType = exsType;
		this.content = content;
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
	public LvlModel getLvl() {
		return lvl;
	}
	public void setLvl(LvlModel lvl) {
		this.lvl = lvl;
	}
	public List<UsersModel> getUsersRvd() {
		return usersRvd;
	}
	public void setUsersRvd(List<UsersModel> usersRvd) {
		this.usersRvd = usersRvd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ExsTypeModel getExsType() {
		return exsType;
	}
	public void setExsType(ExsTypeModel exsType) {
		this.exsType = exsType;
	}
}
