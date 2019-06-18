package top.liuliyong.datastructure.graph;

import java.util.Random;

/**
 * 稠密图，使用邻接矩阵实现
 *
 * @Author liyong.liu
 * @Date 2019-06-06
 **/
public class DenseGraph {
    private int n, m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new boolean[n][];
        for (int i = 0; i < n; i++) {
            g[i] = new boolean[n];
        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    /**
     * 增加一条边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new IllegalArgumentException("v or w is illegal");
        }
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new IllegalArgumentException("v is illegal");
        }
        return g[v][w];
    }

    /**
     * 相邻节点迭代器
     */
    class AdjIterator {
        private DenseGraph G;
        private int v;
        private int index;

        AdjIterator(DenseGraph G, int v) {
            this.v = v;
            this.index = -1;
            this.G = G;
        }

        int begin() {
            index = -1;
            return next();
        }

        int next() {
            for (index += 1; index < G.V(); index++) {
                if (G.g[v][index]) {
                    return index;
                }
            }
            return -1;
        }

        boolean end() {
            return index >= G.V();
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = 20;
        int M = 100;
        DenseGraph sg = new DenseGraph(N, false);
        for (int i = 0; i < M; i++) {
            int a = random.nextInt(N);
            int b = random.nextInt(N);
            sg.addEdge(a, b);
        }

        for (int v = 0; v < N; v++) {
            System.out.print(v + " : ");
            DenseGraph.AdjIterator iterator = sg.new AdjIterator(sg, v);
            for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

}
