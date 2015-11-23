#ifndef __LISTA_H__ //se nao for definida a biblioteca
#define __LISTA_H__ //defina a biblioteca

//--INCLUDES
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
//------------------


//STRUCTS
struct Node_t{
	void* data;
	struct Node_t* next;	
};// LEMBRAR DESSE PONTO NO FINAL DA STRUCT

struct Lista_t{
	struct Node_t* first;
	struct Node_t* last;
};
//----------------------------------

//--PROTOTIPOS
struct Node_t* cria_no(void* dado);

struct Lista_t* cria_lista();

void print_no (struct Node_t*);

void* del_no(struct Node_t* no);

void ins_pri(struct Node_t* no, struct Lista_t* lista);

void ins_ult(struct Node_t* no, struct Lista_t* lista);

struct Node_t* rem_pri(struct Lista_t*);

struct Node_t* rem_ult(struct Lista_t*);
//------------------------------------------

#endif //__LISTA_H__ //fim if
