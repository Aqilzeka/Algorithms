package aStartAlgorithm;

public class Cell {

    public int i, j;
    public Cell parents;
    public int heuristicCost;
    public int finalCost;
    public boolean solution;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return String.format("[ %d, %d ]", i, j);

    }
}