package com.example.teacherInfo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAO {
    @Autowired
    SqlSession sqlSession;

    public int insertInfo(TeacherVO vo) {
        int result = sqlSession.insert("TeacherInfo.insertInfo", vo);
        return result;
    }

    public TeacherVO getInfo(int seq){
        TeacherVO one = sqlSession.selectOne("TeacherInfo.getInfo",seq);
        return one;
    }

    public List<TeacherVO> getInfoList(){
        List<TeacherVO> list = sqlSession.selectList("TeacherInfo.getInfoList");
        return list;
    }

    public int updateInfo(TeacherVO vo) {
        int result = sqlSession.update("TeacherInfo.updateInfo", vo);
        return result;
    }

    public int deleteInfo(int seq) {
        int result = sqlSession.delete("TeacherInfo.deleteInfo", seq);
        return result;
    }



}
