---
title: Project 2
parent: Projects
---
<script>
MathJax = {
  tex: {
    inlineMath: [['$', '$'], ['\\(', '\\)']]
  },
  svg: {
    fontCache: 'global'
  }
};
</script>
<script type="text/javascript" id="MathJax-script" async
  src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-svg.js">
</script>


# CS 241 Project 2: Rotating ArrayLists
{: .no_toc }

1. TOC
{:toc}

**Reminder:** Everything in this project must be your own work.  If you include any code that was not invented by you, you must give a citation for 
it.


## Getting started

- Download the starter code [here](rotating-starter.zip).
- Make a new Intellij project. Then copy the contents of this  `src`  folder exactly into the  `src`  folder in the new project.

## Introduction
We recently explored the List ADT and developed our own implementation backed by a Java array, called `RArrayList`.  In this project, you will develop a similar 
implementation called `RotatingArrayList` that contains some additional functionality.  In particular, the List we develop in this project will have the ability to be 
*rotated*.

A rotation of a list refers to shifting all the elements of a list one spot either to the right or to the left, and the element that is shifted off the end is "rotated" back 
to the other side.  There are two types of rotations, a left rotation and a right rotation, as illustrated here:

```
Suppose we have an array like this:

 [0]  [1]  [2]  [3]
---------------------
| 10 | 20 | 30 | 40 |
---------------------

A "right rotation" would shift the elements like this:

 [0]  [1]  [2]  [3]
---------------------
| 40 | 10 | 20 | 30 |
---------------------

A "left rotation" (of the original array) would
shift the elements like this:

 [0]  [1]  [2]  [3]
---------------------
| 20 | 30 | 40 | 10 |
---------------------
```
Array rotations are useful in many contexts, however, manually shifting all the elements would take $O(n)$ time, because we have to traverse the entire array.  For this 
project, we will explore an implementation that allows us to perform this rotation in $O(1)$ time.

The key to implementing rotations in constant time is we will allow the first and last elements of the array --- from the user's perspective --- to not necessarily be stored 
in the first and last indices of the actual array.  We will do this by maintaining, for each array, a separate variable called its "offset."  **The offset of an array is an 
integer that tells us which index in the array holds the actual first element of the array.**  This is more easily explained with a picture.

Suppose we have the following situation:

```
PROGRAMMER'S PERSPECTIVE:           |  USER'S PERSPECTIVE:
                                    |
 [0]  [1]  [2]  [3]                 |  [0]  [1]  [2]  [3]   
---------------------               | ---------------------  
| 10 | 20 | 30 | 40 |   offset=0    | | 10 | 20 | 30 | 40 |
---------------------               | --------------------- 
```
In this situation, everything is "normal."  Because the offset is zero, this means the first element of the array is at index 0, as usual.  The programmer of the class and 
the user of the class "see" the same list.

But suppose we change the offset of the array:
```
PROGRAMMER'S PERSPECTIVE:           |  USER'S PERSPECTIVE:
                                    |
 [0]  [1]  [2]  [3]                 |  [0]  [1]  [2]  [3]   
---------------------               | ---------------------  
| 10 | 20 | 30 | 40 |   offset=1    | | 20 | 30 | 40 | 10 |
---------------------               | --------------------- 
```
This configuration, with an offset of 1 but the same array contents, implies that while the contents of the array have not changed from the programmer's perspective, the 
user will "see" the list on the right.  In other words, when the user asks for the element at index [0], they will see 20, not 10, because the offset variable tells being 1 
tells the programmer that user's index [0] will be stored at the programmer's index [1].  Similarly, if offset were set to 2, the user would see the 30 at index [0].  

**How is this accomplished?** This is done by changing the way any method that accesses a specific index of the list works -- from the user's perspective, this is only get() 
and set().  When a user asks for the element at a specific index in the array, the code will take the offset into account and will adjust the index to compensate.  For 
instance, if the offset is 1, and the user asks for the element at index 1, the actual element at index 2 would be returned.  Just like the LargeInt class presents a 
different "view" of a class than the implementation is actually storing (digits in reverse vs normal order), our RotatingArrayList class allows the user to "view" the 
underlying array as having a different order of elements than it actually does.

**What does this have to do with rotation?** To rotate an array that maintains this offset variable, we do not have to shift any elements.  We can simply adjust the offset 
up or down by one number.  This takes constant time, and from the user's perspective, all of the elements in the array have moved one position to the left or right.

## A look at the code

-   `RotatingArrayList.java`: This is where you will write your RotatingArrayList class.
-   `RotatingArrayListTester.java`: This is where you will write test cases for your RotatingArrayList class. You will notice the  `main()`  method is just a bunch of calls 
to other testing functions, all commented out. You will write these functions later, and you can comment/uncomment the calls as you complete the project.
-   `CardGame.java`: This is where you will write your final demonstration of the RotatingArrayList class.

## What is the `<E>` thing?
Notice the beginning of the RotatingArrayList class is now:

`public class RotatingArrayList<E>` 

What this  `<E>`  represents is that when we use  `RotatingArrayList`  in practice, we must fill in that  `E`  with a Java class name. You will probably recognize this idea 
from using normal Java  `ArrayList`s: you write  `ArrayList<Integer> numbers = new ArrayList<Integer>()`  to make a new list of  `Integer`s, and  `ArrayList<Double> numbers 
= new ArrayList<Double>()`  to make a new list of  `Double`s, etc. Our  `RotatingArrayList`  class, in order to allow our lists to hold objects of any type, will be 
parameterized similarly.

All you need to remember is that  `<E>`  stands for  **the type of object stored in this list**. Otherwise you can use  `E`  as a regular class name throughout your code 
(with a few caveats that won't factor into this project that much.) 

## Part A: Writing the RotatingArrayList class

### Instance variables
- `E[] data`: this is the data array that holds the underlying elements of the list.  It will often (but not always) have extra slots in it that are available when 
appending/prepending.  Note that because of the offset, these extra slots will not always be at the far right end of the list anymore.
- `int size`: the size of the list from the user's perspective
- `int offset`: the offset is the index in the `data[]` array that holds -- from the user's perspective -- index 0.  The offset should always be between 0 and size-1.  
	- Note: it will be tempting at times to let the offset become negative.  For example, using an offset of -1 mathematically means the same thing as an offset of 
size-1.  However, it will make your code more complicated to allow for negative offsets, so make sure the offset is always between 0 and size-1 (inclusive).  This allows for 
any item of the underlying data array to be the "first" element in the array. 

You will need to fill in a number of methods in the RotatingArrayList class.  All the instance variables you need have already been added (data, size, offset).  
Additionally, a working default constructor and expand have already been added.

### Methods
Here are the methods you must write, along with their running times that you must
stick to.

- toString() - $O(n)$: This will be very similar to the RArrayList toString(), except it must take offset into account.
- size()/get()/set() - $O(1)$: Each of these will be very similar to the RArrayList versions, except they must take offset into account.
- rotateLeft()/rotateRight() - $O(1)$: You can write these by modifying the offset variable.  Do not let offset become negative or get larger than size-1.
- equals() - $O(n)$: Similar to RArrayList's version, but you must take offset into account, because you can have two RotatingArrayLists that are equal from the user's 
perspective, but the data[] arrays are different.
- append()/prepend()/removeFirst()/removeLast - $O(n)$: This where you will spend most of your time on the project.  append/prepend are slightly more complicated than in 
RArrayList because if the offset is in the middle of the data array, you may only need to shift *some* of the elements in the array, not all.  removeFirst and removeLast, as 
well, might require only shifting some of the array.
	- **You must plan out (at least) one of append/prepend and one of removeFirst/removeLast on paper with diagrams and/or pseudocode ahead of time.  This will be turned 
in at the end.**

**Optional, but highly suggested:** You will probably find it very handy to have a method called toStringDebug() or something similar that prints out the entire contents of 
the data[] array, and the current values of size and offset.

### Testing
As you finish each method or group of methods, you should test them thoroughly in RotatingArrayListTester.  I suggest writing individual testing methods like in Project 1.

## Part B: Writing CardGame
After you are 100% sure the RotatingArrayList works, you will write a simple game to demonstrate its use.  The game works like this.  Imagine you are dealt a list of cards, 
in shuffled order, labeled with the numbers 1 to $n$ (for some positive number $n$, I'll use 5 as an example here):

```
[ 2 3 1 5 4 ]
```
The object of the game is to adjust the list of cards so they are in ascending order from 1 to 5.  The only operations you can do are rotate the list to the left or right, 
remove the first or last card from the list (holding it in your hand), and put the card in your hand back in the first or last position.  These operations mirror six of the 
methods from earlier.

For instance, with the cards above, I can first rotate the list left twice to get
```
[ 1 5 4 2 3 ]
```
then I can remove the 1 from the list.  
```
[ 5 4 2 3 ]
```
Now I can rotate the list twice to the right
```
[ 2 3 5 4 ]
```
and add the 1 back at the front.
```
[ 1 2 3 5 4 ]
```
Notice how the list is now almost sorted! We just have to get the 5 and 4 at the end to switch, which is not hard.

### Parts of the game
The game should work by:
- Asking the user how many cards they want to play with (any positive integer $n>1$).
- Deal them that many cards in a random order.
	- You should do this by creating a RotatingArrayList containing the numbers 1 to $n$ in sorted order, and then shuffling them using the [Fisher-Yates 
shuffle](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle).
	- Pseudocode:
	```
	Assume we have a list of size n, with indices 0 to n-1.
	for i from 0 to n−2 (inclusive):
           j <- a random integer such that i <= j < n
           swap list[i] and list[j]
	```
	- You can get a random number j that satisfies the inequality above in Java by doing `int j = ThreadLocalRandom.current().nextInt(i, n);`
	- For each turn in the game:
		- Print the list of cards and the card being held in the user's hand (if any).
		- Let them choose one of the six options (see above).
		- Run the user's choice.
	- The game should automatically stop when the list has been put in sorted order.  You should use the `equals()` method to check for sorted order (generate a second 
RotatingArrayList with the numbers 1 to $n$ in sorted order and compare it against the one in the game). 

## Output
Your output from the card game does not have to match mine exactly, but here are some sample runs: 	[Run 1](run1.txt) | [Run 2](run2.txt)

## At the end of the project

-   As you are preparing to submit the project, please prepare a text file (`.txt`, pdf, or Word doc is fine) answering the following questions:
    1.  What bugs and conceptual difficulties did you encounter? How did you overcome them? What did you learn?
    2.  Describe whatever help (if any) that you received. Don’t include readings, lectures, and exercises, but do include any help from other sources, such as websites or 
people (including classmates and friends) and attribute them by name.
    3.  Describe any serious problems you encountered while writing the program.
    4.  Did you do any of the challenges (see below)? If so, explain what you did.
    5.  List any other feedback you have. Feel free to provide any feedback on how much you learned from doing the assignment, and whether you enjoyed doing it.
-   Please also add a comment at the top of your program stating your name and a pledge that you have followed the honor code and collaboration policy for this project. This 
can be as simple as writing “**I have neither given nor received unauthorized aid on this program.**” You can find the collaboration policy on the syllabus.
-   Remember, projects will be graded not only on correctness, but also appropriateness and efficiency of the algorithms you choose, and on coding style.

## Grading

This project will be graded on the correctness of the output, efficiency of the algorithms, and on coding style, including comments.

## Challenge Problems

-   Add other (non-trivial) methods to the RotatingArrayList class, like adding/prepending multiple items at once.  
-   Make the card game more sophisticated in some way.  For instance, change the card in your hand into a separate RotatingArrayList and allow the user to add multiple items 
to it.

## Submitting

To submit, upload all of your  `.java`  files to canvas, along with your answers to the post-project questions, and your pseudocode/pictures/notes for how you constructed 
the algorithms. This doesn’t have to be formal, and if you just have notes on a page, you can turn in photos.
