package com.company.murad.main;

import com.company.murad.members.Admin;
import com.company.murad.members.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {


    private static final String FILE_PATH = "C:\\Users\\hp\\Desktop/File_Management_System";
    private static File f = new File(FILE_PATH);

    private static final String PATH_TO_USER_INFO = FILE_PATH + File.separator + "user_info.txt";
    private static final String PATH_TO_USERS_LOGINS = FILE_PATH + File.separator + "users_logins.txt";
    private static final String PATH_TO_ADMIN_LOGINS = FILE_PATH + File.separator + "admin_logins.txt";

    public static void writeUsersInfoIntoFile(User us, boolean a) throws IOException {
        if (!f.exists()) {
            f.mkdir();
        }
        FileWriter fw = new FileWriter(PATH_TO_USER_INFO, a);
        try (BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(us.getID() +"--"+ us.getName() + "--" + us.getSurName() + "--" + us.getAge() + "--" + us.getEmail());
            bw.newLine();
        }
        System.out.println("Successfully Done !");

    }

    public static void writeUsersLoginsIntoFile(User us, boolean a) throws IOException {
        if (!f.exists()) {
            f.mkdir();
        }
        FileWriter fw = new FileWriter(PATH_TO_USERS_LOGINS, a);
        try (BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(us.getID() +"&&"+ us.getUserName() + "&&" + us.getPassword() + "&&" + us.isApproval());
            bw.newLine();
        }
        System.out.println("Successfully Done !");

    }
    public static void writeAdminLoginsIntoFile(Admin ad, boolean a) throws IOException {
        if (!f.exists()) {
            f.mkdir();
        }
        FileWriter fw = new FileWriter(PATH_TO_ADMIN_LOGINS, a);
        try (BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(ad.getID() + ad.getAdminUserName() + "&&" + ad.getAdminPassword());
            bw.newLine();
        }
        System.out.println("Successfully Done !");

    }


    public static List<User> readUserInfo() throws IOException {
        try (FileReader fr = new FileReader(PATH_TO_USER_INFO);
             BufferedReader reader = new BufferedReader(fr);) {
            List<User> listOfUsers = new ArrayList<>();

            while (reader.ready()) {

                User us = new User();
                String[] arr = reader.readLine().split("--");
                us.setID(Integer.parseInt(arr[0]));
                us.setName(arr[1]);
                us.setSurName(arr[2]);
                us.setAge(Byte.parseByte(arr[3]));
                us.setEmail(arr[4]);
                listOfUsers.add(us);


            }
            return listOfUsers;

        }


    }

    public static List<User> readUserLogins() throws IOException {
        try (FileReader fr = new FileReader(PATH_TO_USERS_LOGINS);
             BufferedReader reader = new BufferedReader(fr);) {
            List<User> listOfLogins = new ArrayList<>();

            while (reader.ready()) {

                User us = new User();
                String[] arr = reader.readLine().split("&&");
                us.setID(Integer.parseInt(arr[0]));
                us.setUserName(arr[1]);
                us.setPassword(arr[2]);
                us.setApproval(Boolean.parseBoolean(arr[3]));
                listOfLogins.add(us);


            }
            return listOfLogins;

        }
    }

    public static List<Admin> readAdminLogins() throws IOException {
        try (FileReader fr = new FileReader(PATH_TO_ADMIN_LOGINS);
             BufferedReader reader = new BufferedReader(fr);) {
            List<Admin> listOfLogins = new ArrayList<>();

            while (reader.ready()) {

                Admin ad = new Admin();
                String[] arr = reader.readLine().split("&&");
                ad.setID(Integer.parseInt(arr[0]));
                ad.setAdminUserName(arr[1]);
                ad.setAdminPassword(arr[2]);
                listOfLogins.add(ad);


            }
            return listOfLogins;

        }
    }
}
