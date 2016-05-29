 #cd $APACHE_KAFKA_HOME
 
 bin\windows\kafka-topics.bat --create --zookeeper localhost:2181  --replication-factor 1 --partitions 3 --topic HelloKafkaTopic1