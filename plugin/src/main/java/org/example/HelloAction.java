package org.example;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
public class HelloAction extends AnAction {
    private String prompt;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        PsiFile file = e.getData(CommonDataKeys.PSI_FILE);
        if (editor == null || file == null) return;
        String variable = getVariableName(editor, file);
        String method = getFullMethod(editor, file);
        if (variable != null && method != null) {
            prompt = buildPromptMethod(variable, method);
        }
        System.out.println(prompt);
        System.out.println("hello");
    }

    public String getVariableName(Editor editor, PsiFile file){
        int offset = editor.getCaretModel().getOffset();
        PsiElement element = file.findElementAt(offset);
        if (element == null && offset > 0) {
            element = file.findElementAt(offset - 1);
        }
        PsiNamedElement variable = PsiTreeUtil.getParentOfType(element, PsiNamedElement.class);
        if(variable != null){
            return variable.getName();
        }
        return null;
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