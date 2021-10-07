package co.taejoon.dbprj;

import co.taejoon.dbprj.db.DevServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DevServiceImpl dao = new DevServiceImpl();
        dao.selectList();
 
    }
}
