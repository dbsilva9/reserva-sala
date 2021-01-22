package br.com.reserva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
    private String name;

	@Column(nullable = true)
    private String date;
    
	@Column(nullable = true)
    private String startHour;
    
	@Column(nullable = true)
    private String endHour;
	
	@Column(nullable = true)
    private boolean active;

}
