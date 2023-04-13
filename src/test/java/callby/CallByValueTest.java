package callby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallByValueTest {

    static class TestClass{
        public Long id;
        public String name;
        public int age;

        public TestClass(Long id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    void changeName(TestClass tc) {
        tc.setName("linux");
        System.out.println("Method ID = " + System.identityHashCode(tc));
    }

    void changeId(TestClass tc) {
        tc.setId(2L);
        System.out.println("Method ID = " + System.identityHashCode(tc));
    }

    void changeAge(TestClass tc){
        tc.setAge(16);
        System.out.println("Method ID = " + System.identityHashCode(tc));
    }

    @Test
    void test() {
        TestClass tc1 = new TestClass(1L, "mac", 26);
        System.out.println("Construct ID = " + System.identityHashCode(tc1));

        changeName(tc1);
        assertEquals(tc1.getName(), "linux");

        changeId(tc1);
        assertEquals(tc1.getId(), 2L);

        changeAge(tc1);
        assertEquals(tc1.getAge(), 16);
    }
}