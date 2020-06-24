package com.mint_digital_bank.card_verification_consumer.test_project_card_verification_consumer.enums;

public enum MintEnum {
    TOPIC("com.ng.vela.even.card_verified"),
    MINT_KAFKA_SERVER("127.0.0.1:9092"),
    GROUP_ID("mint_group_id");

    private String name;
    MintEnum(String topic){
        this.name = topic;
    }
    public String getName(){
        return this.name;
    }
}
