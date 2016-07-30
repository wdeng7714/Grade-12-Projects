//============================================================================
// Name        : RecursiveFunctionsWendy.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdlib.h>
using namespace std;
int factorialRecursion(int); //Question 1, finding factorial of user input
int sequenceRecursionA(int); //Question 2A, finding first n terms of sequence
int sequenceRecursionB(int); //Question 2B, finding first n terms of sequence
int fibonacciRecursion(int); //Question 3, finding nth term of the fibonacci sequence
int GCD(int, int); //Question 4, finding greatest common divisor
bool isFractorial(int, int); // Question 5, finding fractorials
int fractorialRecursion(int, int); // Question 5, finding fractorials
void hanoiRecursion(int, int, int, int); //Question 5, finding hanoi towers solution

using namespace std;
int main() {
	char again;
	char question;
	start: cout << "Which question? enter 1/2/3/4/5/6: ";
	cin >> question;
	switch (question) {
	case '1': {
		cout << "Find factorial of: ";
		int x;
		cin >> x;
		cout << x << "! = " << factorialRecursion(x);
	}
		break;
	case '2':
		cout << "Which part? enter a/b: ";
		cin >> question;
		cout << "Number of terms: ";
		int x;
		cin >> x;
		if (question == 'a')
			int t = sequenceRecursionA(x);
		else if (question == 'b')
			int t = sequenceRecursionB(x);
		else
			cout << "That is not a valid question";
		break;
	case '3': {
		cout << "Which term in the fibonacci sequence? ";
		int x;
		cin >> x;
		cout << "The " << x << "th term in the fibonacci sequence is: "
				<< fibonacciRecursion(x);
	}
		break;
	case '4': {
		cout << "First number: ";
		int x, y;
		cin >> x;
		cout << "Second number: ";
		cin >> y;
		cout << "The greatest common divisor of " << x << " and " << y << " is "
				<< GCD(x, y);
	}
		break;
	case '5': {
		cout << "Fractorial of: ";
		int x;
		cin >> x;
		cout << "The fractorial of " << x << " is "
				<< fractorialRecursion(x, x);
	}
		break;
	case '6': {
		cout << "Number of pegs: ";
		int n, startPeg, endPeg;
		cin >> n;
		cout << "Start peg: ";
		cin >> startPeg;
		cout << "End peg: ";
		cin >> endPeg;
		hanoiRecursion(n, startPeg, 6 - startPeg - endPeg, endPeg);
	}
		break;
	default:
		cout << "That is not a valid question" << endl;
	}
	cout << endl << endl << "run program again? y/n";
	cin >> again;
	if (again == 'y')
		goto start;

	return 0;
}
int factorialRecursion(int n) {

	if (n == 0) { //base case of 0, returns 1 because 0!=1
		return 1;
	} else {
		return factorialRecursion(n - 1) * n;
	}
}
int sequenceRecursionA(int n) {
	if (n == 1) { //base case of 1, returns 3 because the sequence begins on 3
		cout << "term 1: 3";
		return 3;
	} else {
		int t = sequenceRecursionA(n - 1) - 2;
		cout << endl << "term " << n << ": " << t;
		return t;
	}
}
int sequenceRecursionB(int n) {
	if (n == 1) { //base case of 1, returns -1 because the sequence begins on -1
		cout << "term 1: -1";
		return -1;
	} else {
		int t = 2 * sequenceRecursionB(n - 1);
		cout << endl << "term " << n << ": " << t;
		return t;
	}
}
int fibonacciRecursion(int n) {
	if (n == 1) { //base case of 1, returns 0 because the first number of the sequence is 0
		return 0;
	} else if (n == 2) { //base case of 2, returns 1 because second number of the sequence is 1
		return 1;
	} else {
		return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}
}
int GCD(int x, int y) {
	if (y == 0) {
		return x;
	} else {
		return GCD(y, x % y);
	}
}
bool isFractorial(int x, int i) { //this function checks if the integer i is a fractorial of x
	if (x == 1) {
		return true;
	} else if (i % x == 0) { //if i divides evenly into x, decrement x and check again until it reaches 0
		return isFractorial(x - 1, i);
	} else {
		return false;
	}
}
int fractorialRecursion(int x, int i) {
	if (isFractorial(x, i)) {   //calls on isFactorial to check if integer i is a fractoial of x
		return i; 				//if so, return i
	} else {
		return fractorialRecursion(x, i + 1); //otherwise increment i and check again
	}
}
void hanoiRecursion(int n, int start, int temp, int end) {
	if (n != 0) { //base case of 0, which does nothing
		hanoiRecursion(n - 1, start, end, temp);
		cout << start << " to " << end << endl;
		hanoiRecursion(n - 1, temp, start, end);
	}
}
