package br.com.tommiranda.jerseymongoapp.core;

public class NotificationSuccess extends BaseNotification<Object> {

    public NotificationSuccess(Object notification) {
        super(notification);
        this.sucesso = true;
    }

    @Override
    public Object getRetorno() {
        return retorno;
    }
}
