package br.com.tommiranda.jerseymongoapp.validator;

import br.com.tommiranda.jerseymongoapp.dtos.EnderecoDto;
import java.util.List;

public class EnderecoDtoValidator extends BaseValidator<EnderecoDto> {

    @Override
    public Boolean Validate(EnderecoDto endereco) {
        errorMessages.clear();

        if (endereco == null) {
            errorMessages.add("Endereço nao pode ser nulo");
            return false;
        }

        if (endereco.cidade == null || endereco.cidade.isEmpty())
            errorMessages.add("Cidade não pode ser nula");

        if (endereco.estado == null || endereco.estado.isEmpty())
            errorMessages.add("Estado não pode ser nulo");

        if (endereco.numero == null)
            errorMessages.add("Número da rua não pode ser nulo");

        if (endereco.rua == null || endereco.rua.isEmpty())
            errorMessages.add("Rua não pode ser nula");

        return errorMessages.isEmpty();
    }

    @Override
    public List<String> showErrors() {
        return errorMessages;
    }
}
