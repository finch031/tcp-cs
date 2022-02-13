package com.github.cs;

import java.net.DatagramPacket;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

public interface ClientDiscoveryHandler {
    /**
     * This implementation of the {@link ClientDiscoveryHandler}
     * is responsible for providing the {@link Client}
     * with it's default behavior.
     **/
    public static final ClientDiscoveryHandler DEFAULT = new ClientDiscoveryHandler() {
        public DatagramPacket onRequestNewDatagramPacket () {
            return new DatagramPacket(new byte[0], 0);
        }

        public void onDiscoveredHost (DatagramPacket datagramPacket, Kryo kryo) {
        }

        public void onFinally () {
        }
    };

    /**
     * Implementations of this method should return
     * a new {@link DatagramPacket} that the {@link Client} will use to fill with the
     * incoming packet data sent by the {@link ServerDiscoveryHandler}.
     * @return a new {@link DatagramPacket}
     **/
    DatagramPacket onRequestNewDatagramPacket ();

    /**
     * Called when the {@link Client} discovers a host.
     * @param datagramPacket the same {@link DatagramPacket} from {@link #onRequestNewDatagramPacket()}, after being filled with
     *           the incoming packet data.
     * @param kryo the {@link Kryo} instance, or null.
     **/
    void onDiscoveredHost (DatagramPacket datagramPacket, Kryo kryo);

    /**
     * Called right before the {@link Client#discoverHost(int, int)} or {@link Client#discoverHosts(int, int)} method exits.
     * This allows the implementation to clean up any resources used, i.e. an {@link Input}.
     **/
    void onFinally ();
}