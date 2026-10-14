# StudyTrack 📚

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose para auxiliar estudantes a organizar suas disciplinas.

## Funcionalidades

- Cadastro de disciplinas com nome e descrição.
- Listagem das disciplinas cadastradas.
- Visualização dos detalhes de cada disciplina.
- Edição do nome e da descrição.
- Exclusão de disciplinas.
- Validação para impedir o cadastro ou a edição sem nome.
- Armazenamento local dos dados, mantendo as informações após fechar o aplicativo.
- Contagem de disciplinas cadastradas na tela inicial.

## Tecnologias utilizadas

- **Kotlin:** linguagem de programação.
- **Jetpack Compose:** construção da interface.
- **Navigation Compose:** navegação entre telas.
- **Room:** persistência local de dados.
- **ViewModel:** gerenciamento do estado e da lógica da interface.
- **Repository:** organização do acesso aos dados.
- **Coroutines:** execução de operações assíncronas.

## Arquitetura

O projeto utiliza uma organização inspirada no padrão MVVM, separando a interface, a lógica de apresentação e o acesso aos dados.

- **UI:** telas e componentes construídos com Jetpack Compose.
- **ViewModel:** gerencia os dados apresentados pela interface e as ações do usuário.
- **Repository:** intermedia o acesso aos dados.
- **Room:** armazena as disciplinas localmente no dispositivo.

## Como executar

1. Clone este repositório.
2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Execute o aplicativo em um emulador Android ou dispositivo compatível.

## Objetivo acadêmico

O StudyTrack foi desenvolvido como projeto acadêmico para praticar desenvolvimento Android com Kotlin, construção de interfaces declarativas, navegação entre telas, persistência de dados e organização de código para prática do módulo intermediário de Capacita IREDE.

## Autoria

Desenvolvido por Francisca Ariane dos Santos da Silva