package org.apel.poker.enums;

/**
 * @author wangbowen
 * @description 点数枚举类
 * @Date 2018/5/25
 * @since 1.0.0
 */
public enum PointEnum {
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
        SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), J("J"),
        Q("Q"), K("K"), A("A");
        private final String point;

        PointEnum(String point) {
            this.point = point;
        }
        public String getPoint() {
            return this.point;
        }

        @Override
        public String toString() {
            return this.point;
    }
}
