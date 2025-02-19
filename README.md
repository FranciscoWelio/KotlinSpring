# Teste Técnico - Francisco Welio Firmino da Silva Junior

## Configurações utilizadas
- Kotlin 1.9.25
- SpringBoot 3.4.2

---
## Questões

### L1 Autorização Simples
Resolução: Foi criado 3 entidades
- Merchant (Loja/Local de compra)
- Usuario (Beneficiário do cartão que fará a compra)
- Transaction(Estruta a transação feita pelo o Usuário na Loja/Local)

Foi criado 6 Endpoints,
- 3 Post
  - Criar Usuário
  - Criar Merchant 
  - Fazer Transação
- 3 Get
  - Get Usuario
  - Ger Merchant 
  - Get Transação
### L2 Autorizador Com Fallback
Resolução: No transaçãonService Foi alterado a condição para analisar o "amount" da transação
e comprara com o valor no benefício do Usuário. Para assim, descontar corretamente de cada benefício

### L3 Dependente Do Comerciante
Resolução: No MerchantController foi criado uma solução para identificar o MCC adicionado e concatenar
no nome do Local "Mercado" ou "Restaurante" para promover uma solução, visto que um Local poderia ter
uma infinidade de nomes, como por Exemplo: "Frango da Casa", "Mini-box São Tomé", "NAU". Possívelmente os
nomes Fantasias dos CNPJ. Devido a quantidade impraticável de Possíveis nomes, foi tratado como explicado acima.
No TransactionService foi alterado a condição para analisar o MCC e os nomes dos locais, buscando referência para
determinar de onde seria subtraído o valor da transação.

### L4 Questão Aberta
Resolução: Utilizando o @Transactional podemos ter um controle melhor da concorrência e evitar problemas com
Transações concorrentes. Visto que a anotação Transactional esperar a conclusão, podemos utilizar os atributos
da anotação para melhorar o desempenho e ter uma confiabilidade de concorrentes ou evitar completamente
e perder desempenho.
Utilizando o isolation = READ_COMMITTED: garantios a leitura apenas de dados confirmados
e melhoramos a confiabilidade com um desempenho adequado
Mas utilizando o isolation = SERIALIZABLE evitaremos completamente a concorrência, Mas
perderemos desempenho.

---
# Teste

Os testes foram realizados manualmente utilizando um banco H2 para poder mapear o funcionamento.
Os testes foram feitos no Swagger da aplicação para verificar as chamadas dos Endpoints, as Responses, 
a estrutura Json, Códigos Https
