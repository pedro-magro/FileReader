import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\pedro\\devProjetos\\FileReading\\Good morning!.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Erro: "+ e.getMessage());
        }

        String path2 = "C:\\Users\\pedro\\devProjetos\\FileReading\\output.txt";

        String [] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Erro: "+ e.getMessage());
            e.printStackTrace();
        }

        //working with directories

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the folder path: ");
        String folderPath = sc.nextLine();
        File folder = new File(folderPath);
        File[] folders = folder.listFiles(File::isDirectory);
        System.out.println("Folders: ");
        for(File f : folders){
            System.out.println(f);
        }

        File[] files = folder.listFiles(File::isFile);
        System.out.println("Files: ");
        for(File f : files){
            System.out.println(f);
        }

        boolean succes = new File(folderPath + "\\subdir").mkdir();
        System.out.println("DIrectory created successfully" + succes);

        System.out.println("File: " +folder.getName());
        System.out.println("Parent: " + folder.getParent());
        System.out.println("Path: " + folder.getPath());
        sc.close();

    }
}