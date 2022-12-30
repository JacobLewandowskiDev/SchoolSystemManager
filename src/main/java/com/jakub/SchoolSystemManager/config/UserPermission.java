package com.jakub.SchoolSystemManager.config;

public enum UserPermission {
    STUDENT_READ("student:read"),       //Read list of courses and grades

    TEACHER_READ("teacher:read"),       //Read list of students with their grades
    TEACHER_WRITE("teacher:write"),     //Write a new grade
    TEACHER_UPDATE("teacher:update"),   //Update grade for student
    TEACHER_DELETE("teacher:delete"),   //Delete grade from student

    ADMIN_WRITE("admin:write"),         //Write function to add new courses, teachers and students
    ADMIN_READ("admin:read"),           //Read function to fetch data about courses, teachers and students
    ADMIN_UPDATE("admin:update"),       //Update function for courses, teachers and students
    ADMIN_DELETE("admin:delete"),       //delete function for courses, teachers and students

    //Main admin also has permissions of admin
    MAIN_ADMIN_WRITE("mainAdmin:write"),     //Write a new admin
    MAIN_ADMIN_READ("mainAdmin:read"),      //Read a list of all admins
    MAIN_ADMIN_UPDATE("mainAdmin:update"),  //Update admin info
    MAIN_ADMIN_DELETE("mainAdmin:delete");  //Delete a admin

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
