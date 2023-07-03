[ElasticSearch]
* Port : 9200
* Chrome Plugin : Elasticsearch Head

[Kafka]
* kafka-cli.sh를 통해 컨테이너 접속
* Topic List 확인
  * /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
* Topic 정보 확인
  * /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic topic1 --describe
* Topic 생성
  * /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my_topic --create
* Topic 제거
  * /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic my_topic --delete

[MySQL]
* 계정 정보
  * ROOT Password : root
  * ID : mysql-local
  * Password : mysql-local
  
[Redis]
* cli 사용법
  * redis-cli.sh를 통해 컨테이너 접속
  * redis-cli 실행
  * set [key] [value]
  * get [key]