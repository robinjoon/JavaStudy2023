package polymorphism;

public class MobileUser implements User {
    @Override
    public boolean login(String id, String pw) {
        return false;
    }

    @Override
    public void writePost() {
        System.out.println("모바일기기로 게시글 작성");
    }

    @Override
    public void deletePost() {
        System.out.println("모바일기기로 게시글 삭제");
    }

    @Override
    public void writeComment() {
        System.out.println("모바일기기로 댓글 작성");
    }

    @Override
    public void deleteComment() {
        System.out.println("모바일기기로 댓글 삭제");
    }
}
