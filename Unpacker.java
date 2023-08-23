/*
unpacking activity(write the data in new created file)
 */
import java.io.*;
import java.util.*;

class Unpacker
{
    public static void main(String arg[]) throws Exception
    {
        
        Scanner sobj = new Scanner(System.in);
        byte Header[] = new byte[100];
        int iRet = 0;
        String Headerstr, Tokens[];
        int iCount = 0;


        System.out.println("-----------Marvellous Packer Unpacker------------");
        System.out.println("Unpacking Activity of the application is started....");

        System.out.println("Enter the file name which contain packed data : ");
        String PackFile = sobj.nextLine();

        try
        {
            File Packobj = new File(PackFile);
        
            FileInputStream inobj = new FileInputStream(Packobj);

            while ((iRet = inobj.read(Header, 0, 100)) > 0)
            {
                Headerstr = new String(Header);

                Tokens = Headerstr.split(" ");

                File newfileobj = new File(Tokens[0]);
                newfileobj.createNewFile();


                FileOutputStream outobj = new FileOutputStream(newfileobj);

                int FileSize = Integer.parseInt(Tokens[1]);
                byte Buffer[] = new byte[FileSize];   //to convet the string to integer
        
                inobj.read(Buffer, 0, FileSize);
                outobj.write(Buffer, 0, FileSize);

                System.out.println("File Succesfully extracted with name " + Tokens[0]);
                iCount++;
            }
            System.out.println("---------------------Unpacking Summary----------------------");
            System.out.println("Total number of files Extracted : "+ iCount);
            System.out.println("Thank you for using the Marellous Packer Unpacker...");

        }
        catch(Exception obj)
        {
            System.out.println("Execption ocuers " + obj);
        }
        
    }
}