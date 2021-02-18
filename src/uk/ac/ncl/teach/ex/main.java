package uk.ac.ncl.teach.ex;

import uk.ac.ncl.teach.ex.enums.BikeTypeEnum;
import uk.ac.ncl.teach.ex.interfaces.Bike;
import uk.ac.ncl.teach.ex.model.CustomerRecord;
import uk.ac.ncl.teach.ex.model.RentalCompany;

import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;

public class main {

    public static void main(String[] args) {
        RentalCompany company = new RentalCompany(50, 10);

        System.out.println("road bike available num is " + company.availableBikes(BikeTypeEnum.RoadBike));
        System.out.println("electric bike available num is " + company.availableBikes(BikeTypeEnum.ElectricBike));

        Calendar birthDay = Calendar.getInstance();
        birthDay.set(2010, 3, 15);

        CustomerRecord customerRecord = new CustomerRecord("li", "mei", birthDay,
                Calendar.getInstance(), true);


        Bike issueBike = company.issueBike(customerRecord, BikeTypeEnum.ElectricBike);

        if (issueBike != null) {
            System.out.println(customerRecord.getFullName() + " rent success");
            System.out.println("rent bike is " + company.getRentedBikes());
            System.out.println("customer " + customerRecord.getFullName() + " rent bike is " + issueBike);

        }else {
            System.out.println(customerRecord.getFullName() + " rent fail");
        }

        LinkedList<Bike> rentList = company.getBike(customerRecord);

        System.out.println("customer " + customerRecord.getFullName() + " rent bike list is " + rentList);


        company.terminateRental(customerRecord);


        System.out.println("rent bike is " + company.getRentedBikes());

    }
}
