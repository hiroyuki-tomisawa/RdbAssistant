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
 * $Id: CancelExecuteStatementDialog.java 232 2009-08-01 07:06:41Z cattaka $
 */
package net.cattaka.rdbassistant.gui.table;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

import net.cattaka.swing.util.ButtonsBundle;
import net.cattaka.util.ExceptionHandler;
import net.cattaka.util.MessageBundle;
import net.cattaka.util.StringUtil;

/**
 * ResultSet抽出時のキャンセル用ダイアログ
 * @author cattaka
 */
public class CancelExecuteStatementDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel messageLabel;
	private JLabel timeLabel;
	private StatementExecuteThread statementExecuteThread;
	private Timer timer;
	private long startTime;
	
	public CancelExecuteStatementDialog(Frame parentFrame, StatementExecuteThread statementExecuteThread, long startTime) throws HeadlessException {
		super(parentFrame);
		setTitle(MessageBundle.getMessage("now_sql_executing"));
		setSize(300,100);
		
		this.statementExecuteThread = statementExecuteThread;
		this.startTime = startTime;
		makeLayout();
	}
	private void makeLayout() {
		JButton cancelButton = new JButton();
		ButtonsBundle.applyButtonDifinition(cancelButton, "cancel");
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);
		this.messageLabel = new JLabel();
		this.messageLabel.setText(MessageBundle.getMessage("now_sql_executing"));
		this.timeLabel = new JLabel();
		
		cancelButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.messageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.getContentPane().add(this.messageLabel);
		this.getContentPane().add(this.timeLabel);
		this.getContentPane().add(cancelButton);

		// タイマーの設定
		{
			this.timer = new Timer(200, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateLabel();
				}
			});
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					timer.start();
				}
				@Override
				public void windowClosing(WindowEvent e) {
					timer.stop();
				}
			});
		}
	}
	
	private void updateLabel() {
		if (this.statementExecuteThread.isAlive()) {
			long time = System.currentTimeMillis() - startTime;
			this.timeLabel.setText(StringUtil.longToTimeString(time));
		} else {
			this.setVisible(false);
		}
	}
	public void doCancel() {
		statementExecuteThread.cancel();
		try {
			statementExecuteThread.join();
		} catch (InterruptedException e) {
			// あり得ない
			ExceptionHandler.error(e);
		}
		this.setVisible(false);
	}
	@Override
	public void dispose() {
		timer.stop();
		super.dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("cancel")) {
			doCancel();
		}
	}
}
