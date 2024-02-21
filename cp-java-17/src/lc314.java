
import java.io.*;
import java.util.*;

class Solution {
    static class Message {
        int pos;
        TreeNode node;
        Message(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Deque<Message> queue = new LinkedList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        queue.addLast(new Message(root, 0));
        while(!queue.isEmpty()){
            Message m = queue.removeFirst();
            minCol = Math.min(minCol, m.pos);
            maxCol = Math.max(maxCol, m.pos);
            if (m.node.left != null){
                queue.addLast(new Message(m.node.left, m.pos-1));
            }
            if (m.node.right != null){
                queue.addLast(new Message(m.node.right, m.pos+1));
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for(int i = minCol; i <= maxCol; ++i)
            result.add(map.get(i));
        return result;
    }
}
