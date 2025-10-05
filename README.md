# 🎲 Laboratório de Estrutura de Dados - UFCG

## 📝 Descrição
Repositório com os roteiros de algoritmos e estruturas de dados desenvolvidos ao longo da disciplina. Cada roteiro aborda implementações práticas de conceitos fundamentais da ciência da computação.

## 🛠️ Tecnologias e Ferramentas
- **Java** - Linguagem de programação
- **Maven** - Gerenciamento de dependências
- **JUnit** - Testes unitários

## 🚀 Como Executar

### Pré-requisitos
- **Java 8+** instalado
- **Maven** (opcional - incluído nos projetos)

### Executando um Roteiro
```bash
# Navegue até o diretório do roteiro desejado
cd R01-01-Rot-SimpleSorting-Bidirectional-Bubble-environment

# Compilar o projeto
mvn compile

# Executar testes
mvn test

# Executar com Java (se aplicável)
mvn exec:java
```

## 📚 Roteiros Desenvolvidos

| Roteiro | Tema abordado | Código |
|---------|---------------|--------|
| **R01** | Ordenação por comparação (BubbleSort, SelectionSort, InsertionSort) | [Link](./R01-01-Rot-SimpleSorting-Bidirectional-Bubble-environment) |
| **R02** | Ordenação por comparação (MergeSort, QuickSort) | [Link](./R02-01-Rot-RecursiveSorting-Quick3-Merge-environment) |
| **R03** | Ordenação em tempo linear (CountingSort) | [Link](./R04-01-Rot-LinearSorting-Countingsort-environment) |
| **R04** | Cálculo de estatística de ordem e floor (BinarySearch, QuickSelect) | [Link](./R05-01-Rot-KLargestQuickSelectFloor-environment) |
| **R05** | Tipos abstratos de dados (Stack, Queue) | [Link](./R07-01-Rot-TAD-Linear-environment) |
| **R06** | Lista encadeada (LinkedList) | [Link](./R08-01-Rot-Linked-list-environment) |
| **R07** | Tabela hash (HashTable) | [Link](./R10-01-Rot-TabelaHash-environment) |
| **R08** | Árvore binária de busca (BST) | [Link](./R11-01-Rot-BST-environment) |
| **R09** | Heap binária (BinaryHeap) | [Link](./R12-01-Rot-HeapBinaria-environment) |
| **R10** | Árvore balanceada (AVL) | [Link](./R13-01-Rot-AVL-environment) |
| **RE5** | Lista encadeada iterativa ordenada | [Link](./RE5-01-RE-Linked-list-iterativa-ordenada-environment) |

## 🏗️ Estrutura dos Projetos
Cada roteiro segue a estrutura Maven padrão:
```
RXX-XX-XX-ambiente/
├── src/
│   ├── main/java/    # Código fonte das implementações
│   └── test/java/    # Testes unitários
├── pom.xml           # Configuração Maven
└── target/           # Arquivos compilados (gerado)
```

## 🧪 Testes
Todos os roteiros incluem testes unitários para validar as implementações:
```bash
# Executar testes específicos de um roteiro
mvn test

# Ver relatório de testes
open target/surefire-reports/*.txt
```

## 📊 Tópicos Abordados
- **Algoritmos de Ordenação** (quadráticos, O(n log n), lineares)
- **Estruturas Lineares** (pilhas, filas, listas encadeadas)
- **Tabelas Hash** (endereçamento aberto e fechado)
- **Árvores** (BST, AVL, Heaps)
- **Algoritmos de Busca** (binary search, quick select)
- **Estatísticas de Ordem** (k-ésimo menor elemento)

---

*Repositório educacional desenvolvido para fins acadêmicos* 🎓