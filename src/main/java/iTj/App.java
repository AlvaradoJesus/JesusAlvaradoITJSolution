package iTj;

import com.google.inject.Guice;
import com.google.inject.Injector;
import iTj.application.Application;
import iTj.modules.AppModule;

public class App 
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new AppModule());
        Application application = injector.getInstance(Application.class);
        application.startApplication();
    }
}
