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
	
	@Id
	@ManyToOne
	@JoinColumn (name = "crs_id")
	private CrsModel crs;	
	
	@Column
	private String name; 
	@Column
	private String image;
}
