package sg.nus.iss.day17workshop.models;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

public class BoardGame {
    private String setNum;
    private String gameId;
    private String name;
    private String year;
    private String ranking;
    private String rating;

    public String getSetNum() {
        return setNum;
    }
    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }
    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getRanking() {
        return ranking;
    }
    public void setRanking(String ranking) {
        this.ranking = ranking;
    } 
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public static BoardGame create(JsonObject jo){
        BoardGame bg = new BoardGame();
        bg.setSetNum(jo.getString("setNum"));
        bg.setGameId(jo.getString("gameId"));
        bg.setName(jo.getString("name"));
        bg.setYear(jo.getString("year"));
        bg.setRanking(jo.getString("ranking"));
        bg.setRating(jo.getString("rating"));
        return bg;
        
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
                    .add("setNum", setNum)
                    .add("gameId", gameId)
                    .add("name", name)
                    .add("year", year)
                    .add("ranking", ranking)
                    .build();

    }

    
}
