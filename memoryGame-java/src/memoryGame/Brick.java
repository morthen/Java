package memoryGame;
import javax.swing.JButton;


public class Brick extends JButton {

	private static final long serialVersionUID = 1L;
	int coordX;
    int coordY;
    String value;
	private boolean isFaceUp;

    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	public Brick(String value)
	{
		this.setValue(value);
	}

	public Brick(String buttonText, int coordX, int coordY) {
       // super(buttonText);
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public boolean isFaceUp() {
		return isFaceUp;
	}

	public void setFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}

	/**
     * @return the coordX
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * @return the coordY
     */
    public int getCoordY() {
        return coordY;
    }
}
