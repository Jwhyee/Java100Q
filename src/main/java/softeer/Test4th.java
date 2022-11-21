package softeer;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
/*
80383000
3
101 1234
201 256512
301 10242048
201*256512*
201*12345*
80383000*
* */
public class Test4th {
    static Map<String, String> housePwd = new LinkedHashMap<>();
    public static boolean isCurrentPassword(String inputValue) {
        String inputHouseNum = inputValue.split("\\*")[0];
        String inputPwd = inputValue.split("\\*")[1];
        return housePwd.get(inputHouseNum).equals(inputPwd);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String commonPwd = br.readLine();
        int households = Integer.parseInt(br.readLine());
        for (int i = 0; i < households; i++) {
            String input = br.readLine();
            housePwd.put(input.split(" ")[0], input.split(" ")[1]);
        }

        String inputValue = br.readLine();
        String inputLastCode = inputValue.substring(inputValue.length() - 5, inputValue.length() - 1);

        String STATUS = "";
        switch (inputValue.charAt(inputValue.length() - 1)) {
            case '*':
                if(inputValue.contains(commonPwd) || isCurrentPassword(inputValue)) STATUS = "OPEN";
                break;
            case '!':
                if(inputLastCode.equals("0000")) STATUS = "SECURITY";
                else STATUS = "CALL";
                break;
        }
        System.out.println(inputLastCode + " " + STATUS);
    }
}
