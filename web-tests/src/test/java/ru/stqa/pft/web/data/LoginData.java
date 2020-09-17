package ru.stqa.pft.web.data;

import java.io.*;

public class LoginData {

    private String login;
    private String pass;

    public LoginData(){
        try {
//            File file = new File("C:\\Tools\\note.txt");
            File file = new File("src/test/resources/notes.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            login = reader.readLine();
            pass = reader.readLine();

/*            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogin(){
        return login;
    }

    public String getPass(){
        return pass;
    }
}
