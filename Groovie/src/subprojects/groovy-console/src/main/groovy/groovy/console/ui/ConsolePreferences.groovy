/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package groovy.console.ui

import groovy.beans.Bindable
import groovy.swing.SwingBuilder
import org.codehaus.groovy.tools.shell.util.MessageSource

import javax.swing.JDialog
import javax.swing.JFileChooser
import java.awt.Dimension

class ConsolePreferences {

    // Default maximum number of characters to show on console at any time
    static int DEFAULT_MAX_OUTPUT_CHARS = 20000
    static int DEFAULT_LOOP_MODE_DELAY_MILLIS = 1000

    @Bindable
    int maxOutputChars

    @Bindable
    int loopModeDelay

    private final console
    private final MessageSource T

    private JDialog dialog
    File outputFile

    ConsolePreferences(console) {
        this.console = console
        T = new MessageSource(Console)

        maxOutputChars = console.loadMaxOutputChars()
        loopModeDelay = console.prefs.getInt('loopModeDelay', DEFAULT_LOOP_MODE_DELAY_MILLIS)
        console.maxOutputChars = maxOutputChars
    }

    void show() {
        console.swing.edt {
            if (!dialog) {
                buildDialog()
            }
            dialog.setLocationRelativeTo(console.frame)
            dialog.pack()
            dialog.getRootPane().setDefaultButton(console.swing.closePrefsButton)
            console.swing.doLater console.swing.closePrefsButton.&requestFocusInWindow
            dialog.setVisible(true)
        }
    }

    private void buildDialog() {
        dialog = console.swing.dialog(
                title: T['prefs.dialog.title'], owner: console.frame, modal: true
        ) {
            vbox {
                vbox(border: titledBorder(T['prefs.output.settings.title'])) {
                    hbox {
                        label "${T['prefs.max.characters.output']}:"

                        formattedTextField value: maxOutputChars, id: 'txtMaxOutputChars',
                                text:
                                        bind(target: this, targetProperty: 'maxOutputChars',
                                                validator: this.&isInteger, converter: Integer.&parseInt),
                                columns: 6
                    }

                    hbox {
                        label "${T['prefs.loop.mode.title']}:"

                        formattedTextField value: loopModeDelay, id: 'txtLoopModeDelay',
                                text:
                        bind(target: this, targetProperty: 'loopModeDelay',
                                validator: this.&isInteger, converter: Integer.&parseInt),
                        columns: 8
                    }

                    hbox {
                        checkBox T['prefs.output.file'], id: 'outputFileCheckBox', selected: false
                        hglue()
                        label T['prefs.output.file.name'], id: 'outputFileName',
                                enabled: bind(source: outputFileCheckBox, sourceProperty: 'selected')
                        button T['prefs.output.file.select'], id: 'outputFileNameButton',
                                enabled: bind(source: outputFileCheckBox, sourceProperty: 'selected'),
                                actionPerformed: this.&onChooseFile
                    }
                }

                vglue()

                hbox {
                    button T['prefs.reset.defaults'], id: 'resetPrefsButton', actionPerformed: this.&onReset
                    hglue()
                    button T['prefs.close'], id: 'closePrefsButton', actionPerformed: this.&onClose
                }

            }
        }

        console.swing.txtMaxOutputChars.maximumSize = new Dimension(Integer.MAX_VALUE, (int) console.swing.txtMaxOutputChars.preferredSize.height)

        def outputLogFileName = console.prefs.get('outputLogFileName', null)
        if (outputLogFileName != null) {
            console.swing.outputFileCheckBox.selected = true
            console.swing.outputFileName.text = outputLogFileName
        }
    }

    private boolean isInteger(value) {
        try {
            Integer.parseInt(value)
            return true
        } catch (NumberFormatException ignore) {
            return false
        }
    }

    private void onReset(EventObject event) {
        console.swing.txtMaxOutputChars.text = DEFAULT_MAX_OUTPUT_CHARS
        console.swing.txtLoopModeDelay.text = DEFAULT_LOOP_MODE_DELAY_MILLIS
    }

    private void onClose(EventObject event) {
        console.prefs.putInt('maxOutputChars', maxOutputChars)
        console.prefs.putInt('loopModeDelay', loopModeDelay)
        // For backwards compatibility 'maxOutputChars' remains defined in the Console class
        // and so we update the value to keep it in sync.
        if (maxOutputChars != console.maxOutputChars) {
            console.maxOutputChars = maxOutputChars
        }

        console.setOutputPreferences(console.swing.outputFileCheckBox.enabled, outputFile)

        dialog.dispose()
    }

    private void onChooseFile(EventObject event) {
        JFileChooser fileChooser = console.swing.fileChooser()

        if (console.prefs.get('outputLogFileName', null) != null) {
            fileChooser.setSelectedFile(new File(console.prefs.get('outputLogFileName', null)))
        }

        if (fileChooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION) {
            outputFile = fileChooser.selectedFile
        }
        console.swing.outputFileName.text = outputFile.path
    }

    // Useful for testing gui
    static void main(args) {
        javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName())
        def c = new Expando().with {
            swing = new SwingBuilder()
            frame = swing.frame(title: 'foo', size: [800, 800])
            DEFAULT_MAX_OUTPUT_CHARS = 25000
            maxOutputChars = 25000
            loadMaxOutputChars = { 20000 }
            prefs = [putInt: { s, t -> }, getInt: { s, t -> t }]
            it
        }
        ConsolePreferences cp = new ConsolePreferences(c)
        cp.show()
        c.frame.dispose()
        println "maxOutputChars==${cp.maxOutputChars}"
        println "console.maxOutputChars==${c.maxOutputChars}"
        println 'done'
    }
}