package txtBoard2.txtBoard;

public class Post {
    private int id;
    private String title;
    private String content;
    private String currentTime; // 현재 시간 타임
    private int view = 1; // 조회수

    public Post(int id, String title, String content, String currentTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.currentTime = currentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = this.view + view;
    }
}
