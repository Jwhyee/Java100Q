package algo.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlienDiction {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        List<String> spellList = new ArrayList<>(List.of(spell));
        List<String> dicList = new ArrayList<>(List.of(dic));
        for (int i = 0; i < Math.pow(spellList.size(), 2); i++) {
            Collections.shuffle(spellList);
            System.out.println("spellList = " + spellList);
            String word = "";
            for (int j = 0; j < spellList.size(); j++) {
                word += spellList.get(j);
                System.out.println("word = " + word);
            }
            if (dicList.contains(word)) {
                answer = 1;
                break;
            } else {
                answer = 2;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        String[] spell = {"p", "o", "s"};
        String[] spell = {"z", "d", "x"};
//        String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        AlienDiction a = new AlienDiction();
        System.out.println(a.solution(spell, dic));
    }
}
