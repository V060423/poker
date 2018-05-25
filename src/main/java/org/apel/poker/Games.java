package org.apel.poker;


import org.apel.poker.bean.Card;
import org.apel.poker.handle.TexasPoker;

/**
 * @author wangbowen
 * @description 游戏类
 * @Date 2018/5/24
 * @since 1.0.0
 */
public class Games {
    public static void main(String[] args){

        TexasPoker texasPoker1 = new TexasPoker();
        TexasPoker texasPoker2 = new TexasPoker();

        for (Card card : texasPoker1.getCards()) {
            System.out.print(card + " ");
        }
        System.out.println();
        for (Card card : texasPoker2.getCards()) {
            System.out.print(card + " ");
        }
        System.out.println();
        int result = texasPoker1.compareTo(texasPoker2);
        System.out.println(result);


    }
}
