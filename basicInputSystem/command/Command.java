package tools.basicInputSystem.command;

import java.util.ArrayList;

/**
 * Beschreibt abstrakt jeden Befehl, der im CommandTerminal get�tigt werden
 * kann. Der String command enth�llt den Befehl, der f�r eine sub class gillt.
 * 
 * Ein Command folgt stehts dieser syntax: NAME_DES_COMMANDS <ERSTER_PARAMETER>
 * <N_TER_PARAMTER> Es sind unendlich viele Paramter m�glich.
 * 
 * Ein Beispiel: kill <allPlayers> Beispiel zwei: hallo <Das ist ein Text> <f�r
 * Rosa>
 * 
 * Nat�rlich geht auch: kill </all>. Eventuell ist ein paramter Befehl dann
 * besser zu verstehen.... Ein paramter muss immer mit einer spitzen klammer
 * nach rechts starten und mit einer spitzen klammer nach rechts enden. Alles
 * zwischen diesen Klammern wird dann als paramter aufgefasst.
 */

public abstract class Command
{
	protected String command = "";

	/**
	 * @param command Der Name des Befehls, der in die Console eingeben werden soll
	 *                , damit etwas passiert.
	 */

	public Command(String command)
	{
		this.command = command;
	}

	/**
	 * F�hrt einen Befehlt aus. Mit methoden aufruf wird eine Liste aus Strings
	 * �bergeben, die als paramerter des Befehls dienen. Element 0 aus der liste ist
	 * der erste parameter. Theoretisch sind unendlich viele parameter m�glich.
	 * 
	 * @param params
	 */

	public void executeCommand(ArrayList<String> params)
	{
	}

	/**
	 * Wird von der Help klasse aufgerufen. Diese Methode sollte einen String
	 * zur�ckgeben, dessen Inhalt infos zu der kindsklasse einer Kommandklasse
	 * enth�llt. Der Inhalt, der hier zur�ckgeben wird, wir von der Help klasse in
	 * der Konsole ausgegeben.
	 * 
	 * @return
	 */

	public String getSpecificCommandInfo()
	{
		return "";
	}

	public final String getCommand()
	{
		return command;
	}
}
