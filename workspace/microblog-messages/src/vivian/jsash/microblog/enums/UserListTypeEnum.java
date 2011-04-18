package vivian.jsash.microblog.enums;

public enum UserListTypeEnum {
	
	New,
	Online,
	Populer,
	Group,
	Follow,
	Followed;

	public String getName( int value ) {
		switch( value ) {
			case 0:
				return New.name();
			case 1:
				return Online.name();
			case 2:
				return Populer.name();
			case 3:
				return Group.name();
			case 4:
				return Follow.name();
			default:
				return Followed.name();
		}
	}
}
