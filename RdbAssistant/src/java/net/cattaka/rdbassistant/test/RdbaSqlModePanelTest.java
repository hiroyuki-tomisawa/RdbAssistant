/*
 * Copyright (c) 2009, Takao Sumitomo
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, 
 * with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the 
 *       above copyright notice, this list of conditions
 *       and the following disclaimer.
 *     * Redistributions in binary form must reproduce
 *       the above copyright notice, this list of
 *       conditions and the following disclaimer in the
 *       documentation and/or other materials provided
 *       with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software
 * and documentation are those of the authors and should
 * not be interpreted as representing official policies,
 * either expressed or implied.
 */
/*
 * $Id: RdbaSqlModePanelTest.java 259 2010-02-27 13:45:56Z cattaka $
 */
package net.cattaka.rdbassistant.test;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import net.cattaka.rdbassistant.core.RdbaConnection;
import net.cattaka.rdbassistant.core.RdbaConnectionFactory;
import net.cattaka.rdbassistant.driver.mysql.MySqlRdbaConnectionInfo;
import net.cattaka.rdbassistant.gui.sql.RdbaSqlEditorTabbedPanel;

public class RdbaSqlModePanelTest {
	public static void main(String[] args) throws Exception {
		NullRdbaGuiInterface nullRdbaGuiInterface = new NullRdbaGuiInterface();
		//RdbaSqlModePanel rdbaSqlModePanel = new RdbaSqlModePanel(nullRdbaGuiInterface);
		RdbaSqlEditorTabbedPanel rdbaSqlModePanel = new RdbaSqlEditorTabbedPanel(nullRdbaGuiInterface);
		
		JFrame f = new JFrame();
		f.setSize(600,400);
		f.getContentPane().add(rdbaSqlModePanel);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
//		rdbaSqlModePanel.updateMenu(RdbaModeInterface.TargetMenu.FILE_MENU, fileMenu);
//		rdbaSqlModePanel.updateMenu(RdbaModeInterface.TargetMenu.EDIT_MENU, editMenu);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		f.setJMenuBar(menuBar);
		
		MySqlRdbaConnectionInfo rci = new MySqlRdbaConnectionInfo();
		rci.setHost("localhost");
		rci.setPort(3306);
		rci.setDatabase("rdbassistant");
		rci.setUserName("rdbassistant");
		rci.setPassword("rdbassistant");
		final RdbaConnection conn = RdbaConnectionFactory.createRdbConnection(rci, nullRdbaGuiInterface.getRdbaConfig().getRdbaJdbcBundle());
		rdbaSqlModePanel.setRdbConnection(conn);
		rdbaSqlModePanel.addTab();
		rdbaSqlModePanel.addTab();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		rdbaSqlModePanel.doGuiLayout();
	}
}
