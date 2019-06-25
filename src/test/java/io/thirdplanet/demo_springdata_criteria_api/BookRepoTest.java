package io.thirdplanet.demo_springdata_criteria_api;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.basic.BasicLookAndFeel;

import io.thirdplanet.demo_springdata_criteria_api.domain.Book;
import io.thirdplanet.demo_springdata_criteria_api.repo.BookRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepoTest {
    List<Book> bookList = new ArrayList<Book>();

    @Before
    public void setUp() {
        Book book1 = new Book();
        book1.setId(1);
        book1.setLabel("Lable-1");
        book1.setPageCount(100);

        Book book2 = new Book();
        book2.setId(2);
        book2.setLabel("Lable-2");
        book2.setPageCount(200);

        Book book3 = new Book();
        book3.setId(3);
        book3.setLabel("Lable-3");
        book3.setPageCount(300);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

    }

    @Test
    public void testBookList() {
        boolean sizeFlag = false;
        if (bookList.size() > 0)
            sizeFlag = true;
        assertTrue(sizeFlag);
    }

    @Test
    public void testBookRepo() {

        BookRepository bookRepoMock = mock(BookRepository.class);
        OngoingStubbing<Optional<Book>> foobar = when(bookRepoMock.findById(1))
                .thenReturn(Optional.of(bookList.get(0)));

        Optional<Book> barfooOpt = ((CrudRepository<Book, Integer>) foobar.getMock()).findById(1);
        Book book = barfooOpt.get() ;
        boolean bookFlag = false ;
        if(book != null )
            bookFlag = true ;
        assertTrue(bookFlag);

        boolean bookIdFlag = false;
        if(book.getId() == 1)
            bookIdFlag = true ;
        assertTrue(bookIdFlag);
     
    }


    @Mock
    BookRepository bookRepoMock2  ;

    //@InjectMocks
    //SomeBusinessImpl businessImpl ;

    @Test
    public void testGetBookId(){
        when(bookRepoMock2.findById(1))
                .thenReturn(Optional.of(bookList.get(0)));
    }



}