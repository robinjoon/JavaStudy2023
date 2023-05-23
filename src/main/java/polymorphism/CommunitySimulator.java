package polymorphism;

public class CommunitySimulator {
    public static void main(String[] args) {
        User robin = new PCUser();
        robin.writePost();
        robin.writeComment();
        robin.deleteComment();
        robin.deletePost();
    }
}
