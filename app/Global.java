import configs.AppConfig;
import configs.DataConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    private ApplicationContext appContext;

    // designates the config files to be used.
    @Override
    public void onStart(Application app) {
        appContext = new AnnotationConfigApplicationContext(AppConfig.class, DataConfig.class);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return appContext.getBean(clazz);
    }
}
