package com.app.poquer_control_03;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class MockGet {
    public static String perform(final String uri, final MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(uri);

        return mockMvc.perform(requestBuilder)
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
