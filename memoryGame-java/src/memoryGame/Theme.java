package memoryGame;

public class Theme {

	private int themeId;
	private String themeName;
	
	
	public Theme() {
		super();
	}
	
	public Theme(int themeId, String themeName) {
		super();
		this.themeId = themeId;
		this.themeName = themeName;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
	
	
}
