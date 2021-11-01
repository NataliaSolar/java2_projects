package hashing;

/**
 *
 * @author Thomas.Abbott
 */
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChainingHashTable ht = new ChainingHashTable(10);
        //LinearProbingHashTable ht = new LinearProbingHashTable(10);
        
        Item[] items = {
            new Item(57, "Tom"),
            new Item(7, "Noah"),
            new Item(3, "Gislaine"),
            new Item(22, "Marten"),
            new Item(359, "Michael")
        };

        for (int i = 0; i < items.length; i++) {
            ht.HashInsert(items[i]);
        }

        //ht.HashRemove(items[2]);
        //ht.HashRemove(7);
        System.out.println(ht);
    }
}
