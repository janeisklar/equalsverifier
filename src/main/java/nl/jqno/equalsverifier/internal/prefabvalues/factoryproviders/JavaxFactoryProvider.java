package nl.jqno.equalsverifier.internal.prefabvalues.factoryproviders;

import static nl.jqno.equalsverifier.internal.prefabvalues.factories.Factories.values;

import javax.naming.Reference;
import nl.jqno.equalsverifier.internal.prefabvalues.FactoryCache;

public final class JavaxFactoryProvider implements FactoryProvider {

    public FactoryCache getFactoryCache() {
        FactoryCache cache = new FactoryCache();

        cache.put(
                Reference.class,
                values(new Reference("one"), new Reference("two"), new Reference("one")));

        return cache;
    }
}
