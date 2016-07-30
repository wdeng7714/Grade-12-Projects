#include "Person.h"
#include "Student.h"
#include <vector>
#ifndef TEACHER_H_
#define TEACHER_H_

class Teacher: public Person {
	string m_teachables;
	string m_employeeID;
	//friend class Student;

public:
	Teacher();
	Teacher(string firstName, string lastName);
	Teacher(string firstName, string lastName, string address,
			string teachables, string employeeID);
	Teacher(string firstName, string lastName, string teachables,
			string employeeID);
	string getTeachables();
	string getEmployeeID();
	void setTeachables(string teachables);
	void setEmployeeID(string employeeID);
	void markStudentLate(vector<Student> &students);
	string toString();
	bool isValidId(string employeeID);
};

#endif /* TEACHER_H_ */
