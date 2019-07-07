package Trynio.service;

import Trynio.entity.proffession;

import java.util.List;

public interface ProffessionService
{
    List<proffession> getProffessions();

    public void saveProfession(proffession proffession);

    proffession getProffession(int proffessionId);

    proffession getProffessionByName(String proffessionName);


}
