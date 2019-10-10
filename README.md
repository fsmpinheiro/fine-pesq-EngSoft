# Financiencia
Sistema de cadastro de projetos, com avaliação de assessores. Trabalho desenvolvido para a disciplina de Engenharia de Software em 2019.2

## Descrição
Uma agência de financiamento de projetos de pesquisa deseja criar um sistema de banco de dados para gerenciar seu funcionamento. Para cada projeto são cadastrados: 
- Código interno 
- título
- Duração do projeto 
- Instituição onde será realizado
- Área de pesquisa. 

As áreas de pesquisa estão predefinidas é para cada uma delas são cadastrados 
- Código 
- Nome 
- Descrição 
- Indice que indica sua relevância econômica. 

Para cada pesquisador solicitante são cadastrados: 
- RG 
- CPF 
- Nome 
- Sexo 
- Data de nascimento 
- Grau científico
- Instituição onde foi alcançado esse título. 

Note-se que um mesmo pesquisador pode ter vários projetos em análise. Um pesquisador é cadastrado no sistema unicamente quando o primeiro dos seus projetos é submetido.

A agência recebe os projetos submetidos pelos pesquisadores e associa cada um destes a um assessor que deve aprovar ou não o financiamento. Para estes assessores são cadastrados: 
- RG 
- CPF 
- Nome 
- Sexo 
- Data de nascimento 
- Grau científico 
- Instituição onde trabalha
- Áreas nas quais tem capacidade de avaliar projetos. 

Estas áreas de pesquisa devem ser definidas dentre a lista de áreas predefinidas antes mencionadas.

Um assessor pode ser cadastrado mesmo sem ter analisado nenhum projeto. Quando um projeto é enviado a um assessor para análise, é cadastrada a data deste envio. Posteriormente, quando o assessor retorna sua avaliação são também cadastrados a data de resposta e o resultado de aprovação ou não do projeto.
