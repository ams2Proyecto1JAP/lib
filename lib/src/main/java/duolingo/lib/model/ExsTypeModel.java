package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "exs_type")
public class ExsTypeModel {

	@Id
	@Column (name = "exs_type_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String type;
	
	@OneToMany(mappedBy = "exsType")
	private List<ExsModel> exercices;
	
	public ExsTypeModel() {
		
	}
	public ExsTypeModel(String type) {
		this.type = type;
		this.exercices = new ArrayList<ExsModel>();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ExsModel> getExercices() {
		return exercices;
	}
	
	public void addExercices(ExsModel exs) {
		this.exercices.add(exs);
	}
	
}
