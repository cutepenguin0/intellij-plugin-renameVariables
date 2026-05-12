package org.plugin;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class ResultDialogWrapper extends DialogWrapper {
    List<String> selectedVariables;
    public ResultDialogWrapper(List<String> selectedVariables){
        super(true);
        this.setTitle("Rename Variables");
        this.selectedVariables = selectedVariables;
        init();
    }
    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        JPanel variablePanel = new JPanel();
        if(selectedVariables!=null) {
            for (String s : selectedVariables) {
                JLabel word = new JLabel(s);
                variablePanel.add(word);
            }
        }
        centralPanel.add(variablePanel);
        return centralPanel;
    }
}
