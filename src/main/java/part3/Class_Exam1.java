package part3;

class FarmMachine {
    int modelPrice;
    int modelYear;
    String modelColor;
    String modelState;

    public FarmMachine(int modelPrice, int modelYear, String modelColor, String modelState) {
        this.modelPrice = modelPrice;
        this.modelYear = modelYear;
        this.modelColor = modelColor;
        this.modelState = modelState;
    }
}
public class Class_Exam1 {
    public static void main(String[] args) {
        // Q. FarmMachine의 속성과 동작들을 가지는 클래스를 코드로 구현하고 객체를 생성하여 동작
        // 가격, 연식, 색상, 상태
        FarmMachine farmMachine = new FarmMachine(1000000, 2020, "red", "moving");
        System.out.println(farmMachine.modelPrice);
        System.out.println(farmMachine.modelYear);
        System.out.println(farmMachine.modelColor);
        System.out.println("FarmMachine is " + farmMachine.modelState);
    }
}
