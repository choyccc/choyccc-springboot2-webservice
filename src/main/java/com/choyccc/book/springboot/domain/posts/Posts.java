package com.choyccc.book.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

/*
* (1) @Entity
*   테이블과 링크될 클래스임을 나타냄
*   기본값으로 크래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
*   ex) SalesManager.java -> sales_manager table
* (2) @Id
*   해당 테이블의 PK필드를 나타냄
* (3) @GeneratedValue
*   PK의 생성 규칙을 나타냄
*   스프링 부트 2.0에서는 GenerationType.Identity 옵션을 추가해야만 auto_increment가 됨
*   스프링 부트 2.0버전과 1.5버전의 차이는 jojoldu.tistory.com/295에 정리했음
* (4) @Column
*   테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
*   사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
*   문자열의 경우 VARCHAR(255)가 기본값인데 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용
*
*
* */
