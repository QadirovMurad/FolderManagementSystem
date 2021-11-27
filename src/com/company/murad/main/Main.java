package com.company.murad.main;

import com.company.murad.members.Admin;
import com.company.murad.members.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("1.Login as Admin\n2.Login as User\n3.Register as User");
        System.out.println("Choice : ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                if (Admin.checkAdminUserNameAndPassword()) {
                    System.out.println("Successfully logined !");
                    Admin.seeUnConfirmedUsers();
                    int ch;
                    System.out.println("Do you want to confirm them ? 1.Yes 2.No");
                    ch = sc.nextInt();
                    if (ch == 1)
                        Admin.confirmUser();
                    else
                        System.out.println("Good bye !");
                } else
                    System.out.println("Incorrect username or password !");
                break;
            case 2:
                if (User.checkUsersUserNameAndPassword()) {
                    System.out.println("Successfully logined !");
                    User.enterPathAndDoSomething();
                } else
                    System.out.println("Incorrect username or password !");

                break;
            case 3:
                User u = new User();
                u.register();
                System.out.println("");
                Admin.checkAdminUserNameAndPassword();
                Admin.confirmUser();
                main(args);
                break;
            default:
                System.out.println("Wrong Input !");
        }
        main(args);
    }
}
