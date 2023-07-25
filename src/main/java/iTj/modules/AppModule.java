package iTj.modules;

import com.google.inject.AbstractModule;
import iTj.solutions.ArrayEvaluator;
import iTj.solutions.ArrayEvaluatorImpl;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ArrayEvaluator.class).to(ArrayEvaluatorImpl.class);
    }
}
