package exo1;

    @FunctionalInterface
    public interface Somme<T> {

        T sommer(T x, T y);

        Somme<Integer> sommerint = (x, y) -> x+y;
        Somme<String> sommerString = ((x, y) -> x.concat(y));
        Somme<Double> sommeDouble = (x,y)-> x+y;
        Somme<Long> sommerLong = ((x, y) -> x+y);
    }


