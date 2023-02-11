package com.ihub.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ihub.dto.RoomDTO;
import com.ihub.service.RoomService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RoomController.class)
public class TestRoomController {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private RoomService roomService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testRoomController() throws Exception {

		RoomDTO roomDTO = new RoomDTO();

		roomDTO.setRid(1);
		roomDTO.setNoofrooms(5);
		roomDTO.setRent(500);
		roomDTO.setType("Luxury");

		Mockito.when(roomService.postroommapping(roomDTO)).thenReturn(roomDTO);

		mockMvc.perform(post("/room/roompost")
				.content(objectMapper.writeValueAsString(roomDTO))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.rid", is(1)))
				.andExpect(jsonPath("$.noofrooms", is(5)))
				.andExpect(jsonPath("$.rent", is(500)))
				.andExpect(jsonPath("$.type", is("Luxury")))
				.andDo(print());
		Mockito.verify(roomService).postroommapping(roomDTO);

	}

}
