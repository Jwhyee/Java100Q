package algo.programmers.lv2;

public class SkillTree {
    /*public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> skillList = Arrays.asList(skill.split(""));
        Collections.reverse(skillList);
        Stack<String> skillStack = new Stack<>();

        for (int i = 0; i < skill_trees.length; i++) {
            String[] skillTreeSplit = skill_trees[i].split("");
            skillStack.addAll(skillList);
            boolean flag = false;
            for (String s : skillTreeSplit) {
                // s가 skillStack 포함되어 있다면 순서 검사
                if (skillStack.size() != 0 && skillStack.contains(s)) {
                    if (skillStack.peek().equals(s)) {
                        skillStack.pop();
                    } else {
                        flag = false;
                        skillStack.clear();
                        break;
                    }
                    flag = true;
                }
            }
            if (flag) {
                answer++;
            }
            if (!skillStack.empty()) {
                skillStack.clear();
            }
        }
        return answer;
    }*/
    public int solution(String skill, String[] skill_trees) {
        // answer 초기화
        int answer = 0;

        // skill_trees의 각 요소별로 skill에 포함되어 있는지 확인하기 위한 과정
        for (String skillTree : skill_trees) {

            // replace를 위해 temp값 추가
            String temp = skillTree;

            // skillTree에 skill의 순서에 맞게 포함되어 있는지 확인하는 과정
            for (int i = 0; i < skillTree.length(); i++) {

                // skill 포함되어 있는지 확인하기 위해 skillTree를 1글자씩 잘라서 s에 저장
                String s = skillTree.substring(i, i + 1);

                // skill에 포함되어 있지 않다면 빈값으로 replace
                if (!skill.contains(s)) {
                    temp = temp.replace(s, "");
                }
            }

            // skill에서 temp 값의 위치를 찾아서 0이면 answer 증가(순서가 맞기 때문!)
            if (skill.indexOf(temp) == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SkillTree st = new SkillTree();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CAE"};
        System.out.println(st.solution(skill, skill_trees));
    }
}
