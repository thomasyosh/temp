import java.util.Random;


class RandomSeed {
    Random rnd = new Random();
    long seed;
    
    public RandomSeed(int n){
        rnd.setSeed(n);
    }
    
    public int getSeed(){
        return rnd.nextInt(5);
    }
}