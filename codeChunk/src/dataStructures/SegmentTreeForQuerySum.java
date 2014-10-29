 

/**
 *
 * @author DELL
 */
public class SegmentTreeForQuerySum {
    public static void main(String[] args) {
         long[] s = new long[10];
         SegmentTree st = new SegmentTree(s);
    }
}
class SegmentTree {
    Node root;
    
    class Node {
	public Node left;
	public Node right;
        public int start;
        public int end;
        public Node parent;
	public long value;
        
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
	Node(long value, int start, int end) {
            this.value = value;
            this.start = start;
            this.end = end;
	}
    }
    
    SegmentTree(long[] values){
        root = create(0, values.length, values, root);
    }
    
    final Node create(int start, int end, long[] values, Node parent){
        if((end - start) == 1){
            return new Node(values[start],start,end-1);
        }
        long l=0, r=0;
        Node node = new Node(start,end-1);
        int mid = (end-start)/2+start;
        node.left = create(start,mid,values,node);
        node.right = create(mid,end,values,node);
        if(node.left != null)
            l = node.left.value;
        if(node.right != null)
            r = node.right.value;
        node.value = l + r;
        return node;
    }
    
    long querySum(int start, int end){
        return querySum(start,end,root);
    }
    long querySum(int start, int end, Node node){
        if(node.start >= start && node.end <= end){
            return node.value;
        }
        long sum = 0;
        int mid = ((node.end+1) - node.start)/2 + node.start;
        if(node.start <= start && node.end >= start){
            if(mid <= end)
                sum += querySum(start, end, node.right);
            if(mid > start)
                sum += querySum(start, end, node.left);
        }
        else if(node.start <= end && node.end >= end){
            if(mid > start)
                sum += querySum(start, end, node.left);
            if(mid <= end)
                sum += querySum(start, end, node.right);
        }
        return sum;
    }
    
    void update(int index, long value){
        update(index, value, root);
    }
    void update(int index, long value, Node node){
        int mid = ((node.end+1) - node.start)/2 + node.start;
        if(node.start <= index && node.end >= index){
            node.value += value;
            if(node.start == node.end){
                return;
            }
            if(mid > index)
                update(index, value, node.left);
            else
                update(index, value, node.right);
        }
    }
}