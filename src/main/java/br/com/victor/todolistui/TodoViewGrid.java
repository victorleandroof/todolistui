package br.com.victor.todolistui;

import br.com.victor.todolistui.service.TodoService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoViewGrid extends Grid<Todo> {

    public TodoViewGrid(@Autowired TodoService todoService) {
        List<Todo> todoList = todoService.findAll();
        ListDataProvider<Todo> dataProvider = new ListDataProvider<>(todoList);
        setDataProvider(dataProvider);
        Grid.Column<Todo> titleColumn =  addColumn(Todo::getTitle).setHeader("Title");
        Grid.Column<Todo> statusColumn =  addColumn(Todo::getStatus).setHeader("Status");
        HeaderRow filterRow = appendHeaderRow();
        TextField firstTitleField = new TextField();
        firstTitleField.addValueChangeListener(event -> dataProvider.addFilter(
                todo -> StringUtils.containsIgnoreCase(todo.getTitle(),
                        firstTitleField.getValue())));
        firstTitleField.setValueChangeMode(ValueChangeMode.EAGER);
        filterRow.getCell(titleColumn).setComponent(firstTitleField);
        firstTitleField.setSizeFull();
        firstTitleField.setPlaceholder("Filter");
        TextField firstStatusField = new TextField();
        firstStatusField.addValueChangeListener(event -> dataProvider.addFilter(
                todo -> StringUtils.containsIgnoreCase(todo.getStatus(),
                        firstTitleField.getValue())));
        firstStatusField.setValueChangeMode(ValueChangeMode.EAGER);
        filterRow.getCell(statusColumn).setComponent(firstStatusField);
        firstStatusField.setSizeFull();
        firstStatusField.setPlaceholder("Filter");
    }
}
