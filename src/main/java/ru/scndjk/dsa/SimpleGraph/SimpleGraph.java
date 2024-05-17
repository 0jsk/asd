package ru.scndjk.dsa.SimpleGraph;

import java.util.ArrayList;
import java.util.Stack;

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

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        restoreHits();

        Stack<Vertex> stack = new Stack<>();

        if (vertex[VFrom] == null || vertex[VTo] == null) {
            return new ArrayList<>();
        }

        stack.push(vertex[VFrom]);
        vertex[VFrom].Hit = true;

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            if (currentVertex.Value == vertex[VTo].Value) {
                return buildPath(stack);
            }

            int adjacentVertexIndex = findUnvisitedAdjacentVertex(currentVertex);

            if (adjacentVertexIndex != -1) {
                stack.push(vertex[adjacentVertexIndex]);
                vertex[adjacentVertexIndex].Hit = true;
            } else {
                stack.pop();
            }
        }

        return new ArrayList<>();
    }

    private int findUnvisitedAdjacentVertex(Vertex vertex) {
        for (int i = 0; i < max_vertex; i += 1) {
            if (m_adjacency[vertex.Value][i] == 1 && !this.vertex[i].Hit) {
                return i;
            }
        }

        return -1;
    }

    private ArrayList<Vertex> buildPath(Stack<Vertex> stack) {
        ArrayList<Vertex> path = new ArrayList<>();

        for (Vertex v : stack) {
            path.add(0, v);
        }

        return path;
    }

    private void restoreHits() {
        for (Vertex v : vertex) {
            v.Hit = false;
        }
    }
}
