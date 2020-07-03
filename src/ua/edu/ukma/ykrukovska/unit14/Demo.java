package ua.edu.ukma.ykrukovska.unit14;

public class Demo {

    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyLinkedList<Integer> linkedListInt = new MyLinkedList<>();

        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");

        linkedListInt.add(3);
        linkedListInt.add(8);
        linkedListInt.add(-5);
        linkedListInt.add(99);
        linkedListInt.add(1);

        linkedList.delete("first");
        System.out.println("Size: " + linkedList.size());
        System.out.println("Contains: " + linkedList.contains("first"));
        System.out.println("Contains: " + linkedList.contains("third"));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(4));
        System.out.println();

        System.out.println("Size: " + linkedListInt.size());
        System.out.println("Contains: " + linkedListInt.contains(2));
        System.out.println("Contains: " + linkedListInt.contains(1));
        System.out.println(linkedListInt.get(0));
        System.out.println(linkedListInt.get(4));
    }

}
