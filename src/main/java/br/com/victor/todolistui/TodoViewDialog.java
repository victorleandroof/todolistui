package br.com.victor.todolistui;

import br.com.victor.todolistui.exception.TodoException;
import br.com.victor.todolistui.service.TodoService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class TodoViewDialog extends Dialog {

    private Logger log = LoggerFactory.getLogger(TodoView.class);


    public TodoViewDialog(@Autowired TodoService todoService) {
        VerticalLayout formDiv = new VerticalLayout();
        TextField txtTitleTask = new TextField();
        txtTitleTask.setPlaceholder("Title");
        txtTitleTask.setLabel("Title Task");
        txtTitleTask.setWidthFull();
        TextArea txtDescriptionTask = new TextArea();
        txtDescriptionTask.setPlaceholder("Description");
        txtDescriptionTask.setLabel("Description Task");
        txtDescriptionTask.setWidthFull();
        DatePicker dateDeadLine = new DatePicker();
        dateDeadLine.setLabel("DeadLine");
        dateDeadLine.setWidthFull();
        Button saveButton = new Button();
        saveButton.setText("Salvar");
        saveButton.getStyle().set("background","#46ba4e");
        saveButton.getStyle().set("color","#fff");
        formDiv.add(txtTitleTask);
        formDiv.add(txtDescriptionTask);
        formDiv.add(dateDeadLine);
        formDiv.add(saveButton);
        add(formDiv);
        setWidth("400px");
        saveButton.addClickListener(event-> {
            try {
                Todo todo = new Todo();
                todo.setTitle(txtTitleTask.getValue());
                todo.setDescription(txtDescriptionTask.getValue());
                todo.setStatus("TODO");
                //todo.setDeadline(dateDeadLine.getValue());
                Todo todoSaved = todoService.create(todo);
                UI.getCurrent().getPage().reload();
                Notification.show(ConstanteMsg.MSG_SUCCESS_SAVE,3000, Notification.Position.TOP_END);
            }catch(Exception ex){
                ex.printStackTrace();
                throw new TodoException(ConstanteMsg.ERROR_SAVE_TODO_ERROR);
            }
        });
    }
}
