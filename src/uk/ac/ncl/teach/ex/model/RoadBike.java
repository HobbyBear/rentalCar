package uk.ac.ncl.teach.ex.model;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;
import uk.ac.ncl.teach.ex.interfaces.Bike;

public class RoadBike extends Bike {


    public RoadBike(String sequenceNum, boolean isRent) {
        super(sequenceNum, isRent);
    }

    @Override
    public BikeTypeEnum getType() {
        return BikeTypeEnum.RoadBike;
    }
}
