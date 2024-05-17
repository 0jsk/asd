package ru.scndjk.dsa.SimpleGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleGraphTest {
    @Test
    void test_AddVertex() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);

        assertEquals(1, graph.vertex[0].Value);
        assertEquals(2, graph.vertex[1].Value);
        assertEquals(3, graph.vertex[2].Value);
    }

    @Test
    void test_RemoveVertex() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);

        graph.RemoveVertex(0);

        assertNull(graph.vertex[0]);
        for (int i = 0; i < graph.max_vertex; i++) {
            assertEquals(0, graph.m_adjacency[0][i]);
            assertEquals(0, graph.m_adjacency[i][0]);
        }
    }

    @Test
    void test_IsEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);

        assertTrue(graph.IsEdge(0, 1));
        assertFalse(graph.IsEdge(1, 0));
        assertFalse(graph.IsEdge(0, 0));
    }

    @Test
    void test_AddEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);

        assertEquals(1, graph.m_adjacency[0][1]);
    }

    @Test
    void test_RemoveEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        graph.RemoveEdge(0, 1);

        assertEquals(0, graph.m_adjacency[0][1]);
    }
}
