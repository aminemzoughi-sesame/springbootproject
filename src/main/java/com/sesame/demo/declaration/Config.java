package com.sesame.demo.declaration;
import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.SmsNotificateur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Config {
    @Bean
    public Notificateur notificateur() {
        return new EmailNotificateur();
    }
    @Bean(name = "alerteSms")
    public Notificateur sms() {
        return new SmsNotificateur();
    }
}
