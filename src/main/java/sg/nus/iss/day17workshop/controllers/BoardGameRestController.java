package sg.nus.iss.day17workshop.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;


//write GET/boardgame<id>
//200 {"..."} data
//404{error: "id<id> not found"}
@Controller
@RequestMapping(path = "/boardgame", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardGameRestController {
    //build to return json 
    @GetMapping(path="{id}")
    public ResponseEntity<String> getBoardGame(
       @ RequestParam(name = "boardgame", defaultValue = "0")Integer count){
        if(count<0 || count > 20){
            JsonObject errorResponse = Json
                                    .createObjectBuilder()
                                    .add("error", "INVALID INDEX, Your input: %d".formatted(count))
                                    .build();
                    String payload = errorResponse.toString();
            //build to return 400
            return ResponseEntity
                    //.status(HttpStatus.BAD_REQUEST)
                    .badRequest()
                    .body(payload);
        } 

        //create response payload
        JsonObjectBuilder builder = Json
                                    .createObjectBuilder()
                                    .add("gameId", count);
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for(Integer i: ) 
        
        
                                    return null;
        
        
       }
    

    
}
