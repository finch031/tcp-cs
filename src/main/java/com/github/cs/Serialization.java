package com.github.cs;

import java.nio.ByteBuffer;

/**
 * Controls how objects are transmitted over the network.
 * All methods must be synchronized or otherwise thread safe.
 * */
public interface Serialization {
    /**
     * @param connection May be null.
     * */
    void write (Connection connection, ByteBuffer buffer, Object object);

    Object read (Connection connection, ByteBuffer buffer);

    /**
     * The fixed number of bytes that will be written by
     * {@link #writeLength(ByteBuffer, int)} and read by
     * {@link #readLength(ByteBuffer)}.
     * */
    int getLengthLength ();

    void writeLength (ByteBuffer buffer, int length);

    int readLength (ByteBuffer buffer);
}