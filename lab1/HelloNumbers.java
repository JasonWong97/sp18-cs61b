/*
 * @Author: Weng Jiacheng
 * @Date: 2020-11-24 16:33:08
 * @LastEditors: Weng Jiacheng
 * @LastEditTime: 2020-11-24 16:36:46
 * @FilePath: /ex1/HelloNumbers.java
 */
public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int sum=0;
        while (x < 10) {
            System.out.print(sum + " ");
            x=x+1;
            sum = sum+x;
        }
    }
}