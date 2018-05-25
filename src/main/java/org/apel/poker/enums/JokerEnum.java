package org.apel.poker.enums;

/**
 * @author wangbowen
 * @description 大小王枚举类
 * @Date 2018/5/25
 * @since 1.0.0
 */
public enum  JokerEnum {
    RED("大王"),BLACK("小王");
    private String name;
    JokerEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
