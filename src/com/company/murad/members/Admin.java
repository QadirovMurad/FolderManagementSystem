package com.company.murad.members;

import com.company.murad.main.FileUtility;
import com.company.murad.main.Method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private int ID;
    private String adminUserName;
    private String adminPassword;

    public static Scanner sc = new Scanner(System.in);

    public static void seeAllUsers() throws IOException {
        List<User> userListInfo = FileUtility.readUserInfo();
        List<User> userListLogins = FileUtility.readUserLogins();
        for (int i = 0; i < userListInfo.size(); i++) {
            System.out.println("Name : " + userListInfo.get(i).getName());
            System.out.println("SurName : " + userListInfo.get(i).getSurName());
            System.out.println("Age : " + userListInfo.get(i).getAge());
            System.out.println("Email : " + userListInfo.get(i).getEmail());
            System.out.println("Approval : " + userListLogins.get(i).isApproval());
        }
    }

    public static void seeUnConfirmedUsers() throws IOException {
        List<User> userListInfo = FileUtility.readUserInfo();
        List<User> userListLogins = FileUtility.readUserLogins();
        for (int i = 0; i < userListInfo.size(); i++) {
            if (userListLogins.get(i).isApproval() == false) {
                System.out.println("Name : " + userListInfo.get(i).getName());
                System.out.println("SurName : " + userListInfo.get(i).getSurName());
                System.out.println("Age : " + userListInfo.get(i).getAge());
                System.out.println("Email : " + userListInfo.get(i).getEmail());
                System.out.println("Approval : " + userListLogins.get(i).isApproval());
            }
        }

    }

    public static void confirmUser() throws IOException {
        List<User> userListInfo = FileUtility.readUserInfo();
        List<User> userListLogins = FileUtility.readUserLogins();
        List<User> approvedUserList = new ArrayList<>();
        int choice;
        for (int i = 0; i < userListLogins.size(); i++) {
            if(userListLogins.get(i).isApproval()==false) {
                System.out.println("----------------------");
                System.out.println(userListInfo.get(i).getName() + " " + userListInfo.get(i).getSurName());
                System.out.println("1.Approve 2.Not Approve");
                System.out.println("choice : ");
                choice = sc.nextInt();
                userListInfo.get(i).setUserName(userListLogins.get(i).getUserName());
                userListInfo.get(i).setPassword(userListLogins.get(i).getPassword());
                if (choice == 1) {
                    User us = userListInfo.get(i);
                    us.setApproval(true);
                    approvedUserList.add(us);
                } else {
                    approvedUserList.add(userListInfo.get(i));
                }
            }
        }
        for (int j = 0; j < approvedUserList.size(); j++) {
            if (j == 0) {
                FileUtility.writeUsersLoginsIntoFile(approvedUserList.get(j), false);
                FileUtility.writeUsersInfoIntoFile(approvedUserList.get(j), false);
            } else {
                FileUtility.writeUsersLoginsIntoFile(approvedUserList.get(j), true);
                FileUtility.writeUsersInfoIntoFile(approvedUserList.get(j), true);
            }
        }

        seeAllUsers();


    }

    private static String[] enterAdminUserNameAndPassword() {

        String[] nameAndPassword = new String[2];
        System.out.println("Enter admin user name :");
        String userName = sc.next();
        sc.nextLine();
        System.out.println("Enter admin password :");
        String password = sc.next();
        nameAndPassword[0] = userName;
        nameAndPassword[1] = password;
        return nameAndPassword;
    }

    public static boolean checkAdminUserNameAndPassword() throws Exception {
        String arr[] = enterAdminUserNameAndPassword();
        List<Admin> p = FileUtility.readAdminLogins();
        boolean a = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getAdminUserName().equalsIgnoreCase(arr[0]) && p.get(i).getAdminPassword().equals(arr[1]))
                a = true;

        }

        return a;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}
