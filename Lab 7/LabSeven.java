// Ron Pearsall Lab 7
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class LabSeven{
   /*Main method that reads file, splits file into arrays, calculates total 
   *price, and writes prices to new file.
   *@params: String args
   *@returns: None void
   */
   public static void main(String[] args){
      
      String fileIn;
      String[] orderId = new String[2820];
      String[] productId = new String[2820];
      double[] unitPrice = new double[2820];
      double[] discount = new double[2820];
      int[] quanity = new int[2820];
      int i = 0;   
      //reading file in, and storing info in different arrays.
      try{
         File readFile = new File("OrderDetails.txt");
         Scanner in = new Scanner(readFile);
         while (in.hasNext()){
            fileIn = in.nextLine();
            String[] splitString = fileIn.split(",");
            quanity[i] = Integer.parseInt(splitString[0]);
            unitPrice[i] = Double.parseDouble(splitString[1]);
            orderId[i] = splitString[2];
            productId[i] = splitString[3];
            discount[i] = Double.parseDouble(splitString[4]);
            i++;
         }
         in.close();
      } 
      catch (Exception e){
           System.out.println(e.getMessage());   
      }
      //for loop that calculates total price and writes price to new file.
      try{
         PrintWriter outfile = new PrintWriter("Prices.txt");
         for(int j = 0; j < 2820; j++){
            double prices = unitPrice[j] * quanity[j] - (discount[j] * quanity[j] * unitPrice[j]);
            outfile.println(orderId[j]+", "+prices);
         }
         outfile.close();
      }
      catch (Exception e){
            System.out.println(e.getMessage());
      }
   }
}