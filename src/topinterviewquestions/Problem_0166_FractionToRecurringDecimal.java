package topinterviewquestions;

import java.util.HashMap;

public class Problem_0166_FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        // 整数部分
        res.append(num / den);
        num %= den;

        // 说明能整除
        if (num == 0) {
            return res.toString();
        }
        // 小数部分
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            // 如果之前余数出现过
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            // 记录一下余数出现的位置
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

}
