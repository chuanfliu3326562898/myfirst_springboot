package com.jiangfengliu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 应用模块名称<p>
 * 代码描述<获取所有阶段返回dto>
 *
 * @Author: liujiangfeng
 * Company: 跟谁学<p>
 * @Date: 2019-12-22
 */
@RunWith(SpringRunner.class)
public class UseH2ChildTest extends UseH2Test{

    @Test
    public void test()throws Exception{
        super.useH2();
    }
}
