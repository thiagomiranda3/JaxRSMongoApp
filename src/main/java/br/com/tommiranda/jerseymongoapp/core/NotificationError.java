package br.com.tommiranda.jerseymongoapp.core;

import java.util.List;

public class NotificationError extends BaseNotification<List<String>>{

    public NotificationError(List<String> notification) {
        super(notification);
        this.sucesso = false;
    }

    @Override
    public List<String> getRetorno() {
        return retorno;
    }
}
