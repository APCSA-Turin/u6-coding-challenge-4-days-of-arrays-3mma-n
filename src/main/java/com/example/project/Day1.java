package com.example.project;
import java.util.Random;
public class Day1{
    private static String[] elf_names = {"Glitter", "Chocolate","Tiny","Snowflake","Frosty"};

    public static String generateElfName(String name){
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        int idx = (int) (Math.random() * 5);
        return elf_names[idx] + " " + name;  
    }
}