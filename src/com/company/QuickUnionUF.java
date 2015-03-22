package com.company;

public class QuickUnionUF
{
    private int[] id;

    QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    private int root (int p)
    {
        while ( id[p] != p )
            p = id[p];
        return p;
    }

    public boolean connected (int p, int q)
    {
        return root(p) == root(q);
    }

    public void union (int p, int q)
    {
        id[root(p)] = root(q);
    }

    public void printIDs()
    {
        System.out.print("id[]:");
        for (int element : id)
            System.out.print(" " + element);
        System.out.println();
    }

    public static void main(String[] args)
    {
        System.out.println("Quick Union demo from Coursera");
        QuickUnionUF QuickUnion1 = new QuickUnionUF(10);
        QuickUnion1.printIDs();
        QuickUnion1.union(4, 3);
        QuickUnion1.union(3, 8);
        QuickUnion1.union(6, 5);
        QuickUnion1.union(9, 4);
        QuickUnion1.union(2, 1);
        QuickUnion1.printIDs();
        System.out.println("connected(8, 9) = " + QuickUnion1.connected(8, 9));
        System.out.println("connected(5, 0) = " + QuickUnion1.connected(5, 0));
        QuickUnion1.union(5, 0);
        QuickUnion1.union(7, 2);
        QuickUnion1.union(6, 1);
        QuickUnion1.union(7, 3);
        QuickUnion1.printIDs();
    }
}
