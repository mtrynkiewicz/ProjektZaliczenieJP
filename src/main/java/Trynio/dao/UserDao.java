package Trynio.dao;

public interface UserDao
{
    boolean isLoggedIn(String userName, String password);
}
