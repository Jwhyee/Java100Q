package callby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallByReferenceTest {

    static class Mac {
        private final String name;
        private final String processor;
        private int screenSize;
        private int ramSize;

        public Mac(String name, String processor, int screenSize, int ramSize) {
            this.name = name;
            this.processor = processor;
            this.screenSize = screenSize;
            this.ramSize = ramSize;
        }

        @Override
        public String toString() {
            return "Mac{" +
                    "name='" + name + '\'' +
                    ", processor='" + processor + '\'' +
                    ", screenSize=" + screenSize +
                    ", ramSize=" + ramSize + "GB" +
                    '}';
        }
    }

    private void changeMac(Mac myMac, Mac newMac) {
        myMac = newMac;
    }

    @Test
    public void changeMacTest() {
        Mac myMac = new Mac("Macbook Air", "m1", 13, 8);
        Mac macBookPro14 = new Mac("Macbook Pro", "m1 max", 14, 32);

        changeMac(myMac, macBookPro14);
        System.out.println(myMac.toString());
        System.out.println(macBookPro14.toString());
        assertEquals(myMac, macBookPro14);

        myMac = macBookPro14;
        System.out.println(myMac.toString());
        System.out.println(macBookPro14.toString());
        assertEquals(myMac, macBookPro14);
    }
}