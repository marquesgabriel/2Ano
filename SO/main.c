#include "lista.h"

int main()
{
	struct Node_t* no_local;
	struct Lista_t* lista_local;

	lista_local=cria_lista();
	int* dado;//PONTEIRO INT PRA DADO

	printf("\nDigite o dado que deseja inserir no nó: ");
	dado = malloc(sizeof(int));//MALLOC
	scanf("%d", dado);
	no_local=cria_no(dado);

	ins_pri(no_local, lista_local);

	printf("\nDigite o dado que deseja inserir no nó: ");
	dado = malloc(sizeof(int) );
	scanf("%d", dado);
	no_local=cria_no( dado );

	ins_pri(no_local, lista_local);

	printf("\nDigite o dado que deseja inserir no nó: ");
	dado = malloc(sizeof(int) );
	scanf("%d", dado);
	no_local=cria_no( dado );

	ins_pri(no_local, lista_local);

	print_no (lista_local->first);
	print_no (lista_local->last);

//	rem_pri(lista_local);
	rem_ult(lista_local);

	print_no (lista_local->first);
	print_no (lista_local->last);

//	rem_pri(lista_local);
	rem_ult(lista_local);

	print_no (lista_local->first);
	print_no (lista_local->last);

	return 0;
}

