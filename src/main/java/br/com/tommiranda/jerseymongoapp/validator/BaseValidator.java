package br.com.tommiranda.jerseymongoapp.validator;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseValidator<T> implements Validator<T> {

    protected final List<String> errorMessages = new ArrayList<>();

    @Override
    public List<String> showErrors() {
        return errorMessages;
    }

}
