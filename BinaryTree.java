import java.util.*;

public class BinaryTree {
    int value;
    BinaryTree lchild;
    BinaryTree rchild;


    BinaryTree(int value) {
        this.value = value;
        lchild = null;
        rchild = null;
    }

    BinaryTree(int[] values) {
        this.value = values[0];
        for (int i = 1; i < values.length; i++) {
            insertNode(this, values[i]);
        }
    }


    public void insertNode(BinaryTree node, int[] values) {
        for (int value : values) {
            insertNode(node, value);
        }
    }

    public BinaryTree insertNode(BinaryTree node, int nvalue) {
        if (node == null) {
            return node = new BinaryTree(nvalue);
        } else if (nvalue > node.value) {
            if (node.rchild == null) {
                return node.rchild = new BinaryTree(nvalue);
            } else {
                return insertNode(node.rchild, nvalue);
            }
        } else if (nvalue < node.value) {
            if (node.lchild == null) {
                return node.lchild = new BinaryTree(nvalue);
            } else {
                return insertNode(node.lchild, nvalue);
            }
        } else {
            return null;
        }
    }

    public void print(BinaryTree node, String indent) {
        if (node.rchild != null) {
            print(node.rchild, indent + "  ");
        }

        System.out.println(indent + node.value);

        if (node.lchild != null) {
            print(node.lchild, indent + "  ");
        }
    }

    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree(new int[]{10, 25, 20, 6, 4, 8, 50, 30, 6});
//        tree.print(tree, "");
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        for (int i: new int[] {3, 2, 5, 1, 9, 4, 3}){
//            treeSet.add(i);
//        }
//        System.out.println(treeSet);


        //Создание пустого дерева
        TreeSet<String> tree = new TreeSet<String>();

        //Добавление элементов
        tree.add("abc");
        tree.add("aba");

        //Элементы выводятся в сортированном (лексикографическом) порядке
        //Классы должны быть Comparable
        System.out.println("===== Tree =====");
        for (String s : tree) {
            System.out.println(s);
        }
        System.out.println();

        //Удаление элементов
        System.out.println(tree.remove("aaa"));
        //удаление несуществующего элемента возвращает False
        System.out.println(tree.remove("abc"));

        System.out.println("===== Tree =====");
        for (String s : tree) {
            System.out.println(s);
        }
        System.out.println();

        tree.add("zzz");
        tree.add("xyz");
        tree.add("zca");

        //Быстрая проверка наличия элемента
        System.out.println(tree.contains("xyz") + " " + tree.contains("aab"));

        // Выводит наименьший элемент, больший или равный указанного
        System.out.println("ceiling = " + tree.ceiling("zyb"));
        System.out.println(tree.ceiling("zzzz")); //null если нет такого элемента

        //Выводит наибольший, элемент меньший или равный указанного
        System.out.println("floor = " + tree.floor("zyb"));
        System.out.println(tree.floor("a")); //null если нет такого элемента

        System.out.println("===== Subtree =====");
        //Взятие подмножества элементов >= zaa и < zzzz
        SortedSet<String> subtree = tree.subSet("zaa", "zzzz");
        for (String s : subtree) {
            System.out.println(s);
        }
        System.out.println();
    }
}
/*
public class bt {
    public static void main(String[] args) {
        BinaryTree_withRoot bt = new BinaryTree_withRoot();
        bt.add(new int[] {10, 25, 20, 6, 4, 8, 50, 30, 6});
        bt.print(bt.root, "");
    }
}


class BinaryTree_withRoot {
    Node root = null;
    void print(Node root, String indent) {
        if (root.right != null) {
            print(root.right, indent + "  ");
        }
        System.out.println(indent + root.data);
        if (root.left != null) {
            print(root.left, indent + "  ");
        }
    }

    Node add(int ndata){
        if (root == null){
            return root = new Node(ndata);
        }
        else{
            return root.add(ndata);
        }
    }
    void add(int[] ndata){
        for (int elem: ndata){
            add(elem);
        }
    }
}


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    Node addRight(int data) {
        if (right == null) {
            right = new Node(data);
            return right;
        }
        return null;
    }

    Node addLeft(int data) {
        if (left == null) {
            left = new Node(data);
            return left;
        }
        return null;
    }

    Node add(int ndata) {
        if (ndata < data) {
            if (left == null){
                return addLeft(ndata);
            }
            return left.add(ndata);
        } else if (ndata > data) {
            if (right == null){
                return addRight(ndata);
            }
            return right.add(ndata);
        } else {
            return null;
        }
    }

}


 */