package sg.nus.iss.day17workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day17workshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day17workshopApplication.class, args);
	}

}



//Structure it, only return json, use @RestController
//ln14 returns one resource
//ln 17 returns an array, it starts from boardgames, returns a whole list
//start with @RestController, 2 controllers,
//2 of them are BoardGamesRestController
//implement service BoardGamesServuice > bgSvc should have getBoardGames(id), getBoardGames(offset, limit) then List
//implement repository BoardGamesRepository implement get(id) and also get the keys() > List
//