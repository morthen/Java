package GUI;

public class Runner {

	public static void main(String[] args) {
		Runner runner = new Runner();
		GUIGameSettings settings = new GUIGameSettings();
		
		runner.startMenu(settings);
	}
	
	@SuppressWarnings("deprecation")
	public void startMenu(GUIGameSettings settings){
		
		
		GUISettingsBoard settingsBoard = new GUISettingsBoard(settings);
		settingsBoard.show(true);
		
		while (settings.isSettingsWindow()){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			// wait here for settings
		}
		
		settingsBoard.dispose(); // removes settings board (could be hide if we want a way to save info)
		
		System.out.println(settings.getGridColumns() + " columns");
		System.out.println(settings.getGridRows() + " rows");
		System.out.println(settings.getTheme() + " theme");
		System.out.println(settings.getTime() + " time");
		System.out.println(settings.getNumberOfPlayers() + " players");
		
		
		GUINameSelectWindow nameSelect = new GUINameSelectWindow(settings);
		nameSelect.show();
		
		while (!nameSelect.isStartButtonPressed()){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			// wait here for name select
		}
		
		nameSelect.dispose();
		
		System.out.println(" ------------ Name Select -----------------");
		for (int i = 0; i < settings.getNumberOfPlayers(); i++)
		System.out.println(settings.getPlayers().get(i).getName() + " : " + settings.getPlayers().get(i).getClass());
		
		
		// TODO: get main board
		
		
	}
	
}
