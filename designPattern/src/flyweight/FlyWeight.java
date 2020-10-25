package flyweight;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 */
public class FlyWeight {//相同的对象只会创建一次
    TreeNode treeNode1 = new TreeNode(3, 4, TreeFactory.getTree("xxx", "xxxxxxxxx"));
    TreeNode treeNode2 = new TreeNode(0, 1, TreeFactory.getTree("xxx", "xxxxxxxxx"));
}

//场景: 一个游戏地图上有很多树, 但是树只有几种, 这个时候不需要把所有的树都new出来, 只需要将这几种树new出来就可以了

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }
 }
class Tree {
    private final String name;//定义成final类型, 保证多线程环境下的线程安全
    private final String data;

    Tree(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }



    public String getData() {
        return data;
    }


}

class TreeNode {
    private  int x;//树在地图上的横坐标
    private  int y;//树在地图上的纵坐标
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
