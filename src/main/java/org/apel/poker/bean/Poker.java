package org.apel.poker.bean;

import org.apel.poker.enums.ColorEnum;
import org.apel.poker.enums.PointEnum;

import java.util.*;

/**
 * @author wangbowen
 * @description 扑克牌类
 * 参考 https://github.com/omusico/Poker_Java/blob/master/src/cn/com/caoyue/game/poker/Poker.java
 * @Date 2018/5/24
 * @since 1.0.0
 */
public class Poker {
   private Card [] cards;
    /**
     * 生成一副牌
     */
    public Poker() {
        int index = 0;
        cards = new Card[52];
        for (PointEnum point : PointEnum.values()) {
            for (ColorEnum color :ColorEnum.values()) {
                cards[index] = new Card(color.name(), point.name());
                index++;
            }
        }
    }

    /**
     * 获取生成的一副牌
     * @return
     */
    public Card[] getCards() {
        return cards;
    }
    /**
     * 获取生成的一副牌
     * @return
     */
    public Card[] getCards(int  numberOfCards) {
        return this.deal(0,numberOfCards);
    }

    /**
     * 发牌,根据指定索引、数量
     * @param startIndex 起始索引值
     * @param numberOfCards 要获得牌的张数
     * @return Card
     */
    public Card[] deal(int startIndex, int numberOfCards) {
        Card[] temp = new Card[numberOfCards];
        System.arraycopy(cards, startIndex, temp, 0, numberOfCards);
        return temp;
    }

    /**
     * 洗牌,最后一张牌与他前面52 张牌中随机一张交换位置,倒数第二张与他前面51张牌中随机一张牌交换位置，依次类推
     */
    public void  shuffle(){
        for (int i = cards.length - 1; i > 0; i--) {
            int index = i;
            int index2 = new Random().nextInt(i);
            Card temp = cards[index];
            cards[index] = cards[index2];
            cards[index2] = temp;
        }
    }
}
