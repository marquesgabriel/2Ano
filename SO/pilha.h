#ifndef __PILHA_H__
#define __PILHA_H__

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

struct Pilha_t{
	struct Node_t* first;
	struct Node_t* last;
};
//----------------------------------

//--PROTOTIPOS
struct Node_t* cria_no(void* dado);

struct Lista_t* cria_pilha();

void print_no (struct Node_t*);

void empilhar(struct Node_t*, struct Pilha_t*);

struct Node_t* desempilhar(struct Pilha_t*);

//------------------------------------------


#endif __PILHA_H__
