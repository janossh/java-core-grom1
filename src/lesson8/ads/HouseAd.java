package lesson8.ads;

public class HouseAd extends Ad {
    String ownerName;
    String address;
    int square;
    int flor;

    public HouseAd(long id, int price, String ownerName, String address, int square, int flor) {
        super(id, price);
       this.ownerName = ownerName;
        this.address = address;
        this.square = square;
        this.flor = flor;
    }

    boolean checkOwner() {
        Owners owners = new Owners();
        for (String owner : owners.owners){
            if (ownerName==owner)
                return true;
        }

        return false;

    }
}
