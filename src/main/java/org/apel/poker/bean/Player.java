package org.apel.poker.bean;

import java.util.List;

/**
 * @author wangbowen
 * @description 游戏玩家
 * @Date 2018/5/24
 * @since 1.0.0
 */
public class Player {
    /**
     * 玩家id
     */
    private String  id;
    /**
     * 玩家姓名
     */
    private String name;
    /**
     * 筹码
     */
    private  double money;
    /**
     *
     * 玩家手持的牌
     */
    private List<Card> card;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public Player(String id,String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\''+
                '}';
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
