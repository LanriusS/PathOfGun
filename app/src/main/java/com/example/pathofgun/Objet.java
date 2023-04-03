package com.example.pathofgun;

public enum Objet {

        ACOG("Viseur ACOG"),
        RED("Viseur point rouge"),
        SILENCIEUX("Silencieux"),
        COMPENSATEUR("Compensateur"),
        MAG("Chargeur double"),
        SCOPE("Viseur X6"),
        CROSSE("Crosse"),
        POIGNEE("Poignée"),
        C50("Calibre 50"),
        OTAN("Calibre 5.56"),
        C9("Calibre 9mm");

        private final String name;

        Objet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
