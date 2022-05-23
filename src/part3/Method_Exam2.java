package part3;

public class Method_Exam2 {
    public static String upperCase(String content) {
        return content.toUpperCase();
    }
    public static void main(String[] args) {
        //Q. 반환값과 인자값이 있는 대문자 출력 메소드를 구현하시오.
        String content = "korea";
        System.out.println(upperCase(content));
    }
}
