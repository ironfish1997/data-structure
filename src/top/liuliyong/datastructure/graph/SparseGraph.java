package top.liuliyong.datastructure.graph;


import java.util.LinkedList;
import java.util.Random;

/**
 * 稀疏图，使用邻接表实现
 *
 * @Author liyong.liu
 * @Date 2019-06-06
 **/
public class SparseGraph {
    private int n, m;
    private boolean directed;
    private LinkedList<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<Integer>();
        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new IllegalArgumentException("v or w is illegal");
        }
        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new IllegalArgumentException("v or w is illegal");
        }
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i).equals(w)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 相邻节点迭代器
     */
    class AdjIterator {
        private SparseGraph G;
        private int v;
        private int index;

        AdjIterator(SparseGraph G, int v) {
            this.v = v;
            this.index = 0;
            this.G = G;
        }

        int begin() {
            index = 0;
            if (G.g[v].size() != 0) {
                return G.g[v].get(0);
            }
            return -1;
        }

        int next() {
            index++;
            if (index < G.g[v].size()) {
                return G.g[v].get(index);
            }
            return -1;
        }

        boolean end() {
            return index >= G.g[v].size();
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = 20;
        int M = 100;
        SparseGraph sg = new SparseGraph(N, false);
        for (int i = 0; i < M; i++) {
            int a = random.nextInt(N);
            int b = random.nextInt(N);
            sg.addEdge(a, b);
        }

        for (int v = 0; v < N; v++) {
            System.out.print(v + " : ");
            AdjIterator iterator = sg.new AdjIterator(sg, v);
            for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
