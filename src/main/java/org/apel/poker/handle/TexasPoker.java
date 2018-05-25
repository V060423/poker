package org.apel.poker.handle;

import org.apel.poker.bean.Card;
import org.apel.poker.bean.Poker;
import org.apel.poker.constant.CodeConstant;
import org.apel.poker.enums.ColorEnum;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangbowen
 * @description 德州扑克
 * @Date 2018/5/25
 * @since 1.0.0
 */
public class TexasPoker implements Comparable {
    private Card[] cards;
    private int value;
    private Map<Integer,Integer> map;

    /**
     * 随机获得 7 张牌来组合成一手牌
     */
    public TexasPoker() {
        Poker poker = new Poker();
        poker.shuffle();
        cards = poker.getCards(7);
        Arrays.sort(cards);
        value = this.getPokerCodeResult();
    }


    /**
     * 获得牌堆中的 7 张牌
     * @return 7 张牌组成的数组
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * 将这个德州扑克牌堆与另一个牌堆比较，返回比较结果
     * @param anotherTexasPoker 需要比较的另一个牌堆
     * @return 1大于，0等于，-1小于
     */
    public int compareTo(Object anotherTexasPoker) {
        if (value == ((TexasPoker) anotherTexasPoker).value) {
            return 0;
        }
        if (value < ((TexasPoker) anotherTexasPoker).value) {
            return -1;
        }
        if (value > ((TexasPoker) anotherTexasPoker).value) {
            return 1;
        }
        return 0;
    }
    /**
     * 是不是同花顺
     * @param poker
     * @return
     */
    private boolean isStraightFlush(Card[] poker) {
        return isSameColor(poker) && isStraight(poker);
    }

    /**
     * 是不是四条
     * @return
     */
    private boolean isFourKind() {
        boolean flag = false;
        if (map.size() == 2) {
            for (int i : map.keySet()) {
                if (map.get(i) == 4) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 是不是同花
     * @param poker
     * @return
     */
    private boolean isSameColor(Card[] poker) {
        ColorEnum color = poker[0].getColorEnum();
        boolean flag = true;
        for (int i = 0; i < poker.length; i++) {
            if (!color.equals(poker[i].getColorEnum())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 是不是顺子
     * @param poker
     * @return
     */
    private boolean isStraight(Card[] poker) {
        boolean flag = true;
        Arrays.sort(poker);
        int temp = poker[0].getPointNum();
        for (int i = 1; i < poker.length; i++) {
            if (poker[i].getPointNum() - temp == 1) {
                temp = poker[i].getPointNum();
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * code值
     * @return
     */
    private int getPokerCodeResult(){
         int temp = 0;
         int s = getCode(cards);
         if (temp < s) {
             temp = s;
        }
        return temp;
    }

    /**
     * 每张牌对应的code
     * @param poker
     * @return
     */
    private int getCode(Card[] poker) {
        this.init(poker);
        Arrays.sort(poker);
        int sum = 0;
        for (int i = 0; i < poker.length; i++) {
            sum += poker[i].getPointNum() * Math.pow(14, i);
        }
        if (isStraightFlush(poker)) {
            sum += CodeConstant.a;
        } else if (isFourKind()) {
            sum += CodeConstant.b;
        } else if (isSameColor(poker)) {
            sum += CodeConstant.d;
        } else if (isStraight(poker)) {
            sum += CodeConstant.e;
        } else {
            sum += CodeConstant.l;
        }
        map.clear();
        return sum;
    }

    /**
     * 初始化原有的数据
     * @param poker
     */
    private void init(Card[] poker) {
        map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < poker.length; i++) {
            if (map.containsKey(poker[i].getPointNum())) {
                map.put(poker[i].getPointNum(), (map.get(poker[i].getPointNum()) + 1));
            } else {
                map.put(poker[i].getPointNum(), 1);
            }
        }
    }

}
