package main.java.manager;

import main.java.entity.Post;
import main.java.service.PostService;
import main.java.view.PostView;

import java.util.List;

public class PostApp {
    public void run() {
         final PostService service = new PostService();
         final PostView view = new PostView();

        while(true){
            int menu = view.showMenu();

            switch (menu){
                case 1:
                    String title = view.input("제목");
                    String content = view.input("내용");
                    String author = view.input("작성자");
                    boolean success = service.writePost(title, content, author);
                    System.out.println(success ? "게시글 등록이 완료되었습니다." : "유효성 검사를 통과하지 못 했습니다.");
                    break;
                case 2:
                    List<Post> posts = service.getAllPosts();
                    view.showPostList(posts);
                    break;
                case 3:
                    int id = Integer.parseInt(view.input("게시글 ID"));
                    Post post = service.getPostDetail(id);
                    view.showPostDetail(post);
                    break;
                case 4:
                    int updatedId = Integer.parseInt(view.input("게시글 ID"));
                    String newTitle = view.input("새 제목");
                    String newContent = view.input("새 내용");
                    boolean updated = service.updatePost(updatedId, newTitle, newContent);
                    System.out.println(updated ? "수정 완료" : "유효성 실패 또는 게시글 없음");
                    break;
                case 5:
                    int deletedId = Integer.parseInt(view.input("게시글 ID"));
                    service.deletePost(deletedId);
                    System.out.println("삭제 완료");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }



}
