package br.com.victor.todolistui.exception;

import com.vaadin.flow.component.notification.Notification;

public class TodoException extends  RuntimeException  {
    private String name;
    private String description;

    public TodoException(String name, String description,String mensagem) {
        super(mensagem);
        this.setName(name);
        this.setDescription(description);
    }
    public TodoException(String mensagem) {
        super(mensagem);
        Notification notification = new Notification();
        notification.show(mensagem,3000, Notification.Position.TOP_END);

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
