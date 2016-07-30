#include "Person.h"

Person::Person() {
	// TODO Auto-generated constructor stub
	m_firstName = "first";
	m_lastName = "last";
	m_address = "address";

}
Person::Person(string firstName, string lastName) {
	m_firstName = firstName;
	m_lastName = lastName;
	m_address = "address";
}
Person::Person(string firstName, string lastName, string address) {
	m_firstName = firstName;
	m_lastName = lastName;
	m_address = address;
}
string Person::getFirstName() {
	return m_firstName;
}
string Person::getLastName() {
	return m_lastName;
}
string Person::getAddress() {
	return m_address;
}

void Person::setFirstName(string firstName){
	m_firstName = firstName;
}
void Person::setLastName(string lastName){
	m_lastName = lastName;
}
void Person::setAddress(string address){
	m_address = address;
}

string Person::toString(){
return "Name: "+m_firstName + " "+m_lastName+"\nAddress: "+ m_address;
}
