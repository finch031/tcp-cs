package com.github.cs;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;

/**
 * Represents the local end point of a connection.
 * @author Nathan Sweet <misc@n4te.com>
 **/
public interface EndPoint extends Runnable {
    /**
     * Gets the serialization instance that will be used to serialize and deserialize objects.
     * */
    Serialization getSerialization ();

    /**
     * If the listener already exists, it is not added again.
     **/
    void addListener (Listener listener);

    void removeListener (Listener listener);

    /**
     * Continually updates this end point until {@link #stop()} is called.
     **/
    void run ();

    /**
     * Starts a new thread that calls {@link #run()}.
     **/
    void start ();

    /**
     * Closes this end point and causes {@link #run()} to return.
     **/
    void stop ();

    /**
     * @see Client
     * @see Server
     **/
    void close ();

    /**
     * @see Client#update(int)
     * @see Server#update(int)
     **/
    void update (int timeout) throws IOException;

    /**
     * Returns the last thread that called {@link #update(int)} for this end point.
     * This can be useful to detect when long running
     * code will be run on the update thread.
     **/
    Thread getUpdateThread ();

    /**
     * Gets the Kryo instance that will be used to serialize and deserialize objects.
     * Returns null if {@link KryoSerialization} is not being used.
     * @return May be null.
     * */
    Kryo getKryo ();
}