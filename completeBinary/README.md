# ÁRVORES 

PROJECT TITLE: Agenda implementada através de árvore.

PURPOSE OF PROJECT:

VERSION or DATE:

HOW TO START THIS PROJECT:

AUTHORS: Gabriela Cavalcante da Silva
         Gustavo Alves
         Roberto Dantas

USER INSTRUCTIONS:
	Árvore Binária cheia (completa):
        - Cada nó ou terá os dois filhos (left e right) ou nenhum filho.
    
    Alguns Métodos para entender melhor:
        Node.addChildren(Pessoa) - Adiciona uma pessoa na árvore.
        Node.isEmpty() - Indica se um nó existente tem informação (Pessoa).
        Node.getBrother() - Irmão da direita.
        Node.getLeftBrother() - Irmão da esquerda.
    
    O principal motivo de implementar binária cheia (completa) é para que sempre
    consiga definir o irmão da direita para todos. Dessa forma, a
    função getBrother() será útil para realizar a função de busca por largura: 
            A
        B   ->  C
    D  ->  E ->  F -> G
    
    = Busca em A, se não achar busca em B e C, se não achar em D, E, F e G.
    
    Já a busca por profundidade pode ser implementada de maneira simples por 
    recursividade.