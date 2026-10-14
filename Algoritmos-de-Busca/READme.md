# 🔍 Comparativo de Desempenho: Busca Sequencial vs. Busca Binária

Projeto desenvolvido para a disciplina de **Algoritmos e Estruturas de Dados** (Atividades Práticas Supervisadas - APS) na **Universidade Paulista (UNIP)**. 

O objetivo principal deste projeto é comparar empiricamente o tempo de execução e a eficiência entre os algoritmos de **Busca Sequencial** ($O(n)$) e **Busca Binária** ($O(\log n)$) ao trabalharem com diferentes volumes de dados ordenados.

---

## 🚀 Funcionalidades

- **Geração Dinâmica de Dados**: Criação de arrays de inteiros em ordem aleatória para diferentes tamanhos ($N$).
- **Ordenação Prévia**: Uso do algoritmo `Arrays.sort()` para preparar o conjunto de dados para a busca binária.
- **Simulação do Pior Caso**: Testes configurados para buscar o último elemento do array, exigindo o esforço máximo do algoritmo sequencial.
- **Média de Execução**: Execução repetida (5 iterações por tamanho) para calcular médias precisas em milissegundos ($ms$).
- **Cálculo da Razão $Seq/Bin$**: Demonstração de quantas vezes a Busca Binária é mais rápida que a Busca Sequencial.

---

## 📊 Cenários de Teste

O algoritmo avalia o comportamento de ambos os métodos com as seguintes magnitudes de dados ($N$):

| Tamanho ($N$) | Elementos |
| :--- | :--- |
| **1 mil** | $1.000$ |
| **10 mil** | $10.000$ |
| **100 mil** | $100.000$ |
| **1 mi** | $1.000.000$ |
| **10 mi** | $10.000.000$ |
| **100 mi** | $100.000.000$ |

---

## 📈 Tabela de Resultados Esperados

Ao executar o programa, o console exibe uma tabela comparativa com o seguinte formato:

```text
================================================================
       COMPARATIVO: BUSCA SEQUENCIAL vs BUSCA BINÁRIA
================================================================
Tamanho (N)     Seq. (ms) média      Bin. (ms) média      Razão Seq/Bin
----------------------------------------------------------------
1 mil           0.0051               0.000800             6.4         
10 mil          0.0420               0.001100             38.2        
100 mil         0.3120               0.001500             208.0       
1 mi            2.8500               0.002100             1357.1      
10 mi           29.4000              0.003200             9187.5      
100 mi          295.1000             0.004500             65577.8     
================================================================

CONCLUSÃO:
  - A busca binária é ordens de magnitude mais rápida que a
    sequencial para grandes volumes de dados.
  - A razão Seq/Bin cresce aproximadamente com log2(N),
    confirmando as complexidades O(n) vs O(log n).
  - Para N=100 milhões, a busca sequencial pode ser
    milhares de vezes mais lenta que a binária.
================================================================
```

---

## ⏱️ Análise de Complexidade Assintótica

- **Busca Sequencial — $O(n)$**: Percorre o array elemento por elemento a partir do início. No pior caso (elemento no final do array ou ausente), o tempo de busca cresce linearmente com o tamanho do conjunto de dados.
- **Busca Binária — $O(\log n)$**: Divide repetidamente o intervalo de busca pela metade. Requer que os dados estejam ordenados previamente, mas reduz dramaticamente o número de comparações em grandes volumes de dados.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java (JDK 8 ou superior)
- **IDE**: NetBeans / VS Code / IntelliJ IDEA
- **Sistema de Build**: Apache Ant (`build.xml`)

---

## 📁 Estrutura do Projeto

```text
.
├── src/
│   └── aps/
│       └── Aps.java        # Classe principal com as buscas e medições
├── nbproject/              # Configurações do NetBeans
├── build.xml               # Script de build do Apache Ant
├── manifest.mf             # Arquivo de manifesto do JAR
└── README.md               # Documentação do projeto
```

---

## 💻 Como Executar

### Pré-requisitos
Ter o **JDK (Java Development Kit)** instalado na versão 8 ou superior.

### Via Linha de Comando (Terminal)

1. **Navegue até a pasta do projeto:**
   ```bash
   cd aps-busca-sequencial-binaria
   ```

2. **Compile a classe Java:**
   ```bash
   javac -d bin src/aps/Aps.java
   ```

3. **Execute o programa:**
   ```bash
   java -cp bin aps.Aps
   ```

### Via NetBeans ou VS Code
1. Abra a pasta do projeto na sua IDE.
2. Localize a classe `src/aps/Aps.java`.
3. Clique em **Run** ou pressione `Shift + F6` (no NetBeans).
