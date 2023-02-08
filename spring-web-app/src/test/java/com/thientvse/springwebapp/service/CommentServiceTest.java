package com.thientvse.springwebapp.service;

import com.thientvse.springwebapp.model.Comment;
import com.thientvse.springwebapp.model.CommentType;
import com.thientvse.springwebapp.repository.CommentRepository;
import com.thientvse.springwebapp.services.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class CommentServiceTest {

    @MockBean
    private CommentRepository commentRepository;

    private CommentService commentService;

    @Before
    public void init(){
        commentService = new CommentService(commentRepository);
    }

    @Test
    public void getAllCommentForToday_HappyPath_ShouldReturn1Comment(){
        // Given
        Comment comment = new Comment();
        comment.setComment("Test");
        comment.setType(CommentType.PLUS);
        comment.setCreatedDate(new
                Timestamp(System.currentTimeMillis()));
        List<Comment> comments = Arrays.asList(comment);

        LocalDate now = LocalDate.now();

        when(commentRepository.findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth())).thenReturn(comments);

        // When
        List<Comment> actualComments = commentService.getAllCommentsForToday();

        // Then
        verify(commentRepository, times(1)).findByCreatedYearAndMonthAndDay(now.getYear(),
                now.getMonth().getValue(), now.getDayOfMonth());

        assertThat(comments).isEqualTo(actualComments);



    }
}
