package main.lab1;

import java.util.ArrayList;
import java.util.List;

import main.lab1.DTOs.Actor;
import main.lab1.DTOs.Movie;
import main.lab1.services.CineLsdDatabaseService;
import main.lab1.utils.ActorComparator;
import main.lab1.utils.FileIOUtil;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class AppConcurrent {
  private static String ACTORS_DATA_PATH = "./data/actors.txt";
  private static int NUMBER_OF_ACTORS = 1000;
  
  public static void main(String[] args) throws InterruptedException {
    long startTime = System.nanoTime();
    
    ArrayList<Actor> actors = new ArrayList<Actor>();
    ArrayList<String> actorIds = FileIOUtil.readFile(ACTORS_DATA_PATH, NUMBER_OF_ACTORS);

    // Criar um pool de threads
    ExecutorService executor = Executors.newFixedThreadPool(10);
    List<Future<Actor>> futures = new ArrayList<>();
    
    for(int i = 0; i < actorIds.size(); i++) {
        String actorId = actorIds.get(i);

        Future<Actor> future = executor.submit(new Callable<Actor>() {
            @Override
            public Actor call() throws Exception {
                Actor actor = CineLsdDatabaseService.requestActor(actorId);
                float rating = 0;
                float count = 0;
                ArrayList<String> movies = actor.getMovies();
                for(int j = 0; j < actor.getMovies().size(); j++) {
                    String movieName = movies.get(j);
                    Movie movie = CineLsdDatabaseService.requestMovie(movieName);
                    rating += movie.getAverageRating();
                    count++;
                }
                actor.setRating(rating/count);
                return actor;
            }
        });
        futures.add(future);
    }

    // Pega os resultador quando prontos
    for (Future<Actor> future : futures) {
        try {
            actors.add(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ActorComparator comparator = new ActorComparator();
    actors.sort(comparator);

    int rankingSize = Math.min(10, actors.size());
    System.out.println("Top " + rankingSize + " actors:");
    for (int i = 0; i < rankingSize; i++) {
        Actor actor = actors.get(i);
        System.out.println((i+1) + ". " + actor.getName() + " - Rating: " + actor.getRating());
    }
    
    System.out.println("\n--------------------------------------------------" +
      "\nExecução em segundos: " + ((System.nanoTime() - startTime)/1000000000));
    
    executor.shutdown();
  }
}
