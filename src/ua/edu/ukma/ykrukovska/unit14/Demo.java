package ua.edu.ukma.ykrukovska.unit14;

public class Demo {

    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");

        linkedList.delete("first");

        System.out.println(linkedList.size());
        System.out.println(linkedList.contains("first"));
        System.out.println(linkedList.contains("third"));

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(4));
    }

}
