package com.example.springbootcommon.concurrent.executors.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 2:29 PM
 */
public class FutureAsyncTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Result result = new Result();
        result.setName("zhou");

        Future<Result> future = executor.submit(new Task(result), result);
        Result after = future.get();
        System.out.println(after.getName());
    }

}

class Task implements Runnable{

    private Result result;

    public Task(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        result.setName("tiantian");
    }
}

class Result {
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
