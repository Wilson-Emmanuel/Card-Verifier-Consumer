package com.mint_digital_bank.card_verification_consumer.test_project_card_verification_consumer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "com.ng.vela.even.card_verified",groupId="mint_group_id", containerFactory = "cardConcurrentKafkaListenerContainerFactory")
  public void consume(String card){
      System.out.println(card);
  }
}
