package lesson15.homework0;

public class GoogleAPI implements API {
    private Room[] rooms;
    private Room[] findedRooms;
    //private int count;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count;
        Room etalonRoom = new Room(1001, price, persons, null, hotel, city);
        count = 0;
        for (Room el : rooms)
            if (el != null)
                if (el.equals(etalonRoom) )
                    count++;

        findedRooms = new Room[count];
        count = 0;
        for (Room el : rooms)
            if (el != null)
                if (el.equals(etalonRoom) ) {
                    findedRooms[count] = el;
                    count++;
                }
        return findedRooms;
    }

    @Override
    public Room[] getAll() {
        int count;
        count = 0;
        for (Room el : rooms)
            if (el != null)
//                if (el.dateAvailableFrom.before(new Date()))
                count++;

        findedRooms = new Room[count];
        count = 0;
        for (Room el : rooms) {
            if (el != null) {
//                if (el.dateAvailableFrom.before(new Date())) {
                findedRooms[count] = el;
                count++;
            }
        }
        return findedRooms;
    }
}
