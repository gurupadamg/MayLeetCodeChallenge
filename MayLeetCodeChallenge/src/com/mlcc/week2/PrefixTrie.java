package com.mlcc.week2;

class PrefixTrie {

	/*
	 * Implement a trie with insert, search, and startsWith methods.
	 * 
	 * Example:
	 * 
	 * Trie trie = new Trie();
	 * 
	 * trie.insert("apple"); trie.search("apple"); // returns true
	 * trie.search("app"); // returns false trie.startsWith("app"); // returns true
	 * trie.insert("app"); trie.search("app"); // returns true Note:
	 * 
	 * You may assume that all inputs are consist of lowercase letters a-z. All
	 * inputs are guaranteed to be non-empty strings.
	 */

	class Node {
		char c;
		Node[] arr;
		boolean b;

		public Node(char ch) {
			this.c = ch;
			this.arr = new Node[26];
		}
	}

	Node root;

	/** Initialize your data structure here. */
	public PrefixTrie() {
		root = new Node(' ');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node node = root;
		for (char c : word.toCharArray()) {
			Node temp = node.arr[c - 'a'];
			if (temp == null) {
				node.arr[c - 'a'] = new Node(c);
				node = node.arr[c - 'a'];
			} else {
				node = temp;
			}

		}

		node.b = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node node = root;
		for (char c : word.toCharArray()) {
			Node temp = node.arr[c - 'a'];
			if (temp == null) {
				return false;
			}

			node = temp;
		}

		return node.b;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node node = root;
		for (char c : prefix.toCharArray()) {
			Node temp = node.arr[c - 'a'];
			if (temp == null) {
				return false;
			}

			node = temp;
		}

		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
