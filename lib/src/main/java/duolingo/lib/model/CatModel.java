package duolingo.lib.model;

import javax.persistence.*;

import duolingo.lib.model.id.CatId;


@Entity
@Table (name = "cat")
@IdClass(CatId.class)
public class CatModel {
	
	@Id
	@Column (name = "cat_index")
	private int index;
	
	public CatModel(CrsModel crs, int index, String name, String image) {
		super();
		this.crs = crs;
		this.index = index;
		this.name = name;
		this.image = image;
	}
	@Id
	@ManyToOne
	@JoinColumn (name = "crs_id")
	private CrsModel crs;	
	
	@Column
	private String name; 
	@Column
	private String image;
}
