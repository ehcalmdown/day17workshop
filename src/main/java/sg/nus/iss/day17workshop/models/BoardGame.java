package sg.nus.iss.day17workshop.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class BoardGame {
    private Integer gameId;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer rating;
    private String url;
    private String images;

   
    
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public static BoardGame create(String jsonStr) {
        StringReader strReader = new StringReader(jsonStr);
        JsonReader reader = Json.createReader(strReader);
        return create(reader.readObject());
    }

    public static BoardGame create(JsonObject jo){ //this nonsense converts the json into model so that it can be arranged
        BoardGame bg = new BoardGame();
        bg.setGameId(jo.getInt("gameId"));
        bg.setName(jo.getString("name"));
        bg.setYear(jo.getInt("year"));
        bg.setRanking(jo.getInt("ranking"));
        bg.setRating(jo.getInt("rating"));
        bg.setUrl(jo.getString("url"));
        bg.setImages(jo.getString("images"));
        return bg;
        
    }

    public JsonObject toJson(){ //this nonsense converts the model back into json to make it viable for display
        return Json.createObjectBuilder()
                    .add("gameId", gameId)
                    .add("name", name)
                    .add("year", year)
                    .add("ranking", ranking)
                    .add("rating", rating)
                    .add("url", url)
                    .add("images", images)
                    .build();
                    

    }

    
}
