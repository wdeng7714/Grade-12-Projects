#include "Person.h"

#ifndef STUDENT_H_
#define STUDENT_H_

class Student : public Person {

private:
	int m_grade;
	string m_studentID;
	int m_numLates;
public:
	Student();
	Student(string firstName, string lastName);

	Student(string firstName, string lastName, string address, int grade,
			string studentID);
	Student(string firstName, string lastName, string address, int grade);
	int getGrade();

	string getStudentID();
	int getNumLates();
	void setGrade(int grade);

	void setStudentID(string studentID);
	void addLate();
	string toString();
	bool isValidID(string studentID);
};

#endif /* STUDENT_H_ */
