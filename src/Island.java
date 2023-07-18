import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Island {
    private static int lenght = 5;
    private static int height = 3;
    private static Location [][] island = new Location[lenght][height];

    private Island(){
        Random countOrganizm = new Random();

        for (int i = 0; i < lenght; i++){
            for(int j = 0; j < height; j++){
                int predators = countOrganizm.nextInt();
                island [i][j].predators.add(new Wolf());
                island [i][j].plants.add(new Grass());
            }
        }
    }
}
