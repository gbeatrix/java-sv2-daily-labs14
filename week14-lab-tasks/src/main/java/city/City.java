package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return List.copyOf(buildings);
    }

    public void addBuilding(Building building) {
        if (sumOfAreaOfBuildings() + building.getArea() <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }
/*
    public Building findHighestBuilding() {
        if (buildings.isEmpty()) {
            return null;
        }
        Building highest = buildings.get(0);
        for (Building building : buildings) {
            if (building.getLevels() > highest.getLevels()) {
                highest = building;
            }
        }
        return highest;
    }
*/
    public Building findHighestBuilding() {
        return buildings.stream().max(Comparator.comparing(Building::getLevels)).orElseThrow();
    }
/*
    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().getStreet().equals(street)) {
                result.add(building);
            }
        }
        return result;
    }
*/
    public List<Building> findBuildingsByStreet(String street) {
        return buildings.stream().filter(b -> b.getAddress().getStreet().equals(street)).toList();
    }
/*
    public boolean isThereBuildingWithMorePeopleThan(int limit) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > limit) {
                return true;
            }
        }
        return false;
    }
*/
    public boolean isThereBuildingWithMorePeopleThan(int limit) {
        return buildings.stream().anyMatch(b -> b.calculateNumberOfPeopleCanFit() > limit);
    }

    private long sumOfAreaOfBuildings() {
        long sum = 0;
        for (Building building : buildings) {
            sum += building.getArea();
        }
        return sum;
    }
}
