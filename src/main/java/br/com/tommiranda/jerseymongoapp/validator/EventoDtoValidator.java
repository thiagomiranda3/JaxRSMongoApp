package br.com.tommiranda.jerseymongoapp.validator;

import br.com.tommiranda.jerseymongoapp.dtos.EventoDto;

public class EventoDtoValidator extends BaseValidator<EventoDto> {

    private final AutorDtoValidator autorDtoValidator;
    private final EnderecoDtoValidator enderecoDtoValidator;

    public EventoDtoValidator() {
        this.autorDtoValidator = new AutorDtoValidator();
        this.enderecoDtoValidator = new EnderecoDtoValidator();
    }

    @Override
    public Boolean Validate(EventoDto evento) {
        errorMessages.clear();

        if (evento == null) {
            errorMessages.add("Evento nao pode ser nulo");
            return false;
        }

        if (!autorDtoValidator.Validate(evento.autor)) {
            errorMessages.addAll(autorDtoValidator.showErrors());
        }

        if (evento.descricao == null || evento.descricao.isEmpty()) {
            errorMessages.add("Descrição do evento não pode ser nula");
        }

        if (!enderecoDtoValidator.Validate(evento.endereco)) {
            errorMessages.addAll(enderecoDtoValidator.showErrors());
        }

        if (evento.nome == null || evento.nome.isEmpty()) {
            errorMessages.add("Nome do evento não pode ser nulo");
        }

        return errorMessages.isEmpty();
    }
}
