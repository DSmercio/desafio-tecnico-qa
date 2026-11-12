# Documentação Técnica e Avaliação de Competências em QA

Este documento
reúne as respostas teóricas da Parte 1 e a especificação de engenharia
de requisitos e modelagem BDD da Parte 6 do Desafio Técnico de QA.

## Parte 1: Questões Teóricas sobre Competências de QA

### Questão 1: Qual é o principal objetivo da análise de risco no processo de teste?
O principal objetivo é identificar, avaliar e priorizar os potenciais pontos de falha no sistema e seus impactos no negócio antes do início da execução dos testes. A análise de risco permite ao QA aplicar o conceito de Risk-Based Testing, direcionando o tempo e os recursos de automação/teste manual para os fluxos mais críticos e com maior probabilidade de defeitos.

### Questão 2: O que é um teste baseado em requisitos? Cite exemplos.
É uma abordagem de teste caixa-preta onde os cenários e critérios de aceitação são derivados diretamente das especificações funcionais, Histórias de Usuário (User Stories) ou regras de negócio.

**Exemplo:** Em um e-commerce, o requisito especifica: "Descontos de cupom de 10% só devem se aplicar a compras acima de R\$ 100". O teste baseado em requisitos validará se um pedido de R\$ 99 não recebe o desconto e um de R\$ 101 recebe o desconto corretamente.

### Questão 3: O que é um teste unitário e quem os realiza? Cite exemplos.
O teste unitário é a validação da menor unidade isolada de código (como um método, função ou classe) sem dependências externas reais (banco de dados ou APIs são mockados).

**Quem realiza:** Desenvolvedores de software.Exemplo: Testar um método
Java calcularDesconto(double valorTotal, String cupom) para verificar se
ele retorna o valor numérico correto sob diferentes condições. 
### Questão 4: O que é um teste de Integração e quem os realiza? Cite exemplos.
O teste de integração valida a interface, o contrato e o fluxo
de dados entre dois ou mais componentes, módulos ou serviços
independentes que foram integrados.

**Quem realiza:** Desenvolvedores e Engenheiros de QA.Exemplo: Testar se
o serviço de Carrinho envia o payload no formato correto para o
microsserviço de Checkout via API REST e recebe o status HTTP 200/201. 
### Questão 5: Você precisa realizar testes de Performance em uma aplicação web que calcula o tempo das rotas de entrega para um serviço de entregas por motoboys que realiza 20 milhões de entregas por dia.Quais os conceitos de Testes de Performance você consideraria para esta situação? E quais tipos de Testes de Performance você realizaria nesta situação?

**Conceitos a considerar:** 
Throughput (vazão de requisições/segundo),
Tempo Médio de Resposta, Latência de Rede, Uso de CPU/Memória e os
Percentis P90/P95/P99.

**Tipos de Testes de Performance a realizar:** 

**Teste de Carga (Load Test):** 
Simular a média de tráfego esperado durante o dia para medir a
capacidade baseline. 

**Teste de Estresse (Stress Test):**
Submeter o algoritmo de cálculo de rotas a uma carga muito superior a 20 milhões/dia para identificar o ponto de ruptura da infraestrutura
(breaking point). 

**Teste de Pico (Spike Test):** Simular subidas repentinas
de requisições em horários de pico (ex: horário de almoço ou chuva).

**Teste de Resiliência/Endurance (Soak Test):** Manter uma carga constante por 8 a 12 horas para identificar vazamento de memória (memory leaks) ou
degradação progressiva de banco de dados. 
### Questão 6: O que é CI e CD (Continuous Integration e Continuous Delivery/Deployment)? Cite exemplos práticos aplicados ao QA. 
**CI (Integração Contínua):** Prática
onde desenvolvedores mesclam código em um repositório central com frequência, disparando compilação e suítes de testes automáticos.

**CD (Entrega/Implantação Contínua):** Automatização da entrega do código
validado para ambientes de Staging/Homologação (Delivery) ou direto para
Produção (Deployment).

**Exemplo em QA:** 
- A cada git push ou Pull Request
no GitHub, uma pipeline do GitHub Actions executa os testes unitários, a
automação de API (Rest Assured) e a automação Web (Selenium). Se algum
teste falhar, o deploy para staging é bloqueado automaticamente. 
### Questão 7: Qual tipo de teste foca no comportamento interno do software?
O Teste de **Caixa-Branca (White-Box Testing)** ou **Teste
Estrutural**, que exige acesso ao código-fonte e lógica interna de
desenvolvimento. 
### Questão 8: Qual tipo de teste foca no comportamento externo do software?
O **Teste de Caixa-Preta (Black-Box
Testing)** ou **Teste Funcional**, que avalia as entradas e saídas sem analisar como o código foi implementado internamente. 
### Questão 9:Cite a importância dos testes Exploratórios.
Os testes exploratórios
combinam aprendizado, design e execução simultânea de testes. São
cruciais para descobrir falhas de usabilidade, comportamentos não
mapeados nas histórias de usuário e bugs complexos de borda que scripts
de teste rígidos não conseguem pegar. 
### Questão 10: Quais são os benefícios de termos uma automação de testes funcionais?
Feedback rápido
sobre a saúde do sistema (Fast Feedback Loop). - Redução de erros
humanos em tarefas de validação repetitivas. - Execução em larga escala
e em múltiplos ambientes através da pipeline de CI/CD. - Liberação da
equipe de QA para focar em testes estratégicos e exploratórios. 
### Questão 11: Em qual etapa do projeto o QA deve ser envolvido?
O QA deve ser envolvido na etapa inicial do ciclo de vida, no momento da concepção
do projeto/requisitos (abordagem Shift-Left), participando de
refinamentos, definições de Critérios de Aceite (Three Amigos) e
modelagem de arquitetura de testes. 
### Questão 12: Como manter um trabalho ágil como um todo?
Mantendo ciclos curtos de feedback,
promovendo colaboração diária entre PO, Devs e QA, garantindo histórias de usuário bem refinadas (critérios de aceite claros), automatizando regressões e ajustando a capacidade de entregas com base no WIP (Work in
Progress). 
### Questão 13: Na sua visão, a Qualidade do Software é uma responsabilidade apenas do QA? Justifique sua resposta.
Não, a qualidade é uma responsabilidade de todo o time (Whole Team Ownership). O PO é
responsável por especificar o requisito correto, o desenvolvedor por
aplicar boas práticas de arquitetura e testes unitários, e o QA atua
como um facilitador estratégico da qualidade, garantindo a prevenção de
defeitos em todo o processo. 
### Questão 14: Indique uma ou mais formas de executar testes não funcionais, e explique a importância dos mesmos.

**Formas:** Testes de Performance com Apache JMeter/k6, Testes de
Segurança com OWASP ZAP e Testes de Acessibilidade com ferramentas como
Lighthouse ou axe DevTools.

**Importância:** Um sistema pode funcionar perfeitamente em termos de
regras de negócio, mas ser inviável comercialmente se for extremamente
lento, vazar dados de usuários ou ser inacessível para pessoas com
deficiência. 
### Questão 15: Indique maneiras de dar visibilidade das tarefas do QA pro time como um todo. 
- Manter o board Kanban (ex: Jira)
atualizado com status claros de teste. 
- Apresentar métricas de
qualidade (taxa de conversão de bugs, tempo de ciclo, cobertura de
testes) em refinamentos e retrospectivas. 
- Integrar relatórios visuais
de automação (ex: Allure Reports) com alertas em canais de comunicação
do time (Slack/Teams). 
### Questão 16: De um modo geral, explique as vantagens dos testes manuais e dos automatizados, dê exemplos de aplicação de cada um e seus devidos benefícios.
Testes Manuais:

**Vantagens:** Alta adaptabilidade, avaliação empática de UX/UI e
descoberta de falhas inesperadas. Exemplo: Avaliar a navegação e
intuitividade de um novo fluxo de compra em dispositivos móveis.

Testes
Automatizados:

**Vantagens:** Alta velocidade de execução, repetibilidade sem cansaço e
custo zero por execução após o script estar pronto. Exemplo: Suíte de
testes de regressão de API de autenticação que valida 50 cenários de
login em menos de 10 segundos. 
### Questão 17: Na sua visão, o que a IA pode colaborar para os testes de software? Cite exemplos que possam ajudar no dia a dia.

**Colaboração:** Acelerando tarefas repetitivas, otimizando o design de
cenários e auxiliando na depuração de códigos e logs.

**Exemplos:** 
- Geração de massa de dados sintética complexa. 
- Apoio na
criação inicial de sintaxe BDD/Gherkin a partir de User Stories. 
- Diagnóstico de logs de erro em suítes de testes automatizados para
encontrar a causa raiz (Root Cause Analysis). 
- ### Questão 18: Cite exemplos da importância da rastreabilidade nos testes.
- A rastreabilidade
garante a ligação direta entre Requisito $\rightarrow$ Cenário de Teste
$\rightarrow$ Execução $\rightarrow$ Defeito (Bug).

**Importância:** Se uma regra de negócio mudar no meio da Sprint, a
rastreabilidade permite saber exatamente quais casos de teste e scripts
automatizados precisam ser atualizados. Em caso de auditorias, ela prova
a cobertura completa das regras exigidas. 
### Questão 19: Na sua visão,quando os testes são o suficiente?
Os testes são suficientes quando o
risco residual aceitável é atingido, os critérios de aceite definidos
com o negócio foram atendidos, os cenários críticos foram validados com
taxa de sucesso satisfatória e o custo financeiro/tempo de encontrar um
novo bug supera o impacto que ele causaria. 
### Questão 20: Vamos imaginar 2 cenários que não são ideais:QA está atuando sozinho na squad,mas os DEVs entregam as tarefas com certa rapidez.A equipe de QA é suficiente porém os DEVs liberam as tarefas no final da sprint.Qual é o pior e por que? 
O Cenário 2 é o pior. A liberação tardia de tarefas no
final da sprint gera o efeito "funil" (bottleneck). O QA não terá tempo
hábil para executar testes profundos ou reportar bugs para correção na
mesma sprint, resultando em entregas apressadas e com risco elevado para
produção.

**Como atuar para resolver:** Implementar entregas contínuas em pequenos
lotes (Small Batches), incentivar testes pareados (Dev + QA) assim que o
recurso fica pronto e adotar a automação de testes unitários/integração
no lado do desenvolvimento. 
### Questão 21: Diferencie teste estático e dinâmico.
**Teste Estático:** Realizado sem a execução do software (ex:
revisão de código, análise estática com SonarQube, leitura de
documentação/requisitos).

**Teste Dinâmico:** Realizado com a aplicação em
execução, fornecendo dados de entrada e validando os resultados obtidos
(ex: testes manuais de tela, testes de API via Rest Assured). 
### Questão 22: Diferencie teste alfa e beta.
**Teste Alfa:** Realizado
internamente na empresa desenvolvedora por membros da própria
organização (desenvolvedores, QAs ou stakeholders) antes do lançamento
do produto.

**Teste Beta:** Realizado em ambiente externo por um grupo de
usuários reais do público-alvo antes do lançamento geral para coletar
feedbacks práticos de uso no mundo real. 
### Questão 23: O que é Splunk? Ele pode ser usado por QAs? Se sim, cite exemplos práticos.
O
Splunk é uma plataforma de monitoramento e análise de dados em tempo
real que centraliza e indexa logs de sistemas e infraestrutura.

**Uso por QAs:** Sim, é fundamental.

**Exemplo prático:** Ao identificar um erro HTTP 500 durante uma
automação de testes ou teste manual, o QA pode buscar no Splunk os logs
de exceção do servidor no exato segundo do erro para anexar a stack
trace detalhada ao card do Bug. 
### Questão 24: Cite exemplos de como a AWS (ou serviços de Nuvem) pode ser usada no trabalho do QA. 
- Execução
em paralelo de testes automatizados em contêineres gerenciados pelo AWS
ECS ou EKS. 
- Armazenamento de evidências, prints de falhas e relatórios
HTML de execução em buckets do AWS S3. 
- Criação e destruição dinâmica
de ambientes temporários de teste (ephemeral environments) via AWS EC2.
### Questão 25: Você precisa executar um script de Performance via linha de comando para um projeto. Escreva um exemplo de linha de comando para executar um script performático (ex: JMeter em modo não-GUI ou k6).
**Exemplo JMeter em modo não-GUI:**

``` bash
./jmeter -n -t load-test.jmx -l resultado.csv -e -o relatorio_html
```

**Exemplo k6:**

``` bash
k6 run --vus 50 --duration 5m script-performance.js
```

### Questão 26: Você é um QA especialista em Testes de Performance. Você tem 2 clientes principais: Uma grande indústria de carros e um programa de TV com vários patrocinadores. Nesse cenário, qual dos dois clientes necessita mais de um teste performático e por que?
O programa de TV com vários patrocinadores necessita mais urgentemente de testes de performance de carga/pico.

**Justificativa:** Programas de TV geram tráfego em formato de "Spike"
(pico repentino e gigante). Quando o apresentador anuncia um produto ao
vivo, milhões de acessos simultâneos acontecem em segundos. Se a
aplicação cair, o prejuízo financeiro e contratual com os patrocinadores
é imediato. Na indústria de carros, os sistemas críticos são embarcados
ou de produção (onde o foco é confiabilidade/segurança física), e os
acessos aos portais de vendas costumam ser distribuídos ao longo do dia.
### Questão 27: Você é Especialista em Automação de Testes, porém sua empresa tem uma resistência muito grande para aderir à automação (mesmo necessitando). Que estratégia você usaria para convencer seus gestores e a empresa como um todo a usarem a automação de testes?
**Apresentar o ROI
(Retorno sobre o Investimento):** Mostrar dados numéricos sobre quanto
tempo é gasto repetindo testes de regressão manuais a cada release vs. o
tempo de execução automatizado. 

- **Prova de Conceito (PoC)**: Escolher o
fluxo de negócio mais crítico e doloroso para a empresa (ex: o login ou
fluxo principal de vendas) e criar uma PoC funcional demonstrando a
execução em poucos segundos. 
- **Automatizar sem burocracia na Pipeline:**
Integrar essa PoC na esteira de CI/CD para mostrar aos desenvolvedores o
valor do feedback rápido ao enviar novos códigos. 
### Questão 28: O que é teste de confiabilidade?
É o tipo de teste não funcional que valida se
um sistema consegue manter o nível de desempenho esperado e funcionar
sem falhas operacionais sob condições específicas por um determinado
período de tempo. 
### Questão 29: O que é teste de portabilidade?
É a validação do comportamento e funcionamento da aplicação quando ela é
transferida entre diferentes ambientes de hardware, sistemas
operacionais, navegadores ou configurações de rede. 
### Questão 30: O que é teste de segurança?
É o processo de validação que visa identificar
vulnerabilidades, brechas de acesso, falhas de autenticação/autorização
e riscos de vazamento de dados no sistema, garantindo a proteção dos
ativos da informação contra ataques maliciosos.

## Parte 6: Engenharia de Requisitos e Modelagem BDD (PayPal)

### História de Usuário (US-042)

**Como** um aluno interessado em adquirir cursos na plataforma de ensino
online,

**Quero** realizar o pagamento das minhas compras utilizando minha conta
PayPal,

**Para que** eu tenha uma opção de pagamento rápida, segura e sem a
necessidade de digitar os dados do meu cartão diretamente no site.

### Suíte de Cenários de Teste em Sintaxe BDD / Gherkin

``` gherkin
# language: pt
Funcionalidade: Pagamento de Cursos via PayPal (US-042)
  Como um aluno da plataforma de ensino online
  Quero efetuar o pagamento do curso utilizando o PayPal
  Para concluir a compra com rapidez e segurança

Cenário: Compra realizada com sucesso via PayPal (Caminho Feliz)
    Dado que o aluno está na tela de Checkout com um curso no carrinho
    E a opção de pagamento "PayPal" está visível ao lado das demais opções
    Quando o aluno seleciona "PayPal" e clica em "Concluir Compra"
    E conclui a autenticação e autorização de pagamento na janela do PayPal
    Então o aluno deve ser redirecionado para a página de sucesso da plataforma
    E a tela deve exibir a mensagem "Pagamento Aprovado"
    E a transação deve ser gravada no banco de dados com ID do pedido, ID PayPal, valor, moeda "BRL" e data/hora

Cenário: Transação recusada pela instituição de pagamento (Exceção)
    Dado que o aluno iniciou o pagamento via PayPal na tela de Checkout
    Quando o pagamento é recusado pelo PayPal por insuficiência de saldo ou cartão inválido
    Então o aluno deve ser redirecionado de volta para a tela de Checkout da plataforma
    E uma mensagem amigável "Não foi possível concluir seu pagamento via PayPal. Tente outro método." deve ser exibida
    E os cursos selecionados devem permanecer salvos no carrinho de compras

Cenário: Cancelamento manual do pagamento pelo usuário no ambiente do PayPal
    Dado que o aluno foi redirecionado para a janela externa do PayPal
    Quando o aluno clica no link "Cancelar e voltar para a loja" ou fecha a janela do PayPal
    Então a plataforma deve reabrir a tela de Checkout
    E informar ao aluno que o processo de pagamento foi cancelado
    E o carrinho de compras deve ser mantido intacto
    
Cenário: Liberação de acesso ao curso após notificação assíncrona (Webhook / IPN)
    Dado que uma compra via PayPal foi finalizada e aguarda processamento
    Quando a plataforma recebe a notificação assíncrona Webhook/IPN com status de pagamento confirmado (`PAYMENT.SALE.COMPLETED`)
    Então a plataforma deve atualizar o status do pedido para "Concluído"
    E a liberação do acesso ao curso online deve ser efetuada imediatamente na conta do aluno

Cenário: Prevenção de múltiplos cliques concorrentes no botão de checkout
    Dado que o aluno está na tela de Checkout com o método PayPal selecionado
    Quando o aluno clica repetidamente e de forma simultânea no botão "Concluir Compra"
    Então o sistema deve processar apenas o primeiro clique e desabilitar a ação dos cliques subsequentes
    E abrir apenas uma única sessão de pagamento com o PayPal
```

### Estratégia de Priorização para a Pipeline de CI/CD

**Cenários priorizados:**

-   **Cenário 1 (Caminho Feliz):** Automação End-to-End de regressão na
    esteira.
-   **Cenário 4 (Processamento de Webhook/IPN):** Automação no nível de
    API/Backend.

**Justificativa da escolha:**

-   **Cenário 1 (Caminho Feliz):** Garante a saúde da principal jornada
    de conversão de receita do negócio. Se a integração do Checkout
    quebrar em uma nova release, o impacto financeiro para a empresa é
    imediato.- **Cenário 4 (Webhook/IPN):** É a peça central da
    arquitetura assíncrona de pagamento. Automatizar este teste em nível
    de API garante que o aluno receba o produto digital logo após o
    pagamento, evitando chamadas desnecessárias ao suporte ao cliente
    por falta de liberação de conteúdo.

**Nota técnica de arquitetura:** Em ambientes de CI/CD automatizados, a
interação com telas de terceiros (como o pop-up real do PayPal) é
contornada utilizando stubs/mocks de API para evitar instabilidades de
rede, verificações de CAPTCHA e falhas falsas-positivas na esteira.
