package com.hashcodehub.springboot.studentservices.Controller;


import com.hashcodehub.springboot.studentservices.Model.MasterGroupEntityModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class OptionalControllerPractice {


    @GetMapping("/getMgId")
    public Object getMasterGroup() {

        // get the name of masterGroup
        Optional<MasterGroupEntityModel> masterGroupEntityModel = getMasterGroupFromServiceLayer();

//        if( masterGroupEntityModel.getName()!=null ) {
//                return masterGroupEntityModel.getName().length();
//        }else {
//            return "0";
//        }


        // below mentioned is not the right way of using options since we are again doing null check
//
//       if (masterGroupEntityModel.isPresent()) {
//           return  masterGroupEntityModel.get();
//       } else {
//           return "test";
//       }

//      in this case if masterGroup is null we will return the orElse part -> if it is not null we will return the actual object
//      return   masterGroupEntityModel.orElse(MasterGroupEntityModel.builder().id(5).build());


//        this call will check the getName in mastrGroup and if getName is not null it will return name if it is null it will return HSBC
        return masterGroupEntityModel.map(MasterGroupEntityModel::getName)
                .orElse("HSBC");


    }


    public Optional<MasterGroupEntityModel> getMasterGroupFromServiceLayer() {
//        MasterGroupEntityModel masterGroupEntityModel =  MasterGroupEntityModel.builder().id(2).name("HSBC").build();
//        MasterGroupEntityModel masterGroupEntityModel =  null;


        MasterGroupEntityModel masterGroupEntityModel = MasterGroupEntityModel.builder().id(2).name(null).build();
        log.info("masterGroupCreated ..");

        return Optional.ofNullable(masterGroupEntityModel);

    }
}
