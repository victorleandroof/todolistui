package br.com.victor.todolistui.service;

import br.com.victor.todolistui.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "todolist", url = "https://todolistreative.herokuapp.com/v1/todo")
public interface TodoService {

    @RequestMapping(value = "",method = RequestMethod.GET,consumes= MediaType.APPLICATION_JSON_VALUE)
    List<Todo> findAll();


    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
    Todo create(@RequestBody @Valid Todo todo);

}
