package com.youngkaka.dota.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.youngkaka.dota.repository.DotaMapRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(DotaMapController.class)
public class DotaMapControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DotaMapRepository dotaMapRepository;
	
	
	private String mapId;

	@Before
	public void before() throws Exception {
		mapId = "m5";
		this.mvc.perform(post("/map/new").param("id", mapId).param("name", "Map 5")).andExpect(status().isOk());
	}

	@Test
	public void testIndex() throws Exception {
		String cs1 = "<title>Maps</title>";
		this.mvc.perform(get("/map")).andExpect(status().isOk()).andExpect(view().name("map/maps"))
				.andExpect(model().attributeExists("maps")).andExpect(content().string(allOf(containsString(cs1))));
	}

	@Test
	public void testNewMap() throws Exception {
		String cs1 = "<title>New Map</title>";
		this.mvc.perform(get("/map/new")).andExpect(status().isOk()).andExpect(view().name("map/new_map"))
				.andExpect(content().string(allOf(containsString(cs1))));
	}
	
//	@Test
//	public void testUpdateMap() throws Exception {
//		String cs1 = "<title>Update Map</title>";
//		this.mvc.perform(get("/map/update/" + mapId)).andExpect(view().name("map/update_map"))
//				.andExpect(model().attributeExists("map"))
//				.andExpect(content().string(allOf(containsString(cs1))));
//	}

	@After
	public void testAddNewMap() throws Exception {
		this.mvc.perform(get("/map/del/" + mapId)).andExpect(status().isOk());
	}

}
