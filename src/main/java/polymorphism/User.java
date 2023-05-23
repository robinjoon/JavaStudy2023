package polymorphism;

public interface User {
    boolean login(String id, String pw);

    void writePost();
    void deletePost();

    void writeComment();
    void deleteComment();
}
