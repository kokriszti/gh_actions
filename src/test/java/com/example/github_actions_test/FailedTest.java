package com.example.github_actions_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class FailedTest {

	@Test
	void failedTest() {
		log.info("Failed test");
		assertEquals(true, false);
	}

}
