package org.plugin;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class DataDialogWrapper extends DialogWrapper {
    private String method;
    private List<String> variables;
    private final java.util.List<JCheckBox> checkBoxes = new java.util.ArrayList<>();
    private JRadioButton typeBtn;
    private JRadioButton nameBtn;
    protected DataDialogWrapper(String m, List<String> v) {
        super(true);
        method = m;
        variables = v;
        setTitle("Rename Local Variables");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        JPanel methodPanel = new JPanel(new BorderLayout());
        JLabel methodLabel = new JLabel("<html><pre>" + method + "</pre></html>");
        methodPanel.add(methodLabel, BorderLayout.CENTER);
        Border border = BorderFactory.createTitledBorder("For method:");
        methodPanel.setBorder(border);

        JPanel variablePanel = new JPanel(new BorderLayout());
        JLabel question  = new JLabel("What local variables name suggestion do you want to see?");
        variablePanel.add(question);
        variablePanel.setLayout(new BoxLayout(variablePanel, BoxLayout.X_AXIS));
        for (String var : variables) {
            JCheckBox cb = new JCheckBox(var);
            checkBoxes.add(cb);
            variablePanel.add(cb);
        }
        JPanel strategyPanel = new JPanel();
        strategyPanel.setLayout(new BoxLayout(strategyPanel, BoxLayout.Y_AXIS));
        strategyPanel.setBorder(BorderFactory.createTitledBorder("Suggestion strategy:"));
        JLabel question2 = new JLabel("Do you want suggestions based on type or name?");
        strategyPanel.add(question2);
        ButtonGroup group = new ButtonGroup();
        typeBtn = new JRadioButton("Based on type",true);
        nameBtn = new JRadioButton("Based on name");
        group.add(typeBtn);
        group.add(nameBtn);
        strategyPanel.add(typeBtn);
        strategyPanel.add(nameBtn);
        centralPanel.add(methodPanel);
        centralPanel.add(Box.createVerticalStrut(10));
        centralPanel.add(variablePanel);
        centralPanel.add(Box.createVerticalStrut(10));
        centralPanel.add(strategyPanel);
        return centralPanel;
    }

    public List<String> getSelectedVariables(){
        java.util.List<String> selected = new java.util.ArrayList<>();
        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                selected.add(cb.getText());
            }
        }
        return selected;
    }

    public String getSelectedStrategy() {
        if (typeBtn.isSelected()) return "type";
        if (nameBtn.isSelected()) return "name";
        return "type";
    }
}
