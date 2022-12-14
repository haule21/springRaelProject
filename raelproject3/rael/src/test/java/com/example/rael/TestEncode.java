package com.example.rael;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.rael.config.RootConfig;
import com.example.rael.config.SecurityConfig;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {RootConfig.class,SecurityConfig.class})
public class TestEncode {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	Logger log = (Logger) LoggerFactory.getLogger(TestEncode.class);
	
	@Test
	public void TestEncode_() {
		
		log.debug("============================");
		log.debug("============================");
		log.debug("============================");
		log.debug(encoder.encode("haul2"));
		log.debug("============================");
		log.debug("============================");
		log.debug("============================");
		
		return;
		
	}
}
