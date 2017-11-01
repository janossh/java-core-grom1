package lesson28;

import java.util.Comparator;
import java.util.Date;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (compareToValues(o1.getChannelName(), o2.getChannelName()) != 0)
            return compareToValues(o1.getChannelName(), o2.getChannelName());
        else if (compareToValues(o1.getFingerprint(), o2.getFingerprint()) != 0)
            return compareToValues(o1.getFingerprint(), o2.getFingerprint());

            return compareToValues(o1.getDateCreated(), o2.getDateCreated());
    }

    private <S extends Comparable> int compareToValues(S s1, S s2) {

        if (s1 == null) {
            return s2 == null ? 0 : 1;
        }
        if (s2 == null)
            return -1;

        if(s1.getClass().getSimpleName().equals("String"))
            return ((String)s1).compareTo((String) s2);
        return ((Date)s1).getTime() - ((Date)s2).getTime() > 0 ? -1 : 1;
    }

}