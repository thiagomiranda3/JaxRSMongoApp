package br.com.tommiranda.jerseymongoapp.core;

public interface Notification<T> {

    Boolean getSucesso();

    T getRetorno();
}
