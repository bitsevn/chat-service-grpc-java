package com.bitsevn.projects.chat.client;

import com.bitsevn.projects.chat.core.ChatRequest;
import com.bitsevn.projects.chat.core.ChatResponse;
import com.bitsevn.projects.chat.core.ChatServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
				.usePlaintext()
				.build();

		ChatServiceGrpc.ChatServiceBlockingStub stub
				= ChatServiceGrpc.newBlockingStub(channel);

		ChatResponse chatResponse = stub.hello(ChatRequest
				.newBuilder()
				.setFirstName("Arun")
				.setLastName("Kumar")
				.build());
		System.out.println(chatResponse);
		channel.shutdown();
	}
}
