package models;

import models.AVLNode;

public class AVLTree<T> {	
	
	public int find(AVLNode<T> sub, T el, int found) {
		if( sub != null && found == 0){
			if(sub.element.toString().compareTo(el.toString()) == 0)
				found = 1;
			else if (sub.element.toString().compareTo(el.toString()) < 0)
				found = this.find(sub.left_tree, el, found);
			else
				found = this.find(sub.right_tree, el, found);
		}

		return found;
	}
	
	public AVLNode<T> insert(AVLNode<T> sub, T element){
		AVLNode<T> new_tree;
		if (sub == null){
			new_tree = new AVLNode<T>();
			new_tree.element = element;
			new_tree.left_h = 0;
			new_tree.right_h = 0;
			new_tree.left_tree = null;
			new_tree.right_tree = null;
			sub = new_tree;
		}
		else if(element.toString().compareTo(sub.left_tree.element.toString()) < 0){
			sub.left_tree = this.insert(sub.left_tree, element);
			if (sub.left_tree.right_h > sub.left_tree.left_h)
				sub.left_h = sub.left_tree.right_h + 1;
			else
				sub.left_h = sub.left_tree.left_h + 1;

			sub = this.rebalance(sub);
		}
		else{
			sub.right_tree = this.insert(sub.right_tree, element);
			if(sub.right_tree.right_h > sub.right_tree.left_h)
				sub.right_h = sub.right_tree.right_h+1;
			else
				sub.right_h = sub.right_tree.left_h + 1;
			sub = this.rebalance(sub);
		}

		return sub;
	}
	
	public AVLNode<T> rebalance(AVLNode<T> sub){
		int diff, node_diff;
		diff = sub.right_h - sub.right_h;

		if ( diff == 2){
			node_diff = sub.right_tree.right_h - sub.right_tree.left_h;
		
			if(node_diff >=0)
				sub = this.left_rotation(sub);
			else {
				sub.right_tree = this.right_rotation(sub.right_tree);
				sub = this.left_rotation(sub);
			}

		}

		else if (diff == -2){
			node_diff = sub.left_tree.right_h - sub.left_tree.left_h;
			if (node_diff <= 0)
				sub = this.right_rotation(sub);
			else{
				sub.left_tree = this.left_rotation(sub.left_tree);
				sub = this.right_rotation(sub);
			}
		}

		return sub;
	}
	
	public AVLNode<T> left_rotation(AVLNode<T> sub){
		AVLNode<T> st1 = sub.right_tree;
		AVLNode<T> st2 = sub.left_tree;

		sub.right_tree = st2;
		st1.left_tree = sub;

		if(sub.right_tree == null) 
			sub.right_h = 0;

		else if (sub.right_tree.left_h > sub.right_tree.right_h)
			sub.right_h = sub.right_tree.left_h + 1;
		else
			sub.right_h = sub.right_tree.right_h + 1;

		if (st1.left_tree.left_h > st1.left_tree.right_h)
			st1.left_h = sub.left_tree.left_h + 1;
		else
			st1.left_h = st1.left_tree.right_h + 1;
		
		return st1;
	}

	public AVLNode<T> right_rotation(AVLNode<T> sub){

		AVLNode<T> st1 = sub.left_tree;
		AVLNode<T> st2 = st1.right_tree;
		sub.left_tree = st2;
		st1.right_tree = sub;

		if ( sub.left_tree == null)
			sub.left_h = 0;
		
		else if (sub.left_tree.left_h > sub.left_tree.right_h)
			sub.left_h = sub.left_tree.left_h + 1;
		else
			sub.left_h = sub.left_tree.left_h + 1;
		
		if (st1.right_tree.left_h > st1.right_tree.right_h)
			sub.right_h = st1.right_tree.left_h + 1;
		else
			st1.right_h = st1.right_tree.right_h + 1;

		return sub;

	}
}
