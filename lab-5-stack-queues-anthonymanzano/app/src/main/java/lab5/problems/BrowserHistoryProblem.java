package lab5.problems;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import lab5.util.dataStructures.LinkedStack;
import lab5.util.interfaces.Stack;

public class BrowserHistoryProblem {
	/**
	 * TODO EXERCISE 1:
	 * 
	 * In your Internet browser (e.g. Google Chrome), you can use the "back" and "forward" arrows 
	 * to navigate through your browsing history.
	 * 
	 * Implement a non-member method called browserHistory(String[] clicks) that takes 
	 * a list of strings called clicks containing a mix of pages visited and back/forward arrow clicks, 
	 * and returns a list of the pages visited in order.
	 * 
	 * It may be helpful to open a new Google Chrome tab and experiment with using the backward and forward buttons.
	 * 
	 * Example: 
	 * Assume clicks = {"Google", "Facebook", "Instagram", "<", ">"}, 
	 * then a call to browserHistory(clicks) returns {"Google", "Facebook", "Instagram", "Facebook", "Instagram"} 
	 * because the user went backward to Facebook, then forward to Instagram.
	 * 
	 * Here are some additional edge cases to consider:
	 * 
	 * 1) The user may hit the back or forward buttons multiple times in a row.
	 * 2) If the user tries to click the "back" or "forward" arrow even though 
	 *    there is nowhere to go / it is greyed out, keep them on the same page without reloading the page.
	 * 3) The user might refresh the page / visit the same page multiple times in a row. 
	 *    Count these as a single visit.
	 * 4) The user might visit the same page multiple times, but not necessarily in a row. Consider these distinct.
	 * 
	 * Hint: Store the result and its values using an ArrayList<String> (import from java.util) as you 
	 * make your solution and return them as an array of strings using result.toArray(new String[result.size()])
	 * 
	 * WARNING: You MUST use a stack, implementations that use indices (or pointers) will receive ZERO credit.
	 * 
	 * @param clicks - Array of strings denoting the web pages and clicks user made in their browser
	 * @return The Array of strings with clicks made with the forward and back buttons replaced with 
	 * 		   the corresponding page
	 */
	public String[] browserHistory(String[] clicks) {
		/*TODO ADD YOUR CODE HERE*/
	      ArrayList<String> result =  new ArrayList<>();
	        LinkedStack<String> back = new LinkedStack<>();
	        LinkedStack<String>  foward = new LinkedStack<>();
	        LinkedStack<String> currstack = new LinkedStack<>();
	        String current = null;
	        
	
	        
	        for(String page : clicks) {
	        	if( page == "<" && !back.isEmpty()) {
	        		foward.push(currstack.pop());
	        		currstack.push(back.pop());
	        		current = currstack.top();
	        		result.add(current);
	        	}else if( page == ">" && !foward.isEmpty()) {
	        		back.push(currstack.pop());
	        		currstack.push(foward.pop());
	        		current = currstack.top();
	        		result.add(current);
	        	}else if( page == "<" && back.isEmpty()) {
	        		continue;
	        	}else if( page == ">" && foward.isEmpty()) {
	        		continue;

	        	}
	        	else {
	        		if(current != page) {
	        			if(currstack.isEmpty()) {
	        				currstack.push(page);
	        				result.add(page);
	        				current = page;
	        				
	        			}else {
	        		back.push(currstack.pop());
	        		currstack.push(page);
	        		result.add(page);
	        		current = page;
	        		foward.clear();
	        			}
	        	}
	        	
	        }
	            
	    }
	        return result.toArray(new String[result.size()]); // Dummy Return
	}
}