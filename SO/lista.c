#include "lista.h"

//PRINTS DE TESTE
void print_no (struct Node_t* no){
	int *pi;
	pi = no->data;
	printf ("---------NO---------\n");
	printf ("| dado = %d         |\n", (int) *pi);
	printf ("| ende = %p |\n", no);
	printf ("| next = %p |\n", no->next);
	printf ("--------------------\n\n");
}

struct Node_t* cria_no(void* dado){
	struct Node_t* no;
	no= malloc (sizeof(struct Node_t) );
	no->data=dado;//atribui o endereço do dado que o usr passou
	//o (->) é a mesma coisa que (*ptr).atributo//
//	printf("dentro: %d\n", no);
	return no;
}

struct Lista_t* cria_lista(){
	struct Lista_t* lista;
	lista= malloc (sizeof(struct Lista_t) );
	lista->first = lista->last = NULL;
	return lista;
}

void* del_no(struct Node_t* no){
	void* dado;
	dado=no->data;
	// lembrar que quando é ponteiro de struct, usar o -> para acessar o atributo da struct;
	free(no);
	return dado;
}

void ins_pri(struct Node_t* no, struct Lista_t* lista){
	if(lista->first==NULL){
//		no->next=no;
		no->next=NULL;
		lista->first=no;
		lista->last=no;
	}
	else{
		no->next=lista->first;//passo 2

		lista->last->next=no;//passo 3
		lista->first=no;
	}
}

void ins_ult(struct Node_t* no, struct Lista_t* lista){
	if(lista->first==NULL){
		no->next=no;
		lista->first=no;
		lista->last=no;
	}
	else{
		no->next=lista->last->next;//passo 2

		lista->last->next=lista->first;//passo 3
		lista->last=no;
	}
}


struct Node_t* rem_pri(struct Lista_t* lista){
	lista->last->next = lista->first->next;
	free(lista->first);
	lista->first = lista->first->next;	
}

struct Node_t* rem_ult(struct Lista_t* lista){
	struct Node_t* aux = lista->first->next;	

	while(aux->next->next != lista->first){
		aux = aux->next;
	}

	aux->next=lista->first;
	free(lista->last);
	lista->last=aux;
}

