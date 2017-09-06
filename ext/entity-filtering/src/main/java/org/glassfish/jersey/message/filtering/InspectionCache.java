package org.glassfish.jersey.message.filtering;

import org.reflections.Reflections;

import javax.inject.Singleton;
import java.util.Set;

/**
 * A class path inspection cache built around the Reflections library.
 */
@Singleton
public final class InspectionCache {

    private final Reflections reflections;

    public InspectionCache() {
        reflections = new Reflections();
    }

    /**
     * Returns a set of types that are considered sub-types of the specified class. The Reflections method returns
     * Set&lt;Class&lt;? extends T&gt; but we don't have a generic type argument for {@code cls} so we need an
     * unchecked cast. In this case, it's warranted since we know the returned set will only contain types that
     * extend {@code cls}.
     *
     * @param cls The class whose subtypes are to be returned as a set.
     * @return The set of all classes that are considered sub types of the specified class.
     */
    @SuppressWarnings("unchecked")
    Set<Class<?>> getSubTypes(Class<?> cls) {
        return (Set<Class<?>>) reflections.getSubTypesOf(cls);
    }
}
