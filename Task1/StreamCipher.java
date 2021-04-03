
import java.util.Random;
import java.lang.Long;
import java.io.*;


class StreamCipher{
    public static void main(String []args){
        if(args.length!=3){
            System.out.println("the program should have 3 arguments...");
            java.lang.System.exit(1);
        } 

        long key = -1; 
        try{
            key = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("the provided key cant parse to be long");
            java.lang.System.exit(1);

        }

        Random ran = new Random();
        ran.setSeed(key);

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new BufferedInputStream(new FileInputStream(args[1]));
        } catch (FileNotFoundException e) {
            System.out.println("Exception" + e);
            java.lang.System.exit(1);

        }

        try {
            out = new BufferedOutputStream(new FileOutputStream(args[2]));
        } catch (FileNotFoundException e) {
            System.out.println("exception"+ e);
            java.lang.System.exit(1);

        }

        int n ;
        n = readByte(in);

    while(n!=-1){
            int c = n^ran.nextInt(256);
            if(c > 127){
                c = c-128;
            }
    try {
            out.write(c);
        } 
        catch (IOException e) {
            System.out.println("cant write to the provided file");
            java.lang.System.exit(1);

            }
            n = readByte(in);
        }
        try{
            out.flush();
          } catch(IOException e) {
            System.out.println("Exception given: " + e);
            java.lang.System.exit(1);

          }
          try {
            in.close();
          } catch (IOException e) {
            System.out.println("Exception given: " + e);
            java.lang.System.exit(1);

          }
          try {
            out.close();
          } catch (IOException e) {
            System.out.println("Exception given: " + e);
            java.lang.System.exit(1);

          }
          java.lang.System.exit(0);

    }
    private static int readByte(BufferedInputStream in){
        int n = 0;
        try {
            n = in.read(); 
        } catch (IOException e) {
            System.out.println("can not read byte from given file");
            java.lang.System.exit(1);

        }
        return n;
    }
}
