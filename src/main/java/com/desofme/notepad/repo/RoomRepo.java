package com.desofme.notepad.repo;

import com.desofme.notepad.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {


    Optional<Room> findByRoomId(String roomId);
}
