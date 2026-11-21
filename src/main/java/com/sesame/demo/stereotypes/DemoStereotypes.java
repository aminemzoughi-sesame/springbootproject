package com.sesame.demo.stereotypes;
import com.sesame.demo.commun.Outils;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
public class DemoStereotypes {
    public static void main(String[] args) {
        Outils.silence();
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(Config.class)) {
            System.out.println("Beans : " + Outils.beans(ctx));
            afficher(ctx, "@Controller", Controller.class);
            afficher(ctx, "@Service ", Service.class);
            afficher(ctx, "@Repository", Repository.class);
            System.out.println("@Service est une @Component : "
                    + Service.class.isAnnotationPresent(Component.class));
            ctx.getBean(EmpruntController.class).demander("amine@sesame.tn", "Clean Code");
        } catch (BeansException e) {
            System.out.println("Erreur : " + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    static void afficher(AnnotationConfigApplicationContext ctx, String etiquette,
                         Class<? extends Annotation> annotation) {
        String[] noms = ctx.getBeanNamesForAnnotation(annotation);
        System.out.println(etiquette + " : " + Arrays.toString(noms));
    }
}
