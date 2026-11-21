package com.sesame.demo.injection;
import com.sesame.demo.commun.Notificateur;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
@Service
public class ServiceConstructeur {
    private final Notificateur notificateur;
    public ServiceConstructeur(
            @Qualifier("notificateurSms") Notificateur notificateur) {
        this.notificateur = notificateur;
    }

    public String decrire() {
        return getClass().getSimpleName() + " utilise "
                + notificateur.getClass().getSimpleName();
    }
}
