```java
//mybatis的入门案例
//使用 MyBatis 的主要 Java 接口就是 SqlSession。你可以通过这个接口来执行命令，获取映射器和管理事务。

/*SqlSessions 是由 SqlSessionFactory 实例创建的。SqlSessionFactory 对象包含创建 SqlSession 实例的所有方法。而 SqlSessionFactory 本身是由 SqlSessionFactoryBuilder 创建的，它可以从 XML、注解或手动配置 Java 代码来创建 SqlSessionFactory。*/

public class MybatisTest {
    public static void main(String args[]) throws IOException {
        //1.读取配置文件，大小写不敏感。
        //该文件应当位于src/main/resouces目录下。
        InputStream in= Resources.getResourceAsStream("sqlConfigMap.xml");

        //2.创建SqlSessionFactory工厂
        //SqlSessionFactoryBuilder--->SqlSessionFactory-->SqlSession
        //然后SqlSession获取映射器,那么SqlSession其实相当于
        //SqlSessionFactoryBuilder 有五个 build() 方法，
        //每一种都允许你从不同的资源中创建一个 SqlSession 实例。
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        //3.使用工厂生成SqlSession对象
        SqlSession session=factory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        /*Mapper动态代理方法：程序员只需要写dao接口(Mapper)，而不需要写dao实现类，
        由mybatis根据dao接口和映射文件中statement的定义生成接口实现代理对象。可以调用代理对象方法。
        */
        IUserDao userDao=session.getMapper(IUserDao.class);

        //5.使用代理对象执行方法
        List <user> users=userDao.findAll();
        for(user user0: users){
            System.out.println(user0);
        }

        //6.释放资源
        session.close();;
        in.close();
    }
}
```

dao=data access object即数据访问层

注意在mybatis中执行完sql语句是要commit的，不然更新无效。通过commit和rollback实现事务的提交和回滚。









为了可以让建立连接和释放资源的过程复用，改为:

```java
 @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象，添加true之后相当于自动提交
        //就可以不用sqlSession.commit了
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }


    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

	@Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts){
            System.out.println("--------每个account的信息------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
```



