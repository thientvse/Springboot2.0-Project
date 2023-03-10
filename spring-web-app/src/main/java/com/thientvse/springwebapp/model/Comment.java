package com.thientvse.springwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rb_comment")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public String comment;

    @Enumerated(EnumType.STRING)
    public CommentType type;

    @CreatedDate
    private Timestamp createdDate;


    @CreatedBy
    private String createdBy;
}
