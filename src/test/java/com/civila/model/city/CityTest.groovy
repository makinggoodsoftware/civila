package com.civila.model.city

import com.civila.model.Coordinates
import spock.lang.Specification


class CityTest extends Specification {
    def "should create city"() {
        given:
        def city = new City(
                'name': "Alberta",
                'influence': new Surface('width': 8, 'height': 10),
                'walled': new PlacedCityElement(
                        'relativeToParentAnchorPoint': new Coordinates('x': 2, 'y': 3),
                        cityElement: new Division(
                                'surface': new Surface('width': 6, 'height': 5),
                                'blocks': [
                                        new PlacedCityElement(
                                                'relativeToParentAnchorPoint': new Coordinates('x': 1, 'y': 1),
                                                cityElement: new Division(
                                                        'controller': Faction.MAGES,
                                                        'surface': new Surface('width': 2, 'height': 2),
                                                        'blocks': [
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.COMMERCE),
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HQ),
                                                        ]
                                                ),
                                        ),
                                        new PlacedCityElement(
                                                'relativeToParentAnchorPoint': new Coordinates('x': 3, 'y': 1),
                                                cityElement: new Division(
                                                        'controller': Faction.DIPLOMATS,
                                                        'surface': new Surface('width': 2, 'height': 2),
                                                        'blocks': [
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.COMMERCE),
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HQ),
                                                        ]
                                                ),
                                        ),
                                        new PlacedCityElement(
                                                'relativeToParentAnchorPoint': new Coordinates('x': 5, 'y': 1),
                                                cityElement: new Division(
                                                        'controller': Faction.MERCHANTS,
                                                        'surface': new Surface('width': 2, 'height': 2),
                                                        'blocks': [
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.COMMERCE),
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HQ),
                                                        ]
                                                ),
                                        ),
                                        new PlacedCityElement(
                                                'relativeToParentAnchorPoint': new Coordinates('x': 1, 'y': 3),
                                                cityElement: new Division(
                                                        'controller': Faction.KNIGHTS,
                                                        'surface': new Surface('width': 2, 'height': 2),
                                                        'blocks': [
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.COMMERCE),
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HQ),
                                                        ]
                                                ),
                                        ),
                                        new PlacedCityElement(
                                                'relativeToParentAnchorPoint': new Coordinates('x': 3, 'y': 3),
                                                cityElement: new Division(
                                                        'controller': Faction.CENTRAL,
                                                        'surface': new Surface('width': 4, 'height': 2),
                                                        'blocks': [
                                                                new Building(type: BuildingType.TOWER),
                                                                new Building(type: BuildingType.HORSES),
                                                                new Building(type: BuildingType.TAVERN),
                                                                new Building(type: BuildingType.HQ),
                                                                new Building(type: BuildingType.BLACKSMITH),
                                                                new Building(type: BuildingType.MARKET),
                                                                new Building(type: BuildingType.CHURCH),
                                                                new Building(type: BuildingType.PRISON),
                                                        ]
                                                ),
                                        ),
                                        new PlacedCityElement(
                                                'relativeToParentAnchorPoint': new Coordinates('x': 1, 'y': 5),
                                                cityElement: new Division(
                                                        'controller': Faction.FARMERS,
                                                        'surface': new Surface('width': 6, 'height': 1),
                                                        'blocks': [
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HQ),
                                                                new Building(type: BuildingType.COMMERCE),
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HOUSE),
                                                                new Building(type: BuildingType.HOUSE),
                                                        ]
                                                ),
                                        ),
                                ]
                        )
                ),
                'unwalled' : [
                        new PlacedCityElement(
                                'relativeToParentAnchorPoint': new Coordinates('x': 4, 'y': 1),
                                cityElement: new Division(
                                        'surface': new Surface('width': 2, 'height': 2),
                                        'blocks': [
                                                new Building(type: BuildingType.HOUSE),
                                                new Building(type: BuildingType.HOUSE),
                                                new Building(type: BuildingType.FARM),
                                                new Building(type: BuildingType.FARM),
                                        ]
                                ),
                        ),
                        new PlacedCityElement(
                                'relativeToParentAnchorPoint': new Coordinates('x': 3, 'y': 9),
                                cityElement: new Division(
                                        'surface': new Surface('width': 4, 'height': 2),
                                        'blocks': [
                                                new Building(type: BuildingType.HOUSE),
                                                new Building(type: BuildingType.FARM),
                                                new Building(type: BuildingType.FARM),
                                                new Building(type: BuildingType.HOUSE),
                                                new Building(type: BuildingType.HOUSE),
                                                new Building(type: BuildingType.FARM),
                                                new Building(type: BuildingType.FARM),
                                                new Building(type: BuildingType.HOUSE),
                                        ]
                                ),
                        ),
                ]
        )
        when:


        city

        then:
        true
    }
}
