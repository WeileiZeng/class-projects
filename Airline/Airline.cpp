#include <iostream>
#include <fstream>
#include <string.h>
#include <stdio.h>
#include <cstdlib>
#include <vector>
using namespace std;


class Airline;
class Ticket;

class Passenger
{
    string lastName;
    string firstName;
    Ticket* pticket;

    public:
    Passenger (string last, string first, Ticket* t)
    {
        lastName = last;
        firstName = first;
        pticket = t;
    }

    string toString()
    {
        return firstName + string(" ") + lastName;
    }
    virtual void insert(Airline* a) = 0;

};

class Airline
{
    public:
    vector <Passenger*> first;
    vector <Passenger*> business;
    vector <Passenger*> economy;

    Airline()
    {
        first.reserve(35);
        business.reserve(70);
        economy.reserve(140);

    }

    void board (Passenger* p)
    {
        (*p).insert(this);
    }

};

class Ticket
{
    public:
    string ticketid;
    vector <Passenger*>* psection;

    Ticket (Airline* a, int row,  string id)
    {
        ticketid = id;

        if ( row <= 5 )
            psection = &(a->first);

        else if ( row <= 15)
            psection = &(a->business);

        else psection = &(a->economy);

    }
};


class FirstClass: public Passenger
{
    public:
    FirstClass (string last, string first, Ticket* t) : Passenger(last, first, t) {}

    void insert(Airline* a)
    {
        (a->first).push_back(this);
    }

};

class BusinessClass: public Passenger
{
    public:
        BusinessClass (string last, string first, Ticket* t) : Passenger(last, first, t) {}

    void insert(Airline* a)
    {
        (a->business).push_back(this);
    }
};

class EconomyClass: public Passenger
{
    public:
        EconomyClass (string last, string first, Ticket* t) : Passenger(last, first, t) {}

    void insert(Airline* a)
    {
        (a->economy).push_back(this);
    }
};

void printList(Airline* a)
{
    int i;

    cout << "First Class:\n";
    for (i=0; i<(a->first).size(); i++)
    {
        cout << ((a->first)[i])->toString();
        if (i<(a->first).size()-2)
            cout << ", ";
    }

    cout << "\n\nBusiness Class:\n";
    for (i=0; i<(a->business).size(); i++)
    {
        cout << ((a->business)[i])->toString();
        if (i<(a->business).size()-1)
            cout << ", ";
    }

    cout << "\n\nEconomy Class:\n";
    for (i=0; i<(a->economy).size(); i++)
    {
        cout << ((a->economy)[i])->toString();
        if (i<(a->economy).size()-1)
            cout << ", ";
    }
}

string parseString(string* value, string* last, string* first, string* rowstr, string* seat, int* row, int* flight)
{
    *last = (*value).substr(0, (*value).find_first_of(","));
    (*value).erase(0, (*value).find_first_of((","))+1);
    *first = (*value).substr(0, (*value).find_first_of(","));
    (*value).erase(0, (*value).find_first_of((","))+1);
    *rowstr = (*value).substr(0, (*value).find_first_of(","));
    *row = atoi(((*value).substr(0, (*value).find_first_of(","))).c_str());
    (*value).erase(0, (*value).find_first_of((","))+1);
    *seat = (*value).substr(0, (*value).find_first_of(","));
    (*value).erase(0, (*value).find_first_of((","))+1);
    *flight = atoi((*value).c_str());
    return *value + string("-") + *rowstr + string("-") + *seat;

}

void getData (Airline* a, string filename)
{
    Ticket* t;
    ifstream in(filename.c_str());
    string value, last, first, rowstr, seat, id;
    int row, flight;
    Passenger* p;

    while (in.good())
    {
         getline(in, value, '\n');
         id = parseString(&value, &last, &first, &rowstr, &seat, &row, &flight);
         t = new Ticket(a, row, id);

         if (*(t->psection) == a->first)
            p = new FirstClass(last, first, t);

         else if (*(t->psection) == a->business)
            p = new BusinessClass(last, first, t);

         else p = new EconomyClass(last, first, t);

         (*a).board(p);
    }
}

int main()
{
    Airline* a = new Airline();
    getData(a, "AIRLINE4.CSV");
    printList(a);
}
