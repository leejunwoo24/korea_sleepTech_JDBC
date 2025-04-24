package main.java;

/*
* 1. 회원 CRUD 프로젝트 MemberManager
* - dao: MemberDao
* - db: DBConnection
* - entity: Member
* - manager: MemberManager
*
*
* 2. 게시판 CRUD 프로젝트 (+ MVC 패턴)
* - dao: PostDao
* - db: DBConnection
* - entity: Post
* - service (비즈니스 로직 처리): PostService
* - view: PostView
* - manager: PostApp
* */

import main.java.manager.PostApp;

public class Main {
    public static void main(String[] args) {
//        MemberManager mm = new MemberManager();
//
//        try {
//            mm.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        PostApp pm = new PostApp();
        try{
            pm.run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

