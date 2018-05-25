package org.apel.poker.enums;

/**
 * @author wangbowen
 * @description 花色枚举
 * @Date 2018/5/25
 * @since 1.0.0
 */
public enum ColorEnum {
        SPADE("黑桃"), HEARTS("红桃"),BLOCK("方块"),CLUB("梅花");
        private  String color;
        ColorEnum(String color) {
            this.color = color;
        }
        public String getColor() {
            return color;
        }
        @Override
        public String toString() {
            return this.color;
        }
}
