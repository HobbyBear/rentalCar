package uk.ac.ncl.teach.ex.model;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;
import uk.ac.ncl.teach.ex.interfaces.Bike;


public class BikeFactory {


    public Bike createBike(BikeTypeEnum bikeTypeEnum) {
        if (bikeTypeEnum.equals(BikeTypeEnum.RoadBike)) {
            return new RoadBike(SequenceGenerator.generateBikeNo(bikeTypeEnum), false);
        }
        if (bikeTypeEnum.equals(BikeTypeEnum.ElectricBike)) {
            return new ElectricBike(SequenceGenerator.generateBikeNo(bikeTypeEnum), false);
        }
        return null;
    }


}
