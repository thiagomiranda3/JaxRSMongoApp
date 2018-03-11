package br.com.tommiranda.jerseymongoapp.core;

public class NoticationSuccess extends BaseNotification<Object>{

    public NoticationSuccess(Object notification) {
        super(notification);
        this.sucesso = true;
    }

    @Override
    public Object getRetorno() {
        return retorno;
    }
}