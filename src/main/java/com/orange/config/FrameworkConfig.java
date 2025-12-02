package com.orange.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configuration/config.properties")
public interface FrameworkConfig extends Config{
	
	String browser();
	String appurl();

}
