package com.everis.cursotesting.test.contexto;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author fgajardo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/app-config.xml" })
@Transactional(value = "transactionManager")
public abstract class TestContext {

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LoggerFactory.getLogger(TestContext.class);

}
