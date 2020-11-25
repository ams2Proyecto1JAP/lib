package duolingo.lib.dao.interfaces;


import duolingo.lib.model.ShopItemsModel;

public interface IShopItems {

	public ShopItemsModel getShopItemById(int id);
	public boolean saveShopItem(ShopItemsModel item);
}
