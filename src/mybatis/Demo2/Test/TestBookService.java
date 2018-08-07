package mybatis.Demo2.Test;

import mybatis.Demo2.Model.Book;
import mybatis.Demo2.Service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * @Title: 通过动态代理生成dao的实现类,避免冗余发开,提倡
 * @Date: 2018/8/7 19:13
 */
public class TestBookService {

    //在外边定义,这样可以在下面的方法中使用
    public BookService bookservice;

    @Before
    public void before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("mybatis/Demo2/applicationContext.xml");
        bookservice= (BookService) ctx.getBean("bookService");
    }
    
    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books=bookservice.getAllBooks();
        assertNotNull(books);
    }

    @Test
    public void testAdd() throws Exception {
        Book entity=new Book(0, "Hibernate 第七版", 78.1, new Date());
        assertEquals(1, bookservice.add(entity));
    }

    @Test
    public void testDeleteInt() throws Exception {
        assertEquals(1, bookservice.delete(3));
    }

    @Test
    public void testDeleteStringArray() throws Exception {
        String[] ids={"7","11","12"};
        assertEquals(3, bookservice.delete(ids));
    }

    @Test
    public void testUpdate() throws Exception {
        Book entity=new Book(7, "Hibernate 第二版", 79.1, new Date());
        assertEquals(1, bookservice.update(entity));
    }
    
    @Test
    public void testGetBookById() throws Exception {
        assertNotNull(bookservice.getBookById(1));
    }
    
    @Test
    public void testAddDouble() throws Exception {
        //因为书名相同，添加第二本会失败，用于测试事务
        Book entity1=new Book(0, "Hibernate 8", 78.1, new Date());
        Book entity2=new Book(0, "Hibernate 8", 78.1, new Date());
        assertEquals(2, bookservice.add(entity1, entity2));
    }
}