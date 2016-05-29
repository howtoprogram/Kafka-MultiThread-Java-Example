package com.howtoprogram.kafka.singleconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ConsumerThreadHandler implements Runnable {

  private ConsumerRecord consumerRecord;

  public ConsumerThreadHandler(ConsumerRecord consumerRecord) {
    this.consumerRecord = consumerRecord;
  }

  public void run() {
    System.out.println("Process: " + consumerRecord.value() + ", Offset: " + consumerRecord.offset()
        + ", By ThreadID: " + Thread.currentThread().getId());
  }
}
