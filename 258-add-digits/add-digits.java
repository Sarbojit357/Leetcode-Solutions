class Solution {
    int sum = 0;
    int CountOfDigits(int num){
        int count = 0;
        sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;

            count ++;
        }
        return count;
    }
    public int addDigits(int num) {
        while(CountOfDigits(num) > 1){
            num = sum;
        }
      return num;
    }
    
}