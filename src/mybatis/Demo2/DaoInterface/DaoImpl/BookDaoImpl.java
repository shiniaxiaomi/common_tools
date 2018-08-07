package mybatis.Demo2.DaoInterface.DaoImpl;

import mybatis.Demo2.DaoInterface.BookDAO;
import mybatis.Demo2.Model.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Yingjie.Lu on 2018/8/7.
 */

@Component
public class BookDaoImpl implements BookDAO {
    @Autowired  //自动注入sqlSessionFactoryBean,可以直接获取到sqlSession
    SqlSessionFactoryBean sqlSessionFactoryBean;

    //查询所有图书
    @Override
    public List<Book> getAllBooks() throws Exception {
        SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();//获取SqlSession
        List<Book> list = sqlSession.selectList("BookDAO.getAllBooks");
        sqlSession.close();
        return list;
    }

    //通过id查询图书
    @Override
    public Book getBookById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();//获取SqlSession
        Book book = sqlSession.selectOne("BookDAO.getBookById",id);
        sqlSession.close();
        return book;
    }

    //添加图书
    @Override
    public int add(Book entity) throws Exception {
        SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();//获取SqlSession
        int result = sqlSession.insert("BookDAO.add",entity);
        sqlSession.close();
        return result;
    }

    //删除图书
    @Override
    public int delete(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();//获取SqlSession
        int result = sqlSession.delete("BookDAO.delete",id);
        sqlSession.close();
        return result;
    }

    //更新图书
    @Override
    public int update(Book entity) throws Exception {
        SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();//获取SqlSession
        int result = sqlSession.update("BookDAO.update",entity);
        sqlSession.close();
        return result;
    }
}
