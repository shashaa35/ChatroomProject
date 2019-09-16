
package edu.udacity.java.nano;

import edu.udacity.java.nano.chat.Message;
import edu.udacity.java.nano.chat.WebSocketChatServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

;

@WebMvcTest(WebSocketChatServer.class)
@RunWith(SpringRunner.class)
public class WebSocketChatApplicationTest {

    private final static String TEST_USERNAME = "Tom";
    private final static String TEST_MESSAGE = "Hello world.";
    private final static int TEST_onlineCount = 0;

    private Message message;

    private WebSocketChatServer server;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMessage(){
        /* Create a basic Message object and see if everything is working **/
        message = new Message(TEST_MESSAGE, TEST_USERNAME, Message.ENTER, TEST_onlineCount);
        assertEquals(message.getUsername(), TEST_USERNAME);
        assertEquals(message.getMsg(), TEST_MESSAGE);
        assertEquals(message.getType(), Message.ENTER);
        assertEquals(message.getOnlineCount(), TEST_onlineCount);
    }

    @Test
    /* Check if the basic login page is present. **/
    public void testOpeningStartPage() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/login"))
                .andExpect(content().string(containsString("Chat Room")));
    }

    @Test
    public void testUserLogin() throws Exception{
        /* Login with the user Tom into our chat application and see if the current view is than chat instead of login **/
        this.mockMvc.perform(get("/index")
                .param("username", TEST_USERNAME))
                .andExpect(status().isOk())
                .andExpect(view().name("/chat"));
    }
}