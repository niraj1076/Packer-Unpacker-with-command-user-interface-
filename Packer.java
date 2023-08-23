/*
some decoration
 */
import java.io.*;
import java.util.*;

class Packer
{
    public static void main(String arg[]) throws Exception
    {
        byte Buffer[] = new byte[1024];
        boolean bRet = false;
        int iRet = 0;
        int PackCount = 0;

        Scanner sobj = new Scanner(System.in);

        System.out.println("-----------Marvellous Packer Unpacker------------");
        
        System.out.println("Packing Activity of the application is started....");

        
        System.out.println("Enter the name of folder which contain the file you :");
        String FolderName = sobj.nextLine();

        File fobj = new File(FolderName);
        String Header = null;

        System.out.println("Enter the name of the packed file you want to create : ");
        String PackFile = sobj.nextLine();

        try
        {    
            File Packobj = new File(PackFile);
            bRet = Packobj.createNewFile();
            if(bRet == false)
            {
                System.out.println("Unable to create packed file");
            }

            System.out.println("Packed file gets succesfull create in the current directory");
            FileOutputStream outobj = new FileOutputStream(Packobj);


            bRet = fobj.isDirectory();
            if(bRet == true)
            {
                File list[] = fobj.listFiles();

                System.out.println("Total Number of file found in the directory are :" + list.length);
                for(int i = 0; i < list.length; i++)       //to travl the the whole directory
                {
                    if(list[i].getName().endsWith(".txt"))     //the file will only enter if it is .txt file
                    {
                        Header = list[i].getName() + " " + list[i].length();
                        for(int j = Header.length(); j < 100 ; j++)
                        {
                            Header = Header + " ";
                        }
                        byte bHeader[] = Header.getBytes();     //to convert the normal char to bytes(bHeader is a array)
                        outobj.write(bHeader, 0 , bHeader.length);       //this will write the string if byte in file

                        FileInputStream inobj = new FileInputStream(list[i]);

                        //loop to write the data
                        while((iRet = inobj.read(Buffer)) != -1)
                        {
                            outobj.write(Buffer,0,iRet);
                        }
                        System.out.println("File sycessfully packed with name : "+ list[i].getName());

                        inobj.close();
                        PackCount++;
                    }
                }
                System.out.println("---------------------Packing Summary----------------------");
                System.out.println("Total number of files scanned : "+ list.length);
                System.out.println("Total number of file packes : "+ PackCount);

                System.out.println("Thank you for using the Marellous Packer Unpacker...");

            }
            
        }
        catch(Exception iobj)
        {
            System.out.println("Error "+ iobj);
        }
    }
}