package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.AbstractJsonMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractWrapper<E extends AbstractJsonMapping> extends AbstractJsonMapping implements IWrapperResult<E> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractWrapper.class);
    protected E result;

    @Override
    public final E getResult(Class<E> resultClass) {
        // If the wrapper has an error, propogate it to the subclass
        if (isError()) {
            try {
                // If the wrapper is in error, there is no result class, so we need to create one
                result = resultClass.newInstance();
                result.setStatusMessage(getStatusMessage());
            } catch (InstantiationException | IllegalAccessException ex) {
                LOG.warn("Failed to instantiate {}", resultClass.getSimpleName(), ex);
                result = null;
            }
        }

        // Return the result
        return result;
    }

}
