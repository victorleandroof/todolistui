package br.com.victor.todolistui;


import br.com.victor.todolistui.service.TodoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;




@Route
@PWA(name = "todolist", shortName = "todo")
public class TodoView extends VerticalLayout {


    public TodoView(@Autowired TodoService todoService) {
        Notification notification = new Notification();
        notification.show(ConstanteMsg.MSG_WELCOME,3000, Notification.Position.TOP_END);
        getStyle().set("background","linear-gradient(to right, #5B86E5, #36D1DC)");
        setHeightFull();
        setWidthFull();
        setAlignItems(Alignment.CENTER);
        TodoViewHead todoViewHead = new TodoViewHead(todoService);
        TodoViewPainel todoViewPainel = new TodoViewPainel(todoService);
        add(todoViewHead);
        add(todoViewPainel);
    }
}