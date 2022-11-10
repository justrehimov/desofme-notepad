package com.desofme.notepad.service;

import com.desofme.notepad.controller.RoomController;
import com.desofme.notepad.entity.Room;
import com.desofme.notepad.repo.RoomRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public Room generateRoom() {
  
        var uid = UUID.randomUUID().toString().substring(0, 6);
        Room room = new Room();
        room.setRoomId(uid);
        room.setUpdatedAt(new Date());
        room.setIsNewSomething(false);
        return roomRepo.save(room);
    }

    public Room getByUID(String roomId) {
        return roomRepo.findByRoomId(roomId).orElse(null);
    }

    public void sendMessage(String message, String roomId) {
        var room = getByUID(roomId);
        room.setMessage(message);
        room.setUpdatedAt(new Date());
        roomRepo.save(room);
    }

    public Room getRoomMessage(String roomId) {
        var room = roomRepo.findByRoomId(roomId).orElse(null);
        return room;
    }
}
