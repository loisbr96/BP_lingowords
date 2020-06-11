//package com.commands;
//
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.context.annotation.Import;
//import org.springframework.shell.Input;
//import org.springframework.shell.Shell;
//import org.springframework.shell.result.DefaultResultHandler;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Import(TestApplicationRunner.class)
//public class CommandComponentTest {
//
//    @Autowired
//    private Shell shell;
//
//    @Test
//    public void welcomeMessage(){
//        assertThat(shell.evaluate(() -> "welcome")).isEqualTo("welcome");
//    }
//
////    @Test
////    public void runTest(){
////
////        Object result = shell.evaluate(new Input() {
////            @Override
////            public String rawText() {
////                return "Welcome to the LoLingo words application.\n " +
////                        "What would you like to do?\n" +
////                        "type the command 'help' for the commands";
////            }
////        });
////
////        DefaultResultHandler resultHandler = new DefaultResultHandler();
////        resultHandler.handleResult(result);
////
////    }
//}
//TODO: error with starting up the test, it doesnt start but keeps waiting
