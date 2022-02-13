package com.github.cs;

import com.esotericsoftware.minlog.Log;

/**
 * Marker interface to denote that a message is used by the Ninja framework
 * and is generally invisible to the developer. Eg, these messages are only logged
 * at the {@link Log#LEVEL_TRACE} level.
 * @author Nathan Sweet <misc@n4te.com>
 **/
public interface FrameworkMessage {
    static final FrameworkMessage.KeepAlive keepAlive = new KeepAlive();

    /**
     * Internal message to give the client the server assigned connection ID.
     **/
    public static class RegisterTCP implements FrameworkMessage {
        public int connectionID;
    }

    /**
     * Internal message to give the server the client's UDP port.
     **/
    public static class RegisterUDP implements FrameworkMessage {
        public int connectionID;
    }

    /** Internal message to keep connections alive. */
    public static class KeepAlive implements FrameworkMessage {
    }

    /** Internal message to discover running servers. */
    public static class DiscoverHost implements FrameworkMessage {
    }

    /** Internal message to determine round trip time. */
    public static class Ping implements FrameworkMessage {
        public int id;
        public boolean isReply;
    }
}
