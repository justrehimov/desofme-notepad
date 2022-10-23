package com.desofme.notepad.controller;

import com.desofme.notepad.entity.Room;
import com.desofme.notepad.service.RoomService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat-room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/generate")
    public Room generateRoom() {
        return roomService.generateRoom();
    }

    @GetMapping("/message")
    public Room getByRoomId(@RequestParam("roomId") String roomId){
        return roomService.getRoomMessage(roomId);
    }

    @PostMapping("/send-message/{roomId}")
    public void sendMessage(@RequestParam("message") String message, @PathVariable("roomId") String roomId){
        roomService.sendMessage(message, roomId);
    }

}
