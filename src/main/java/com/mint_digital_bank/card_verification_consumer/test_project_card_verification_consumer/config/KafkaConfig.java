package com.mint_digital_bank.card_verification_consumer.test_project_card_verification_consumer.config;

import com.mint_digital_bank.card_verification_consumer.test_project_card_verification_consumer.enums.MintEnum;
import com.mint_digital_bank.card_verification_consumer.test_project_card_verification_consumer.models.Card;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, Card> consumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,MintEnum.MINT_KAFKA_SERVER.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, MintEnum.GROUP_ID.getName());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(), new JsonDeserializer<>(Card.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Card> cardConcurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Card> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
