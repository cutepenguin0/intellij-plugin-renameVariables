package org.plugin;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class ResultDialogWrapper extends DialogWrapper {
    private List<SelectedVariables> selectedVariables;
    private String selectedStrategy;
    public ResultDialogWrapper(List<SelectedVariables>selectedVariables,String selectedStrategy){
        super(true);
        this.setTitle("Rename Variables");
        this.selectedVariables = selectedVariables;
        this.selectedStrategy = selectedStrategy;
        init();
    }
    @Override
    protected @Nullable JComponent createCenterPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (selectedVariables != null) {

            for (SelectedVariables var : selectedVariables) {
                JPanel row = new JPanel();
                JLabel label = new JLabel(var.getOldName() + " (" + var.getType() + ")");
                List<String> suggestions = Objects.equals(selectedStrategy, "type") ? NameTypeSuggestions.TYPE_SUGGESTIONS.get(var.getType())
                                : NameTypeSuggestions.ABBREVIATION_SUGGESTIONS.get(var.getOldName());
                System.out.println(selectedStrategy);
                JComboBox<String> comboBox = new JComboBox<>();
                if (suggestions != null) {
                    for (String s : suggestions) {
                        comboBox.addItem(s);
                    }
                }
                else{
                    comboBox.addItem("No suggestions");
                }

                row.add(label);
                row.add(comboBox);

                panel.add(row);
            }
        }

        return new JScrollPane(panel);
    }
}
