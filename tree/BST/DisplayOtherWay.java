
public class DisplayOtherWay {
    public void displayByParentNode(InsertInBst.Node currentNode) {
        while (currentNode != null) {
            System.out.print("  \t " + currentNode.data);
            currentNode = currentNode.parent;
        }
    }
}