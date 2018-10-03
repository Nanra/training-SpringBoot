package com.tabeldata.training.springbootdemo.controller;
import com.tabeldata.training.springbootdemo.dto.RequestHalo;
import com.tabeldata.training.springbootdemo.dto.ResponseHalo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/halo")
public class HaloController {

    @GetMapping(
            path = "/findByName")
    public ResponseEntity<ResponseHalo> halo(
            @RequestParam(name = "nama", required = false)
                    String param){
        if(param.trim().isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(new ResponseHalo(param, null));
    }

    @PostMapping(
            path = "/findByName")
    public String haloPost(
            @RequestParam String nama,
            @RequestBody RequestHalo request) {
        String format = String.format("{ \"message\": \"halo ini dari spring\", \"nama\" : \"%s\" }",
                request.getNama());
        return format;
    }
}
