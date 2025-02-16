COMP 313/413 Project 2 Report (ANSWERS)
O
TODO also try with a LinkedList-does it make any difference ?

Answer : Yes, switching between Arraylist and Linkedlist can alter behaviour and performance, but method fuctionality remains unchanged as 	both implements the list interface.

TestList.java and TestIterator.java

TestList.java

	testRemoveObject()

		list.remove(5); // what does this method do?

			 Answer : It will not remove the number 5 from the list if it exists as a value. Instead, it removes the element at 
                                  the position of index 5.

		list.remove(Integer.valueOf(5)); // what does this one do?

			Answer : The first occurrence of the value 5 from the list, not by index, but by its actual value.

TestIterator.java

	testRemove()

		i.remove(); // what happens if you use list.remove(77)?

	    Answer : By using an iterator (i.remove()), it will remove the element returned by i.next().
            Whereas, If we use list.remove(77) to remove the first occurrence of a specific value (77),
            we would check for that value in the iterator loop and use i.remove() to remove it.

TestPerformance.java

	State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
	to get the running time in milliseconds and how the test running times were recorded.

	Answer : I have executed the test 6 times for each size (10, 100, 1000 and 10000)
	         to get the running time in ms and I have recorded it separately.

	These are examples of SIZEs you might choose, you can choose others if you wish.

	SIZE 10
				     #1         #2               #3         #4              #5   			 
        testLinkedListAddRemove:  42.276542    19.89575     17.102083    17.624667      20.302875      ... (fill these in in ms)
        testArrayListAddRemove:   21.226375    19.898       18.823625    19.077625      18.8145
	testLinkedListAccess :    6.829875     6.887        6.917        7.647          7.052416
        testArrayListAccess :     1.507833     4.29925      4.729625     4.27625        5.777083

	SIZE 100
				     #1         #2               #3         #4              #5     
        testLinkedListAddRemove :  10.810667   11.666417     13.431        14.387625     13.002208          ... (fill these in in ms)
        testArrayListAddRemove  :  27.271167   26.954125     26.937791     28.100125     26.055834
	testLinkedListAccess :     5.054375    5.121375      5.46175       5.6295        5.486875
        testArrayListAccess  :     1.740167    1.650542      1.76275       1.675625      1.777083

	SIZE 1000
				      #1            #2           #3          #4                #5    	  
       testLinkedListAddRemove :  7.8818333   13.331458       10.577208      10.5506083      9.957625      ... (fill these in in ms)
       testArrayListAddRemove :   180.11083   176.340125      179.72025      175.422416      176.895583
       testLinkedListAccess :     2.85666     2.858208        3.197125       2.588041        2.630416
       testArrayListAccess :      1.642667    1.594041        1.589875       1.591459        1.611667

	SIZE 10000
				     #1       #2                  #3         #4                 #5         
       testLinkedListAddRemove :  6.02625    7.108417      9.00125       8.895833         7.905583          ... (fill these in in ms)
       testArrayListAddRemove:    1628.649   1611.436458   1615.70598    1619.706625      1619.677209
       testLinkedListAccess :     2.881834   2.8865        3.1438        2.535417         2.640417
       testArrayListAccess:       1.639958   1.59525       1.598375      1.597333         1.614125

	listAccess - which type of List is better to use, and why?

		Answer : ArrayList is faster for Access operations, consistently performing better than LinkedList. This is because 				ArrayList provides constant-time access due to its contiguous memory structure.
                        LinkedList shows significantly slower access times, especially as the size increases, because it requires 
                        traveral of the list for access.
                        Therefore, ArrayList is more efficient for Access operations, providing faster element retrieval, especially as the 
                        size grows.

	listAddRemove - which type of List is better to use, and why?

		Answer: LinkedList performs better for Add/Remove operations, especially as the size increases. The time decreases as the 
                        size increases, indicating that LinkedList is efficient for dynamic insertions and deletions.
                        ArrayList shows an increase in Add/Remove time as size grows, especially noticeable at larger sizes (1000 and 10000).
                        Therefore , LinkedList is more efficient for Add/Remove operations, especially when frequent modifications are                               required.
