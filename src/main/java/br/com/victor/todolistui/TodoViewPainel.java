package br.com.victor.todolistui;

import br.com.victor.todolistui.service.TodoService;
import com.vaadin.flow.component.grid.Grid;;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoViewPainel extends VerticalLayout {

    public TodoViewPainel(@Autowired TodoService todoService) {
        getStyle().set("background","#fff");
        setHeight("40%");
        setWidth("40%");
        TodoViewGrid todoViewGrid = new TodoViewGrid(todoService);
        add(todoViewGrid);
    }
}
