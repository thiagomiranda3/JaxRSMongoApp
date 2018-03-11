package br.com.tommiranda.jerseymongoapp.validator;

import java.util.List;

public interface Validator<T> {

    Boolean Validate(T object);

    List<String> showErrors();
}
