public class LeadingZeros {
    public static void main(String[] args) {
        System.out.println(leadingZero(100000));
    }

    private static int leadingZero(int n) {
        int ans = 0;
        while (n % 10 == 0){
            ans++;
            n = n / 10;
        }
        return ans;
    }
}

