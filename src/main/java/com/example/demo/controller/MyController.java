package com.example.demo.controller;

import com.example.demo.VO.*;
import com.example.demo.service.MyService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "clientA/api")
public class MyController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyService myService;

    @PostMapping("/common/validate")
    public ResponseVO validate(@RequestBody LoginVO loginVO) throws SQLException {
        return myService.validate(loginVO);
    }

    @GetMapping("/adm/getAdmInfo/{account}")
    public ResponseVO getAdmInfo(@PathVariable String account) throws SQLException {
        return myService.getAdmInfo(account);
    }

    @GetMapping("/adm/getStuInfoForAdm")
    public ResponseVO getStuInfoForAdm() throws SQLException {
        return myService.getStuInfoForAdm();
    }

    @GetMapping("/adm/getLessonInfoForAdm")
    public ResponseVO getLessonInfoForAdm() throws SQLException {
        return myService.getLessonInfoForAdm();
    }

    @PostMapping("/adm/changeAdmPassword")
    public ResponseVO changeAdmPassword(@RequestBody AdminVO adminVO) throws SQLException {
        return myService.changeAdmPassword(adminVO);
    }

    @PostMapping("/adm/updateAdmLesson")
    public ResponseVO changeAdmLesson(@RequestBody CourseVO courseVO) throws SQLException {
        if(courseVO.getIsShared()!=null){
            if(courseVO.getIsShared().equals("是")){
                courseVO.setIsShared("1");
            }
            if(courseVO.getIsShared().equals("否")){
                courseVO.setIsShared("0");
            }
        }
        return myService.changeAdmLesson(courseVO);
    }

    @PostMapping("/adm/deleteAdmLesson/{lessonId}")
    public ResponseVO deleteLesson(@PathVariable String lessonId)throws SQLException{
        return myService.deleteLesson(lessonId);
    }

    @GetMapping("/stu/getStuInfo/{account}")
    public ResponseVO getStuInfo(@PathVariable String account) throws SQLException {
        return myService.getStuInfo(account);
    }

    @GetMapping("/stu/getLessonInfo")
    public ResponseVO getLessonInfo() throws SQLException, DocumentException {
        return myService.getLessonInfo();
    }

    @PostMapping("/stu/changePassword")
    public ResponseVO changePassword(@RequestBody LoginVO loginVO) throws SQLException {
        return myService.changePassword(loginVO);
    }

    @PostMapping("/stu/chooseLesson")
    public ResponseVO chooseLesson(@RequestBody ChooseVO chooseVO) throws SQLException {
        return myService.chooseLesson(chooseVO);
    }

    @GetMapping("stu/getChoosedLesson/{stuId}")
    public ResponseVO getChoosedLesson(@PathVariable String stuId) throws SQLException, DocumentException {
        return myService.getChoosedLesson(stuId);
    }

    @PostMapping("/stu/dropLesson")
    public ResponseVO dropLesson(@RequestBody ChooseVO chooseVO) throws SQLException, DocumentException {
        return myService.dropLesson(chooseVO);
    }

    @PostMapping("/stu/dropLesson_clientA")
    public ResponseVO dropLesson_clientA(@RequestBody String xml) throws SQLException, DocumentException {
        return myService.dropLesson_clientA(xml);
    }

    @GetMapping("stu/getChoosedLesson_clientA/{stuId}")
    public ResponseVO getChoosedLesson_clientA(@PathVariable String stuId) throws SQLException {
        return myService.getChoosedLesson_clientA(stuId);
    }

    @PostMapping("/stu/chooseLesson_clientA")
    public ResponseVO chooseLesson_clientA(@RequestBody String xml) throws SQLException, DocumentException {
        return myService.chooseLesson_clientA(xml);
    }

    @GetMapping("getShareLesson_clientA")
    public ResponseVO getShareLesson_clientA() throws SQLException, DocumentException {
        return myService.getShareLesson_clientA();
    }


}
