
#include <string>
#include <iostream>

using namespace std;

#ifndef PERSON_H_
#define PERSON_H_



class Person {
private:
	string m_firstName;
	string m_lastName;
	string m_address;

public:
	Person();

	Person(string firstName, string lastName);
	Person(string firstName, string lastName,  string address);

	string getFirstName();
	string getLastName();
	string getAddress();

	void setFirstName(string firstName);
	void setLastName(string lastName);
	void setAddress(string address);

	string toString();

};

#endif /* PERSON_H_ */
