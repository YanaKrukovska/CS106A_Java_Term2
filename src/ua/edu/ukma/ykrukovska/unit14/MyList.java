package ua.edu.ukma.ykrukovska.unit14;

public interface MyList<T> {


   void add(T e);
   void delete(T e);
   T get(int i);
   boolean contains(T e);
   int size();

}
