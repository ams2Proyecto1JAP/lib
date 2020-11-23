package duolingo.lib.model;

import javax.persistence.*;

import duolingo.lib.model.id.UsersFollowId;

@Entity
@Table (name = "users_follow")
@IdClass(UsersFollowId.class)
public class UsersFollowModel {
	
	@Id
	@Column
	private UsersModel followed;
	
	@Id
	@Column
	private UsersModel follower;

	public UsersFollowModel(UsersModel followed, UsersModel follower) {
		super();
		this.followed = followed;
		this.follower = follower;
	}
	
}
