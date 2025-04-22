package main.java.jdbc;

// === SQL 실행 및 결과 처리 === //
// Statement VS PreparedStatement vs ResultSet

// === SQL 실행 흐름 === //
// 1. Connection 객체 생성
// 2. SQL문 준비 (SELECT, INSERT 등)
// 3. Statement, PreparedStatement 객체 생성 - SQL 실행 객체 생성
// 4. SQL 실행 (executeQuery, executeUpdate)
// 5. 결과 처리 (ResultSet 또는 영햘 줄 확인)

// === Satement VS PreparedStatement === //
// 1) SQL 작성 방식
// Statement: SQL을 직접 문자열로 작성
// PreparedStatement: +? 를 사용해 파라미터 처리

// 2) 보안
// statement: SQL Injection 위험 있음
// PreparedStatement: SQL Injection 방지

// 3) 성능
// Statement: 매번 컴파일
// PreparedStatement: 사전 컴파일 >> 더 빠름
public class Jdbc03 {
}
