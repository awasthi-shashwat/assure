package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.dto.MembersDTO;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembersController {

    @Autowired
    MembersService membersService;

    @GetMapping("/get/allmembers")
    public List<MembersDTO> getallmembers(){
        return membersService.getallmembers();
    }
    @GetMapping("/get/member/{id}")
    public  MembersDTO getmemberbyid(@PathVariable Long id){
        return membersService.memberbyid(id);
    }
    @PostMapping("/post/member/")
    public String postmember(@RequestBody MembersDTO membersDTO){
        return membersService.postmember(membersDTO);
    }
   @PutMapping("/put/member/")
    public MembersDTO updatemember(@RequestBody MembersDTO membersDTO){
        return membersService.updatemember(membersDTO);

   }
   @DeleteMapping("/delete/member/{id}")
    public String deletemember(@PathVariable Long id){
     return membersService.deletemember(id);
   }

}
