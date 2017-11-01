package lesson28;

import java.util.*;

public class DemoCamparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001,null,"aaaa", true, new Date());
        Capability capability2 = new Capability(1005,"test",null, false, new Date());
        Capability capability3 = new Capability(900,"test","cccc", true, new Date());
        Capability capability4 = new Capability(900,"test","rrrr", false, null);

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        //capabilities.sort(new IsActiveComparator());

        capabilities.sort(new FullComparator());

        System.out.println(capabilities);


    }
}
