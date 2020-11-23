package duolingo.lib.model.id;

import duolingo.lib.model.UsersModel;

public class UsersFollowId {
	private UsersModel followed;
	private UsersModel follower;
	
	public UsersFollowId(UsersModel followed, UsersModel follower) {
		this.followed = followed;
		this.follower = follower;
	}
}
