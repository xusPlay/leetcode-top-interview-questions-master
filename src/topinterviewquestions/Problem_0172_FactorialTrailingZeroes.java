package topinterviewquestions;

/**
 * 因子5的数量
 * <p>
 * 每25个数会多出来一个5的因子
 */
public class Problem_0172_FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

}
