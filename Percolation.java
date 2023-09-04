import edu.princeton.cs.algs4.*;

public class Percolation {
    private WeightedQuickUnionUF Model;

    private boolean[] openedSites;
    private int dimension;

    public Percolation(int n){
        Model = new WeightedQuickUnionUF((n*n)+2);
        openedSites = new boolean[n*n+2];
        dimension = n;
    }
    //opens the site (row, col) if it is not open already)
    public void open(int row, int col) {

        openedSites[this.conv(row, col)] = true;

        if (row == 1) {
            Model.union(this.conv(row, col), 0);
        }
        if(row==dimension) {
            Model.union(this.conv(row, col), (dimension*dimension)+1);
        }
        try{
            if(openedSites[this.conv(row, col+1)]==true){
                Model.union(this.conv(row, col), this.conv(row, col+1));
            }
        }
        catch(Exception e){
            ;
        }
        try{
            if(openedSites[this.conv(row, col-1)]==true){
                Model.union(this.conv(row, col), this.conv(row, col-1));
            }
        }
        catch(Exception e){
            ;
        }
        try{
            if(openedSites[this.conv(row-1, col)]==true){
                Model.union(this.conv(row, col), this.conv(row-1, col));
            }
        }
        catch(Exception e){
            ;
        }
        try{
            if(openedSites[this.conv(row+1, col)]==true){
                Model.union(this.conv(row, col), this.conv(row+1, col));
            }
        }
        catch(Exception e){
            ;
        }
    }
    //A method to make converting from row col form to int array form easier
    public int conv(int row, int col) {
        row -=1;
        return (row*dimension+col);
        }

    //is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return openedSites[(row-1)*dimension + col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){return Model.find(0)==Model.find(this.conv(row, col));}

    //returns the number of open sites
    public int numberOfOpenSites() {
        int count =0;
        for(int i=0; i< openedSites.length;i++){
            if(openedSites[i]==true){count++;}
        }
        return count;
    }

    //does the system percolate?
    public boolean percolates() {return Model.find(0)==Model.find(dimension*dimension+1);}

    public static void main(String[] args) {}

}
