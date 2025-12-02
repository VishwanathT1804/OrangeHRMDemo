package com.orange.config;

import org.aeonbits.owner.ConfigFactory;

public final class ConfiguartionFactory {
	
	private ConfiguartionFactory() {}
	
	public static FrameworkConfig getConfig() {
		return ConfigFactory.create(FrameworkConfig.class);
	}

}
