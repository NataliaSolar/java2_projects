
package hashing;

/**
 *
 * @author Thomas.Abbott
 */
public class Item {
    private int key;
    private String name;
    
    public Item( int key, String name ) {
        this.key = key;
        this.name = name;
    }

    public int getKey() { return key; }
    public String getString() { return name; }
    public String toString() { return name; }
}
