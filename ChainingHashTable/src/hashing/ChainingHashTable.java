package hashing;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.LinkedList;
import java.util.List;



public class ChainingHashTable<T>  {

	
    ArrayList<SinglyLinkedList<Item>> hashTable;
    int hashTableSize;
    
    public ChainingHashTable(int tableSize) {
        hashTableSize = tableSize;
        hashTable = new ArrayList<SinglyLinkedList<Item>>(hashTableSize);        
        for( int i = 0; i < hashTableSize; i++ ) {
            hashTable.add(i, new SinglyLinkedList<Item>());
        }
    }

    public void HashInsert( Item nuItem ) {
        if( HashSearch(nuItem.getKey()) == null) {
            SinglyLinkedList<Item> bucketList = hashTable.get(hash(nuItem.getKey()));
            bucketList.add(nuItem);
        }
    }
    
    public void HashRemove( Item item ) {
        Item rmItem = HashSearch(item.getKey());
        if(rmItem != null ) {
            SinglyLinkedList<Item> bucketList = hashTable.get(hash(item.getKey()));
            bucketList.remove(rmItem);
        }
    }
    
    public void HashRemove( int key ) {
        Item rmItem = HashSearch(key);
        if(rmItem != null ) {
        	SinglyLinkedList<Item> bucketList = hashTable.get(hash(key));
            bucketList.remove(rmItem);
        }
    }

    
    public Item HashSearch(int srchKey){
    	
    	/*
    	int arrayIndexHash = srchKey % (hashTableSize-1);
    	
    	while(hashTable.get(arrayIndexHash) != null){
    		
    		if(hashTable.get(arrayIndexHash).equals(srchKey)){
    			
    			System.out.println(srchKey + " was Found in Index " + arrayIndexHash);
    			
    			return null;
    			
    		}
    		++arrayIndexHash;
    		arrayIndexHash %= hashTableSize;
    		
    	}
    	
    	
		return null;
        */
        SinglyLinkedList<Item> bucketList = hashTable.get(hash(srchKey));
    	//Iterator<SinglyLinkedList<Item>> it = ((List<SinglyLinkedList<Item>>) bucketList).iterator();
        Iterator<Item> it = bucketList.iterator();
        while(it.hasNext()) {
            Item nextItem = it.next();
            if(nextItem.getKey() == srchKey ) {
                return nextItem;
            }
        }
        return null;
    }
    	
    	
    	
 
    	/*
    	SinglyLinkedList<Item> bucketList = hashTable.get(hash(srchKey));
    	Iterator<SinglyLinkedList<Item>> it = ((List<SinglyLinkedList<Item>>) bucketList).iterator();
       // Iterator<Item> it = bucketList.iterator();
        while(it.hasNext()) {
            Item nextItem = it.next();
            if(nextItem.getKey() == srchKey ) {
                return nextItem;
            }
        }
        return null;
        */
    
   
   private int hash( int key ) {
       return key % hashTableSize;
   }
   
   public String toString() {
       StringBuilder sb = new StringBuilder();
       for( int i = 0; i < hashTableSize; i++ ) {
           sb.append( i );
           sb.append( ":"+ hashTable.get(i) + "\n" );
       }
       return sb.toString();
   }
}