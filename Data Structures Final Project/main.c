/*
   Team Project 10
   Cricket Players Database
   Written by: Venkata Poreddy
   6/20/2013

   Contains the functions needed to load the data, provide screen output,
   get user input, and utilize the hash and bst functions.
*/

#include "team10.h"

int  compareName   (void* name1, void* name2);
char* makeToupper(char* temp) ;
char* makeString(char* temp_name);
void DestroyHead(HEAD* head);
HEAD* createListHead (HEAD* head);
int convertToHash (char* name);
void userDelete (HEAD* head);
void userInsert (HEAD* head);
void getData (char* filename, HEAD* head);
void writeToFile (HASH* hashTable, char* filename);
void printOptions ();
void menu (HEAD* head);

int main (void)
{
	HEAD* head = NULL;
	head = createListHead(head);
	getData("inputfile.txt", head);
	printf("\n\n  *************** WELCOME TO CRICKET DATABASE!!! ***************\n");
	menu(head);

	#ifdef _MSC_VER
    printf( _CrtDumpMemoryLeaks() ? "Memory Leak\n" : "No Memory Leak\n");
    #endif

	system("pause");

	return 0;
}

/*	==================== makeToupper ====================
	Change the first character of first name and
	last name to capital

	    Pre  char pointer
	    Post char pointer
*/

char* makeToupper(char* temp)
{
	int i;
	char pre;

	temp[0] = toupper(temp[0]);

	for(i=0;i<strlen(temp);i++)
	{
		if(i>0)
		{
			pre = temp[i-1];
			if(pre == ' ')
				temp[i] = toupper(temp[i]);
		}
	}
	return(temp);
}

/*	==================== makeString ====================
	allocate String and return
	    Pre  char pointer
	    Post char pointer allocated
*/

char* makeString(char* temp_name)
{
	char* ptr = (char*)malloc(strlen(temp_name)+1);
	if(!ptr)
	{
		printf("Memory allocation error!\n");
		exit(100);
	}
	strcpy(ptr,temp_name);
	return ptr;
}

/*	==================== DestroyHead ====================
	Destroy the head structure.
	    Pre  HEAD pointer
	    Post none
*/

void DestroyHead(HEAD* head)
{
	HASH* hashTable;
	BST_TREE* bstTree;
	LIST_NODE* tempNode;
	int i,j;

	hashTable = head->pHash;
	bstTree = head->pTree;

	for(i=0;i<SIZE;i++)
	{
		for(j=0;j<hashTable[i].count;j++)
		{
			tempNode = hashTable[i].list;
			hashTable[i].list = tempNode->next;
			free(tempNode->dataPtr->name);
			free(tempNode->dataPtr->team);
			free(tempNode);
		}
	}

	free(hashTable);
	BST_Destroy(bstTree);
	free(head);

	return ;

}

/*	==================== createListHead ====================
	This function sets head structure point to hash table
	and BST tree.
	   Pre   head
	   Post  head
*/

HEAD* createListHead (HEAD* head)
{
	int i;
	if(!(head = (HEAD*)malloc(sizeof(HEAD))))
        printf("No memory available\n");

	head->totalCount = 0;
	head->pHash = createHashTable(head->pHash);
	head->pTree = BST_Create(compareName);
	return head;
}

/*	==================== compareName ====================
	This function compares two names and returns an
	appropriate number.
	   Pre   name1, name2
	   Post  -1, 0, +1
*/

int  compareName   (void* name1, void* name2)
{
//	Local Definitions
	CRICKET n1 = *((CRICKET*)name1);
    CRICKET n2 = *((CRICKET*)name2);;

//	Statements
	if (strcmp(n1.name, n2.name)<0)
	      return -1;

	if (!strcmp(n1.name, n2.name))
	      return 0;

	return +1;
}

/*	==================== playerStats ====================
	Prints detailed statistics for a player
	   Pre   player
	   Post  none
*/

void playerStats (CRICKET* player)
{
	printf("************************************************************** \n");
	printf("*             Name : %25s               *\n", player->name);
	printf("*             Runs : %25d               *\n", player->run);
	printf("*             Team : %25s               *\n", player->team);
	printf("*          Matches : %25d               *\n", player->match);
	printf("*          Wickets : %25d               *\n", player->wicket);
	printf("*    Runs per match: %25.2lf               *\n", (double)player->run / (double)player->match);
	printf("* Wickets per match: %25.2lf               *\n", (double)player->wicket / (double)player->match);
	printf("************************************************************** \n");
}

/*	==================== userDelete ====================
	This function deletes a player user enters in hash table and BST
	tree.
	   Pre   head
	   Post  none
*/

void userDelete (HEAD* head)
{
	HASH* hashTable = head->pHash;
	BST_TREE* bstTree = head->pTree;
	int found = 0;
    int i;
	int key;
	LIST_NODE* tempNode = NULL;
    LIST_NODE* tempPre = NULL;
	char* searchVal;
	char  searchValTemp[30];

    printf("     Enter a name to delete: ");
    gets(searchValTemp);

	searchVal = makeString(searchValTemp);
	searchVal = makeToupper(searchVal);

	key = convertToHash(searchVal);

    tempNode = hashTable[key].list;

	while (tempNode != NULL && !found)
    {
	    if (strcmp(searchVal, ((CRICKET*)(tempNode->dataPtr))->name)==0)
        {
            found = 1;
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
		BST_Delete(bstTree, tempNode->dataPtr);
		free(tempNode);
		printf("     Player deleted! \n");
		hashTable[key].count--;
		head->totalCount--;
	}

	free(searchVal);
    return;
}

/*	==================== userInsert ====================
	This function inserts a player user enters in hash
	table and BST tree.
	   Pre   head
	   Post  none
*/

void userInsert (HEAD* head)
{
	int key = 0;
	int i = 0;
	int duplicate = 0;
    CRICKET* player;
	LIST_NODE* tempNode = NULL;
    char* runs;
	char* matches;
	char* wickets;
	char Temp[30];

	if(!(player = (CRICKET*)malloc(sizeof(CRICKET))))
		printf("No memory available\n");

    printf("     Name: ");
	gets(Temp);

	player->name = makeString(Temp);
	player->name = makeToupper(player->name);

	key = convertToHash(player->name);
	tempNode = head->pHash[key].list;

	while(tempNode != NULL)
	{
		if (strcmp(player->name, tempNode->dataPtr->name) == 0)
		{
			printf("\n     This name already exists\n");
			duplicate = 1;
		}
		tempNode = tempNode->next;
	}

	if (duplicate)
	{
		free(player->name);
		free(player);
	}
	else
	{
		printf("     Team: ");
 		gets(Temp);
		player->team = makeString(Temp);

		printf("     Total runs: ");
		gets(Temp);
		runs = makeString(Temp);

		printf("     Total wickets: ");
		gets(Temp);
		wickets = makeString(Temp);

		printf("     Total matches: ");
		gets(Temp);
		matches = makeString(Temp);

		player->run = atoi(runs);
		player->match = atoi(matches);
		player->wicket = atoi(wickets);


		player->team = makeToupper(player->team);
		insertHash(player, head->pHash, key);
		BST_Insert (head->pTree, player);
		head->totalCount++;
		free(runs);
		free(matches);
		free(wickets);
	}
}

/*	==================== getData ====================
	This function gets data from a file and inserts
	data into BST tree and hash table.
	   Pre   filename, head
	   Post  none
*/

void getData (char* filename, HEAD* head)
{
	char readIn [100];
	char* runs;
	char* matches;
	char* wickets;
	int key = 0;

	FILE* fpData =  fopen(filename, "r");
    CRICKET* player;

	if (!fpData)
	{
	    printf("Error opening file %s\a\n", filename);
	    exit (210);
	}
    fgets (readIn, 100, fpData);
	while (fgets (readIn, 100, fpData))
	{
	    if(!(player = (CRICKET*)malloc(sizeof(CRICKET))))
			printf("No memory available\n");

		player->name = makeString(strtok(readIn,","));
		runs = makeString(strtok(NULL,","));
		wickets = makeString(strtok(NULL,","));
		player->team = makeString(strtok(NULL,","));
		matches = makeString(strtok(NULL,"\n"));

	    player->run = atoi(runs);
	    player->match = atoi(matches);
		player->wicket = atoi(wickets);

	    BST_Insert (head->pTree, player);
		key = convertToHash(player->name);
        insertHash(player, head->pHash, key);
		head->totalCount++;

		free(runs);
		free(matches);
		free(wickets);

	}

	fclose(fpData);
}

/*	==================== writeToFile ====================
	This function writes data a user enters into a file.
	   Pre   hashTable, filename
	   Post  none
*/

void writeToFile (HASH* hashTable, char* filename)
{
	int i; int j;
	LIST_NODE* tempNode = NULL;
	CRICKET* player = NULL;
    FILE* fpData =  fopen(filename, "w");
	printf("\n     Saving to file...\n");
    fprintf(fpData, "Name,Runs,Wickets,Team,Matches\n");

    for (i = 0; i<SIZE; i++)
    {
        tempNode = hashTable[i].list;

		if((hashTable[i].key) != 0 && tempNode != NULL)
		{

			for (j=0; j<hashTable[i].count; j++)
			{
				player = (CRICKET*)(tempNode->dataPtr);
			    fprintf(fpData,"%s,%ld,%d,%s,%d\n", player->name, player->run, player->wicket, player->team, player->match);
                tempNode = tempNode->next;
			}
		}
     }
	fclose(fpData);
}


/*	==================== printOptions ====================
	This function prints options for user.
	   Pre   none
	   Post  none
*/

void printOptions ()
{
	printf("\n\n  *************** MENU ***************\n");
	printf("  *                                  *\n");
	printf("  *    1. Search for a player        *\n");
	printf("  *    2. Search for a team          *\n");
	printf("  *    3. Insert a new player        *\n");
	printf("  *    4. Delete a player            *\n");
	printf("  *    5. Print alphabetical list    *\n");
	printf("  *    6. Print indented BST         *\n");
	printf("  *    7. Print hash sequence        *\n");
	printf("  *    8. Efficiency                 *\n");
	printf("  *    9. Save to file               *\n");
	printf("  *    0. Exit (saves to file)       *\n");
	printf("  *                                  *\n");
	printf("  ************************************\n\n");
}

/*	==================== menu ====================
	This function prints menu for user and calls
	various functions.
	   Pre   head
	   Post  none
*/

void menu (HEAD* head)
{
	char* choice;
	char choicetemp[5];
	int valid = 0;

	choice = makeString(choicetemp);
	do
	{
		printOptions();
		while (!valid)
		{
			printf("     Enter your choice: ");
			gets(choice);
			if ((choice[0] < '0' || choice[0] > '9')||(strlen(choice)>1))
				printf("     Invalid choice\n");
			else
				valid = 1;
		}
		valid = 0;
		switch(choice[0])
		{
			case '1': searchName(head);
				    break;
			case '2': searchTeam(head->pTree);
				    break;
			case '3': userInsert(head);
					break;
			case '4': userDelete(head);
					break;
			case '5': printAlphabetical(head->pTree);
					break;
			case '6': printIndented(head->pTree);
					break;
			case '7': printHash(head->pHash);
				    break;
			case '8': efficiency(head, head->pHash);
					break;
			case '9': writeToFile(head->pHash, "outputfile.txt");
				    break;
			case '0': writeToFile(head->pHash, "outputfile.txt");
					  DestroyHead(head);
					break;
		}
	} while (choice[0] != '0');
	free(choice);
}
