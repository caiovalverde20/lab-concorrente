package main.lab1;

import java.util.ArrayList;

import main.lab1.DTOs.Actor;
import main.lab1.DTOs.Movie;
import main.lab1.services.CineLsdDatabaseService;
import main.lab1.utils.ActorComparator;
import main.lab1.utils.FileIOUtil;

public class App {
  private static String ACTORS_DATA_PATH = "./data/actors.txt";
  private static int NUMBER_OF_ACTORS = 10;
  
  public static void main(String[] args) throws InterruptedException {
    long startTime = System.nanoTime();
    
    ArrayList<Actor> actors = new ArrayList<Actor>();
    ArrayList<String> actorIds = FileIOUtil.readFile(ACTORS_DATA_PATH, NUMBER_OF_ACTORS);
    System.out.println(actorIds.size());
    for(int i = 0; i < actorIds.size(); i++) {
    	String actorName = actorIds.get(i);
        Actor actor = CineLsdDatabaseService.requestActor(actorName);
        
        float rating = 0;
        float count = 0;
        for(int j = 0; j < actor.getMovies().size(); j++) {
        	String movieName = (actor.getMovies().get(j));
        	Movie movie = CineLsdDatabaseService.requestMovie(movieName);
        	rating += movie.getAverageRating();
        	count ++;
        	
        }
        actor.setRating(rating/count);
        actors.add(actor);
    }
    ActorComparator comparator = new ActorComparator();
    actors.sort(comparator);
    
    System.out.println(actors);
    System.out.println("\n--------------------------------------------------" +
      "\nTotal execution time in millis: " + ((System.nanoTime() - startTime)/1000000));
    }
}

