package com.civila.model.city

class InfluenceArea {
    String name
    Faction faction

    public static InfluenceArea faction (Faction faction){
        new InfluenceArea(faction: faction)
    }

    public static InfluenceArea group (String name){
        new InfluenceArea(name: name)
    }
}
