package mybatis.Demo2.Service;

import mybatis.Demo2.DaoInterface.BookDAO;
import mybatis.Demo2.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    //类型直接写接口,在注入的实现会注入对应的实现类
    //面向接口编程,方便更换实现
    @Autowired
    BookDAO bookDao;
    
    public List<Book> getAllBooks() throws Exception {
        return bookDao.getAllBooks();
    }
    
    public Book getBookById(int id) throws Exception {
        return bookDao.getBookById(id);
    }
    
    public int add(Book entity) throws Exception {
        if(entity.getTitle()==null||entity.getTitle().equals("")){
            throw new Exception("书名必须不为空");
        }
        return bookDao.add(entity);
    }
    
    @Transactional
    public int add(Book entity1,Book entityBak) throws Exception {
        int rows=0;
        rows=bookDao.add(entity1);
        rows=bookDao.add(entityBak);
        return rows;
    }

    public int delete(int id) throws Exception {
        return bookDao.delete(id);
    }
    

    //多删除
    public int delete(String[] ids) throws Exception {
        int rows=0;
        for (String idStr : ids) {
            int id=Integer.parseInt(idStr);
            rows+=delete(id);
        }
        return rows;
    }

    public int update(Book entity) throws Exception {
        return bookDao.update(entity);
    }

}