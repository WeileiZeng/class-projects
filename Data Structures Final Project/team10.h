/*
   Team Project 10
   Cricket Players Database
   Written by: Seung-beom Hong, Akash Malla, Venkata Poreddy
   6/20/2013

   Our team's header file, contains structure and prototype declarations.
*/

#include<math.h>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#ifdef _MSC_VER
#include <crtdbg.h>  // needed to check for memory leaks (Windows only!)
#endif

#define SIZE 83

typedef enum { false, true} bool;

typedef struct
{
	char* name;
	long int run;
	char* team;
	int match;
	int wicket;
} CRICKET;

typedef struct node
{
	CRICKET* dataPtr;
	struct node* left;
	struct node* right;
} NODE;


typedef struct listNode
{
    CRICKET* dataPtr;
    struct listNode* next;

} LIST_NODE;

typedef struct
{
	int   count;
	int  (*compare) (void* argu1, void* argu2);
	NODE*  root;
} BST_TREE;

typedef struct
{
    LIST_NODE* list;
	int key;
	int count;

} HASH;

typedef struct
{
	int totalCount;
	HASH* pHash;
	BST_TREE* pTree;
} HEAD;

//	BST: Prototype Declarations for public functions
	BST_TREE* BST_Create
	         (int (*compare) (void* argu1, void* argu2));
	BST_TREE* BST_Destroy (BST_TREE* tree);

	bool  BST_Insert   (BST_TREE* tree, void* dataPtr);
	bool  BST_Delete   (BST_TREE* tree, void* dltKey);
	void  BST_Traverse (BST_TREE* tree,
	                    void (*process)(void* dataPtr));
    void BST_Traverse_Indent (BST_TREE* tree,
                        void (*process) (void* dataPtr));
	void BST_TraverseTeam (BST_TREE* tree,
                   void (*process) (void* dataPtr, char* teamName, int* found), char* teamName, int* found);
	void searchTeam (BST_TREE* bstTree);
	void processTeam   (void* dataPtr, char* teamName, int* found);
	void printNames   (void* dataPtr, void* data);
	void printAlphabetical  (BST_TREE* list);
	void printIndented(BST_TREE* bstTree);

//HASH prototype declarations
	HASH* createHashTable (HASH* hashTable);
	void insertHash (CRICKET* player, HASH* hashTable, int key);
	void disconnectNode (LIST_NODE* tempNode, LIST_NODE* tempPre, HASH* hashTable, int key);
	void printHash (HASH* hashTable);
	void efficiency (HEAD* head, HASH* hashTable);
	void searchName (HEAD* head);

