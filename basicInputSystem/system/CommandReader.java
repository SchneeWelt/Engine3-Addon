package tools.basicInputSystem.system;

/**
 * Lie�t den Command aus einer daf�r vorgesehenen String sequez aus.
 */

public class CommandReader
{
	/**
	 * Lie�t aus dem eingabe String den Command aus
	 * 
	 * @param input
	 * @return
	 */

	public final String readCommand(String input)
	{
		if (input == null)
			return "";
		
		return input.split(" ")[0];
	}
}
