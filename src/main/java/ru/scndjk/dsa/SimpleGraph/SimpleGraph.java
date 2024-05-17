package ru.scndjk.dsa.SimpleGraph;

class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph {
    public Vertex[] vertex;
    public int[][] m_adjacency;
    public int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        Vertex newVertex = new Vertex(value);

        for (int i = 0; i < max_vertex; i += 1) {
            if (vertex[i] == null) {
                vertex[i] = newVertex;
                return;
            }
        }
    }

    public void RemoveVertex(int v) {
        if (vertex[v] == null) {
            return;
        }

        vertex[v] = null;

        for (int i = 0; i < max_vertex; i += 1) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        if (vertex[v1] == null || vertex[v2] == null) {
            return false;
        }

        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        if (vertex[v1] == null || vertex[v2] == null) {
            return;
        }

        m_adjacency[v1][v2] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        if (vertex[v1] == null || vertex[v2] == null) {
            return;
        }

        m_adjacency[v1][v2] = 0;
    }
}
