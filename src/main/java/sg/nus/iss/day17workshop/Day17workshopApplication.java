package sg.nus.iss.day17workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day17workshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day17workshopApplication.class, args);
	}

}
//write GET/boardgame<id>
//200 {"..."} data
//404{error: "id<id> not found"}
//GET /boardgames <<this will return ['/boardgames/1', "/boardgames/2"..... etc]
//by default, ln 14 gets 2 parameters > offset =0 and limit = 5. Offset to start from the top, limit is the line number limit
//chuk wants us to find a way to get the keys and sort them by numerical order, and then list them from 0 to whatever number is limit

//Structure it, only return json, use @RestController
//ln14 returns one resource
//ln 17 returns an array, it starts from boardgames, returns a whole list
//start with @RestController, 2 controllers,
//2 of them are BoardGamesRestController
//implement service BoardGamesServuice > bgSvc should have getBoardGames(id), getBoardGames(offset, limit) then List
//implement repository BoardGamesRepository implement get(id) and also get the keys() > List
//