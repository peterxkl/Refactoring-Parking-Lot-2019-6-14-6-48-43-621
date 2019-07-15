
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket parking(Car car) throws NoPositionException{
        ParkingLot selectedParkingLot = parkingLots.get(0);
        double MaxRate = 0;
        double rate = 0d;
        for (ParkingLot parkingLot : parkingLots) {
            rate = parkingLot.getParkingCapacity() / parkingLot.getCapacity();
            if (rate > MaxRate) {
                selectedParkingLot = parkingLot;
                MaxRate = rate;
            }
        }
        if(selectedParkingLot!=null){{

            return selectedParkingLot.park(car);
        }}else{
            throw new NoPositionException("No enough position.");
        }
    }
}
