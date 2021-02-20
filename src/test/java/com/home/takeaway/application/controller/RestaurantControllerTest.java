//package com.home.takeaway.application.controllers;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.home.takeaway.application.dto.RestaurantDTO;
//import com.home.takeaway.domain.service.RestaurantService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = RestaurantController.class, secure = false) //TODO disable security
//public class RestaurantControllerTest {
//
//    private final String GET_LIST_URI = "/restaurant/list/all";
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private RestaurantService restaurantService;
//
//    @Before
//    public void setUp() {
//        when(restaurantService.getRestaurantList()).thenReturn(restaurantDTOList());
//    }
//
//    @Test
//    public void should_return_restaurant_list() throws Exception {
//        //when
//        MvcResult resultActions = mvc.perform(MockMvcRequestBuilders.get(GET_LIST_URI))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//
//        //then
//        List<RestaurantDTO> result = objectMapper.readValue(resultActions.getResponse().getContentAsString(), new TypeReference<List<RestaurantDTO>>() {});
//        assertThat(result).isNotNull();
//        assertThat(result).hasSize(restaurantDTOList().size());
////        assertThat(result).hasSameElementsAs(new ArrayList<>(restaurantDTOList())); TODO Why doesn't work
//
//    }
//
//    private List<RestaurantDTO> restaurantDTOList() {
//        return List.of(
//                RestaurantDTO.builder()
//                        .name("Test's restaurant")
//                        .created(new Date())
//                        .build()
//        );
//    }
//}