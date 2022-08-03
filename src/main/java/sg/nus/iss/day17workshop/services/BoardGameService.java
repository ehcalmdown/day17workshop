package sg.nus.iss.day17workshop.services;

// import java.io.StringReader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import jakarta.json.JsonReader;
import sg.nus.iss.day17workshop.models.BoardGame;
import sg.nus.iss.day17workshop.repositories.BoardGameRepository;


@Service
public class BoardGameService {

    @Autowired
    private BoardGameRepository bgRepo;

    public Integer count() {
        return bgRepo.count();
    }

    public List<String> keys() {
        return bgRepo.keys();
    }

    public Optional<BoardGame> getBoardgameById(Integer gameId) {
        return getBoardgameById(gameId.toString());
    }
    public Optional<BoardGame> getBoardgameById(String gameId) {
        String result = bgRepo.get(gameId);
        if (null == result)
            return Optional.empty();

        return Optional.of(BoardGame.create(result));
    }

}

//     public List<BoardGame> getBoardGame(String count){

//         //check if info is cached
//         Optional<String> opt = bgRepo.get(count);
//         String payload;

//         System.out.println("Game set number:" + count);

//         if(opt.isEmpty()){
//             System.out.println("Empty?");


//             //create uri with query string
//             String url = UriComponentsBuilder.fromUriString(URL)
//                         .queryParam("q", count)
//                         .toUriString();

//         //create the GET request, GET url
//         RequestEntity<Void> req = RequestEntity.get(url).build();
//         }
//         return null;
//     }
    
// }
