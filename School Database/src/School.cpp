#include "Student.h"
#include "Teacher.h"
#include <vector>
using namespace std;

int main() {
	string first, last, address, id, teachable;
	string type;
	unsigned int grade;
	string loop = "y", markLate="y";
	vector<Student> students;
	vector<Teacher> teachers;
	while (loop == "y") {
		cout << "Enter your first name: ";
		getline(cin, first);
		cout << "Enter your last name: ";
		getline(cin, last);
		cout << "Enter your address: ";
		getline(cin, address);
		cout << "Are you a student or a teacher?[s/t] ";
		getline(cin, type);

		if (type == "s") {
			Student *s = new Student(first, last);
			s->setAddress(address);
			cout << "Enter your ID: ";
			getline(cin, id);
			s->setStudentID(id);
			while (s->isValidID(id) == false) {
				cout << "That ID is invalid. Please try again: ";
				getline(cin, id);
				s->setStudentID(id);
			}
			cout << "Enter your grade: ";
			cin >> grade;
			s->setGrade(grade);
			students.push_back(*s);
			cout << " \nThis is your profile: " << endl;
			cout << s->toString() << endl;
			delete s;
		} else if (type == "t") {
			Teacher *t = new Teacher(first, last);
			t->setAddress(address);
			cout << "What is your teachable subject? ";
			getline(cin, teachable);
			t->setTeachables(teachable);
			cout << "Enter your ID: ";
			getline(cin, id);
			t->setEmployeeID(id);
			while (t->isValidId(id) == false) {
				cout << "That ID is invalid. Please try again: ";
				getline(cin, id);
				t->setEmployeeID(id);
			}

			teachers.push_back(*t);
			cout << " \nThis is your profile: " << endl;
			cout << t->toString() << endl;
			cout << "Mark a student late?[y/n]";
			while (markLate == "y") {
				cin>> markLate;
				if (markLate == "y") {
					t->markStudentLate(students);
					cout<<"Mark another student late?[y/n]";
				}
			}

		}
		getline(cin, loop);
		cout << " \nRegister another person?[y/n]";
		getline(cin, loop);

	}

	return 0;
}
