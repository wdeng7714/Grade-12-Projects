#include "Student.h"
#include <string>
#include <sstream>
Student::Student() {
	m_grade = 0;
	m_numLates = 0;
	m_studentID="S000000000";

}
Student::Student(string firstName, string lastName) {
	m_grade = 0;
	m_numLates = 0;
	m_studentID="S000000000";
	Person::setFirstName(firstName);
	Person::setLastName(lastName);
}
Student::Student(string firstName, string lastName, string address, int grade,
		string studentID) {
	m_grade = grade;
	m_numLates = 0;
	setStudentID(studentID);
	Person::setFirstName(firstName);
	Person::setLastName(lastName);
	Person::setAddress(address);

}
Student::Student(string firstName, string lastName, string address, int grade) {
	m_grade = grade;
	m_numLates = 0;
	m_studentID = "S000000000";
	Person::setFirstName(firstName);
	Person::setLastName(lastName);

}

//member functions
string Student::toString() {
	stringstream ssGrade;
	ssGrade << m_grade;
	stringstream ssNumLates;
	ssNumLates << m_numLates;

	return Person::toString() + "\nStudent ID: " + m_studentID + "\nGrade: "+ ssGrade.str() + "\nLates: " + ssNumLates.str();
}
bool Student::isValidID(string studentID) {
	if (studentID.length() == 10) {
		if (studentID.at(0) == 'S') {
			for (int i = 1; i < 10; i++) {
				if (!isdigit(studentID.at(i))) {
					return false;
				}
			}
			return true;
		}
	}

	return false;
}

//getters
string Student::getStudentID() {
	return m_studentID;
}
int Student::getNumLates() {
	return m_numLates;
}
int Student::getGrade() {
	return m_grade;
}

//setters
void Student::setStudentID(string studentID) {
	if (isValidID(studentID)) {
		m_studentID = studentID;
	}
}
void Student::setGrade(int grade) {
	m_grade = grade;
}
void Student::addLate() {
	m_numLates++;
}
