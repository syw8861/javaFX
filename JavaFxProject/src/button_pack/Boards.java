package button_pack;

public class Boards
{
	private String title;
	private String password;
	private String publicity;
	private String exitDate;
	private String content;
	public Boards(String title, String password, String publicity, String exitDate)
	{
		super();
		this.title = title;
		this.password = password;
		this.publicity = publicity;
		this.exitDate = exitDate;
	}
	public String getTitle()
	{
		return title;
	}
	public String getPassword()
	{
		return password;
	}
	public String getPublicity()
	{
		return publicity;
	}
	public String getExitDate()
	{
		return exitDate;
	}
	public String getContent()
	{
		return content;
	}
}
