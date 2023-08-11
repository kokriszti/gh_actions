package com.example.github_actions_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GithubActionsTestApplicationTests {

	@Test
	void successfulTest() {
		System.out.println("Successful test");
		assertEquals(true, true);
	}

	@Test
	void failedTest() {
		System.out.println("Failed test");
		assertEquals(true, false);
	}

}
