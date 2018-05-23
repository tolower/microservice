package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;

public interface Formatter {

    String format(ILoggingEvent event);
}