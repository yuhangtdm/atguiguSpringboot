package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("emps")
    public String list(Map<String,Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("emps",all);
        return "emp/list";
    }

    @GetMapping("emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @GetMapping("emp/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id, Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        if(id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("emp",employee);
        }
        return "emp/add";
    }

    @PostMapping("emp")
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PutMapping("emp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
