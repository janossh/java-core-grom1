package lesson15.homework0;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] findedRooms;
        int count = 0;
        for (API el : apis) {
            if (el != null)
                count += el.findRooms(price, persons, city, hotel).length;
        }
        findedRooms = new Room[count];
        count = 0;

        for (API el : apis) {
            if (el != null)
                for (Room room : el.findRooms(price, persons, city, hotel)) {
                    findedRooms[count] = room;
                    count++;
                }
        }
        return findedRooms;

    }

    public Room[] check(API api1, API api2) {
        Room[] findedRooms = null;
        int count = 0;
        if (api1 == null || api2 == null)
            return null;
        for (Room el1 : api1.getAll())
            for (Room el2 : api2.getAll())
                if (el1 != null && el2 != null)
                    if (el1.equals(el2) && el1.hashCode() == el2.hashCode())
                        count++;

        findedRooms = new Room[count];
        count = 0;

        for (Room el1 : api1.getAll())
            for (Room el2 : api2.getAll())
                if (el1 != null && el2 != null)
                    if (el1.equals(el2) && el1.hashCode() == el2.hashCode()) {
                        findedRooms[count] = el1;
                        count++;
                    }


        return findedRooms;
    }
}

