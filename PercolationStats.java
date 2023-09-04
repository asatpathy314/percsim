import edu.princeton.cs.algs4.*;
public class PercolationStats {
        private double[] data;
        // perform independent trials on an n-by-n grid
        public PercolationStats(int n, int trials) {
            data = new double[trials];
            for(int i=0;i<trials;i++){
                Percolation trialPerc = new Percolation(n);
                int counter = 0;
                while(!trialPerc.percolates()){
                    trialPerc.open(StdRandom.uniformInt(1, n+1), StdRandom.uniformInt(1, n+1));
                }
                data[i] = ((double)(trialPerc.numberOfOpenSites())/((double)(n*n)));
            }
        }

        // sample mean of percolation threshold
        public double mean() {
            double sum = 0.0;
            for(int i = 0; i<data.length; i++){
                sum+=data[i];
            }
            return sum/data.length;
        }

        // sample standard deviation of percolation threshold
        public double stddev(){
            return StdStats.stddev(data);
        }

        // low endpoint of 95% confidence interval
        public double confidenceLo(){
            return 0.95*this.mean();
        }

        // high endpoint of 95% confidence interval
        public double confidenceHi(){
            return 1.05*this.mean();
        }

    // test client (see below)
    public static void main(String[] args) {
            //example use
            PercolationStats testObject = new PercolationStats(200, 1000);
            System.out.println(testObject.mean());

    }
}
