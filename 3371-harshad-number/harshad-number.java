class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int m = x;
        int sum = 0;
        while(x!=0){
            int d = x % 10;
            sum = sum + d;
            x = x / 10;
        }
        if(m % sum  == 0){
            return sum;
        }
        else{
            return -1;
        }
    }
}