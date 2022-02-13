package com.github.cs.example;

import com.esotericsoftware.kryo.Kryo;
import com.github.cs.EndPoint;

// This class is a convenient place to keep things common to both the client and server.
public class Network {
    public static final int port = 54555;

    // This registers objects that are going to be sent over the network.
    public static void register (EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(RegisterName.class);
        kryo.register(String[].class);
        kryo.register(UpdateNames.class);
        kryo.register(ChatMessage.class);
    }

    public static class RegisterName {
        public String name;
    }

    public static class UpdateNames {
        public String[] names;
    }

    public static class ChatMessage {
        public String text;
    }
}
