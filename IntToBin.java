/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + number + " is: " + toBinary(number));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's. */
    public static String toBinary(int number) {
        String binaryStr = "0";
        
        if (number == 0)
            return "0";
        
        if (number == 1)
            return "1";
        
        if (number % 2 == 0)
            binaryStr = toBinary(number / 2) + '0';
        else
            binaryStr = toBinary(number / 2) + '1';
            
        return binaryStr;
    }    
}