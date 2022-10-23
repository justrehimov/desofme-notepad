package com.desofme.notepad.controller;

import com.desofme.notepad.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/room")
    public ModelAndView room(@RequestParam("roomId") String roomId, ModelAndView modelAndView){
        var room = roomService.getByUID(roomId);
        if(room==null){
            modelAndView.setViewName("error");
        }else {
            modelAndView.setViewName("room");
        }
        return modelAndView;
    }

}
