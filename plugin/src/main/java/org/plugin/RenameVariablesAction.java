package org.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RenameVariablesAction extends AnAction {
    private String prompt;
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        PsiFile file = e.getData(CommonDataKeys.PSI_FILE);
        if (editor == null || file == null) return;
        List<String> variable = getVariableName(editor, file);
        String method = getFullMethod(editor, file);
        DataDialogWrapper dialog = new DataDialogWrapper(method, variable);
        List<String> selected = null;
        if (dialog.showAndGet()) {
            selected = dialog.getSelectedVariables();
        }
        if (selected != null && !selected.isEmpty()) {
            ResultDialogWrapper resultDialog = new ResultDialogWrapper(selected);
            resultDialog.show();
        }
    }

    public List<String> getVariableName(Editor editor, PsiFile file){
        int offset = editor.getCaretModel().getOffset();
        PsiElement element = file.findElementAt(offset);
        if (element == null && offset > 0) {
            element = file.findElementAt(offset - 1);
        }
        PsiMethod method = PsiTreeUtil.getParentOfType(element, PsiMethod.class);
        if (method == null) return null;
        Collection<PsiLocalVariable> variables = PsiTreeUtil.findChildrenOfType(method, PsiLocalVariable.class);
        List<String> result = new ArrayList<>();
        for (PsiLocalVariable var : variables) {
            var.getName();
            result.add(var.getName());
        }

        return result;


    }


    public String getFullMethod(Editor editor, PsiFile file) {
        int offset = editor.getCaretModel().getOffset();
        PsiElement element = file.findElementAt(offset);
        PsiMethod method = PsiTreeUtil.getParentOfType(element, PsiMethod.class);
        String fullMethod = null;
        if (method != null) {
            fullMethod = method.getText();
        }
        return fullMethod;
    }

    public String buildPromptMethod(String variable, String method){
        String sb = "For my method \n" + method + "\n" +"give me three examples to rename variable " + variable;
       return sb;
    }
}