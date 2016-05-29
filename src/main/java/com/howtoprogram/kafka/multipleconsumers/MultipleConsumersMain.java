package com.howtoprogram.kafka.multipleconsumers;

public final class MultipleConsumersMain {

  public static void main(String[] args) {

    String brokers = "localhost:9092";
    String groupId = "group01";
    String topic = "HelloKafkaTopic1";
    int numberOfConsumer = 3;


    if (args != null && args.length > 4) {
      brokers = args[0];
      groupId = args[1];
      topic = args[2];
      numberOfConsumer = Integer.parseInt(args[3]);
    }

    // Start Notification Producer Thread
    NotificationProducerThread producerThread = new NotificationProducerThread(brokers, topic);
    Thread t1 = new Thread(producerThread);
    t1.start();

    // Start group of Notification Consumers
    NotificationConsumerGroup consumerGroup =
        new NotificationConsumerGroup(brokers, groupId, topic, numberOfConsumer);

    consumerGroup.execute();

    try {
      Thread.sleep(100000);
    } catch (InterruptedException ie) {

    }
  }
}
