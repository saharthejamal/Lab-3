public class Main {
    public static void main(String[] args) {
      String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
      
      // Best-case scenario: The pattern is found at the beginning
      String bestCase = "A";
  
      long startTime = System.nanoTime();
      int index = match(text, bestCase);
      long endTime = System.nanoTime();
      long elapsedTime = endTime - startTime;
  
      System.out.println("Best-case elapsed time: " + elapsedTime + " nanoseconds");
  
      if (index >= 0)
        System.out.println("Best-case input matched at index " + index);
      else
        System.out.println("Best-case input unmatched");
  
      // Worst-case scenario: The pattern doesn't exist in text
      String worstCase = "ZZ";
  
      startTime = System.nanoTime();
      index = match(text, worstCase);
      endTime = System.nanoTime();
      elapsedTime = endTime - startTime;
  
      System.out.println("Worst-case elapsed time: " + elapsedTime + " nanoseconds");
  
      if (index >= 0)
        System.out.println("Worst-case input matched at index " + index);
      else
        System.out.println("Worst-case input unmatched");
    }
  
    public static int match(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (isMatched(i, text, pattern))
                return i;
        }
        return -1;
    }
    
    private static boolean isMatched(int i, String text, String pattern) {
        for (int k = 0; k < pattern.length(); k++) {
            if (pattern.charAt(k) != text.charAt(i + k)) {
                return false;
            }
        }
        return true;
    }
  }