package txtBoard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtBoardApp {

    Scanner sc = new Scanner(System.in);

    ArrayList<Post> postList = new ArrayList<>();
    ArrayList<Comment> commentList = new ArrayList<>();

    int countPostId = 1;
    int countCommentId = 1;



    public void appRun(){

        Post test1 = new Post(countPostId, "안녕하세요 반갑습니다. java 공부중이에요.", "...", inputCurrentTime());
        Post test2 = new Post(countPostId = countPostId + 1, "java 질문좀 할게요~", "...", inputCurrentTime());
        Post test3 = new Post(countPostId = countPostId + 1, "b 정처기 따야되나요?", "...", inputCurrentTime());
        postList.add(test1);
        postList.add(test2);
        postList.add(test3);
        countPostId++;


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

                Post post = new Post(countPostId, postTitle, postContent, inputCurrentTime());

                postList.add(post);
                System.out.println("게시물이 등록되었습니다.");

                countPostId++;
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
                Post post = findPostId(targetId);

                if (post == null) {
                    System.out.println("없는 게시물 번호입니다.");
                }else {
                    System.out.print("제목 : ");
                    String boardTitle = sc.nextLine();
                    System.out.print("내용 : ");
                    String boardContent = sc.nextLine();

                    post.setTitle(boardTitle);
                    post.setContent(boardContent);

                    System.out.printf("update : %d번 게시물이 수정되었습니다.\n", post.getId());
                }

            }else if (commend.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                Post post = findPostId(targetId);

                if (post == null) {
                    System.out.println("delete : 없는 게시물 번호입니다.");
                }else {
                    postList.remove(post);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n",post.getId());
                }

            } else if (commend.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                Post post = findPostId(targetId);

                if (post == null) {
                    System.out.println("detail : 없는 게시물 번호입니다.");
                }else {
                    comments(post);
                    post.setView(1);
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


    // 상세보기 - 댓글보기 기능 만들기
    void comments(Post post) {
        while (true) {
            printPostDetail(post);
            printComments();
            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
            String commentsFunc = sc.nextLine();
            if (commentsFunc.equals("1") || commentsFunc.equals("2. 댓글 등록") || commentsFunc.equals("댓글")) {
                System.out.print("댓글내용 : ");
                String commentContent = sc.nextLine();

                Comment comment = new Comment(countPostId, commentContent, inputCurrentTime());

                commentList.add(comment);
                System.out.println(" 댓글이 성공적으로 등록되었습니다.");

                countPostId++;


            } else if (commentsFunc.equals("2") || commentsFunc.equals("2. 추천") || commentsFunc.equals("추천")) {
                System.out.println("추천 기능");
            } else if (commentsFunc.equals("3") || commentsFunc.equals("3. 수정") || commentsFunc.equals("수정")) {
                System.out.println("수정 기능");
            } else if (commentsFunc.equals("4") || commentsFunc.equals("2. 삭제") || commentsFunc.equals("삭제")) {
                System.out.println("삭제 기능");
            } else if (commentsFunc.equals("5") || commentsFunc.equals("2. 목록으로") || commentsFunc.equals("목록")) {
                System.out.println("명령어 목록으로 이동합니다.");
                break;
            }
            //targetId.contains(keyword)
        }


    }

    void printComments() {
        if (commentList.isEmpty()){
            return;
        } else{
            System.out.println("======댓글======");
            for (Comment comment : commentList) {

                System.out.printf("댓글 내용 : %s\n", comment.getContent());
                System.out.printf("등록 작성일 : %s\n", comment.getCurrentTime());
                System.out.println("==============");
            }
        }

    }

    // Post 아이디 찾는 함수
    Post findPostId(int targetId) {

        for (Post post : postList) {
            if (post.getId() == targetId) {
                return post;
            }
        }

        return null;

    }
    // Post 상세 보기
    void printPostDetail(Post post) {

        System.out.println("==============");
        System.out.printf("번호 : %d\n", post.getId());
        System.out.printf("제목 : %s\n", post.getTitle());
        System.out.printf("내용 : %s\n", post.getContent());
        System.out.printf("등록일자 : %s\n", post.getCurrentTime());
        System.out.printf("조회수 : %d\n", post.getView());
        System.out.println("==============");
    }

    // 날짜 포멧팅
    String inputCurrentTime() {
        LocalDateTime now = LocalDateTime.now(); // 현재 날짜/시간
        return now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
