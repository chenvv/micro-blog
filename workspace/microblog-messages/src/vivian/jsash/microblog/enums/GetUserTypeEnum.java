package vivian.jsash.microblog.enums;

public enum GetUserTypeEnum {
	
	ID,
	NAME,
	EMAIL;

	public String getName( int value ) {
		switch( value ) {
		case 0:
			return ID.name();
		case 1:
			return NAME.name();
		default:
			return EMAIL.name();
		}
	}
}
