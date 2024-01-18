public class Patterns {
    public static void hollow_rectangle(int totRows, int totCols) {
        //outer loop for printing lines
        for( int i=1; i <= totRows; i++) {
            // inner loop for traversing each cell and printing star
            for( int j = 1; j<=totCols; j++) {
                // cell- (i,j)
                if(i == 1 || i == totRows || j == 1 || j == totCols) {
                    // boundary cells
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void invt_Rot_half_pyr(int totRows, int totCols) {
        // outer loop for total no. of lines
        int n = totRows;
        for( int i = 1; i<=totRows; i++) {

            // for printing spaces
            for( int k = 1; k<= n-i; k++) {
                System.out.print(" ");
            }


            // inner loop for each cell traversing and priting star
            for( int j = 1; j <=i; j++) {
                // cell_(i,j)
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void inverted_half_pyramid(int n) {
        // outer loop for tottal number of lines
        for( int i = 1; i <= n; i++) {

            // inner loop to print the numbers
            for ( int j = 1; j <= n-i+1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int n) {
        int counter = 1;
        // outer loop for total number of lines
        for( int i = 1; i <= n; i++) {
            // inner loop for the numbers
            for( int j = 1; j <=i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void triangle_0_1(int n) {
        // outer loop for total number of lines
        for( int i = 1; i <= n; i++){
            // inner loop for to print 0 & 1
            for ( int j = 1; j <= i; j++) {
                int k = i+j;
                if( k % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly_pattern(int n) {

            // 1st half

        // outer loop for total no of lines
        for ( int i = 1; i <= n; i++) {
            // inner loop for stars
            for ( int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 2nd loop for to print spaces 
            for ( int k = 1; k <= (n-i)*2; k++) {
                System.out.print(" ");
            }

            for ( int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        //2nd half
        // for 2nd half to create a mirror image we just change the outer
        //loop from i = n to i = 1

        for ( int i =n; i >= 1; i--) {
            // inner loop for stars
            for ( int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 2nd loop for to print spaces 
            for ( int k = 1; k <= (n-i)*2; k++) {
                System.out.print(" ");
            }

            for ( int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n ) {
        // outer loop for total number of lines
        for ( int i = 1; i <= n; i++) {
            // inner loop to print spaces
            for ( int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }
            // 2nd loop to print stars on same line
            for ( int k = 1; k <= n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        // outer loop for total numbber of lines
        for( int i = 1; i <= n; i++) {
            // 1st inner loop to print spaces 
            for ( int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }

            // 2nd inner loop to print stars
            // this loop is same as for the boundary rectangle 
            // as there are spaces first printed it will appear titled
            for ( int j = 1; j <= n; j++) {
                if( i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        // 1st half

        // outer loop to print total number of lines 
        for( int i = 1; i <= n ; i++) {
            // 1st inner loop to print spaces 
            for ( int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }

            // 2nd inner loop to print stars
            for ( int j =1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 2nd half

        for( int i = n; i >=1 ; i--) {
            // 1st inner loop to print spaces 
            for ( int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }

            // 2nd inner loop to print stars
            for ( int j =1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        }

        public static void number_pyramid(int n) {
            // outer loop for total number of lines
            for(int i =1; i<=n; i++) {
                // 1st inner loop to print spaces
                for( int j = 1; j <= n-i; j++) {
                    System.out.print(" ");
                }

                //numbers
                for( int j = 1; j<= i; j++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            
        }

        public static void palindromic_pattern(int n) {
            // outer loop for total number of lines
            for( int i = 1; i <= n; i++) {
                //1st inner loop will e for spaces
                for(int j = 1; j <= n-i; j++) {
                    System.out.print(" ");
                }
                // 2nd inner loop to print the first descending part
                for( int j = i; j>=1; j--) {
                    System.out.print(j);

                }

                //3rd loop for ascending number
                for(int j = 2; j <= i; j++ ) {
                    System.out.print(j);

                }
                System.out.println();
            }
        }
    public static void main(String[] args) {

        //hollow_rectangle(4, 5);
       //invt_Rot_half_pyr(4, 5);
        //inverted_half_pyramid(5);
       // floyd_triangle(5);
       //triangle_0_1(5);
      butterfly_pattern(4);
       //solid_rhombus(7);
       //hollow_rhombus(5);
       //diamond(7);
       //number_pyramid(5);
       //palindromic_pattern(5);
    }


}
