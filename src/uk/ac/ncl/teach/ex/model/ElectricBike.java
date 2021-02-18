package uk.ac.ncl.teach.ex.model;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;
import uk.ac.ncl.teach.ex.interfaces.Bike;

public class ElectricBike extends Bike {

    private boolean isFullElectricity;


    public ElectricBike(String sequenceNum, boolean isRent) {
        super(sequenceNum, isRent);
    }



    @Override
    public BikeTypeEnum getType() {
        return BikeTypeEnum.ElectricBike;
    }

    public boolean isFullElectricity() {
        return isFullElectricity;
    }

    public void setFullElectricity(boolean fullElectricity) {
        isFullElectricity = fullElectricity;
    }
}
