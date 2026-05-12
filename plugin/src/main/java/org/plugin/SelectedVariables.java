package org.plugin;

public class SelectedVariables {
    private String oldName;
    private String newName;
    private String type;


    SelectedVariables(String o, String t){
        oldName = o;
        type = t;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
