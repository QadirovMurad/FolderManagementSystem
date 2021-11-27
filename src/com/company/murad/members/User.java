package com.company.murad.members;

import com.company.murad.main.FileUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static com.company.murad.main.FileUtility.writeUsersInfoIntoFile;

public class User {
    private int ID;
    private String name;
    private String surName;
    private String email;
    private byte age;
    private String userName;
    private String password;
    private boolean approval = false;
    public static Scanner sc = new Scanner(System.in);

    private static String[] enterUsersUserNameAndPassword() {
        Scanner sc = new Scanner(System.in);
        String[] nameAndPassword = new String[2];
        System.out.println("Enter user name :");
        String userName = sc.next();
        sc.nextLine();
        System.out.println("Enter password :");
        String password = sc.next();
        nameAndPassword[0] = userName;
        nameAndPassword[1] = password;
        return nameAndPassword;
    }

    public static boolean checkUsersUserNameAndPassword() throws Exception {
        String[] arr = enterUsersUserNameAndPassword();
        List<User> users = FileUtility.readUserLogins();
        boolean a = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equalsIgnoreCase(arr[0]) && users.get(i).getPassword().equals(arr[1]) && users.get(i).isApproval() == true)
                a = true;

        }
        return a;
    }

    public void login() throws IOException {
        boolean checkUserNamePassword = false;
        boolean checkApproval = false;
        List<User> users = FileUtility.readUserLogins();
        String[] arr = enterUsersUserNameAndPassword();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName() == arr[0] && users.get(i).getPassword() == arr[1] && users.get(i).isApproval() == true) {
                checkApproval = true;
            }

        }
        if (!checkApproval) {
            System.out.println("Incorrect data");
        }

    }

    public static void enterPathAndDoSomething() {
        System.out.println("Enter path : ");
        String path = sc.nextLine();
        File f = new File(path);
        if (f.exists()) {
            String[] files = f.list();
            for (String s : files) {
                System.out.println(s);
            }
        } else {
            System.out.println("That directory does not exist !!!");
            return;
        }
        System.out.println("what would you like to do ? 1.delete 2.rename");
        System.out.print("Choice : ");
        int ch = sc.nextInt();
        if (ch == 1) {
            deleteFile(f, path);
        } else if (ch == 2) {
            renameFile(f, path);

        }
    }

    public static void deleteFile(File f, String path) {
        System.out.println("Enter the name of file you would like to delete");
        String deletedfile = sc.next();
        f = new File(path + File.separator + deletedfile);
        f.delete();
    }

    public static void renameFile(File f, String path) {
        System.out.println("Enter the name of file you would like to rename");
        String renamedfile = sc.next();
        System.out.println("Enter new name :");
        String newName = sc.next();
        f = new File(path + File.separator + renamedfile);
        f.renameTo(new File(path + File.separator + newName));
    }
    public static void renameFile2(String src, String trgt) throws IOException {
        Path source = Paths.get(src);
        Path target = Paths.get(trgt);
        Files.move(source,target);
    }


    public void register() throws IOException {
        Scanner sc = new Scanner(System.in);
        User us = new User();
        int numOfUsers;
        System.out.println("How many new Users will register ? ");
        System.out.print("Number : ");
        numOfUsers = sc.nextInt();
        for (int i = 0; i < numOfUsers; i++) {
            System.out.println((i + 1) + "'s User");
            System.out.println("Enter ID : ");
            int id = sc.nextInt();
            System.out.println("Enter name :");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Enter surname :");
            String surName = sc.next();
            System.out.println("Enter email :");
            String email = sc.next();
            System.out.println("Enter age :");
            byte age = sc.nextByte();
            sc.nextLine();
            System.out.println("Enter new username :");
            String userName = sc.next();
            System.out.println("Enter new password :");
            String password = sc.next();
            us.setID(id);
            us.setName(name);
            us.setSurName(surName);
            us.setAge(age);
            us.setEmail(email);
            us.setUserName(userName);
            us.setPassword(password);
            FileUtility.writeUsersInfoIntoFile(us, true);
            FileUtility.writeUsersLoginsIntoFile(us, true);
            System.out.println("Wait till the Admin approve your request !");
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordl) {
        this.password = passwordl;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
