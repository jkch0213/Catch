package Client;
public class MyInformation {

	private String gameId;
	private String numId;
	private int level;
	private int exp;
	private String introduce;

	public MyInformation() {
		// TODO Auto-generated constructor stub
		gameId="";
		numId="";
		level=1;
		exp=0;
		introduce="";

	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}
