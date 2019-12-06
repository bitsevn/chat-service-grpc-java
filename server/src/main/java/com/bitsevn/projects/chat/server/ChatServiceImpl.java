package com.bitsevn.projects.chat.server;

import com.bitsevn.projects.chat.core.ChatRequest;
import com.bitsevn.projects.chat.core.ChatResponse;
import com.bitsevn.projects.chat.core.ChatServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

@Component("chatService")
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    @Override
    public void hello(ChatRequest request, StreamObserver<ChatResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        ChatResponse response = ChatResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
