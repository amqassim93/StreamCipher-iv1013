
import java.util.Random;
import java.lang.Long;
import java.io.*;


class StreamCipher{
    private static long seed;
    public static void main(String []args){
        seed = 0;
        int n ;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        if(args.length!=3){
            System.out.println("the program should have 3 arguments...");
        } 

        try{
            seed = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("the provided key cant parse to be long");
        }

        Random ran = new Random();
        ran.setSeed(seed);
        int S = ran.nextInt(256);

        try {
            in = new BufferedInputStream(new FileInputStream(args[1]));
        } catch (FileNotFoundException e) {
            System.out.println("Exception" + e);
        }

        try {
            out = new BufferedOutputStream(new FileOutputStream(args[2]));
        } catch (FileNotFoundException e) {
            System.out.println("exception"+ e);
        }

        n = readByte(in);

    while(n!=-1){
            int c = n^S;

            if(c > 127){
                c = c-128;
            }
    try {
            out.write(c);
        } 
        catch (IOException e) {
            System.out.println("cant write to the provided file");
            }
            n = readByte(in);
        }
        try{
            out.flush();
          } catch(IOException e) {
            System.out.println("Exception given: " + e);
          }
          try {
            in.close();
          } catch (IOException e) {
            System.out.println("Exception given: " + e);
          }
          try {
            out.close();
          } catch (IOException e) {
            System.out.println("Exception given: " + e);
          }
    }
    private static int readByte(BufferedInputStream in){
        int n = 0;
        try {
            n = in.read(); 
        } catch (IOException e) {
            System.out.println("can not read byte from given file");
        }
        return n;
    }
}
