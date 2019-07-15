import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket parking(Car car) throws NoPositionException{
        List<Integer> list = parkingLots.stream().map(x->x.getParkingCapacity()/x.getCapacity()).collect(Collectors.toList());
        int max = Collections.max(list);
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getParkingCapacity() == max){
                Ticket ticket = parkingLot.park(car);
                return ticket;
            }
        }
        throw new NoPositionException("No enough position.");

    }
}
