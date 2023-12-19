package com.iablonski.backend.planner.search;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.Date;


public class TaskSearchValues {
    private String title;
    private Byte completed;
    @NotBlank(message = "Must contain at least 1 character")
    @Getter
    private String email;
    private Long priorityId;
    private Long categoryId;
    private Date dateFrom;
    private Date dateTo;

    private Integer pageNumber;
    private Integer pageSize;

    private String sortColumn;
    private String sortDirection;

    public String getTitle() {
        if (title != null) return title;
        return null;
    }

    public Boolean getCompleted(){
        return completed != null && completed == 1;
    }

    public Long getPriorityId() {
        if (priorityId != null) return priorityId;
        return null;
    }

    public Long getCategoryId() {
        if (categoryId != null) return categoryId;
        return null;
    }

    public Date getDateFrom() {
        if (dateFrom != null) {
            Calendar calendarFr = Calendar.getInstance();
            calendarFr.setTime(dateFrom);
            calendarFr.set(Calendar.HOUR_OF_DAY, 0);
            calendarFr.set(Calendar.MINUTE, 0);
            calendarFr.set(Calendar.SECOND, 0);
            calendarFr.set(Calendar.MILLISECOND, 1);
            dateFrom = calendarFr.getTime();
        }
        return dateFrom;
    }

    public Date getDateTo() {
        if (dateTo != null) {
            Calendar calendarFr = Calendar.getInstance();
            calendarFr.setTime(dateTo);
            calendarFr.set(Calendar.HOUR_OF_DAY, 23);
            calendarFr.set(Calendar.MINUTE, 59);
            calendarFr.set(Calendar.SECOND, 59);
            calendarFr.set(Calendar.MILLISECOND, 999);
            dateTo = calendarFr.getTime();
        }
        return dateTo;
    }

    public Integer getPageNumber() {
        if (pageNumber != null) return pageNumber;
        return null;
    }

    public Integer getPageSize() {
        if (pageSize != null) return pageSize;
        return null;
    }

    public String getSortColumn() {
        if (sortColumn != null) return sortColumn;
        return null;
    }

    public Sort.Direction getSortDirection() {
        if (sortDirection == null ||
                sortDirection.trim().isEmpty() ||
                sortDirection.trim().equalsIgnoreCase("asc")) return Sort.Direction.ASC;
        return Sort.Direction.DESC;
    }
}
