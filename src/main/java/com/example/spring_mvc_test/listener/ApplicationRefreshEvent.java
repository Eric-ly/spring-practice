package com.example.spring_mvc_test.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationRefreshEvent implements ApplicationListener<ContextRefreshedEvent> {
    private int count = 0;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        System.out.println( " test " );

        synchronized (ApplicationRefreshEvent.class) {
            System.out.println( " application-mvc-test: application name " + event.getApplicationContext().getDisplayName());

//        Teacher teacher = (Teacher) event.getApplicationContext().getBean("teacher");
//        System.out.println("ApplicationRefreshedEvent："+teacher.getName());
//        teacher.setName("化学老师准备改名了");
            if(event.getApplicationContext().getParent() != null) {
                System.out.println( " application-mvc-test:  application parent name " + event.getApplicationContext().getParent().getDisplayName());
            }else {
                System.out.println( " application parent is null, event is  " + event.getApplicationContext().getDisplayName());
            }
            if (count <1){
                count ++;
                ApplicationContext parent = event.getApplicationContext();
                System.out.println(" event applicationContext as parent  : " + parent);
//            DemoController guessController = (DemoController) event.getApplicationContext().getBean("demoController");
                ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"classpath:applicationContext-test.xml"},parent);
                System.out.println( " create new ApplicationContext  " +context.getDisplayName() );

                //            guessController.setGuessPioneerContext(new FileSystemXmlApplicationContext(new String[]{"classpath:guess-pioneer/guess-pioneer.xml"},parent));
            }
        }


    }
}