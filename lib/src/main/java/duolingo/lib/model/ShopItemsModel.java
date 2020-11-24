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
	
}
