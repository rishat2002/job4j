package API;

public class Address {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Client live "+"city "+city+" street "+street;
    }

    @Override
    public boolean equals(Object a) {
        Address n=(Address) a;
        return this.city.equals(n.city);
    }

    @Override
    public int hashCode() {
        return city.length();
    }
}
