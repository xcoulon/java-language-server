package org.jboss.tools.vscode.ipc;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IPCPlugin implements BundleActivator {

	private static BundleContext context;
	
	@Override
	public void start(BundleContext context) throws Exception {
		IPCPlugin.context = context;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		IPCPlugin.context = null;
	}

	public static void log(IStatus status) {
		Platform.getLog(IPCPlugin.context.getBundle()).log(status);
	}
	
	public static void logError(String message) {
		log(new Status(IStatus.ERROR, context.getBundle().getSymbolicName(), message));
	}

	public static void logInfo(String message) {
		log(new Status(IStatus.INFO, context.getBundle().getSymbolicName(), message));
	}
	
	public static void logException(String message, Throwable ex) {
		log(new Status(IStatus.ERROR, context.getBundle().getSymbolicName(), message, ex));
	}
	
}
