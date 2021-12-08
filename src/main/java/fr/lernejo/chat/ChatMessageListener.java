package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    public static void onMessage(String message) {
        System.out.println(message);
    }

}
