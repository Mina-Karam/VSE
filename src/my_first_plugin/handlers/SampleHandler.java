package my_first_plugin.handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}
	
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"VSE",
				"Hello, Siemens Egypt");
		try
	    {
	        Runtime r = Runtime.getRuntime();

	        String pythonScriptPath = "C:\\Users\\minak\\OneDrive\\Desktop\\VSE.py";
	        Process p = r.exec("python " + pythonScriptPath);

	        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line = "";
	        while((line = bfr.readLine()) != null) {
	        // display each output line form python script
	        System.out.println(line);
	    }
	    }
	    catch (Exception e)
	    {
	    String cause = e.getMessage();
	    if (cause.equals("python: not found"))
	        System.out.println("No python interpreter found.");
	    }
	    return null;
	}
}
