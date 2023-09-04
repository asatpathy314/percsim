# PercolationStats and Percolation Readme

This readme provides an overview of the two classes, `PercolationStats` and `Percolation`, and explains how to use them to simulate and analyze percolation in a grid.

## Class 1: PercolationStats

### Description
`PercolationStats` is a Java class used to simulate and analyze the percolation threshold of a grid system using Monte Carlo simulations. It computes various statistical properties related to percolation, such as the mean, standard deviation, and confidence intervals.

### Constructor
```java
public PercolationStats(int n, int trials)
```
- Initializes the `PercolationStats` object.
- `n`: The size of the grid (n x n).
- `trials`: The number of independent trials to perform.

### Public Methods
1. `public double mean()`
   - Calculates and returns the sample mean of the percolation threshold from the trials.

2. `public double stddev()`
   - Calculates and returns the sample standard deviation of the percolation threshold from the trials.

3. `public double confidenceLo()`
   - Calculates and returns the low endpoint of the 95% confidence interval for the percolation threshold.

4. `public double confidenceHi()`
   - Calculates and returns the high endpoint of the 95% confidence interval for the percolation threshold.

### Usage Example (in `main` method)
```java
PercolationStats testObject = new PercolationStats(200, 1000);
System.out.println(testObject.mean());
```

## Class 2: Percolation

### Description
`Percolation` is a Java class that models a percolation system on an n x n grid. It provides methods to open sites, check if sites are open or connected, and determine if the system percolates.

### Constructor
```java
public Percolation(int n)
```
- Initializes the `Percolation` object.
- `n`: The size of the grid (n x n).

### Public Methods
1. `public void open(int row, int col)`
   - Opens the site at the specified row and column if it is not already open.

2. `public boolean isOpen(int row, int col)`
   - Checks if the site at the specified row and column is open.

3. `public boolean isFull(int row, int col)`
   - Checks if the site at the specified row and column is connected to the top (i.e., is full).

4. `public int numberOfOpenSites()`
   - Returns the number of open sites in the grid.

5. `public boolean percolates()`
   - Checks if the system percolates (i.e., there is a path from the top to the bottom of the grid).

### Usage Example
```java
Percolation perc = new Percolation(5);
perc.open(1, 2);
boolean isOpen = perc.isOpen(1, 2);
boolean isFull = perc.isFull(1, 2);
int numOpenSites = perc.numberOfOpenSites();
boolean percolates = perc.percolates();
```

## How to Use
1. Create a `PercolationStats` object by specifying the grid size (n) and the number of trials.
2. Use the public methods of `PercolationStats` to calculate statistical properties related to percolation.
3. Create a `Percolation` object by specifying the grid size (n).
4. Use the public methods of `Percolation` to model and analyze percolation on the grid.

### Note
- Make sure to have the `edu.princeton.cs.algs4` library included in your project for the code to work correctly.
- https://algs4.cs.princeton.edu/code/algs4.jar
- The `Percolation` class models percolation using the Weighted Quick Union-Find algorithm.
