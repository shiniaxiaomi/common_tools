package mybatis.Demo2.DaoInterface;

import mybatis.Demo2.Model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书数据访问接口
 */
public interface BookDAO {
    public List<Book> getAllBooks() throws Exception;
    public Book getBookById(@Param("id") int id) throws Exception;
    public int add(Book entity) throws Exception;
    public int delete(int id) throws Exception;
    public int update(Book entity) throws Exception;
}