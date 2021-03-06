package de.pustovalov.quarkus.controller.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class LoggingRestFilter implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(LoggingRestFilter.class);

    @Context
    UriInfo info;

    @Override
    public void filter(ContainerRequestContext context) {
        final String method = context.getMethod();
        final String path = info.getPath();
        LOG.infof("Request %s %s from IP %s", method, path);
    }
}