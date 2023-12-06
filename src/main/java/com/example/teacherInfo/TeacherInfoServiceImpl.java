package com.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {
    @Autowired
    TeacherDAO teacherDAO;

    @Override
    public int insertInfo(TeacherVO vo) {
        return teacherDAO.insertInfo(vo);
    }

    @Override
    public int deleteInfo(int seq) {
        return teacherDAO.deleteInfo(seq);
    }

    @Override
    public int updateInfo(TeacherVO vo) {
        return teacherDAO.updateInfo(vo);
    }

    @Override
    public TeacherVO getInfo(int seq) {
        return teacherDAO.getInfo(seq);
    }

    @Override
    public List<TeacherVO> getInfoList() {
        return teacherDAO.getInfoList();
    }
}
