package updateblequeue;

public class Main {

    public static void main(String[] args) {
        final UpdatableQueue queue = new UpdatableQueue(5);

        new Thread(){
            @Override
            public void run() {
                queue.addQueueItem(10, "Content first of 10 id item");
                queue.addQueueItem(1, "Content first of 1 id item");
                queue.addQueueItem(10, "Content second of 10 id item");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.addQueueItem(130, 1000);
                queue.addQueueItem(1056, "Content first of 1056 id item");
                QueueItem item = queue.addQueueItem(10, "Content third of 10 id item");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                QueueItem item = queue.takeQueueItem(10);
                item = queue.takeQueueItem(130);
                item = queue.takeQueueItem(1);
            }
        }.start();

    }
}