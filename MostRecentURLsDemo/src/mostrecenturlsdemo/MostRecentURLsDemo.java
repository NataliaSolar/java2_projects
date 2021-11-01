/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrecenturlsdemo;

/**
 *
 * @author Natalia
 */
public class MostRecentURLsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MostRecentURLs mru = new MostRecentURLs( 5 );
		mru.push("seven");
		mru.push("six");
		mru.push("five");
		mru.push("four");
		mru.push("three");
		mru.push("two");
		mru.push("one");
		mru.push("zero");
		//String url0 = mru.pop();
		//String url1 = mru.pop();
		System.out.print("urls : ");
		System.out.println( mru );
    }
    
}
