package com.example.github_actions_test;

import com.example.github_actions_test.picturehandling.PictureHandler;
import com.example.github_actions_test.picturehandling.PictureHandlerRefactor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GithubActionsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubActionsTestApplication.class, args);

//		PictureHandler pictureHandler = new PictureHandler();
//		pictureHandler.setPictureFilePath("C:\\Users\\krisztina.pelei\\Kriszti\\java_gyakorlas\\github_actions_test\\src\\main\\java\\com\\example\\github_actions_test\\caf.jpg");
//
//		if (pictureHandler.getPictureBytes() != null) {
//			System.out.println("success");
//		} else {
//			System.out.println("fail");
//		}

		PictureHandlerRefactor pictureHandler2 = new PictureHandlerRefactor();
		pictureHandler2.setPictureFilePath("src/main/java/com/example/github_actions_test/caf.jpg");
//		pictureHandler2.setPictureFilePath("C:\\Users\\krisztina.pelei\\Kriszti\\java_gyakorlas\\github_actions_test\\src\\main\\java\\com\\example\\github_actions_test\\caf.jpg");

		try {
			pictureHandler2.getPictureBytes();
			System.out.println("success");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
