package main.java.jdbc;


/*
*   ===== JDBC 환경설정 =====
*
*  1. 필요한 준비물
*   1) JDK(JAVA - JDK17)
*   2) IDE(IntelliJ, Eclipse 등)
*   3) MySQL(MySQL Server 8.x 이상 권장)
*   4) JDBC 드라이버
*         : mysql-connector-java=x.x.xx.jar
* */

// ===JDBC 자주 발생하는 오류 $ 해결법 === //
//  1. ClassNotFoundException
// : 외부 라이브러리(sql connection)가 프로젝트에 추가되지 않음

// 2. Access denied for user
// : DB 사용자 ID/PW 오타 또는 권한 없음

// 3. Communications link failure
// : MySQL 서버가 실행 중인지 확인 (포트번호 확인 3306)

// 4. Unknown database
// : DB 이름 오타 또는 데이터 베이스 미생성

// === JDBC 연결 흐름 === //
/*
 *   1. JDBC 드라이법 로딩
 *   2. DB 접속 정보 설정 (URL, 사용자명, 비밀번호)
 *   3. DriverManager를 통해 DB 연결을 시도
 *   4. Connection 객체를 통해 DB 작업 수행
 *   5. 연결 종료
 * */
public class Jdbc02 {
}
