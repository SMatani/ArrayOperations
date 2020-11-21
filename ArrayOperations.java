/*Java code for different array operations*/

import java.util.Arrays;

public class ArrayOperations {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 7, 1, 4, 9 };
		int[] nums1 = new int[] { 1, 1, 5 };
		int[] nums2 = new int[] { 3, 2, 1, 1 };

		int count = countRaises(nums);
		int count1 = countRaises(nums1);
		int count2 = countRaises(nums2);

		System.out.println("Count of numbers followed by higher numbers");
		System.out.println("Array 1 :" + count);
		System.out.println("Array 2 :" + count1);
		System.out.println("Array 3 :" + count2);

		System.out.println("\nPrint the last half of the array");
		int[] nums3 = new int[] { 4, 7, 1, 5, 4, 2 };
		int[] nums4 = new int[] { 2, 8 };
		int[] nums5 = new int[] { 1, 2, 2, 1 };

		lastHalf(nums3);
		lastHalf(nums4);
		lastHalf(nums5);

		System.out.println("\n\nRemoving all");
		int[] nums6 = new int[] { 3, 5, 5, 2 };
		int[] nums7 = new int[] { 10 };
		int[] nums8 = new int[] { 5 };

		removeAll(5, nums6);
		removeAll(10, nums7);
		removeAll(7, nums8);

		System.out.println("\n\nThe second occurences of the key : ");
		int[] nums9 = new int[] { 3, 7, 2 };
		int[] nums10 = new int[] { 5, 7, 5 };
		int[] nums11 = new int[] { 8, 8, 5, 1, 4 };

		secondIndexOf(nums9, 2);
		secondIndexOf(nums10, 5);
		secondIndexOf(nums11, 8);

		System.out.println("Operation Copy");
		int[] nums12 = new int[] { 3, 4 };
		int[] nums13 = new int[] { 10, 20, 30 };
		int[] nums14 = new int[] { 1 };

		repeat(nums12, 2);
		repeat(nums13, 3);
		repeat(nums14, 5);

		System.out.println("\n\nRemove First Element Operation");
		int[] nums15 = new int[] { 3, 4, 5 };
		int[] nums16 = new int[] { 1 };
		int[] nums17 = new int[] {};

		allButFirst(nums15);
		allButFirst(nums16);
		allButFirst(nums17);

		System.out.println("\n\nBuild Array with size");
		buildArray(3);
		buildArray(0);
		buildArray(5);

		System.out.println("\n\nArray with last element repeated");
		int[] nums18 = new int[] { 3 };
		int[] nums19 = new int[] { 7, 1, 5 };
		int[] nums20 = new int[] { 1, 0 };
		lastElement(nums18);
		lastElement(nums19);
		lastElement(nums20);

		System.out.println("\n\nArrayafter removing first occurence");
		int[] nums21 = new int[] { 17, 5, 13, 5, 8 };
		int[] nums22 = new int[] { 1, 2, 3 };
		int[] nums23 = new int[] { 6, 5, 4, 6, 5 };
		removeFirst(nums21, 5);
		removeFirst(nums22, 3);
		removeFirst(nums23, 6);

	}

	/*Function receives an integer array and returns and prints the count of the presence of digits that have higher digit after them*/
	
	static int countRaises(int[] nums) {
		int prev = nums[0];
		int next = nums[1];

		int count = 0;

		int size = nums.length;

		for (int i = 0; i < size - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				count++;
			}
		}
		return count;
	}

	/*Function takes an array of integers and returns and prints the last half array*/ 
	static void lastHalf(int[] nums) {
		int size = nums.length;

		int n = size / 2;
		int halfArray[] = new int[n];

		for (int i = n; i < size; i++) {
			int j = 0;
			halfArray[j] = nums[i];
			j++;
		}

		int j = 0;
		for (int i = n; i < size; i++) {
			halfArray[j] = nums[i];
			j++;
		}

		System.out.println("\nLast Half Array:");

		for (int i = 0; i < n; i++) {
			System.out.print(halfArray[i] + " ");
		}

	}

	/*Function takes an array of integers and a value and returns and prints an array removing that value*/
	static void removeAll(int remove, int[] nums) {
		int size = nums.length;

		int newsize = 0;
		for (int i = 0; i < size; i++) {
			if (nums[i] != remove) {
				newsize++;
			} else {
				continue;
			}
		}

		int[] RemovedArray = new int[newsize];

		int j = 0;
		for (int i = 0; i < size; i++) {

			if (nums[i] == remove) {
				continue;

			} else {
				RemovedArray[j] = nums[i];
				if (j == newsize) {
					break;
				} else
					j++;
			}

		}

		System.out.println("\nArray after removal: ");

		for (int i = 0; i < newsize; i++) {
			System.out.print(RemovedArray[i] + " ");
		}

	}

	/*Function takes an array of integers and a key value and returns and prints the second index of passed key value if found else -1*/
	static int secondIndexOf(int[] nums, int key) {
		int size = nums.length;

		int secondIndex;
		int count = 0;
		int i;
		for (i = 0; i < size; i++) {
			if (nums[i] == key) {
				count++;
				if (count == 2) {
					System.out.println("The second index of " + key + " is :" + i);
					break;
				}
			}
		}

		if (count == 0 || count == 1) {
			System.out.println("-1 ");
		}

		return count;

	}

	/*Function takes an array nums of integers and a value n and returns and prints an array with the values in nums repeated n number of times*/
	static int[] repeat(int[] nums, int n) {
		int size = nums.length;
		int newsize = size * n;
		int[] newArray = new int[newsize];
		int j = 0;

		for (int i = 0; i < newsize; i++)

		{

			newArray[i] = nums[j];
			j++;
			if (j == size) {
				j = 0;
			}
		}

		System.out.println("\nArray after multiple addition: ");

		for (int i = 0; i < newsize; i++) {
			System.out.print(newArray[i] + " ");
		}
		return newArray;
	}

	/*Function takes an array of integers and a value and returns and prints an array after removing first element */
	static int[] allButFirst(int[] nums) {
		int[] newArray = null;
		int size = nums.length;
		int newsize = size - 1;
		if (newsize > 0) {
			newArray = new int[size - 1];

			int j = 1;
			for (int i = 0; i < newsize; i++)

			{

				newArray[i] = nums[j];
				j++;
				if (j == size) {
					j = 0;
				}
			}

		}
		System.out.println("\nArray after removing first element: ");

		for (int i = 0; i < newsize; i++) {
			System.out.print(newArray[i] + " ");
		}

		return newArray;
	}
	
	
	/*Function takes a value and returns and prints an array with the size of the value ex: value=4 it will return [4,4,4,4]
	 */
	static int[] buildArray(int size) {
		int[] newArray = new int[size];

		for (int i = 0; i < size; i++) {

			newArray[i] = size;

		}
		System.out.println("\nArray Built : ");
		for (int i = 0; i < size; i++) {
			System.out.print(newArray[i] + " ");
		}
		return newArray;
	}

	/*It receives an integer array and returns/prints an array copied with the last element repeated*/
	static int[] lastElement(int[] nums) {
		int n = nums.length;
		int size = n + 1;

		int[] newArray = new int[size];

		int j = 0;
		for (int i = 0; i < size; i++)

		{

			newArray[i] = nums[j];

			if (j + 1 == size - 1) {
				newArray[i + 1] = nums[j];
				break;
			}
			j++;
		}

		System.out.println("\nArray after copying last element too ");

		for (int i = 0; i < size; i++) {
			System.out.print(newArray[i] + " ");
		}

		return newArray;

	}

	/*It receives an integer array and a value and returns/prints an array with the first occurence of the received value
	 * removed*/
	static int[] removeFirst(int[] nums, int value) {
		int size = nums.length;
		int newsize = 0;
		int i;
		for (i = 0; i < size; i++) {
			if (nums[i] == value) {
				newsize = size - 1;
				break;
			}
		}

		int count = 0;
		int[] newArray = new int[newsize];

		int j = 0;
		for (i = 0; i < size; i++) {
			if (nums[i] == value && count != 1) {
				count = 1;
				continue;
			} else {
				newArray[j] = nums[i];
				j++;

			}

		}

		System.out.println("\nArray after removal: ");

		for (i = 0; i < newsize; i++) {
			System.out.print(newArray[i] + " ");
		}
		return newArray;
	}

}

/* OUTPUT
Count of numbers followed by higher numbers
Array 1 :3
Array 2 :1
Array 3 :0

Print the last half of the array

Last Half Array:
5 4 2 
Last Half Array:
8 
Last Half Array:
2 1 

Removing all

Array after removal: 
3 2 
Array after removal: 

Array after removal: 
5 

The second occurences of the key : 
-1 
The second index of 5 is :2
The second index of 8 is :1
Operation Copy

Array after multiple addition: 
3 4 3 4 
Array after multiple addition: 
10 20 30 10 20 30 10 20 30 
Array after multiple addition: 
1 1 1 1 1 

Remove First Element Operation

Array after removing first element: 
4 5 
Array after removing first element: 

Array after removing first element: 


Build Array with size

Array Built : 
3 3 3 
Array Built : 

Array Built : 
5 5 5 5 5 

Array with last element repeated

Array after copying last element too 
3 3 
Array after copying last element too 
7 1 5 5 
Array after copying last element too 
1 0 0 

Arrayafter removing first occurence

Array after removal: 
17 13 5 8 
Array after removal: 
1 2 
Array after removal: 
5 4 6 5 
*/
