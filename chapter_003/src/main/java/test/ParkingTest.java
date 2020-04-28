package test;

import org.junit.Test;
import ru.job4j.NewMachineParking.BigCar;
import ru.job4j.NewMachineParking.LittleCar;
import ru.job4j.NewMachineParking.Parking;

import static org.junit.Assert.assertEquals;

public class ParkingTest {
    @Test
    public void bussyForBigCarwhenplaceIs() {
        Parking p=new Parking(2,3);
        for (int i=0;i<3;i++) {
            assertEquals(true,p.bussyForBigCar(new BigCar()));
        }
    }
    @Test
    public void bussyForBigCarwhenplaceIsNot() {
        Parking p=new Parking(2,3);
        for (int i=0;i<3;i++) {
            assertEquals(true,p.bussyForBigCar(new BigCar()));
        }
        assertEquals(false,p.bussyForBigCar(new BigCar()));
    }
    @Test
    public void bussyForSmallPlaceIs() {
        Parking p=new Parking(2,3);
        for (int i=0;i<3;i++) {
            assertEquals(true,p.bussyForSmallPlace(new LittleCar()));
        }
    }
    @Test
    public void bussyForSmallPlaceIsNot() {
        Parking p=new Parking(2,3);
        for (int i=0;i<3;i++) {
            assertEquals(true,p.bussyForSmallPlace(new LittleCar()));
        }
        assertEquals(false,p.bussyForSmallPlace(new LittleCar()));
    }
}
