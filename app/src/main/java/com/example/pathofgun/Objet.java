package com.example.pathofgun;

public enum Objet {

        ACOG("Viseur ACOG"),
        RED("Viseur point rouge"),
        SILENCIEUX("Silencieux"),
        COMPENSATEUR("Compensateur"),
        MAG("Chargeur double"),
        SCOPE("Viseur X6"),
        CROSSE("Crosse"),
        POIGNEE("Poignée");
        private final String name;

        Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
