package fr.lernejo.chat;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatMessageListener {
    ChatMessageRepository chat= new ChatMessageRepository();
    public void onMessage(String var)
    {
        chat.addChatMessage(var);

    }
}
