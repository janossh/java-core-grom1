package lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (!o1.getDateCreated().equals(o2.getDateCreated()))
            return o1.getDateCreated().getTime() - o2.getDateCreated().getTime()<0 ? -1 : 1;
        return 0;
    }
}
