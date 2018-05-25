package org.apel.poker.bean;

import org.apel.poker.enums.ColorEnum;
import org.apel.poker.enums.JokerEnum;
import org.apel.poker.enums.PointEnum;

/**
 * @author wangbowen
 * @description 一张牌
 * @Date 2018/5/24
 * @since 1.0.0
 */
public class Card  implements  Comparable{
    /**
     * 花色
     */
    private ColorEnum colorEnum;
    /**
     * 点数枚举
     */
    private PointEnum pointEnum;
    /**
     * 大小王枚举
     */
    private JokerEnum jokerEnum;
    /**
     * 是否需要大小王
     */
    private boolean isJoker;

    /**
     * 创建一张牌
     * @param color
     * @param point
     */
    public Card(String color,String  point){
        this.colorEnum  = ColorEnum.valueOf(color);
        this.pointEnum  = PointEnum.valueOf(point);
    }
    /**
     * 获取牌的花色
     */
    public String getColor() {
        return isJoker ? jokerEnum.toString() : colorEnum.toString();
    }

    /**
     * 获取牌的点数
     * @return  2-10  J、Q、K、A
     */
    public String getPoint(){
        return isJoker ? jokerEnum.toString() : pointEnum.toString();
    }
    /**
     * 获得这张牌的点数数字
     * @return 如果是数字点数(2 to 10)。返回点数对应数值，如果不是，J=11, Q=12, K=13, A=14
     */
    public int getPointNum() {
        return isJoker ? (jokerEnum == JokerEnum.BLACK ? 15 : 16) : pointEnum.ordinal() + 2;
    }

    /**
     * 获取花色和点数
     * @return
     */
    @Override
    public String toString() {
        return isJoker?jokerEnum.toString():colorEnum.toString()+pointEnum.toString();
    }

    public int compareTo(Object anotherCard) {
        if (this == anotherCard || getPointNum() == ((Card) anotherCard).getPointNum()) {
            return 0;
        }
        if (getPointNum() < ((Card) anotherCard).getPointNum()) {
            return -1;
        }
        if (getPointNum() > ((Card) anotherCard).getPointNum()) {
            return 1;
        }
        return 0;
    }

    public ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(ColorEnum colorEnum) {
        this.colorEnum = colorEnum;
    }

    public PointEnum getPointEnum() {
        return pointEnum;
    }

    public void setPointEnum(PointEnum pointEnum) {
        this.pointEnum = pointEnum;
    }

    public JokerEnum getJokerEnum() {
        return jokerEnum;
    }

    public void setJokerEnum(JokerEnum jokerEnum) {
        this.jokerEnum = jokerEnum;
    }
}
