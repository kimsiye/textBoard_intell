package txtBoard2.txtBoard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtBoardApp {

    Scanner sc = new Scanner(System.in);

    ArrayList<Post> postList = new ArrayList<>();

    int countId = 1;

    LocalDateTime now = LocalDateTime.now(); // 현재 날짜/시간
    String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

    public void appRun(){

        Post test1 = new Post(countId, "안녕하세요 반갑습니다. java 공부중이에요.", "...", formatedNow);
        Post test2 = new Post(countId = countId + 1, "java 질문좀 할게요~", "...", formatedNow);
        Post test3 = new Post(countId = countId + 1, "b 정처기 따야되나요?", "...", formatedNow);
        postList.add(test1);
        postList.add(test2);
        postList.add(test3);
        countId++;


        while(true){
            System.out.println("실행기능 : exit, add, list, update, delete, detail, search");
            System.out.print("명령어 : ");
            String commend = sc.nextLine();

            if(commend.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else if(commend.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String postTitle = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String postContent = sc.nextLine();

                Post post = new Post(countId, postTitle, postContent, formatedNow);

                postList.add(post);
                System.out.println("게시물이 등록되었습니다.");

                countId++;
            } else if (commend.equals("list")) {
                System.out.println("==============");
                for(Post post : postList){
                    System.out.printf("번호 : %d\n",post.getId());
                    System.out.printf("제목 : %s\n",post.getTitle());
                    System.out.println("==============");
                }
            }else if (commend.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                boolean found = false;
                for (Post post : postList) {
                    if(post.getId() == targetId){
                        System.out.print("제목 : ");
                        String boardTitle = sc.nextLine();
                        System.out.print("내용 : ");
                        String boardContent = sc.nextLine();

                        post.setTitle(boardTitle);
                        post.setContent(boardContent);

                        System.out.printf("update : %d번 게시물이 수정되었습니다.\n",post.getId());
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("없는 게시물 번호입니다.");
                }
            }else if (commend.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                boolean found = false;
                for (Post post : postList) {
                    if(post.getId() == targetId){

                        postList.remove(post);

                        System.out.printf("%d번 게시물이 삭제되었습니다.\n",post.getId());
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("delete : 없는 게시물 번호입니다.");
                }
            } else if (commend.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                boolean found = false;
                for (Post post : postList) {
                    if(post.getId() == targetId){

                        System.out.println("==============");
                        System.out.printf("번호 : %d\n", post.getId());
                        System.out.printf("제목 : %s\n", post.getTitle());
                        System.out.printf("내용 : %s\n", post.getContent());
                        System.out.printf("등록일자 : %s\n", post.getCurrentTime());
                        System.out.printf("조회수 : %d\n", post.getView());
                        System.out.println("==============");
                        post.setView(1);

                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("detail : 없는 게시물 번호입니다.");
                }
            } else if (commend.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String keyword = sc.nextLine();
                boolean found = false;
                System.out.println("==============");
                for (Post post : postList) {
                    if (post.getTitle().contains(keyword)) {

                        System.out.printf("번호 : %d\n", post.getId());
                        System.out.printf("제목 : %s\n", post.getTitle());
                        System.out.println("==============");

                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("검색 결과가 없습니다.");
                }

            }

        }
    }

}
