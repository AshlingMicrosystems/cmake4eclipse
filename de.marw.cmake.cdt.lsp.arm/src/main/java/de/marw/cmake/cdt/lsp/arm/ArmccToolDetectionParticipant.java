/*******************************************************************************
 * Copyright (c) 2019 Martin Weber.
 *
 * Content is provided to you under the terms and conditions of the Eclipse Public License Version 2.0 "EPL".
 * A copy of the EPL is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package de.marw.cmake.cdt.lsp.arm;

import de.marw.cmake.cdt.lsp.Arglets;
import de.marw.cmake.cdt.lsp.DefaultToolCommandlineParser;
import de.marw.cmake.cdt.lsp.DefaultToolDetectionParticipant;
import de.marw.cmake.cdt.lsp.IArglet;

/**
 * armcc C & C++.
 *
 * @author Martin Weber
 */
public class ArmccToolDetectionParticipant extends DefaultToolDetectionParticipant {

  public ArmccToolDetectionParticipant() {
    super("armcc", true, "exe", new ToolCommandlineParser());
  }

  private static class ToolCommandlineParser extends DefaultToolCommandlineParser {

    private static final IArglet[] arglets = {
        new Arglets.IncludePath_C_POSIX(),
        new Arglets.MacroDefine_C_POSIX(), new Arglets.MacroUndefine_C_POSIX(),
        new Arglets.SystemIncludePath_armcc()
    };

    private ToolCommandlineParser() {
      super(null, null, new ArmccBuiltinDetectionBehavior(), arglets);
    }
  }
}
