# Desenvolvimento III - App de Academia

O app foi desenvolvido com o intuito de servir como um gerenciador para atividades voltadas a Academias, como criação de turmas e manutenção de dados dos alunos e instrutores.

O app tem a divisão entre dois tipos de usuários: Alunos e Instrutores, nos quais instrutores funcionam como administradores do sistema - tendo permissão para modificar dados além de criar novos usuários.

Para DB, o app utiliza Google Firebase.

## Login

O login é feito com MD5 diretamente com o Firebase. Usuários são criados ou pelo próprio console do Firebase ou por dentro do sistema por administradores.

![login](https://github.com/ChristianPrzybulinski/DSWIII_Grupo03/blob/master/login.png)

## Tela Inicial

A tela inicial mostra as turmas nas quais o usuario está cadastrado pro dia de hoje. Pra acessar as demais funções, usa-se o menu da Action Bar.

## Perfil de Usuário

Mostra as informações cadastrais do usuário. Nesta tela existe uma diferença de permissão entre os dois tipos de usuários:
- Administradores (instrutores) podem alterar todos os campos de seu perfil.
- Alunos somente tem autorização para alterar alguns campos.

Todos tipos de usuário tem permissão de visualização de todos campos.

## Turmas

A tela de turmas permite que seja selecionado o dia ao qual quer ser visualizada ou inclusa a turma e a partir daí abre a segunda tela que lista todas as turmas cadastradas pro usuário.

| ![turma1](https://github.com/ChristianPrzybulinski/DSWIII_Grupo03/blob/master/turma1.png) | ![turma2](https://github.com/ChristianPrzybulinski/DSWIII_Grupo03/blob/master/turma2.png) |
|:---:|:---:|


## Autores

* **Christian Przybulinski** -  [ChristianPrzybulinski](https://github.com/ChristianPrzybulinski)
* **Gabriel Rech** -  [gaelrech](https://github.com/gaelrech)
* **Thales Fortes** -  [fsthales](https://github.com/fsthales)


