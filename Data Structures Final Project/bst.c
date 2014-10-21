/*
   Team Project 10
   Cricket Players Database
   Written by: Akash Malla
   6/20/2013

   Contains the functions dealing with BST management of the cricket players.
   BST is used for alphabetical order, and searching by team.

*/

#include "team10.h"

//	BST: Prototype Declarations for private functions
static NODE* _insert (BST_TREE* tree,
					  NODE* root,
					  NODE* newPtr);
static NODE* _delete (BST_TREE* tree,
					  NODE* root,
					  void* dataPtr,
					  bool* success);
static void _traverse (NODE* root,
					   void (*process) (void* dataPtr));
static void _traverse_indent (NODE* root,
                void (*process) (void* dataPtr), int depth);
static void _traverseTeam (NODE* root,
                void (*process) (void* dataPtr, char* teamName, int* found), char* teamName, int* found);
static void _destroy (NODE* root);


/*	================= BST_Create ================
	Allocates dynamic memory for an BST tree head
	node and returns its address to caller
	   Pre    compare is address of compare function
	          used when two nodes need to be compared
	   Post   head allocated or error returned
	   Return head node pointer; null if overflow
*/
BST_TREE* BST_Create
        (int  (*compare) (void* argu1, void* argu2))
{
	BST_TREE* tree;

	tree = (BST_TREE*) malloc (sizeof (BST_TREE));
	if (tree){
	    tree->root    = NULL;
	    tree->count   = 0;
	    tree->compare = compare;
	}

	return tree;
}

/*	================= BST_Insert ===================
	This function inserts new data into the tree.
	   Pre    tree is pointer to BST tree structure
	   Post   data inserted or memory overflow
	   Return Success (true) or Overflow (false)
*/
bool BST_Insert (BST_TREE* tree, void* dataPtr)
{
	NODE* newPtr;

	newPtr = (NODE*)malloc(sizeof(NODE));
	if (!newPtr)
	   return false;

	newPtr->right   = NULL;
	newPtr->left    = NULL;
	newPtr->dataPtr = dataPtr;

	if (tree->count == 0)
	    tree->root  =  newPtr;
	else
	    _insert(tree, tree->root, newPtr);

	(tree->count)++;
	return true;
}

/*	==================== _insert ====================
	This function uses recursion to insert the new data
	into a leaf node in the BST tree.
	   Pre    Application has called BST_Insert, which
	          passes root and data pointer
	   Post   Data have been inserted
	   Return pointer to [potentially] new root
*/
static NODE* _insert (BST_TREE* tree, NODE* root, NODE* newPtr)
{
	if (!root)
	   return newPtr;

	if (tree->compare(newPtr->dataPtr,
	                  root->dataPtr) < 0){
	    root->left = _insert(tree, root->left, newPtr);
	    return root;
	}
	else{
	    root->right = _insert(tree, root->right, newPtr);
	    return root;
	}
	return root;
}

/* ================== BST_Delete ==================
	This function deletes a node from the tree and
	rebalances it if necessary.
	   Pre    tree initialized--null tree is OK
	          dltKey is pointer to data structure
	                 containing key to be deleted
	   Post   node deleted and its space recycled
	          -or- An error code is returned
	   Return Success (true) or Not found (false)
*/
bool BST_Delete (BST_TREE* tree, void* dltKey)
{
	bool  success;
	NODE* newRoot;

	newRoot = _delete (tree, tree->root, dltKey, &success);
	if (success){
	    tree->root = newRoot;
	    (tree->count)--;
	    if (tree->count == 0)
	        tree->root = NULL;
	}
	return success;
}

/*	==================== _delete ====================
	Deletes node from the tree (key must be unique!)
	   Pre    tree initialized--null tree is OK.
	          dataPtr contains key of node to be deleted
	   Post   node is deleted and its space recycled
	          -or- if key not found, tree is unchanged
	   Return success is true if deleted; false if not found
	          pointer to root
*/
static NODE*  _delete (BST_TREE* tree,    NODE* root,
                void*     dataPtr, bool* success)
{
	NODE* dltPtr;
	NODE* exchPtr;
	NODE* newRoot;
	void* holdPtr;

	if (!root){
	    *success = false;
	    return NULL;
	}

	if (tree->compare(dataPtr, root->dataPtr) < 0)
	    root->left  = _delete (tree,    root->left,
	                           dataPtr, success);
	else if (tree->compare(dataPtr, root->dataPtr) > 0)
	    root->right = _delete (tree,    root->right,
	                            dataPtr, success);
	else{
	    dltPtr = root;
		if (!root->left){
			free(root->dataPtr->name);
			free(root->dataPtr->team);
            free (root->dataPtr);
	        newRoot = root->right;
	        free (dltPtr);
	        *success = true;
	        return newRoot;
	     }
	     else
			 if (!root->right){
				 free(root->dataPtr->name);
				 free(root->dataPtr->team);
				 free (root->dataPtr);
	             newRoot = root->left;
	             free (dltPtr);
	             *success = true;
	             return newRoot;
	         }
			 else{
                 exchPtr = root->left;

	             while (exchPtr->right)
	                 exchPtr = exchPtr->right;
	              holdPtr          = root->dataPtr;
	              root->dataPtr    = exchPtr->dataPtr;
	              exchPtr->dataPtr = holdPtr;
	              root->left       =
	                 _delete (tree,   root->left,
	                          exchPtr->dataPtr, success);
			 }
	}
	return root;
}

/*	=================== BST_Traverse ===================
	Process tree using inorder traversal.
	   Pre   Tree has been created (may be null)
	         process ?isits?nodes during traversal
	   Post  Nodes processed in LNR (inorder) sequence
*/
void BST_Traverse (BST_TREE* tree,
                   void (*process) (void* dataPtr))
{
	_traverse (tree->root, process);
	return;
}

/*	=================== BST_TraverseTeam ===================
	Process tree using inorder traversal, used for matching player's team.
	   Pre   Tree has been created (may be null)
	         process ?isits?nodes during traversal, found, teamName
	   Post  Nodes processed in LNR (inorder) sequence
*/
void BST_TraverseTeam (BST_TREE* tree,
                   void (*process) (void* dataPtr, char* teamName, int* found), char* teamName, int* found)
{
	_traverseTeam (tree->root, process, teamName, found);
	return;
}

/*	=================== _traverseTeam ===================
	Inorder tree traversal. To process a node, we use
	the function passed when traversal was called.
	   Pre   Tree has been created (may be null), found, teamName
	   Post  All nodes processed
*/
static void _traverseTeam (NODE* root,
                void (*process) (void* dataPtr, char* teamName, int* found), char* teamName, int* found)
{
    if (root){
        _traverseTeam (root->left, process, teamName, found);
        process   (root->dataPtr, teamName, found);
        _traverseTeam (root->right, process, teamName, found);
    }
    return;
}

/*	=================== BST_Traverse_Indent ===================
	Process tree using inorder traversal.
	   Pre   Tree has been created (may be null)
	         process ?isits?nodes during traversal
	   Post  Nodes processed in LNR (inorder) sequence
*/

void BST_Traverse_Indent (BST_TREE* tree,
                   void (*process) (void* dataPtr))
{
    int depth = 0;
	_traverse_indent (tree->root, process, depth);
	return;
}

/*	=================== _traverse_indent ===================
	Inorder tree traversal. To process nodes by indenting in
	terms of tree levels.
	   Pre   root and process function
	   Post  All nodes processed
*/
static void _traverse_indent (NODE* root,
                void (*process) (void* dataPtr), int depth)
{
    int i;
    if (root){
        _traverse_indent (root->right, process, (depth+1));
        for(i = 0; i < depth; i++)
            printf("  ");

        printf("%d.", depth + 1);
        process   (root->dataPtr);
        _traverse_indent (root->left, process, (depth+1));
    }
    return;
}



/*	=================== _traverse ===================
	Inorder tree traversal. To process a node, we use
	the function passed when traversal was called.
	   Pre   Tree has been created (may be null)
	   Post  All nodes processed
*/
static void _traverse (NODE* root,
                void (*process) (void* dataPtr))
{
    if (root){
        _traverse (root->left, process);
        process   (root->dataPtr);
        _traverse (root->right, process);
    }
    return;
}


/*	=============== BST_Destroy ==============
	Deletes all data in tree and recycles memory.
	The nodes are deleted by calling a recursive
	function to traverse the tree in inorder sequence.
	   Pre      tree is a pointer to a valid tree
	   Post     All data and head structure deleted
	   Return   null head pointer
*/
BST_TREE* BST_Destroy (BST_TREE* tree)
{
	if (tree)
		_destroy (tree->root);

	free (tree);
	return NULL;
}

/*	=============== _destroy ==============
	Deletes all data in tree and recycles memory.
	It also recycles memory for the key and data nodes.
	The nodes are deleted by calling a recursive
	function to traverse the tree in inorder sequence.
	   Pre      root is pointer to valid tree/subtree
	   Post     All data and head structure deleted
	   Return   null head pointer
*/
static void _destroy (NODE* root)
{
	if (root){
	    _destroy (root->left);
	    free (root->dataPtr);
	    _destroy (root->right);
	    free (root);
	}
	return;
}

/*	==================== printTeam ====================
	This function compares two teams if they match, then
	displays the players in that team.
	   Pre   head
	   Post  none
*/

void printTeam   (void* dataPtr, char* teamName, int* found)
{
	CRICKET* player = ((CRICKET*) dataPtr);
	if (strcmp(teamName, player->team) == 0)
	{
		printf("     %s\n", player->name);
		(*found)++;
	}
}

/*	==================== searchTeam ====================
	This function searches a team by using BST tree.
	   Pre   bstTree
	   Post  none
*/

void searchTeam (BST_TREE* bstTree)
{
	char* searchteam;
	char searchteamTemp[30];
	int zero = 0;
	int* found = &zero;

    printf("     Enter a team to search for: ");
    gets(searchteamTemp);
	searchteam = makeString(searchteamTemp);
	searchteam = makeToupper(searchteam);

	searchteam[0] = toupper(searchteam[0]);
	printf("\n");
	BST_TraverseTeam (bstTree, printTeam, searchteam, found);
	if (!zero) printf("     Team not found\n");
	free(searchteam);
	return;
}

/*	==================== printNames ====================
	This function prints a player.
	   Pre   dataPtr, data
	   Post  none
*/

void printNames   (void* dataPtr, void* data)
{
	CRICKET player = *((CRICKET*) dataPtr);
	printf("%s\n", player.name);
	return 0;
}

/*	==================== printAlphabetical ====================
	This function prints data by alphabetical order using
	BST tree traverse.
	   Pre   list
	   Post  none
*/

void printAlphabetical  (BST_TREE* list)
{
	int i = 0;
	printf("\n------------------------------------------------\n");
	BST_Traverse (list, printNames);
	printf("------------------------------------------------\n");
}

/*	==================== printIndented ====================
	This function prints BST tree indented.
	   Pre   head, hashTable
	   Post  none
*/

void printIndented(BST_TREE* bstTree)
{
	printf("\nIndented Tree:\n\n");
	printf("------------------------------------------------\n");
	BST_Traverse_Indent (bstTree, printNames);
	printf("------------------------------------------------\n");
	printf("\n");
}
