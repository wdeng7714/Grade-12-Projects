#include "Teacher.h"

Teacher::Teacher() {
	m_teachables = "Nothing";
	m_employeeID = "C00000";
}
Teacher::Teacher(string firstName, string lastName) {
	Person::setFirstName(firstName);
	Person::setLastName(lastName);
	m_teachables = "Nothing";
	m_employeeID = "C00000";
}
Teacher::Teacher(string firstName, string lastName, string address,
		string teachables, string employeeID) {
	m_teachables = teachables;
	setEmployeeID(employeeID);
	Person::setFirstName(firstName);
	Person::setLastName(lastName);
	Person::setAddress(address);

}
Teacher::Teacher(string firstName, string lastName, string teachables,
		string employeeID) {
	m_teachables = teachables;
	m_employeeID = employeeID;
	Person::setFirstName(firstName);
	Person::setLastName(lastName);

}
string Teacher::getTeachables() {
	return m_teachables;
}
string Teacher::getEmployeeID() {
	return m_employeeID;
}
void Teacher::setTeachables(string teachables) {
	m_teachables = teachables;
}
void Teacher::setEmployeeID(string employeeID) {
	if (isValidId(employeeID)) {
		m_employeeID = employeeID;
	}
}
void Teacher::markStudentLate(vector<Student> &students) {
	int unsigned sLate;
	if (students.size() == 0) {
		cout << "There are currently no registered students";
	} else {
		cout << "\nThere are currently " << students.size() << " Students: \n";
		for (unsigned int x = 0; x < students.size(); x++) {
			cout << "Student " << x + 1 << ": "<<endl;
			cout << students[x].toString()<<"\n\n";
		}
		cout << "Which student is late?(enter a number)";
		cin >> sLate;
		if (sLate > students.size()) {
			cout << "No such student"<<endl;
		} else {
			students[sLate - 1].addLate();
			cout << students[sLate - 1].getFirstName()
					<< " has been marked late" << endl<<endl;
			cout << "This is " << students[sLate - 1].getFirstName()
					<< "'s new profile:" << endl;
			cout << students[sLate - 1].toString()<<"\n";
		}
	}
}
string Teacher::toString() {
	return Person::toString() + "\nEmployee ID: " + m_employeeID
			+ "\nTeachables: " + m_teachables;
}

bool Teacher::isValidId(string employeeID) {
	if (employeeID.length() == 6) {
		if (employeeID.at(0) == 'C') {
			for (int i = 1; i < 6; i++) {
				if (!isdigit(employeeID.at(i))) {
					return false;
				}
			}
			return true;
		}
	}

	return false;

}
