package main.java.dao;

import main.java.db.DBConnection;
import main.java.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    public void save(Post post){
        String sql = "INSERT INTO post (title, content, author, created_at) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getAuthor());
            // LocalDateTime 타입인 post.getCreatedAt()을
            // >> JDBC에서 사용가능한 java.sql.Timestamp 타입으로 변환해주는 코드
            pstmt.setTimestamp(4, Timestamp.valueOf(post.getCreateAt()));

            pstmt.executeUpdate();
        } catch(SQLException e){
            // sout: 기본 출력
            // serr: 오류 형식 출력
            System.err.println("[Error] 게시글 저장 실패: " + e.getMessage());
        }
    }

    public List<Post> findAll(){
        // post 데이터 전체조회: id를 기주능로 정렬 (내림차순)
        String sql = "SELECT * FROM post ORDER BY id DESC";
        List<Post> postList = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                Post post = new Post(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("author"),
                        // toLocalDateTime()
                        // : 날짜 가공 메서드, DB의  Timestamp을 LocalDateTime로 변환
                        rs.getTimestamp("created_at").toLocalDateTime()
                );
                postList.add(post);
            }

        }catch (SQLException e){
            System.err.println("[Error]");
        }
        return postList;
    }

    public Post findById(int id) {
        // post 데이터 단건조회: 조건에  파라미터의 동적 파라미터에 따라 조회
       String sql = "SELECT * FROM post WHERE id = ?";

       try (Connection conn = DBConnection.getConnection();
       PreparedStatement pstmt = conn.prepareStatement(sql)
       ){
           pstmt.setInt(1, id);
           ResultSet rs = pstmt.executeQuery();

           if (rs.next()) {
               return new Post(
                       rs.getInt("id"),
                       rs.getString("title"),
                       rs.getString("content"),
                       rs.getString("author"),
                       rs.getTimestamp("created_at").toLocalDateTime()
               );
           }
       } catch(SQLException e){
           System.err.println("[Error] 게시글 상세 조회 실패: " + e.getMessage());
       }
       return null;
    }

    public void update(Post post){
        // post 데이터 수정: 조건에 id의 동적 파라미터에 따라 title과 content를 수정
        String sql = "UPDATE post SET title = ? , content = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getId());
            pstmt.executeUpdate();
        } catch(SQLException e){
            System.err.println("[Error] 게시글 수정 실패: " + e.getMessage());
        }

    }

    public void delete(int id){
        // post 데이터 삭제: 조건에 id의 동적 파라미터에 따라 삭제
        String sql = "DELETE FROM post WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[Error] 게시글 삭제 실패: " + e.getMessage());
        }
    }
}
