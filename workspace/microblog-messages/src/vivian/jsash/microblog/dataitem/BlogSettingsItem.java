package vivian.jsash.microblog.dataitem;

public class BlogSettingsItem {
	private int accoutId;
	private String language;
	private byte timeZone;
	private String infoPublic;
	private String usedThemeUrl;
	private String backgroundImageUrl;

	public void setAccoutId(int accoutId) {
		this.accoutId = accoutId;
	}

	public int getAccoutId() {
		return accoutId;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setTimeZone(byte timeZone) {
		this.timeZone = timeZone;
	}

	public byte getTimeZone() {
		return timeZone;
	}

	public void setInfoPublic(String infoPublic) {
		this.infoPublic = infoPublic;
	}

	public String getInfoPublic() {
		return infoPublic;
	}

	public void setUsedThemeUrl(String usedThemeUrl) {
		this.usedThemeUrl = usedThemeUrl;
	}

	public String getUsedThemeUrl() {
		return usedThemeUrl;
	}

	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}

	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}
}
