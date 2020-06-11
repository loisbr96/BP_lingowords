//package com;
////
////import org.junit.Test;
////import org.junit.runner.RunWith;
//
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.Assert;
//import org.springframework.shell.Bootstrap;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.shell.core.CommandResult;
//import org.springframework.shell.core.JLineShellComponent;
//
////import org.springframework.test.context.junit4.SpringRunner;
////
////@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringContextTest {
//
//    static JLineShellComponent shell;
//
//    @BeforeClass
//    public static void startUp() throws InterruptedException {
//        final Bootstrap bootstrap = new Bootstrap();
//        shell = bootstrap.getJLineShellComponent();
//    }
//
//    @AfterClass
//    public static void shutDown(){
//        shell.stop();
//    }
//
//    public static JLineShellComponent getShell(){
//        return shell;
//    }
//
//    @Test
//    public void welcome(){
//        final CommandResult result = shell.executeCommand("welcome");
//        Assert.assertTrue(result.isSuccess());
//    }
//
////    @Test
////    public void contextLoads() {
////    }
//
//}
