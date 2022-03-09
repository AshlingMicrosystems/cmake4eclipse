/*******************************************************************************
 * Copyright (c) 2013 Martin Weber.
 *
 * Content is provided to you under the terms and conditions of the Eclipse Public License Version 2.0 "EPL".
 * A copy of the EPL is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.marw.cmake4eclipse.mbs.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * @author Martin Weber
 */
public class Activator extends Plugin {

  public static final String PLUGIN_ID = "de.marw.cmake4eclipse.mbs"; //$NON-NLS-1$
  /** extension id of the cmake-generated makefile builder */
  public static final String BUILDER_ID = Activator.PLUGIN_ID
      + "." + "genmakebuilder"; //$NON-NLS-1$

  //The shared instance.
  private static Activator plugin;

  /**
   * The constructor.
   */
  public Activator() {
  }

  /**
   * This method is called upon plug-in activation
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    if (!PLUGIN_ID.equals(this.getBundle().getSymbolicName()))
      throw new RuntimeException(
          "BUG: PLUGIN_ID does not match Bundle-SymbolicName");
    plugin = this;
  }

  /**
   * This method is called when the plug-in is stopped
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    super.stop(context);
    plugin = null;
  }

  /**
   * Returns the shared instance.
   */
  public static Activator getDefault() {
    return plugin;
  }
  
  /**
   * Logs an internal error with the specified message.
   * 
   * @param message the error message to log
   */
  public static void logErrorMessage(String message) {
      // this message is intentionally not internationalized, as an exception may
      // be due to the resource bundle itself
      log(newErrorStatus(IStatus.ERROR, "Internal message logged from Debug UI: " + message, null)); //$NON-NLS-1$   
  }
  
  /**
   * Returns a new error status for this plug-in with the given message
   * 
   * @param message the message to be included in the status
   * @param error code
   * @param exception the exception to be included in the status or <code>null</code> if none
   * @return a new error status
   * 
   * @since 2.0
   */
  public static IStatus newErrorStatus(int code, String message, Throwable exception) {
      return new Status(IStatus.ERROR, Activator.PLUGIN_ID, code, message, exception);
  }
  
  /**
   * Logs the specified status with this plug-in's log.
   * 
   * @param status status to log
   */
  public static void log(IStatus status) {
      getDefault().getLog().log(status);
  }
}
