package com.example.teacherInfo;

import java.util.List;

public interface TeacherInfoService {
    public int insertInfo(TeacherVO vo);
    public int deleteInfo(int seq);
    public int updateInfo(TeacherVO vo);
    public TeacherVO getInfo(int seq);
    public List<TeacherVO> getInfoList();
}
