/*******************************************************************************
 * Copyright (c) 2018 Martin Weber.
 *
 * Content is provided to you under the terms and conditions of the Eclipse Public License Version 2.0 "EPL".
 * A copy of the EPL is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.marw.cmake.cdt.internal.lsp.builtins;

import org.eclipse.cdt.ui.CUIPlugin;
import org.eclipse.cdt.ui.IBuildConsoleManager;

import de.marw.cmake4eclipse.mbs.console.AbstractConsole;

/**
 * A console for cmake invocations.
 *
 * @author Martin Weber
 */
public class DetectorConsole extends AbstractConsole {

  private static final String CONSOLE_CONTEXT_MENU_ID = "BuiltinDetectorConsole"; //$NON-NLS-1$

  @Override
  protected IBuildConsoleManager getConsoleManager() {
    return CUIPlugin.getDefault().getConsoleManager("Compiler Built-ins Detection Console", CONSOLE_CONTEXT_MENU_ID);
  }

}
