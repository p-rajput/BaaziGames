import java.util.LinkedList;

/**
 * Q4 Design and implement a producer consumer model using threads and basic data structures. (1-producer, 1-consumer model).
 */

public class ProducerAndConsumer {
    public static void main(String[] args) {
        // Create a LinkedList to act as the shared queue between producer and consumer
        LinkedList<Integer> queue = new LinkedList<>();
        // Set the capacity of the queue
        int capacity = 5;
        // Create a producer and consumer instance, passing in the queue and capacity
        Producer producer = new Producer(queue, capacity);
        Consumer consumer = new Consumer(queue);
        // Create threads for the producer and consumer, passing in the instances
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        // Start the threads
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    // The shared queue
    private final LinkedList<Integer> queue;
    // The maximum capacity of the queue
    private final int capacity;
    // The current value to be produced
    private int value = 0;

    public Producer(LinkedList<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // If the queue is full, wait until notified by the consumer
                while (queue.size() == capacity) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Add the value to the queue and print a message indicating that it has been produced
                queue.add(value);
                System.out.println("Produced " + value);
                // Increment the value for the next iteration
                value++;
                // Notify the consumer that a new value has been added to the queue
                queue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {
    // The shared queue
    private final LinkedList<Integer> queue;

    public Consumer(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // If the queue is empty, wait until notified by the producer
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Remove the first value from the queue and print a message indicating that it has been consumed
                int value = queue.removeFirst();
                System.out.println("Consumed " + value);
                // Notify the producer that a value has been consumed from the queue
                queue.notifyAll();
            }
        }
    }
}
