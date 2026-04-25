class FoodRatings {
    Map<String,String> ftoc;
    Map<String,Integer> ftor;
    Map<String,TreeSet<String>> ctof;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        ftoc = new HashMap<>();
        ftor = new HashMap<>();
        ctof = new HashMap<>();
        for(int i = 0;i<n;i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            ftoc.put(food,cuisine);
            ftor.put(food,rating);
            ctof.putIfAbsent(cuisine,new TreeSet<>((a,b)->{
                int r1 = ftor.get(a);
                int r2 = ftor.get(b);
                if(r2 != r1)return r2-r1;

                return a.compareTo(b);
                }
            ));
            ctof.get(cuisine).add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = ftoc.get(food);
        ctof.get(cuisine).remove(food);
        ftor.put(food,newRating);
        ctof.get(cuisine).add(food);
    }
    
    public String highestRated(String cuisine) {
        return ctof.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */