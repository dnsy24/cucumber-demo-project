package com.company.services.utilities.owner;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:env/qa.properties"})
public interface Configurator extends Config {

    @Key("browser.name")
    String browserName();

    @Key("site.url")
    String siteUrl();

    @Key("explicit.timeout")
    long explicitlyTimeout();
}
