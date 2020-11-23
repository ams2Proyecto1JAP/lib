package duolingo.lib.model;

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
}
