package examplecode;

import java.util.HashMap;
import java.util.Map;

public class Husky {
    public String name;

    public Husky(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        Husky other = (Husky) o;
        return this.name.equals(other.name);
    }

    public int hashCode() {
        return this.name.length();
    }

    public static void main(String[] args) {
        HashMap<Husky, Integer> map = new HashMap<>();
        Husky a = new Husky("lilli");
        Husky b = new Husky("ahmed");

        map.put(a, 1);
        map.put(b, 2);
        System.out.println("-------------------");
        for (Husky husky : map.keySet()) {
            System.out.println("husky = " + husky.hashCode());
        }

        a.name += a.name;
        map.put(a, 3);
        map.put(b, 4);
        System.out.println("-------------------");
        for (Husky husky : map.keySet()) {
            System.out.println("husky = " + husky.hashCode());
        }

        b.name += b.name;
        map.put(b, 5);
        System.out.println("-------------------");

        Husky n1 = null;
        Husky n2 = null;
        int i = 0;
        for (Husky husky : map.keySet()) {
            if(i == 0) n1 = husky;
            else if (i == 2) {
                n2 = husky;
            }
            i++;
        }
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
        System.out.println(n1.equals(n2));
        System.out.println(n1 == n2);
        System.out.println(n1.name);
        System.out.println(n2.name);
        System.out.println("-------------------");

        System.out.println(map.size());

        System.out.println(map.get(new Husky("lilli")));
        System.out.println(map.get(new Husky("lillililli")));
    }
}