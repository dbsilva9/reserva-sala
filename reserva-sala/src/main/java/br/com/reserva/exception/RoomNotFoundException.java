package br.com.reserva.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoomNotFoundException(String beerName) {
        super(String.format("Beer with name %s not found in the system.", beerName));
    }

    public RoomNotFoundException(Long id) {
        super(String.format("Beer with id %s not found in the system.", id));
    }
}
