package mybatis.Demo1.Dao;

import java.util.List;

import mybatis.Demo1.Model.Book;
import org.apache.ibatis.annotations.Param;

/**
 * 图书数据访问接口
 */
public interface BookDAO {
    public List<Book> getAllBooks();
    public Book getBookById(@Param("id") int id);
    public int add(Book entity);
    public int delete(int id);
    public int update(Book entity);
}