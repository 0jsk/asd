package ru.scndjk.dsa.SimpleGraph;

import java.util.*;

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

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        restoreHits();

        if (vertex[VFrom] == null || vertex[VTo] == null) {
            return new ArrayList<>();
        }

        Queue<Vertex> queue = new LinkedList<>();
        int[] predecessors = new int[max_vertex];
        Arrays.fill(predecessors, -1);

        vertex[VFrom].Hit = true;
        queue.add(vertex[VFrom]);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.Value == vertex[VTo].Value) {
                return buildPath(predecessors, VFrom, VTo);
            }

            for (int i = 0; i < max_vertex; i += 1) {
                if (IsEdge(currentVertex.Value, i) && !vertex[i].Hit) {
                    vertex[i].Hit = true;
                    predecessors[i] = currentVertex.Value;
                    queue.add(vertex[i]);
                }
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
        LinkedList<Vertex> path = new LinkedList<>();

        for (Vertex v : stack) {
            path.addFirst(v);
        }

        return new ArrayList<>(path);
    }

    private ArrayList<Vertex> buildPath(int[] predecessors, int VFrom, int VTo) {
        LinkedList<Vertex> path = new LinkedList<>();

        for (int at = VTo; at != -1; at = predecessors[at]) {
            path.addFirst(vertex[at]);

            if (vertex[at].Value == VFrom) {
                break;
            }
        }

        return new ArrayList<>(path);
    }

    private void restoreHits() {
        for (Vertex v : vertex) {
            v.Hit = false;
        }
    }
}
