# projeto_ioasys

**Bibliotecas Adicionadas:**
- 'androidx.cardview:cardview:1.0.0' > Para poder usar o componente de CardView, usado nos itens de lista.
- 'com.squareup.retrofit2:retrofit:2.9.0' > Usado para fazer requisições no servidor
- 'com.squareup.retrofit2:converter-gson:2.5.0' > Usada para auxiliar nas resquisições com o servidor
- 'com.github.bumptech.glide:glide:4.9.0' > Usado para lidar com carregamento de imagens via servidor


**O que eu faria se tivesse mais tempo:**
- Melhoraria alguns componentes visando otimização da aplicação
- Criaria mais tratavivas para evitar bugs e melhorar a UX
- Melhoraria a manutenibilidade do código
- Implementaria RXJava/Couroutines 

**Instruções de uso**
- Na tela de login, digitar o usuario e senha, e apertar em entrar. 
Caso queira usar um usuário fixo pré-definido para este projeto, basta segurar o botao Entrar.
- Na tela principal, ao apertar no ícone de lupa, ele irá pedir para Pesquisar por empresa. Ao terminar de digitar a empresa, aperte no botão de lupa que aparece no próprio teclado. (Digitando apenas a letra *a* na busca, ele retorna duas empresas)
- Depois de pesquisar, ele irá trazer os dados da empresa, se existirem.
- Caso tenha dados de empresa, ele irá traze-los e poderá clicar na empresa para ver os detalhes.

**Minhas observações**
- Fiz conforme consegui entender de acordo com o *Escopo do Projeto*, porém, fica algumas observações.
- Não consegui entender aonde deveria usar os dados que são retornados no BODY ao fazer Login.
- Nas requisições de empresa, eu deixei os parametros *enterprise_types* com valor 1 fixo, e o *name* digitado dinamicamente na pesquisa, de acordo com a Collection do Postman.
- Como nenhuma empresa estava retornando imagem, eu criei um paliativo para evitar o carregando do campo, e usei o icone do Android para ser exibido.

Por conta do tempo, eu fiz as funções principais do projeto, e não fiz uso de todos os itens do *Bônus*
