package fr.lernejo.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args)
    {
        SpringApplication.run(Launcher.class,args);
        var ctx = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate r = ctx.getBean(RabbitTemplate.class);
        Scanner in = new Scanner(System.in);
        String s;
        System.out.println("Input a message, we will send it for you (q for quit)");

        do {
            s = in.nextLine();
            r.convertAndSend("","chat_messages",s);
            System.out.println("Message sent,Input a message, we will send it for you (q for quit)");

        }while (!s.equals("q"));
        ctx.close();

    }
}
