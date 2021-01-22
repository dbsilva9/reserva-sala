package br.com.reserva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reserva.entity.Room;
import br.com.reserva.exception.RoomNotFoundException;
import br.com.reserva.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository repository;

	public Room create(Room room) {
		return repository.save(room);
	}

	public Room update(Long id, Room room) throws RoomNotFoundException {
		var roomUpdate = verifyIfExists(id);
		
		roomUpdate.setActive(room.isActive());
		roomUpdate.setDate(room.getDate());
		roomUpdate.setEndHour(room.getEndHour());
		roomUpdate.setStartHour(room.getStartHour());
		roomUpdate.setName(room.getName());
		
		return repository.save(roomUpdate);
	}

	public List<Room> findAll() {
		return repository.findAll();
	}

	public Room findById(Long id) throws RoomNotFoundException {
		return verifyIfExists(id);
	}

	public void deleteById(Long id) throws RoomNotFoundException {
		verifyIfExists(id);
		repository.deleteById(id);
	}

	private Room verifyIfExists(Long id) throws RoomNotFoundException {
		return repository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
	}

}
