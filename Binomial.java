/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
        //// Uncomment the version of binomial that you want to test

        // Testing the basic binomial implementation:
        // System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

        // Testing the optimized binomial implementation:
        // System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }

    // Computes the Binomial function, basic version.
    public static int binomial1(int n, int k) { 
        if (k > n) return 0;
        if (k == 0 || n == 0) return 1;
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
    }
    
    // Computes the Binomial function, efficiently
    public static long binomial(int n, int k) {
        //// This function creates a 2D array, say cache, 
        //// and then initializes all its elements to -1.
        //// It then calls binomial(n, k, cache), which does all the heavy lifting.
        
        long[][] cache = new long[n + 1][k + 1];
        
        // Iterating through rows (0 to n) and columns (0 to k)
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= k; col++) {
                cache[row][col] = -1;
            }
        }
        return binomial(n, k, cache);
    }

    private static long binomial(int n, int k, long[][] cache) {
        // Check if value is already computed
        if (cache[n][k] != -1) {
            return cache[n][k];
        }
        
        // Base case: k cannot be larger than n
        if (k > n) {
            cache[n][k] = 0; 
            return 0;
        }
        
        // Base case: n is 0 or k is 0
        if (n == 0 || k == 0) {
            cache[n][k] = 1; 
            return 1;
        }
        
        // Recursive step
        cache[n][k] = binomial(n - 1, k, cache) + binomial(n - 1, k - 1, cache);
        return cache[n][k];
    }
}