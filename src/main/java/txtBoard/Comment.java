package txtBoard;

public class Comment {
    private int id;
    private String content;
    private String currentTime;

    public Comment(int id, String content,String currentTime) {
        this.id = id;
        this.content = content;
        this.currentTime = currentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
