package com.thientvse.springwebapp.controller;

import com.thientvse.springwebapp.model.Comment;
import com.thientvse.springwebapp.model.CommentType;
import com.thientvse.springwebapp.services.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.jws.soap.SOAPMessageHandler;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @Test
    public void saveComments_HappyPath_ShouldReturnStatus302() throws Exception {
        // When
        ResultActions resultActions = mockMvc.perform(post("/comment").with(csrf()).with(user("thientv").roles("USER")).param("plusComment", "Test Plus"));

        // Then
        resultActions
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(commentService, times(1)).saveAll(anyList());
        verifyNoMoreInteractions(commentService);
    }

//    @Test
//    public void getComments_HappyPath_ShouldReturnStatus200() throws Exception {
//        // Given
//        Comment comment = new Comment();
//        comment.setComment("Test Plus");
//        comment.setType(CommentType.PLUS);
//        comment.setCreatedBy("thientv");
//        comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//
//        Comment comment2 = new Comment();
//        comment2.setComment("Test Star");
//        comment2.setType(CommentType.STAR);
//        comment2.setCreatedBy("thientv");
//        comment2.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//        List<Comment> comments = Arrays.asList(comment, comment2);
//        when(commentService.getAllCommentsForToday()).thenReturn(comments);
//
//        // When
//        ResultActions resultActions = mockMvc.perform(get("/").with(user("thientv").roles("USER")));
//
//        // Then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(view().name("comment"))
//                .andExpect(model().attribute("plusComments", hasSize(1)))
//                .andExpect(model().attribute("plusComments", hasItem(
//                        allOf(
//                                hasProperty("createdBy", is("thientv")),
//                                hasProperty("comment", is("Test Plus"))
//                        )
//                )))
//                .andExpect(model().attribute("starComments", hasSize(1)))
//                .andExpect(model().attribute("starComments", hasItem(
//                        allOf(
//                                hasProperty("createdBy", is("thientv")),
//                                hasProperty("comment", is("Test Star"))
//                        )
//                )));
//
//        verify(commentService, times(1)).getAllCommentsForToday();
//        verifyNoMoreInteractions(commentService);
//    }


}