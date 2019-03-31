package ua.edu.ukma.ykrukovska.unit11.homework;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;

public class FileTreeFrame extends JFrame {
    private final JScrollPane treePane;
    private JTree fileTree;
    private FileSystemModel fileSystemModel;


    public FileTreeFrame(String directory) {
        super("FileSystem Viewer");
        getContentPane().setLayout(null);


        fileSystemModel = new FileSystemModel(new File(directory));
        fileTree = new JTree(fileSystemModel);
        fileTree.setEditable(true);

        treePane = new JScrollPane(fileTree);
        treePane.setBounds(0, 50, 640, 380);
        getContentPane().add(treePane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    public static void main(String args[]) {
        new FileTreeFrame("c:\\");
    }
}

class FileSystemModel implements TreeModel {
    private Object root;

    public FileSystemModel(Object rootDirectory) {
        root = rootDirectory;
    }

    public Object getRoot() {
        return root;
    }

    public Object getChild(Object parent, int index) {

        File directory = (File) parent;
        String[] children = directory.list();

        return new TreeFile(directory, children[index]);
    }

    public int getChildCount(Object parent) {
        File file = (File) parent;
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null)
                return file.list().length;
        }
        return 0;
    }

    public boolean isLeaf(Object node) {
        File file = (File) node;
        return file.isFile();
    }

    public int getIndexOfChild(Object parent, Object child) {
        File directory = (File) parent;
        File file = (File) child;
        String[] children = directory.list();
        for (int i = 0; i < children.length; i++) {
            if (file.getName().equals(children[i])) {
                return i;
            }
        }
        return -1;

    }

    public void valueForPathChanged(TreePath path, Object value) {
    }

    public void addTreeModelListener(TreeModelListener listener) {
    }

    public void removeTreeModelListener(TreeModelListener listener) {
    }

    private class TreeFile extends File {
        public TreeFile(File parent, String child) {
            super(parent, child);
        }

        public String toString() {
            return getName();
        }
    }
}
