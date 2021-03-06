package utils;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Utils {

	/**
	 * Show one error message
	 * @param window Window where it will appear the message
	 * @param message Message that it will shown to user
	 * @param title Message's title
	 */
	public static void showError(Component window, String title, String message)
	{
		JOptionPane.showMessageDialog(window, message, title, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Show one warning message
	 * @param window Window where it will appear the message
	 * @param message Message that it will shown to user
	 * @param title Message's title
	 */
	public static void showWarn(Component window, String title, String message)
	{
		JOptionPane.showMessageDialog(window, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Show one information message
	 * @param window Window where it will appear the message
	 * @param message Message that it will shown to user
	 * @param title Message's title
	 */
	public static void showInfo(Component window, String message, String title)
	{
		JOptionPane.showMessageDialog(window, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Show one confirm message
	 * @param window Window where it will appear the message
	 * @param message Message that it will shown to user
	 * @param title Message's title
	 * @param buttons Buttons that it will available to user selects
	 * @return
	 */
	public static int confirmDialog(Component window, String message, String title, int buttons)
	{
		return JOptionPane.showConfirmDialog(window, message, title, buttons);
	}

}
