package com.basejava.webapp;

import com.basejava.webapp.model.Resume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ResumeTestData {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Resume resume;

        while (true) {
            System.out.println("Введите полное имя: ");
            String[] fullNameParams = br.readLine().split(" ");
            if (fullNameParams.length < 2 || fullNameParams.length > 3) {
                System.out.println("Некорректное полное имя.");
                continue;
            }

            String fullName = Arrays.toString(fullNameParams);
            resume = new Resume(fullName);
            System.out.printf(resume.getFullName());

            System.out.println("Заполните контактную информацию, выбрав тип контакта - ( Тел. | Skype | Email | LinkedIn | GitHub | Stackoverflow | Домашняя страница): ");
            String[] contactParams = br.readLine().split(" ");
            if (contactParams.length < 1 || contactParams.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }

            switch (contactParams[0]) {
                case "Тел.":
                case "Skype":
                case "Email":
                case "LinkedIn":
                case "GitHub":
                case "Stackoverflow":
                case "Домашняя":
            }
        }
    }
}