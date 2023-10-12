package com.example.cs2340b_team39.Model;

public class Model {
    public static boolean validateCredentials(String name, int difficulty, int character) {
        if (!(name == null) && !(name.isEmpty()) && !(name.isBlank())
                &&  difficulty > -1 && character > -1) {
            return true;
        }
        return false;
    }
}
