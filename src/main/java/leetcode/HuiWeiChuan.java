package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author blackjack
 * @date 2022/7/9
 */
public class HuiWeiChuan {
    public static void main(String args[]){
        String a = "babad";
        String s = longestPalindrome(a);

System.out.println(s);

    }

        public static String longestPalindrome(String s) {
            List<Integer> oddList = new ArrayList();
            List<Integer> evenList = new ArrayList();

           String evenStr = "";
           String oddStr = "";
            for(int i = 0;i<s.length();i++){//
                oddList.add(i);
                evenList.add(i);
            }
            int oddSpan = 1;
            int evenSpan = 0;
            while(true){//一直寻找
                List tempList = dealOdd(s,oddList,oddSpan);
                if(tempList.size()!=0){
                    oddList = tempList;
                    oddSpan++;
                }else{//全都找完了 结束 list为最中数据
                    oddSpan--; //回退一轮span
                    oddStr = s.substring(oddList.get(0)-oddSpan,oddList.get(0)+oddSpan+1);
                    break;
                }
            }
            while(true){//一直寻找
                List tempList = dealEven(s,evenList,evenSpan);
                if(tempList.size()!=0){
                    evenList = tempList;
                    evenSpan++;
                }else{//全都找完了 结束 list为最中数据
                    evenSpan--; //回退一轮span
                    evenStr = s.substring(evenList.get(0)-evenSpan,evenList.get(0)+1+evenSpan+1);
                    break;
                }
            }
            if (oddStr.length()>evenStr.length()){
                return oddStr;
            }else {
                return evenStr;
            }
        }
        //进行一轮查询并标记
        public static List dealOdd(String s, List<Integer> oddList, int oddspan) {

            List<Integer> newOddList = new ArrayList();

            //定义一个数组  temp[] ,span  距离
            for(int i = 0;i<oddList.size();i++){
                if(oddList.get(i)-oddspan<0||oddList.get(i)+oddspan>=s.length()) //注意数组越界
                    continue;
                if(s.charAt(oddList.get(i)-oddspan)==s.charAt(oddList.get(i)+oddspan))
                    newOddList.add(oddList.get(i));
            }
            return newOddList;
        }

    //进行一轮偶数查询并标记
    public static List dealEven(String s,List<Integer> evenList, int evenSpan) {
        List<Integer> newEvenList = new ArrayList();
        //定义一个数组  temp[] ,span  距离
        for(int i = 0;i<evenList.size();i++){
            if(evenList.get(i)-evenSpan<0||evenList.get(i)+1+evenSpan>=s.length()) //注意数组越界
                continue;
            if(s.charAt(evenList.get(i)-evenSpan)==s.charAt(evenList.get(i)+1+evenSpan))
                newEvenList.add(evenList.get(i));
        }

        return newEvenList;
    }
}
