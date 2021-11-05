package com.constructWeek3.assure.service;


import com.constructWeek3.assure.dto.MembersDTO;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.modelmapper.ModelMapperClass;
import com.constructWeek3.assure.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersService {


    @Autowired
    MembersRepository membersRepository;


    public List<MembersDTO> getallmembers() {
        List<Members> allmembers = membersRepository.findAll();
        List<MembersDTO> allmembersdto = new ArrayList<>();
        MembersDTO membersDTO = new MembersDTO();

        for (Members allmembers1 : allmembers) {
            ModelMapperClass.modelMapper().map(allmembers1, membersDTO);
            allmembersdto.add(membersDTO);
        }
        return allmembersdto;
    }


    public MembersDTO memberbyid(Long id) {
        Members members=membersRepository.findById(id).get();
        MembersDTO membersDTO = new MembersDTO();
        ModelMapperClass.modelMapper().map(members,membersDTO);
        return membersDTO;
    }


    public String postmember(MembersDTO membersDTO) {
        Members members= new Members();
        ModelMapperClass.modelMapper().map(membersDTO,members);
        if(membersRepository.findById(members.getMember_id()).get()==null) {
            Members members1 = membersRepository.save(members);
            return new String("saved");
        }
        else{
            return new String("user already exist");
        }

    }


    public MembersDTO updatemember(MembersDTO membersDTO) {
        Members members = membersRepository.findById(membersDTO.getMember_id()).get();
        ModelMapperClass.modelMapper().map(membersDTO, members);
        try {
            membersRepository.save(members);
            return membersDTO;
        }catch(Exception e){
            return null;
        }
    }


    public String deletemember(Long id) {
      Members members = membersRepository.findById(id).get();
        try{
            membersRepository.delete(members);
            return new String("Deleted");
        }catch(Exception es){
            return new String("Error");
        }

    }
}
