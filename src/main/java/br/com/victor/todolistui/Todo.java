package br.com.victor.todolistui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    @NotBlank
    @Size(max = 100,min = 8)
    private String title;
    @JsonProperty(" ")
    @NotBlank
    @Size(max = 255,min = 8)
    private String description;
    @JsonProperty("deadline")
    private LocalDate deadline;
    @JsonProperty("start_date")
    private LocalDate startDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("create_date")
    private LocalDateTime createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
