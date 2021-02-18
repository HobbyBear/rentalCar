package uk.ac.ncl.teach.ex.interfaces;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;

import java.util.Objects;

public abstract class Bike {

    private String sequenceNum;

    private boolean isRent;

    public Bike(String sequenceNum, boolean isRent) {
        this.sequenceNum = sequenceNum;
        this.isRent = isRent;
    }

    public String getSequenceNum() {
        return sequenceNum;
    }


    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

   public abstract  BikeTypeEnum getType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return isRent == bike.isRent && Objects.equals(sequenceNum, bike.sequenceNum);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "sequenceNum='" + sequenceNum + '\'' +
                ", isRent=" + isRent +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequenceNum, isRent);
    }
}
