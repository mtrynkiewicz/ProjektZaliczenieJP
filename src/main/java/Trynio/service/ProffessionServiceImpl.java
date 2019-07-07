package Trynio.service;


import Trynio.dao.ProffessionDao;
import Trynio.entity.proffession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProffessionServiceImpl implements ProffessionService
{
    @Autowired
    private ProffessionDao proffessionDao;

    @Override
    @Transactional
    public List<proffession> getProffessions() {

        List<proffession> list = proffessionDao.getProffessions();
        return list;
    }

    @Override
    @Transactional
    public void saveProfession(proffession proffession) {
        proffessionDao.saveProffession(proffession);
    }

    @Override
    public proffession getProffession(int proffessionId) {
        return proffessionDao.getSingleProffession(proffessionId) ;
    }

    @Override
    public proffession getProffessionByName(String proffessionName) {
        return proffessionDao.getProffessionByName(proffessionName);
    }
}
