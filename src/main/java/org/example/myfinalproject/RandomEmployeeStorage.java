package org.example.myfinalproject;

import java.time.LocalDate;

public class RandomEmployeeStorage {
    public static String[] name = {"Ali","Mohsen","Mohammad","Arsham","Arash","Melika","Maryam","Mona","Zahra","Mehri"};
    public static String[] family = {"Amini","Mahmudi","Khoshnood","Jahani","Hashemi","Mousavi","Rahmani","Rezaiee","Karimi","Barani"};
    public static String[] nationalId = {"4317890056","4326453212","5417654321","1995674312","4327895632","6785671234","6547894532","4311937856"
                                        ,"4322901867","5437823519"};
    public static String[] phone = {"09124814666","09300423674","09218763412","09330929203","09145643212","09907895610",
                                    "09125819908","09126711245","09300524532","09197897856","09203421345"};
    public static LocalDate[] birthDate = {LocalDate.parse("2000-02-10"),LocalDate.parse("1998-01-03"),LocalDate.parse("2003-08-16"),
                                           LocalDate.parse("2001-09-09"),LocalDate.parse("1995-11-01"),LocalDate.parse("2005-10-26"),
                                           LocalDate.parse("2002-07-09"),LocalDate.parse("1999-05-12"),LocalDate.parse("2004-07-02"),
                                           LocalDate.parse("1997-11-11")};
    public static double[] baseSalary = {150,200,100.40,100,30,500,250,125,70.5,650};
    public static double[] hourlyRate = {10,20,15,4.5,5.5,6.75,30,35,12,23};
    public static double[] amountOfHours = {10,20,15,5,6,12,17,24,48,36};
    public static int[] numberOfSales = {10,100,50,25,45,12,18,69,40,42};
    public static double[] commissionRate = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,0.75};
}
