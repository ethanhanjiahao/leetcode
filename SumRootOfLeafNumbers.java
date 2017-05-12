package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author HJH
 *
 */
public class SumRootOfLeafNumbers {

	List<Integer> list = new LinkedList<>(); // ��¼�����ӵĽ��
	// �������ṹ��ֵ����������������

	 static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void getPath(TreeNode root, Stack<Integer> stack) {
		stack.push(root.val);
		if (root.left == null && root.right == null) { // Ҷ�ӽڵ�
			StringBuffer sb = new StringBuffer();
			for (Integer integer : stack) {
				sb.append(integer);
			}
			list.add(Integer.parseInt(sb.toString()));
		}
		// ����������
		if (root.left != null) {
			getPath(root.left, stack);
		}
		// ����������
		if (root.right != null) {
			getPath(root.right, stack);
		}
		stack.pop();
	}

	// ��ȡ������Ӻ�
	public int sumNumbers(TreeNode root) {
		if (root!=null) {
			Stack<Integer> stack = new Stack<>();
			getPath(root, stack);
		}
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new SumRootOfLeafNumbers().sumNumbers(root));
	}

}
