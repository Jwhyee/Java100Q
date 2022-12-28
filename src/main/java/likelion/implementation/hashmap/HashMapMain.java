package likelion.implementation.hashmap;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();

        ages.put("영희", 22);
        ages.put("철수", 23);
        ages.put("민서", 25);
        ages.put("철수", 27);
        ages.remove("영희");
        ages.put("광수", 27);

        ages.findAll();

        for ( String name : ages.keySet() ) {
            System.out.println("이름 : " + name + ", 나이 : " + ages.get(name));
        }

        HashMap<String, Object> everyone = new HashMap<>();
        everyone.put("사람", new 사람());
        everyone.put("원숭이", new 원숭이());
        ((사람)everyone.get("사람")).말하다();
        // 출력 => 사람이 말합니다.
        ((원숭이)everyone.get("원숭이")).묘기를_부리다();
        // 출력 => 원숭이가 묘기를 부립니다.
    }
}
class 사람 {
    void 말하다() {
        System.out.println("사람이 말합니다.");
    }
}
class 원숭이 {
    void 묘기를_부리다() {
        System.out.println("원숭이가 묘기를 부립니다.");
    }
}
