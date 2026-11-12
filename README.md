# 🚀 Desafio Técnico Sênior de Quality Assurance (QA)

Repositório unificado contendo soluções de automação de testes de API, interface web (UI), scripts utilitários, engenharia de performance e modelagem de cenários de teste (BDD).

---

## 🛠️ Tecnologias e Ferramentas Utilizadas
* **Linguagem:** Java (JDK 17+)
* **Gerenciador de Dependências:** Maven
* **Test Framework:** JUnit 5
* **Automação de API:** Rest Assured
* **Automação Web (UI):** Selenium WebDriver (com Page Object Model - POM)
* **Performance:** Apache JMeter (5.6.3)
* **Controle de Versão:** Git / GitHub

---

## 📂 Estrutura do Projeto (Monorepo)

```text
desafio-tecnico-qa/
├── src/test/java/
│   ├── clients/           # Clientes de integração de API (Rest Assured)
│   ├── models/            # Payloads e classes de mapeamento
│   ├── pages/             # Page Objects (Selenium WebDriver)
│   ├── tests/             # Classes de execução dos testes (JUnit 5)
│   └── utils/             # Scripts utilitários (Validador de E-mails)
├── jmeter-performance/    # Scripts de teste de carga e relatórios (.jmx e .csv)
├── documentacao-desafio-qa.md # Respostas teóricas (30 questões) e modelagem BDD
├── pom.xml                # Configuração de dependências Maven
└── README.md              # Documentação principal do projeto
```

---
## ⚙️ Como Executar o Projeto Localmente

### Pré-requisitos
* Java JDK 17+ instalado e configurado nas variáveis de ambiente.
* Maven instalado.
* Apache JMeter instalado (caso queira reexecutar os testes de performance).

### 1. Clonar o Repositório
```
Bash
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
cd seu-repositorio
```
### 2. Executar os Testes de API (DummyJSON)
No terminal, execute o comando Maven para rodar a suíte de testes de API:
```
Bash
mvn test -Dtest=DummyJsonTest
```
### 3. Executar os Testes Web / UI (SwagLabs)
Para rodar a automação E2E da interface web:
```
Bash
mvn test -Dtest=SwagLabsE2ETest
```
### 4. Executar o Script Utilitário de Validação de E-mails

Para rodar o script Java que valida sintaxe e gera o arquivo `validacao_emails.csv`:

* Abra o projeto no IntelliJ IDEA.
* Navegue até `src/test/java/utils/EmailValidatorScript.java`.
* Clique com o botão direito e selecione **Run 'EmailValidatorScript.main()'**.

### 5. Executar o Teste de Performance (JMeter)

Para rodar o teste de carga do BlazeDemo via linha de comando (modo não-GUI):

1. Acesse a pasta de performance:
```
Bash   
cd jmeter-performance
```
2. Execute o comando do JMeter:
```
Bash   
jmeter -n -t load-test.jmx -l resultado.csv -e -o relatorio_html
```
3. Abra o arquivo `relatorio_html/index.html` no seu navegador para analisar as métricas de Throughput, Tempo de Resposta e Percentis (P90/P95/P99).

## 📚 Documentação Adicional

* As **30 Questões Teóricas sobre as Competências da Vaga (Parte 1)** respondidas e a **Modelagem de Cenários BDD (Parte 6 - Integração PayPal)** encontram-se documentadas na íntegra no arquivo [`documentacao-desafio-qa.md`](./documentacao-desafio-qa.md).

