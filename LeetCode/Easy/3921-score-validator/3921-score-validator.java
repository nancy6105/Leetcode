class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;

        int n = events.length;

        for(String ch : events){
            if(counter == 10)break;
            if(ch.equals("W")){
                if(counter < 10){
                    counter++;
                }
            }
            
            else if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6")){
                score += Integer.parseInt(ch);
            }

            else{
                score++;
            }
        }

        return new int[]{score,counter};
    }
}