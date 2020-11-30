package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "shop_items")
public class ShopItemsModel {
	@Id
	@Column (name = "item_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int price;
	
	@Column
	private String image;
	
	@Column
	private String type;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@ManyToMany(mappedBy = "dressesAdquired", cascade = CascadeType.ALL)
	private List<UsersModel> usersAdquired;

	public ShopItemsModel(){}
	public ShopItemsModel(int price, String image, String type, String name, String description) {
		super();
		this.price = price;
		this.image = image;
		this.type = type;
		this.name = name;
		this.description = description;
		this.usersAdquired = new ArrayList<UsersModel>();
	}
	
	public void userBuy (UsersModel usr)
	{
		this.usersAdquired.add(usr);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UsersModel> getUsersAdquired() {
		return usersAdquired;
	}
	public void setUsersAdquired(List<UsersModel> usersAdquired) {
		this.usersAdquired = usersAdquired;
	}
}
