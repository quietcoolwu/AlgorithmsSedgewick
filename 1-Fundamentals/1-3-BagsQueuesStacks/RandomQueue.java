/**
 * Created by William on 2015/7/12.
 */

/*
 * Solution of exercise 1.3.35 and 1.3.36 in
 * Sedgewick and Wayne: Algorithms 4th edition
 */

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

import java.util.Iterator;

public class RandomQueue<T> implements Iterable<T> {

    int capacity = 1;
    int size = 0;
    T[] array = (T[]) new Object[capacity];

    public static void main(String[] args) {
        RandomQueue<Double> q = new RandomQueue<>();
        while (!StdIn.isEmpty())
            q.enqueue(StdIn.readDouble());


        StdOut.println("ITERATOR:");
        for (Double i : q)
            StdOut.println(i);

        StdOut.println("DEQUEUE:");
        while (!q.isEmpty())
            StdOut.println(q.dequeue());

    }

    public void enqueue(T item) {
        if (size == capacity)
            resize(2 * capacity);

        array[size] = item;
        size += 1;
    }

    public T dequeue() {
        if (isEmpty())
            return null;

        int index = StdRandom.uniform(size); // Choose random index
        T output = array[index]; // Choose the corresponding element

        array[index] = array[size - 1]; // replace
        array[size - 1] = null; // to let gc do its job

        size -= 1;
        return output;
    }

    public T sample() {
        if (isEmpty())
            return null;
        return array[StdRandom.uniform(size)];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newArray[i] = array[i];

        array = newArray;
        capacity = newCapacity;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        RandomQueue<T> itq; // We use a random queue to implement the iterator :)

        Itr() {
            itq = new RandomQueue<T>();
            for (int i = 0; i < size; i++)
                itq.enqueue(array[i]);
        }

        public boolean hasNext() {
            return !itq.isEmpty();
        }

        public T next() {
            return itq.dequeue();
        }

        public void remove() {
            throw new UnsupportedOperationException("ArrayStack.Itr.remove");
        }
    }
}
