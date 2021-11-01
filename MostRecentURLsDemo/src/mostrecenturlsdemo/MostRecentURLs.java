/*
 * A class to store the n most recently visited URLs
 */
package mostrecenturlsdemo;

import java.util.LinkedList;

public class MostRecentURLs {
	private int maxCt;
	LinkedList<String> urlList;
	
	// construct an object from the class MostRecentURLs
	// and initialize it with the maximum number of URLs
	// to store
	public MostRecentURLs( int maxCt ) {
		//throw new NotImplementedException();
                this.maxCt = maxCt;
		urlList = new LinkedList<String>();
	}
	
	// return the URL stored at the position specified
	// by the parameter, index
	public String get( int index ) {
		//throw new NotImplementedException();
                return urlList.get(index);
	}
	
	// add a new URL to the head of the list
	public void push( String url ) {
		//throw new NotImplementedException();
            //    remove();
                urlList.addFirst(url);
	}
	
	// remove the URL at the head of the list
	public String pop() {
		return urlList.pop();
	}

	
	//private String remove() {
		//throw new NotImplementedException();	
             //   return urlList.removeLast();

	// remove the URL stored at the position specified
	// by index from the list and return it to the caller
	//public String remove( int index ) {
	//	return urlList.remove( index );
	//}
	
	// return a string representation of the list of URLs
	//@Override
	//public String toString() {
		//throw new NotImplementedException();
	//}
}
