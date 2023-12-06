package com.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/teacherInfo")
public class TeacherInfoController {
    @Autowired
    TeacherInfoService teacherInfoService;

    @RequestMapping("/list")
    public String teacherList(Model model) {
        model.addAttribute("list", teacherInfoService.getInfoList());
        return "teacherlist";
    }

    @RequestMapping("/add")
    public String addTeacher() {
        return "addteacherform";
    }

    @RequestMapping("/addok")
    public String addTeacherOK(TeacherVO vo) {
        if (teacherInfoService.insertInfo(vo) == 0)
            System.out.println("데이터 추가 실패!");
        else
            System.out.println("데이터 추가 성공!!");

        return "redirect:list";
    }

    @RequestMapping("/editform/{seq}")
    public String editTeacher(@PathVariable("seq") int seq, Model model) {
        TeacherVO teacherVO = teacherInfoService.getInfo(seq);
        model.addAttribute("teacher", teacherVO);
        return "editteacherform";
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editTeacherOK(TeacherVO vo) {
        int i = teacherInfoService.updateInfo(vo);
        if (i == 0)
            System.out.println("데이터 수정 실패!");
        else
            System.out.println("데이터 수정 성공!!");
        return "redirect:list";
    }

    @RequestMapping("/deleteok/{seq}")
    public String deleteTeacherOK(@PathVariable("seq") int seq) {
        if (teacherInfoService.deleteInfo(seq) == 0)
            System.out.println("데이터 삭제 실패!");
        else
            System.out.println("데이터 삭제 성공!!");
        return "redirect:../list";
    }

    @RequestMapping("/view/{seq}")
    public String viewTeacher(@PathVariable("seq") int seq, Model model) {
        TeacherVO teacherVO = teacherInfoService.getInfo(seq);
        model.addAttribute("teacherVO", teacherVO);
        return "viewteacher";
    }
}
