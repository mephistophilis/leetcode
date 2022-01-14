package tests;
//1091. Shortest Path in Binary Matrix

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }

    @Test
    void test() {
        Assertions
                .assertEquals(
                        allPathsSourceTarget(TestHelper.arrayStringTo2DIntArray("[[1,2],[3],[3],[]]")),
                        TestHelper.array2DStringToIntList("[[0,1,3],[0,2,3]]"));

    }
}