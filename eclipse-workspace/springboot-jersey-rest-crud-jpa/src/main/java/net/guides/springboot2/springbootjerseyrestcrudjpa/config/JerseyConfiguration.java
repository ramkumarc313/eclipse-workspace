package net.guides.springboot2.springbootjerseyrestcrudjpa.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import net.guides.springboot2.springbootjerseyrestcrudjpa.controller.UserResource;


@Component
@ApplicationPath("/boot-jersey")
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		register(UserResource.class);
	}


}
