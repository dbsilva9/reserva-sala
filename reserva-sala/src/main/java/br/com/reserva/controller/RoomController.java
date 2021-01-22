package br.com.reserva.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.reserva.entity.Room;
import br.com.reserva.exception.RoomNotFoundException;
import br.com.reserva.service.RoomService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/v1/rooms")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	@GetMapping
	public List<Room> getAllRooms(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws RoomNotFoundException{
		var retorno = service.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public Room createRoom(@RequestBody @Valid Room room) {
		return service.create(room);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody @Valid Room room) throws RoomNotFoundException{
		var retorno = service.update(id, room);
		return ResponseEntity.ok(retorno);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)	
	public void deleteRoomById(@PathVariable Long id) throws RoomNotFoundException{
		service.deleteById(id);
	}

}
