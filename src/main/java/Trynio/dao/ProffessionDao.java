package Trynio.dao;

import Trynio.entity.employee;
import Trynio.entity.proffession;

import java.util.List;

public interface ProffessionDao
{
    List<proffession> getProffessions();

    void saveProffession(proffession proffession);

    proffession getSingleProffession(int proffessionId);

    proffession getProffessionByName(String proffessionName);
}
