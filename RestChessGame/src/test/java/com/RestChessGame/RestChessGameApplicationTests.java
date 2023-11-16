package com.RestChessGame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RestChessGameApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testNewGameEndpoint() throws Exception{
		MvcResult result = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		Long gameId = Long.parseLong(content);
		assertNotNull(gameId);
	}

	@Test
	void testGetGameByIdEndpoint() throws Exception {
		MvcResult resultGameId = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		String contentGameId = resultGameId.getResponse().getContentAsString();
		Long gameId = Long.parseLong(contentGameId);
		assertNotNull(gameId);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/chess-game/{gameId}", gameId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testGetAllGamesEndpoint() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		MvcResult result2 = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		String contentGameId = result.getResponse().getContentAsString();
		Long gameId = Long.parseLong(contentGameId);
		assertNotNull(gameId);

		String contentGameId2 = result2.getResponse().getContentAsString();
		Long gameId2 = Long.parseLong(contentGameId2);
		assertNotNull(gameId2);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/chess-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testDeleteGameByIdEndpoint() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		String contentGameId = result.getResponse().getContentAsString();
		Long gameId = Long.parseLong(contentGameId);
		assertNotNull(gameId);

		mockMvc.perform(delete("/api/v1/chess-game/{gameId}", gameId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

	@Test
	void testUpdateGameByIdEndpoint() throws Exception{
		MvcResult result = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		String responseContent = result.getResponse().getContentAsString();
		Long gameId = Long.valueOf(responseContent);

		String updatedGameJson = "{ \"gameId\": " + gameId + ", \"currentTurn\": \"black\", \"winner\": \"white\" }";

		mockMvc.perform(put("/api/v1/chess-game/{gameId}", gameId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(updatedGameJson))
				.andExpect(status().isOk())
				.andExpect(content().string("Game ID " + gameId + " has been updated"));
	}

	@Test
	void testGameMoveEndPoint() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/v1/chess-game/new-game")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		String contentGameId = result.getResponse().getContentAsString();
		Long gameId = Long.parseLong(contentGameId);
		assertNotNull(gameId);

		mockMvc.perform(post("/api/v1/chess-game/{gameId}/a2/a3", gameId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testGetAllMovesEndPoint() throws Exception{
		MvcResult allMovesResult = mockMvc.perform(get("/api/v1/chess-game/all-moves")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testGetMoveByGameIdEndPoint() throws Exception{

	}

	@Test
	void testAllWhitePlayerMovesByGameIdEndPoint() throws Exception{

	}

	@Test
	void testAllBlackPlayerMovesByGameIdEndPoint() throws Exception{

	}
}
