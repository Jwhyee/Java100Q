package edu.LikeLionCodeTest;

import java.util.*;

class Post implements Comparable<Post>{
    private final int id;
    private final String title;
    private final String content;

    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Post post) {
        return post.getId() - this.id;
    }
}
public class CodeTest6{
    public static int id = 1;
    public static List<Post> posts = new ArrayList<>();

    public static void addPost(int id, String title, String content) {
        posts.add(new Post(id, title, content));
        System.out.println("[알림] " + id + "번글이 등록되었습니다.");
    }

    public static void postLists() {
        System.out.println("번호 / 제목");
        System.out.println("-------------------");
        Collections.sort(posts);
        for (Post post : posts) {
            System.out.println(post.getId() + " / " + post.getTitle());
        }
    }

    public static void main(String[] args){
        System.out.println("프로그램 시작");
        Scanner sc = new Scanner(System.in);

        boolean offProgram = true;

        while (offProgram) {
            System.out.print("명령어 ) ");
            String command = sc.next();
            switch (command) {
                case "등록" :
                    System.out.print("제목 : ");
                    String title = sc.next();
                    System.out.print("내용 : ");
                    String content = sc.next();
                    addPost(id, title, content);
                    id++;
                    break;
                case "목록" :
                    postLists();
                    break;
                case "종료" :
                    offProgram = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default :
                    System.out.println("잘못 입력했습니다.");
            }
        }
    }
}
