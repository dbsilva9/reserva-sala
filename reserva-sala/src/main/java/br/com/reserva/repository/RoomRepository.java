package br.com.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reserva.entity.Room;

public interface  RoomRepository extends JpaRepository<Room, Long> {

}
