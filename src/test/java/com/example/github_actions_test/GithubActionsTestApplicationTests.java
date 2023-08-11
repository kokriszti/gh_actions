package com.example.github_actions_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class GithubActionsTestApplicationTests {

	@Test
	void successfulTest() {
		log.info("Successful test");
		System.out.println("Successful test");
		assertEquals(true, true);
	}

//	@Test
//	void failedTest() {
//		System.out.println("Failed test");
//		assertEquals(true, false);
//	}

}
