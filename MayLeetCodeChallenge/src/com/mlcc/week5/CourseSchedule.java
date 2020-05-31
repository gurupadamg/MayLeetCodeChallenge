package com.mlcc.week5;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

	/**
	 * There are a total of numCourses courses you have to take, labeled from 0 to
	 * numCourses-1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you have to
	 * first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true Explanation:
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0. So it is possible. Example 2:
	 * 
	 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false
	 * Explanation: There are a total of 2 courses to take. To take course 1 you
	 * should have finished course 0, and to take course 0 you should also have
	 * finished course 1. So it is impossible.
	 * 
	 * 
	 * Constraints:
	 * 
	 * The input prerequisites is a graph represented by a list of edges, not
	 * adjacency matrices. Read more about how a graph is represented. You may
	 * assume that there are no duplicate edges in the input prerequisites. 1 <=
	 * numCourses <= 10^5
	 */

	List<Integer>[] graph;
	boolean[] visited;
	boolean[] explored;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// creating adjacency list representation of the graph
		graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}

		visited = new boolean[numCourses];
		explored = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				if (isCyclic(i)) {
					return false;
				}
			}
		}

		return true;
	}

	boolean isCyclic(int u) {
		visited[u] = true;
		for (Integer v : graph[u]) {
			if (!visited[v]) {
				if (isCyclic(v)) {
					return true;
				}
			} else if (!explored[v]) {
				return true;
			}
		}
		// explored all the adjacent vertices for vertex "u" and thus marking "u" as
		// explored
		explored[u] = true;
		return false;
	}
}
