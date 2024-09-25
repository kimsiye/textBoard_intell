package txtBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class TxtBoardApp {

    Scanner sc = new Scanner(System.in);

    ArrayList<Post> postList = new ArrayList<>();
int countId = 1;


    public void appRun(){
        while(true){
            System.out.println("실행기능 : exit, add, list, update, delete");
            System.out.print("명령어 : ");
            String commend = sc.nextLine();

            if(commend.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else if(commend.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String boardTitle = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String boardContent = sc.nextLine();

                Post post = new Post();
                post.setId(countId);
                post.setTitle(boardTitle);
                post.setContent(boardContent);

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
            }else if (commend.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
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
            }

        }
    }

}
