package uk.ac.ncl.teach.ex.model;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;

public class SequenceGenerator {

    private static int customerNo;

    private static int bikeNo = 111;


    public static int generateCustomerNum() {
        customerNo++;
        return customerNo;
    }

    public static String generateBikeNo(BikeTypeEnum bikeTypeEnum) {
        bikeNo++;
        switch (bikeTypeEnum) {
            case RoadBike:
                return "rb" + bikeNo;
            case ElectricBike:
                return "eb" + bikeNo;
        }
        return "";
    }


}
