/*
 * @author Matthew O'Neill (moneil13)
 * moneil13
 * @date 11/28/2018
 * @version Java JDK 10.0.2
 * 
 * Description: This program prompts the user with a menu of 5 options.  The user can calculate
 * 				the price of books, using either linear or binary search to find the items.
 * 				In the second part of the program, the user can choose to sort the elements
 * 				of an integer array of 10 randomly generated integers.  They can choose
 * 				between bubble sort or selection sort.
 * 
 * Pseudocode:
 * 
 * Main Function:
 * 		Initialize and declare arrays for book title, id, and price
 * 		While user does not choose to quit by entering 5:
 * 				Display Menu
 * 				Get user menu choice
 * 				Use switch statement to direct program
 * 					If 1:
 * 						Call getId() function, it returns a user-entered ID
 * 						Call getNumber() function, it returns the number of books
 * 							the user wants to buy
 * 						Call linearSearch() function to find a book of a particular array,
 * 							pass in the ID array and the user-chosen ID.  This returns the
 * 							index at which the book is found or -1 if not found.
 * 							If ID found in array, calculate and display book and total cost
 * 							else ID not found, display "not found " message
 * 					If 2:
 * 						Call getId() function, it returns a user-entered ID
 * 						Call getNumber() function, it returns the number of books
 * 							the user wants to buy
 * 						Call binarySearch() function to find a book of a particular array,
 * 							pass in the ID array and the user-chosen ID.  This returns the
 * 							index at which the book is found or -1 if not found.
 * 							If ID found in array, calculate and display book and total cost
 * 							else ID not found, display "not found " message
 * 					If 3:
 * 						Call generateRandomArray() function to generate a 10-element int array
 * 							of random numbers between 1 and 500
 * 						Call displayArray() function to display unsorted array
 * 						Call bubbleSort() function to sort array using bubble sort algorithm
 * 						Call displayArray() function to display sorted array
 * 					If 4:
 * 						Call generateRandomArray() function
 * 						Call displayArray() function to display unsorted array
 * 						Call selectionSort() function to sort array using selection sort algorithm
 * 						Call displayArray() function to display sorted array
 * 					If 5: Quit
 * 					If none of these, display "incorrect choice" message and prompt user again
 * 					Keep looping until user quits with an entry of 5
 * display Function
 * 		Takes in the 3 book arrays as parameters and prints them out in a tabular form
 * getId Function:
 * 		uses scanner to get integer from user and returns that ID integer
 * getNumber Function:
 * 		uses scanner to get int from user and returns the number
 * linearSearch Function:
 * 		Loop through each element
 * 		test if it is a match
 * 		return index of match or -1 if no match
 * binarySearch Function: 
 * 		Test middle element
 * 		If element greater than middle, test upper half of array
 * 		If element less than middle, test lower half of array
 * 		Return index of found element or -1 if not found
 * generateRandomArray Function:
 * 		Make empty array
 * 		Loop through each element, generate random number for each element
 * 		Return random array
 * bubbleSort Function:
 * 		Set flag
 * 		Loop through each element
 * 			If second element less than first, swap elements
 * 		Return sorted array
 * selectionSort Function:
 * 		Set minimum index
 * 		Loop through each element
 * 			If last index less than first index, swap elements
 * 		Return sorted array
 * displayArray Function:
 * 		Print out each element in array
 * 
 */
import java.util.Scanner;

public class Assignment3 {

	//Main Function directs program with menu
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userChoice = 0;
		//Declare book arrays
		String[] bookTitle = {"Starting out with Java", "Java Programming", "Software Structures", 
				"Design and Analysis of Algorithms", "Computer Graphics", "Artificial Intelligence: A Modern Approach", 
				"Probability and Statistics", "Cognitive Science", "Modern Information Retrieval", 
				"Speech and Language Processing"};
		
		int[] bookID = {1101, 1211, 1333, 1456, 1567, 1642, 1699, 1755, 1800, 1999};
		
		double[] bookPrice = {112.32, 73.25, 54.00, 67.32, 135.00, 173.22, 120.00, 42.25, 32.11, 123.75};
		//declare variables to be initialized later
		int id;
		int num;
		int index;
		int[] randArray = new int[10];
		
		//Use loop to keep running menu until user chooses to quit
		while(userChoice != 5) {
			//Display menu options
			System.out.println("1. Linear Search");
			System.out.println("2. Binary Search");
			System.out.println("3. Bubble Sort");
			System.out.println("4. Selection Sort");
			System.out.println("5. Quit");
			System.out.println("Please enter a number between 1-5:");
			userChoice = input.nextInt();
			
			//Use switch statement to direct menu options
			switch(userChoice) {
			
			case 1:
				System.out.println("Linear Search:");
				//Display book info in tabular furmula
				display(bookID, bookTitle, bookPrice);
				//Get id from user
				id = getID();
				//Get number from user
				num = getNumber();
				//Perform linear search on book ID array
				index = linearSearch(bookID, id);
				//If book found, display and calculate total cost
				if(index > 0) {
					System.out.println("You chose Book ID: " + bookID[index] + " with the title: " + bookTitle[index]);
					System.out.println("You chose to buy " + num + " copies.");
					System.out.println("The total cost is: " + (num * bookPrice[index]));
				}
				//Else ID not found, display not found message
				else {
					System.out.println("That book ID was not found.");
				}
				break;
				
			case 2:
				System.out.println("Binary Search");
				//Display book info in table
				display(bookID, bookTitle, bookPrice);
				//Get ID from user
				id = getID();
				//Get number from user
				num = getNumber();
				//Perform binary search on book ID array
				index = binarySearch(bookID, id);
				//If book found, display and calculate total cost
				if(index > 0) {
					System.out.println("You chose Book ID: " + bookID[index] + " with the title: " + bookTitle[index]);
					System.out.println("You chose to buy " + num + " copies.");
					System.out.println("The total cost is: " + (num * bookPrice[index]));
				}
				//Else ID not found, display not found message
				else {
					System.out.println("That book ID was not found.");
				}
				break;
				
			case 3:
				System.out.println("Bubble Sort");
				//Generate random array of ints between 1 and 500
				randArray = generateRandomArray();
				//Display pre-sorted array
				System.out.print("Pre-Sorted: ");
				displayArray(randArray);
				System.out.println("");
				//Display sorted array
				randArray = bubbleSort(randArray);
				System.out.print("After Sorting:");
				displayArray(randArray);
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("Selection Sort");
				//Generate random array
				randArray = generateRandomArray();
				//Display pre-sorted and sorted array
				System.out.print("Pre-Sorted: ");
				displayArray(randArray);
				System.out.println("");
				randArray = selectionSort(randArray);
				System.out.print("After Sorting: ");
				displayArray(randArray);
				System.out.println("\n");
				break;
				
			case 5:
				//Display quit message
				System.out.println("You chose to quit.");
				break;
				
			default:
				//Display invalid choice if not a valid menu choice
				System.out.println("That is an invalid choice, please choode again");
			}
			
		}

	}
	//Display function: Takes in the 3 book arrays as parameters and prints them out in a tabular form
	public static void display(int[] id, String[] title, double[] price) {
		for(int i = 0; i < id.length; i++) {
			System.out.println(id[i] + " " + title[i] + " " + price[i]);
		}
	}
	
	//getId function: uses scanner to get integer from user and returns that ID integer
	public static int getID() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a book ID");
		return input.nextInt();
	}
	
	//getNumber function: uses scanner to get int from user and returns the number
	public static int getNumber() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of books you want to buy:");
		return input.nextInt();
	}
	//linearSearch Function: Performs linear search algorithm on array
	public static int linearSearch(int[] arr, int id) {
		//loop through each element starting with element 0
		for(int i = 0; i < arr.length; i++) {
			//test if item found
			if (arr[i] == id) {
				return i;
			}
		}
		return -1;
	}
	//binarySearch function: Performs binary search algorithm on array
	public static int binarySearch(int[] arr, int id) {
		
		boolean found = false;
		int upper = arr.length - 1;
		int lower = 0;
		//while conditions not met, change search parameters
		while(found == false && lower <= upper) {
			int middle = (upper + lower) / 2;
			//if search successful
			if(id == arr[middle]) {
				found = true;
				return middle;
			}
			//if greater than middle
			else if(id > arr[middle]) {
				lower = middle + 1;	
			}
			//if less than middle
			else if(id < arr[middle]) {
				upper = middle - 1;
			}
		}
		return -1;
	}
	
	//generateRandomArray Function: generates a 10 element array of random integers
	//between 1 and 500
	public static int[] generateRandomArray() {
		int arr[] = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * (500 - 1)) + 1;
		}
		return arr;
	}
	
	//bubbleSort Function: sorts array with bubble sort algorithm
	public static int[] bubbleSort(int arr[]) {
		//set flags
		boolean flag = true;
		int k = 0;
		int temp;
		//while not found, move bubble
		while(flag == true) {
			flag = false;
			k = 1;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] > arr[i + 1]) {
					//swap values
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i+1] = temp;
					flag = true;
				}
			}
		}
		//return sorted array
		return arr;
	}
	//selectionSort Function: sorts array with selection sort algorithm
	public static int[] selectionSort(int arr[]) {
		//set initial values
		int minIndex = 0;
		int temp;
		//loop through array with one search element
		for(int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			//loop through with other search element
			for(int k = i + 1; k < arr.length; k++) {
				if(arr[k] < arr[minIndex]) {
					minIndex = k;
				}
			}
			//swap values
			if(minIndex != i) {
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		//return sorted array
		return arr;
	}
	//displayArray function: prints out the contents of an array
	public static void displayArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
