/*
   Team Project 10
   Cricket Players Database
   Written by: Seung-beom Hong
   6/20/2013

   Contains the functions dealing with hash list management of the
   cricket players. Hash is primarily used for very quick searching.
*/

#include "team10.h"

/*	==================== createHashTable ====================
	This function creates hash table setting list to null,
	count and key to zero.
	   Pre   hashTable
	   Post  hashTable
*/

HASH* createHashTable (HASH* hashTable)
{
	int i;
    if(!(hashTable = (HASH*)malloc(sizeof(HASH)*SIZE)))
        printf("No memory available\n");
	for(i=0 ; i<SIZE ;i++)
	{
	    hashTable[i].list = NULL;
		hashTable[i].count = 0;
		hashTable[i].key = 0;
	}
	return hashTable;
}


/*	==================== convertToHash ====================
	This function makes a unique key that depends on the
	lenght of a name.
	   Pre   name
	   Post  total
*/

int convertToHash (char* name)
{
    int i = 0;
	int total = 0;
    for (i = 0; i < strlen(name); i++)
       total += pow(name[i], 3);

    total %= SIZE;
    return total;
}

/*	==================== insertHash ====================
	This function inserts a player into the hash table.
	   Pre   player, hashTable, key
	   Post  none
*/

void insertHash (CRICKET* player, HASH* hashTable, int key)
{
	LIST_NODE* pPre;
    LIST_NODE* tempNode;
    LIST_NODE* tempNode2;
    int i = 0;

    if(hashTable[key].list == NULL)
	{
		if(!(tempNode = (LIST_NODE*)malloc(sizeof(LIST_NODE))))
			printf("No memory available\n");
		tempNode->next = NULL;
		tempNode->dataPtr = player;
		hashTable[key].list = tempNode;
	}

	else
	{
		tempNode2 = hashTable[key].list;
		if(!(tempNode = (LIST_NODE*)malloc(sizeof(LIST_NODE))))
			printf("No memory available\n");
		tempNode->next = tempNode2;
		tempNode->dataPtr = player;
		hashTable[key].list = tempNode;
	}

    hashTable[key].key = key;
    hashTable[key].count++;
    return;
}

/*	==================== disconnectNode ====================
	This function disconnects a node in the linked list
	from the hash table.
	   Pre   tempNode, tempPre, hashTable, key
	   Post  none
*/

void disconnectNode (LIST_NODE* tempNode, LIST_NODE* tempPre, HASH* hashTable, int key)
{
	if (tempNode->next != NULL)
    {
		if(tempPre == NULL)
		hashTable[key].list = tempNode->next;
		else
			tempPre->next = tempNode->next;
	}

	else
	{
        if(tempPre == NULL)
		hashTable[key].list = tempNode->next;
		else
			tempPre->next = NULL;
	}
}


/*	==================== printHash ====================
	This function prints hash table.
	   Pre   hashTable
	   Post  none
*/

void printHash (HASH* hashTable)
{
    int i;
	int j;
    LIST_NODE* tempNode = NULL;
	printf("\nHash Sequence:\n");
	printf("\nIndex Count  Players\n");
	printf("------------------------------------------------\n");
    for (i = 0; i<SIZE; i++)
    {
        tempNode = hashTable[i].list;
		if((hashTable[i].key) != 0 && tempNode != NULL)
		{

			printf("%2d:    ", hashTable[i].key);
			printf("%d    ", hashTable[i].count);
			for (j=0; j<hashTable[i].count; j++)
			{
                printf("%s", ((CRICKET*)(tempNode->dataPtr))->name);
				if (j+1 != hashTable[i].count)
					printf(", ");
                tempNode = tempNode->next;
			}
			printf("\n");
		}
    }
	printf("------------------------------------------------\n");
}

/*	==================== efficiency ====================
	This function calculates total players, load factor,
	average nodes in linked lists and longest liked list.
	   Pre   head, hashTable
	   Post  none
*/

void efficiency (HEAD* head, HASH* hashTable)
{
    double loadFactor = 0;
    double avg = 0;
	double lists = 0;
	double loadLists = 0;
    int longest = 0;
    int i;
	printf("\n------------------------------------------------\n");
	printf("Efficiency:\n\n");
    for (i = 0; i<SIZE; i++)
    {
		if(hashTable[i].count>=1)
		{
			loadFactor+= hashTable[i].count;
			loadLists += hashTable[i].count;
			lists++;
		}
		else loadLists ++;

        if (hashTable[i].count > longest)
            longest = hashTable[i].count;

        avg += hashTable[i].count;

    }
    loadFactor = (loadFactor / loadLists) * 100;
    avg /= lists;
	printf("   Total Players: %d\n", head->totalCount);
    printf("   Load Factor: %0.2lf%c\n", loadFactor, '%');
    printf("   Longest linked list: %d\n", longest);
    printf("   Average number of nodes: %0.2lf\n", avg);
	printf("\n------------------------------------------------\n");
}

/*	==================== searchName ====================
	This function searches a name user enters through
	the hash table.
	   Pre   head
	   Post  none
*/

void searchName (HEAD* head)
{
	HASH* hashTable = head->pHash;
	int found = 0;
    int i;
	int key;
	LIST_NODE* tempNode = NULL;
    LIST_NODE* tempPre = NULL;
	CRICKET* player = NULL;
	char* searchVal;
	char searchValTemp[30];

    printf("     Enter a name to search: ");
    gets(searchValTemp);

	searchVal = makeString(searchValTemp);
	searchVal = makeToupper(searchVal);

	key = convertToHash(searchVal);

    tempNode = hashTable[key].list;

	while (tempNode != NULL && !found)
    {
	    if (strcmp(searchVal, ((CRICKET*)(tempNode->dataPtr))->name)==0)
        {
			player = tempNode->dataPtr;
            found = 1;
			playerStats(player);
			disconnectNode(tempNode, tempPre, hashTable, key);
        }
        if (!found)
        {
			tempPre = tempNode;
            tempNode = tempNode->next;
        }

    }
    if (!found)
        printf("     Player not found\n");
	else
	{
		insertHash(player, hashTable, key);
		free(tempNode);
		hashTable[key].count--;
	}

	free(searchVal);
    return;
}
