package com.example.springbootcommon.concurrent.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/16
 * Time  : 8:03 AM
 */
public class DisruptorDemo1 {
    // 指定ringBuffer大小
    static int bufferSize = 1024;

    public static void main(String[] args) throws InterruptedException {
        // 构建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
        // 注册事件处理器
        disruptor.handleEventsWith((event, sequence, endOfBatch) -> {
            System.out.println("E: " + event);
        });

        // 启动disruptor
        disruptor.start();

        // 获取RingBuffer
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        // 生产Event
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l=0; true; l++) {
            bb.putLong(0, l);
            // 生产者生产消息
            ringBuffer.publishEvent((event, sequence, buffer) -> event.set(buffer.getLong(0)), bb);
            Thread.sleep(1000);
        }

    }
}

class LongEvent {
    private long value;
    public void set(long value){
        this.value = value;
    }
}
