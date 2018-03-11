package br.com.tommiranda.jerseymongoapp.core;

public class NotificationException extends BaseNotification<String> {

    public NotificationException(String notification) {
        super(notification);
        this.sucesso = false;
    }

    @Override
    public String getRetorno() {
        return retorno;
    }

}
