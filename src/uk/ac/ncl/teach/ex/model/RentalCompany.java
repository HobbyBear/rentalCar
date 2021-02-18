package uk.ac.ncl.teach.ex.model;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;
import uk.ac.ncl.teach.ex.interfaces.Bike;

import java.util.HashMap;
import java.util.LinkedList;

public class RentalCompany {

    private LinkedList<RoadBike> roadBikeLinkedList;

    private LinkedList<ElectricBike> electricBikeLinkedList;


    private LinkedList<Bike> rentedBikeList;

    private BikeFactory bikeFactory;


    private HashMap<String, LinkedList<Bike>> rentRecordMap;

    public RentalCompany(int roadBikeNum, int electricBikeNum) {
        this.roadBikeLinkedList = new LinkedList<>();
        this.electricBikeLinkedList = new LinkedList<>();
        this.rentedBikeList = new LinkedList<>();
        this.bikeFactory = new BikeFactory();
        for (int i = 0; i < roadBikeNum; i++) {
            this.roadBikeLinkedList.add((RoadBike) bikeFactory.createBike(BikeTypeEnum.RoadBike));
        }
        for (int i = 0; i < electricBikeNum; i++) {
            this.electricBikeLinkedList.add((ElectricBike) bikeFactory.createBike(BikeTypeEnum.ElectricBike));
        }
        this.rentRecordMap = new HashMap<>();

    }

    public int availableBikes(BikeTypeEnum typeOfBike) {
        switch (typeOfBike) {
            case RoadBike:
                return this.roadBikeLinkedList.size();
            case ElectricBike:
                return this.electricBikeLinkedList.size();
        }
        return 0;
    }

    public LinkedList<Bike> getRentedBikes() {
        return this.rentedBikeList;
    }

    public LinkedList<Bike> getBike(CustomerRecord customerRecord) {
        LinkedList<Bike> bikes = rentRecordMap.get(customerRecord.getId());
        return bikes;
    }

    public Bike issueBike(CustomerRecord customerRecord, BikeTypeEnum bikeTypeEnum) {
        LinkedList<Bike> customerRentList = rentRecordMap.get(customerRecord.getId());
        if (customerRentList == null) {
            customerRentList = new LinkedList<>();
        }

        if (customerRentList.size() >= 1) {
            return null;
        }


        Bike bike;

        switch (bikeTypeEnum) {
            case ElectricBike:
                if (!customerRecord.isVip()) {
                    return null;
                }
                if (this.electricBikeLinkedList.size() == 0) {
                    return null;
                }

                if (customerRecord.getAge() < 21) {
                    return null;
                }

                bike = electricBikeLinkedList.remove();
                customerRentList.add(bike);
                rentRecordMap.put(customerRecord.getId(), customerRentList);
                bike.setRent(true);
                rentedBikeList.add(bike);
                return bike;
            case RoadBike:
                if (this.roadBikeLinkedList.size() == 0) {
                    return null;
                }
                bike = roadBikeLinkedList.remove();
                customerRentList.add(bike);
                rentRecordMap.put(customerRecord.getId(), customerRentList);
                bike.setRent(true);
                rentedBikeList.add(bike);
                return bike;
        }
        return null;
    }

    public void terminateRental(CustomerRecord customerRecord) {
        LinkedList<Bike> customerRentList = rentRecordMap.get(customerRecord.getId());
        if (customerRentList == null || customerRentList.size() != 1) {
            return;
        }
        Bike bike = customerRentList.remove();
        bike.setRent(false);
        switch (bike.getType()) {
            case ElectricBike:

                electricBikeLinkedList.add((ElectricBike) bike);
                ((ElectricBike) bike).setFullElectricity(true);
                break;
            case RoadBike:
                roadBikeLinkedList.add((RoadBike) bike);
                break;
        }
        rentedBikeList.remove(bike);

    }

}
