package br.com.victor.todolistui;

import br.com.victor.todolistui.service.TodoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoViewHead extends VerticalLayout {


    public TodoViewHead(@Autowired TodoService todoService) {
        setAlignItems(Alignment.CENTER);
        getStyle().set("background","#2980b9");
        setWidth("40%");
        H3 h3 = new H3("TODO LIST!!");
        h3.getStyle().set("color","#fff");
        add(h3);
        TodoViewDialog dialog = new TodoViewDialog(todoService);
        Button addButton = new Button();
        addButton.getStyle().set("background","#46ba4e");
        addButton.getStyle().set("color","#fff");
        addButton.setIcon(VaadinIcon.PLUS.create());
        addButton.addClickListener(event -> dialog.open());
        add(addButton);
    }
}
