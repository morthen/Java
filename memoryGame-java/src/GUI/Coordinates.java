package GUI;

public class Coordinates {

	private int row;
	private int column;
	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Coordinates(int i, int j) {
		this.setRow(i);
		this.setColumn(j);
	}

	public Coordinates(int x, int y, String value) {
		this.setRow(x);
		this.setColumn(y);
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
