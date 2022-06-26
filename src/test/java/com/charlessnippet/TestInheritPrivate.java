package com.charlessnippet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import com.charlessnippet.demos.SubClass;
import com.charlessnippet.demos.SuperClass;

public class TestInheritPrivate
{
    Logger logger = LogManager.getLogger(TestInheritPrivate.class);

    @Test
    public void testInheritPrivate() {
        // SuperClass superClass = new SubClass();
        // superClass.saySomething(1);

        SubClass newSubClass = new SubClass();
        logger.info(newSubClass.saySomething(2));

        logger.traceExit();
    }
}
