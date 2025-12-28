/** Draws the Sierpinski Triangle fractal. */
public class Sierpinski {
    
    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }
    
    // Draws a Sierpinski triangle of depth n on the standard canvas.
    public static void sierpinski(int depth) {
        StdDraw.setScale(0, 1);
        StdDraw.clear();
        
        // Define the three vertices of the main outer triangle
        double xLeft = 0.0, xRight = 1.0, xTop = 0.5;
        double yLeft = 0.0, yRight = 0.0, yTop = 0.866;
        
        StdDraw.setPenColor(StdDraw.BLACK);
        sierpinski(depth, xLeft, xRight, xTop, yLeft, yRight, yTop);
    }
    
    // Does the actual drawing, recursively.
    private static void sierpinski(int depth, double xLeft, double xRight, double xTop,
                                   double yLeft, double yRight, double yTop) {
        // Base case: Draw the triangle
        if (depth == 0) {
            StdDraw.line(xLeft, yLeft, xRight, yRight);
            StdDraw.line(xRight, yRight, xTop, yTop);
            StdDraw.line(xTop, yTop, xLeft, yLeft);
        } else {
            // Calculate midpoints of the three sides
            double xBaseMid = (xLeft + xRight) / 2.0;
            double yBaseMid = (yLeft + yRight) / 2.0;

            double xLeftMid = (xLeft + xTop) / 2.0;
            double yLeftMid = (yLeft + yTop) / 2.0;

            double xRightMid = (xRight + xTop) / 2.0;
            double yRightMid = (yRight + yTop) / 2.0;

            // Recursively draw three smaller triangles
            sierpinski(depth - 1, xLeft, xBaseMid, xLeftMid, yLeft, yBaseMid, yLeftMid);
            sierpinski(depth - 1, xBaseMid, xRight, xRightMid, yBaseMid, yRight, yRightMid);
            sierpinski(depth - 1, xLeftMid, xRightMid, xTop, yLeftMid, yRightMid, yTop);
        }
    }
}