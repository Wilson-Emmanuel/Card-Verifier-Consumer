package com.mint_digital_bank.card_verification_consumer.test_project_card_verification_consumer.models;

public class Card {

    private String scheme;

    private String type;

    private String bank;

    public Card() {
    }

    public Card(String scheme, String type, String bank) {
        this.scheme = scheme;
        this.type = type;
        this.bank = bank;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString(){
        return "{\n" +
                "sheme: "+scheme+",\n"+
                "type: "+type+",\n"+
                "bank: "+bank+"\n"+
                "}";
    }
}
