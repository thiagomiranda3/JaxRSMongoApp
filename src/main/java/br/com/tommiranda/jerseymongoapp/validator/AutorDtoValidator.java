package br.com.tommiranda.jerseymongoapp.validator;

import br.com.tommiranda.jerseymongoapp.dtos.AutorDto;
import java.util.List;

public class AutorDtoValidator extends BaseValidator<AutorDto> {

    @Override
    public Boolean Validate(AutorDto autor) {
        errorMessages.clear();

        if (autor == null) {
            errorMessages.add("Autor nao pode ser nulo");
            return false;
        }

        if (autor.nome == null || autor.nome.isEmpty())
            errorMessages.add("Nome do autor não pode ser nulo");

        if (autor.email == null || autor.email.isEmpty())
            errorMessages.add("Email do autor não pode ser nulo");

        return errorMessages.isEmpty();
    }

    @Override
    public List<String> showErrors() {
        return errorMessages;
    }
}
