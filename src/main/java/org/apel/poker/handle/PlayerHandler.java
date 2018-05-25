package org.apel.poker.handle;

import org.apel.poker.bean.Player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangbowen
 * @description 玩家处理方法
 * @Date 2018/5/24
 * @since 1.0.0
 */
public class PlayerHandler {
    /**
     * 创建2名玩家
     * @return
     */
    public static Map<String,Player> createPlayer(){
            System.out.println("**********开始创建玩家**********");
            //使用map存储玩家信息
            Map<String,Player> map = new LinkedHashMap<String, Player>();
            int count = 0;//计数器
            System.out.println("根据提示进行操作");
            Scanner console = new Scanner(System.in);
            while(true){
                int tempCount = count + 1;
                System.out.println("请输入第"+tempCount+"位玩家ID:");
                String id = console.next();
                System.out.println("请输入第"+tempCount+"位玩家姓名:");
                String name = console.next();
                //save player
                Player player = new Player(id,name);
                map.put(id,player);
                System.out.println("添加第 " + tempCount + " 个玩家  " + name + " 成功");
                count++;
                if(count==2){
                    break;
                }
            }
        System.out.println("**********玩家创建成功**********");
        System.out.println(map);
        return map;
    }
}
