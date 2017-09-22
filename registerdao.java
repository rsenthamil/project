package com.Project.dao;
import org.springframework.stereotype.Repository;
import com.Project.model.register;
@Repository
public interface registerdao
{
public void adduser(register r);
public void getinfo();
public void edituser(int i);
public void deluser(int i);
public void showuser();
}