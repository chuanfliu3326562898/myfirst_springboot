package com.jiangfengliu;
import com.jiangfengliu.service.HelloWorldService;
import com.jiangfengliu.service.HelloWorldService2;
import com.jiangfengliu.service.HelloWorldService2Impl;
import com.jiangfengliu.utils.ToolUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
//@RunWith(SpringRunner.class)
//@PowerMockRunnerDelegate(PowerMockRunner.class)
@SpringBootTest(classes = SpringBootApplicationDemo.class)
//@PrepareForTest({ToolUtil.class})
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HelloWorldServiceTest{
    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    @InjectMocks   //为了注入Mock注入的对象
    private HelloWorldService2Impl helloWorldService2Impl;

    @Mock
    private HelloWorldService2 helloWorldService2;

    @Before
    public void startUp(){
        PowerMockito.mockStatic(ToolUtil.class);
        Mockito.when(ToolUtil.getStr()).thenReturn("static mock");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void helloWorldTest(){
//        when(helloWorldService.getHelloMessage()).then(new Answer(){
//            @Override
//            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
//                return "test mock helloWorldService";
//            }
//        });
        System.out.println(helloWorldService.getHelloMessage());
    }

    @Test
    public void helloWorld2Test() {
//        when(helloWorldService.getHelloMessage()).then(new Answer() {
//            @Override public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
//                return "test mock helloWorldService:";
//            }
//        });
        System.out.println(helloWorldService2Impl.getHelloMessage());
    }

    @Test
    public void helloWorld2MockTest() {
        when(helloWorldService2.getHelloMessage()).then(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return "test mock helloWorldService2:";
            }
        });
        System.out.println(helloWorldService2.getHelloMessage());
    }

    @Test
    public void staticMethodTest(){
        System.out.println(ToolUtil.getStr());
    }
}