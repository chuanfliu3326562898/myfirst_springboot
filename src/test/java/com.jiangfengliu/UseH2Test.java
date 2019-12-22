package com.jiangfengliu;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

import static org.junit.Assert.assertEquals;

/**
 * 应用模块名称<p>
 * 代码描述<获取所有阶段返回dto>
 *
 * @Author: liujiangfeng
 * Company: 跟谁学<p>
 * @Date: 2019-12-20
 */
@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = {"com.jiangfengliu.config"})
@Import(value = { com.jiangfengliu.config.PropertiesWithJavaConfig.class})
public class UseH2Test {


    @Value("${jdbc.driver}")
    private String driverName;
    @Test
    public void useH2() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        // 所有数据都存储在内存中，数据库没有名字
        String url = "jdbc:h2:mem:";
        // 默认的用户名，没有密码
        String user = "sa";
        String password = "";
        Connection conn = DriverManager.getConnection(url, user, password);

        Statement statement = conn.createStatement();

        // H2的语法和MySQL的语法还是有些差别的，比如KEY `w`，CONSTRAINT `w`
        statement.execute("CREATE TABLE channel (id bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',"
            + "  is_del int(11) NOT NULL DEFAULT '0' COMMENT '是否删除',"
            + "  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',"
            + "  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',"
            + "  display_name varchar(16) NOT NULL DEFAULT '' COMMENT '外显名称',\n"
            + "  note_name varchar(20) NOT NULL DEFAULT '' COMMENT '备注名称',\n"
            + "  is_handpick int(11) NOT NULL DEFAULT '0' COMMENT '是否精选', PRIMARY KEY (id)\n"
            + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;");

        statement.execute("INSERT INTO `channel` (`id`, `is_del`, `create_time`, `update_time`, `display_name`, `note_name`, `is_handpick`)\n"
            + "VALUES\n" + "\t(1,0,'2019-04-28 21:02:50','2019-05-09 09:38:10','精选','一年级精选',1),\n"
            + "\t(2,0,'2019-04-28 21:04:12','2019-04-28 21:04:16','精选','二年级精选',1),\n"
            + "\t(3,0,'2019-04-28 21:04:30','2019-04-28 21:04:30','精选','三年级精选',1),\n"
            + "\t(4,0,'2019-04-28 21:04:43','2019-04-28 21:04:43','精选','四年级精选',1),\n"
            + "\t(5,0,'2019-04-28 21:04:59','2019-04-28 21:04:59','精选','五年级精选',1),\n"
            + "\t(6,0,'2019-04-28 21:05:12','2019-05-05 19:23:42','精选','六年级精选',1),\n"
            + "\t(7,0,'2019-04-28 21:05:29','2019-04-28 21:05:29','精选','初一精选',1),\n"
            + "\t(8,0,'2019-04-28 21:05:45','2019-04-28 21:05:45','精选','初二精选',1),\n"
            + "\t(9,0,'2019-04-28 21:05:58','2019-04-28 21:05:58','精选','初三精选',1),\n"
            + "\t(10,0,'2019-04-28 21:06:15','2019-04-28 21:06:15','精选','高一精选',1),\n"
            + "\t(11,0,'2019-04-28 21:06:17','2019-04-28 21:07:08','精选','高二精选',1),\n"
            + "\t(12,0,'2019-04-28 21:07:29','2019-05-08 20:12:18','精选','高三精选',1),\n"
            + "\t(13,0,'2019-04-28 21:07:36','2019-04-28 21:08:12','精选','大学精选',1),\n"
            + "\t(14,0,'2019-04-28 21:08:02','2019-04-28 21:08:11','精选','上班族精选',1),\n"
            + "\t(15,0,'2019-04-28 21:08:32','2019-04-28 21:08:37','精选','家长专区精选',1);");

        ResultSet rs = statement.executeQuery("select *from channel");
        while (rs.next()) {
            Long id = rs.getLong(1);
            Integer isDel = rs.getInt(2);
            String createTime = rs.getString(3);
            String updateTime = rs.getString(4);
            String displayName = rs.getString(5);
            String noteName = rs.getString(6);
            String isHandpick = rs.getString(7);
            System.out.println(
                "id=" + id + " isDel=" + isDel + " createTime=" + createTime + " updateTime=" + updateTime
                    + " displayName:" + displayName + " noteName:" + noteName + " isHandpick:" + isHandpick);
        }

        statement.close();
        conn.close();
    }
}
