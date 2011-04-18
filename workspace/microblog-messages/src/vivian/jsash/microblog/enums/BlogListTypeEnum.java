package vivian.jsash.microblog.enums;

public enum BlogListTypeEnum {
	
	ALL,
	Personal,
	Mix,
	SubBlog;

	public String getName( int value ) {
		switch( value ) {
			case 0:
				return ALL.name();
			case 1:
				return Personal.name();
			case 2:
				return Mix.name();
			default:
				return SubBlog.name();
		}
	}
}
