package com.bitsevn.projects.chat.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

	@Autowired
	private ChatServiceImpl chatService;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException, InterruptedException {
		Server server = ServerBuilder
				.forPort(8080)
				.addService(chatService)
				.build();
		server.start();
		server.awaitTermination();
	}
}
