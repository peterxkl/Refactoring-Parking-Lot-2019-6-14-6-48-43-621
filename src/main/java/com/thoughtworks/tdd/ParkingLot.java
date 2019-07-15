import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket,Car> parkingCarTicket = new HashMap();
    private int actualCapacity;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.actualCapacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<Ticket, Car> getParkingCarTicket() {
        return parkingCarTicket;
    }

    public int getParkingCapacity() {
        return actualCapacity;
    }

    public Ticket park(Car car) throws NoPositionException{
        if(actualCapacity<=0){
            throw new NoPositionException("No enough position.");
        }else{
            Ticket ticket = new Ticket();
            parkingCarTicket.put(ticket,car);
            actualCapacity-=1;
            return ticket;
        }
    }

    public Car fetch(Ticket ticket) throws WrongTicketException , UsedTicketException , NullTicketException{
        if (ticket!=null) {
            if (parkingCarTicket.containsKey(ticket)) {
                if (parkingCarTicket.get(ticket) != null) {
                    Car car = parkingCarTicket.get(ticket);
                    parkingCarTicket.put(ticket, null);
                    actualCapacity+=1;
                    return car;
                } else {
                    throw new UsedTicketException("Used parking ticket.");
                }
            } else {
                throw new WrongTicketException("Wrong parking ticket.");
            }
        }else{
            throw new NullTicketException("Please provide your parking ticket.");
        }


    }
}
