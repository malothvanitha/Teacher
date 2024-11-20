package com.edubridge.app4;

import com.edubridge.app4.model.Teacher;
import com.edubridge.app4.service.TeacherService;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        TeacherService service = new TeacherService();
        String name, email, mobile;
        name = email = mobile = null;

        do {
            System.out.println("Welcome to Teacher Management Application");
            System.out.println("==========================================");
            System.out.println("1. Add Teacher");
            System.out.println("2. View All Teachers");
            System.out.println("3. Search Teacher");
            System.out.println("4. Update Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Delete All Teachers");
            System.out.println("0. Exit");
            System.out.print("Please choose option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add New Teacher");
                    System.out.println("---------------");
                    System.out.print("Enter Teacher Name: ");
                    name = in.next();
                    System.out.print("Enter Teacher Email: ");
                    email = in.next();
                    System.out.print("Enter Teacher Mobile: ");
                    mobile = in.next();

                    Teacher teacher = new Teacher();
                    teacher.setName(name);
                    teacher.setEmail(email);
                    teacher.setMobile(mobile);

                    service.addTeacher(teacher);
                    break;

                case 2:
                    System.out.println("View All Teachers");
                    System.out.println("-----------------");
                    List<Teacher> teachers = service.getAllTeachers();
                    if (teachers.size() != 0) {
                        for (Teacher t : teachers) {
                            System.out.println(t.getId() + "\t" + t.getName() + "\t" + t.getEmail() + "\t" + t.getMobile());
                        }
                    } else {
                        System.out.println("No teachers found");
                    }
                    break;

                case 3:
                    System.out.println("Search Teacher");
                    System.out.println("--------------");
                    System.out.print("Please enter teacher id: ");
                    int id = in.nextInt();
                    Teacher t = service.getTeacherById(id);
                    if (t != null) {
                        System.out.println("Teacher Name: " + t.getName());
                        System.out.println("Teacher Email: " + t.getEmail());
                        System.out.println("Teacher Mobile: " + t.getMobile());
                    } else {
                        System.out.println("No teacher found with id: " + id);
                    }
                    break;

                case 4:
                    System.out.println("Update Teacher Details");
                    System.out.println("----------------------");
                    System.out.print("Enter Teacher Id: ");
                    int teacherId = in.nextInt();
                    System.out.print("Enter Teacher Name: ");
                    name = in.next();
                    System.out.print("Enter Teacher Email: ");
                    email = in.next();
                    System.out.print("Enter Teacher Mobile: ");
                    mobile = in.next();

                    Teacher updatedTeacher = new Teacher();
                    updatedTeacher.setId(teacherId);
                    updatedTeacher.setName(name);
                    updatedTeacher.setEmail(email);
                    updatedTeacher.setMobile(mobile);
                    service.updateTeacher(updatedTeacher);
                    break;

                case 5:
                    System.out.println("Delete Teacher");
                    System.out.println("--------------");
                    System.out.print("Please enter teacher id: ");
                    int tid = in.nextInt();
                    service.deleteTeacher(tid);
                    break;

                case 6:
                    System.out.println("Are you sure you want to delete all teachers? [Y/N]");
                    String confirm = in.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        service.deleteAllTeachers();
                    }
                    break;

                case 0:
                    System.out.println("Bye!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a correct option.");
                    break;
            }

        } while (option != 0);
    }
}
