package sg.nus.iss.day17workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import sg.nus.iss.day17workshop.models.BoardGame;
import sg.nus.iss.day17workshop.repositories.BoardGameRepository;

@Service
public class BoardGameService {

    private static final String URL = "./boardgames.redis";

    @Autowired
    private BoardGameRepository bgRepo;

    public List<BoardGame> getBoardGame(String count){

        //check if info is cached
        Optional<String> opt = bgRepo.get(count);
        String payload;

        System.out.println("Game set number:" + count);

        if(opt.isEmpty()){
            System.out.println("Empty?");


            //create uri with query string
            String url = UriComponentsBuilder.fromUriString(URL)
                        .queryParam("q", count)
                        .toUriString();

        //create the GET request, GET url
        RequestEntity<Void> req = RequestEntity.get(url).build();
        }
        return null;


    }
    
}
