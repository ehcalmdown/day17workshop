package sg.nus.iss.day17workshop.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
// import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
// import jakarta.json.JsonObjectBuilder;
import sg.nus.iss.day17workshop.models.BoardGame;
import sg.nus.iss.day17workshop.services.BoardGameService;


// //write GET/boardgame<id>
// //200 {"..."} data
// //404{error: "id<id> not found"}
// @RestController
// @RequestMapping(path = "/boardgame", produces = MediaType.APPLICATION_JSON_VALUE)
// public class BoardGameRestController {

//     @Autowired
//     private BoardGameService bgSvc;
//     //build to return json 
//     @GetMapping(path="{gameId}")
//     public ResponseEntity<String> getBoardGame(@PathVariable String gameId){
//         Optional<BoardGame> opt = bgSvc.getBoardgameById(gameId);

//             if(opt.isEmpty()){
//                 JsonObject error = Json.createObjectBuilder()
//                                     .add("error", "NOT FOUND".formatted(gameId))
//                                     .build();

//                             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                                     .body(error.toString());
//             }
//         // if(count<0 || count > 20){
//         //     JsonObject errorResponse = Json
//         //                             .createObjectBuilder()
//         //                             .add("error", "INVALID INDEX, Your input: %d".formatted(count))
//         //                             .build();
//         //             String payload = errorResponse.toString();
//         //     //build to return 400
//         //     return ResponseEntity
//         //             //.status(HttpStatus.BAD_REQUEST)
//         //             .badRequest()
//         //             .body(payload);
//         // } 

// BoardGame bg= opt.get();
// return ResponseEntity.ok(bg.toJson().toString());
        
//        }
    

    
// }
@RestController
@RequestMapping(path="/boardgame", produces=MediaType.APPLICATION_JSON_VALUE)
public class BoardGameRestController {

    @Autowired
    private BoardGameService bgSvc;

    @GetMapping(value="{gid}")
    public ResponseEntity<String> getBoardgame(@PathVariable String gid) {
        Optional<BoardGame> opt = bgSvc.getBoardgameById(gid);

        if (opt.isEmpty()) {
            JsonObject err = Json.createObjectBuilder()
                .add("error", "Id %s not found".formatted(gid))
                .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(err.toString());
        }

        BoardGame boardgame = opt.get();
        return ResponseEntity.ok(boardgame.toJson().toString());
    }
    
}