package encapsulation;

/**
 * 게시글을 쓰고 삭제하는 책임, 댓글을 쓰고 삭제하는 책임, 로그인하는 책임
 */
public class User {
    private String id;
    private String pw;
    private int permission;
    public boolean login(String id, String pw){
        return false;
    }
    public void writePost(){
        if(checkPermission()){

        }
    }
    private boolean checkPermission(){
        return true;
    }
    public void deletePost(){

    }

    public void writeComment(){

    }
    public void deleteComment(){

    }
}
