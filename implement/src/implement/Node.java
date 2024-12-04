package implement;

public class Node {
    int x, y;
    int cost;
    Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.cost = 0;
        this.parent = null;
    }
}
