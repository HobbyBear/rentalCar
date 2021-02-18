package uk.ac.ncl.teach.ex.model;

import java.util.Calendar;

public class CustomerRecord {

    private String firstName;

    private String lastName;

    private Calendar birthday;

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }


    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    private Calendar createTime;

    private String id;

    private boolean isVip;



    public CustomerRecord(String firstName, String lastName, Calendar birthday, Calendar createTime, boolean isVip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.createTime = createTime;
        this.isVip = isVip;
        id = firstName.indexOf(0) + lastName.indexOf(0) + "-" + createTime.get(Calendar.YEAR) + "-" + SequenceGenerator.generateCustomerNum();

    }

    public int getAge(){
       return Math.max(Calendar.getInstance().get(Calendar.YEAR) - birthday.get(Calendar.YEAR), 0);
    }
}
