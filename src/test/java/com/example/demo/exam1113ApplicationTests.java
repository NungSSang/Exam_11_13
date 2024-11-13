package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.VO.bookStoreVO;
import com.example.demo.VO.bookVO;
import com.example.demo.repository.bookRepository;
import com.example.demo.repository.bookStoreRepository;

@SpringBootTest
class exam1113ApplicationTests {
		@Autowired
		bookStoreRepository bookStore;
		@Autowired
		bookRepository book;
	@Test

	void t1() {
		bookStore.truncateTable();
		book.truncateTable();
	}

	// 서점 두개를 만들어주세요.

	// 서점은 각각 이름과 보유서적으로 구성됩니다.

	// 각각 코리아서점, 아이티문고

	@Test

	void t2() {
		bookStore.insertStore("코리아서점");
		bookStore.insertStore("아이티문고");

	}

	 

	// 모든 서점 정보 조회

	// 출력 : 코리아서점, 아이티문고

	@Test

	void t3() {
		List<bookStoreVO> bookStoreName = bookStore.selectStore();
		System.out.println("===서점 정보 출력===");
		for(int i = 0; i < bookStoreName.size(); i++) {
			bookStoreVO bookStore = bookStoreName.get(i);
			System.out.println(bookStore.getName());
		}
	}

	 

	 

	// 아이티문고의 이름을 IT문고로 변경해주세요.

	// 변경 후엔 t3() 메서드를 실행해 확인해주세요.

	// 출력 : 코리아서점, IT문고

	@Test

	void t4() {
		bookStore.modifyName(2,"IT문고");
		t3();
	}


	// 책 5권을 만들어주세요.

	// 책은 제목과 저자, 보유 서점으로 구성됩니다.

	// 책은 각각

	// 어린왕자, 생떽쥐페리, 코리아서점

	// 해리포터, 조앤 롤링, 코리아서점

	// 죄와벌, 도스토예프스키, 코리아서점

	// 점프 투 스프링부트, 박응용, 아이티문고

	// 수학의 정석, 홍성대, 아이티문고

	// 로 만들어주세요.

	@Test

	void t5() {
		book.insertBook("어린왕자","생떽쥐페리",1);
		book.insertBook("해리포터","조앤 롤링",1);
		book.insertBook("죄와벌","도스토예프스키",1);
		book.insertBook("점프 투 스프링부트","박응용",2);
		book.insertBook("수학의 정석","홍성대",2);
	}

	 

	// 모든 책의 제목을 출력해주세요.

	@Test

	void t6() {
		
		 List<bookVO> booksName = book.selectBookName();
		 System.out.println("===모든 책의 제목===");
		 for(int i = 0; i < booksName.size(); i++) {
			 bookVO books = booksName.get(i);
			 System.out.println(books.getTitle());
		 }
	}

	 

	// 코리아서점에서 판매하는 책의 제목을 출력해주세요.

	@Test

	void t7() {

		List<bookVO> bookInKorea = book.sellKoreaStore();
		System.out.println("===코리아 서점에서 판매하는 책의 제목===");
		for(int i = 0; i < bookInKorea.size(); i++) {
			bookVO booksInKorea = bookInKorea.get(i);
			System.out.println(booksInKorea.getTitle());
		}

	}

	 

	// 박응용이 쓴 책을 삭제해주세요.

	// 삭제 후 t6 메서드를 이용해 확인해주세요.

	@Test

	void t8() {

		book.deleteBook("박응용");
	}

	 

}
