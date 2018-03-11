package br.com.tommiranda.jerseymongoapp.core;

public abstract class BaseNotification<T> implements Notification<T> {

    protected T retorno;
    protected Boolean sucesso;

    public BaseNotification(T notification) {
        this.retorno = notification;
    }

    @Override
    public Boolean getSucesso() {
        return sucesso;
    }
}
