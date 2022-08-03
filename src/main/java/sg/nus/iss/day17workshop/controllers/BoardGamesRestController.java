package sg.nus.iss.day17workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.iss.day17workshop.services.BoardGameService;

//GET /boardgames <<this will return ['/boardgames/1', "/boardgames/2"..... etc]
//by default, ln 14 gets 2 parameters > offset =0 and limit = 5. Offset to start from the top, limit is the line number limit
//chuk wants us to find a way to get the keys and sort them by numerical order, and then list them from 0 to whatever number is limit
@RestController
@RequestMapping(path = "/boardgames", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardGamesRestController {
    @Autowired //to instatiate automatically
    private BoardGameService bgSvc; //controller instantiates from service

    @GetMapping //used whenever we are using a get program
    ResponseEntity<String> getBoardGames(
        @RequestParam(name = "offset", defaultValue = "0") Integer offset, //use requestparam to obtain the integer value through input
        @RequestParam(name = "limit", defaultValue = "5") Integer limit) {
            List<String> allKeys = bgSvc.keys().subList(offset, offset+limit);
            List<String> keyRange = allKeys.stream()
            .map(k -> "/boardgame/%s".formatted(k))
            .toList();
            JsonArray arr = Json.createArrayBuilder(keyRange).build(); //create json array > needs to convert to list first then change to array

            return ResponseEntity.ok(arr.toString());
            
        }

        @GetMapping(path = "count")
        ResponseEntity<String>getBoardgamesCount(){
            Integer count = bgSvc.count();

            JsonObject payload = Json.createObjectBuilder()
                                .add("count", count)
                                .build();

            return ResponseEntity.ok(payload.toString());
        }

    
}
