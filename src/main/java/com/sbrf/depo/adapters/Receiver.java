package com.sbrf.depo.adapters;

public interface Receiver<T> {

    public Object receive(T source);
}
