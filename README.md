# Exemplo Integração CIPIWS

### Credenciais

* Os serviços privados do CIPIWS possui algumas validações no objeto recebido, umas delas é a validação de credenciais.
Um objeto contendo algumas informações de quem está integrando com o CIPIWS, são eles:
    
      {
        codigoOrgao - String,
        sistema - String,
        cpf - String
      }

##### codigoOrgao - Código da organização do Usuário.
##### sistema - Sigla do Sistema que está realizando a integração.
##### cpf - Cpf do usuário que está relalizando a integração.

Ex: Classe CredenciaisService do projeto

### Token

* Todos serviços privados do CIPIWS requerem um Token de segurança, o mesmo deve ser enviado junto a requisição,
 na propriedade Authorization do cabeçalho da requisição.

* O mesmo deve ser requisitado no serviço:

        /cipiws/api/public/sistema/gerar-token
        
 * Passando os seguintes Parâmetros:
 
        {
            usuario - String,
            senha - String
        } 
        
##### usuario - Sigla do Sistema que está realizando a integração.
##### senha - Senha do Sistema.

Ex: Classe CipiwsTokenService do projeto.


### Exemplos Projeto

O Projeto integração.cipiws tem como intuito demonstrar uma integração de um sistema externo com o CIPIWS, segue passo a passo:

* Ao Iniciar a Aplicação é realizada uma integração inicial com o CIPIWS por meio de um Singleton 
que realiza a busca de um token no CIPIWS para que seja utilizado nas demais requisições:

        Classe: RetokenGatewayService
 
* Para ter acesso ao Swagger, deve ser acessar a url:

        Url: http://localhost:8080/swagger-ui.html#
        Item: teste-integracao-cipiws
        Serviço: /api/cipiws/teste-integracao

* Ao acionar o serviço, será realizada uma requisição o método obterPorId da classe CipiwsSistemaService, 
onde será acionado um serviço do CIPIWS, caso tenha uma exceção retornada do CIPIWS a classe RetokenGatewayService irá 
realizar a consulta de um novo token e realizará a requisição novamente com o novo token recebido.

 
 
 * Obs: para conseguir gerar o token é necessário inserir o usuário e senha nos atributos cipi.usr e cipi.senha e cipi.codOrg 
 no arquivo application.properties na pasta resources
