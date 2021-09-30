package com.emailApp;

public class Password {
    private String password;
    private final int passwordLength = 12;

    public Password() {
        this.password = passwordGenerator(passwordLength);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static String passwordGenerator(int length){
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++){
            password.append(randomCharacter());
        }
        return password.toString();
    }

    private static char randomCharacter(){
        int ascii = 0;
        int rand = (int) (Math.random() * 72); // 10 special characters, 10 digits, 26 uppercase letters, 26 lowercase letters
        if (rand <= 9){
            ascii = rand + 33; //special character, ASCII: 33-42
            return (char) ascii;
        }
        else if (rand > 9 && rand <= 19){
            //number between 10-19, ASCII: 48-57, 48-10=38

            ascii = rand + 38;
            return (char) ascii;
        }
        else if (rand > 19 && rand <= 44){
            //uppercase letters: 20-45, ASCII: 65-90, 65-20=45
            ascii = rand + 45;
            return (char) ascii;
        }
        else {
            //lowercase letters 46-71, ASCII: 97-122, 97-46=51
            ascii = rand + 51;
            return (char) ascii;
        }
    }
}
