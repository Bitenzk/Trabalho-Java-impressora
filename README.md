# Trabalho-Java-impressora

 *🖨️ Sistema de Comunicação com Impressora Elgin*
## 📘 Sobre o Projeto

*Este projeto consiste em uma aplicação Java desenvolvida para realizar a comunicação com impressoras térmicas Elgin por meio da biblioteca JNA e da DLL E1_Impressora01. O sistema disponibiliza métodos para impressão de textos, QR Codes, códigos de barras e controle de recursos da impressora. A comunicação é realizada conforme a arquitetura da JVM (x86 ou x64).*

---

## 🧰 Tecnologias Utilizadas
- **Java** *Orackle OpenJDK 27*
- **IntelliJ IDEA**.
- **JNA** *(Java Native Access).*
- **JNA 5.15.0** 
- **DLL E1_Impressora01** *(SDK Elgin).*
- **Impressora térmica Elgin compatível.**

---

## 📁 Estrutura do Projeto
```
text
/src
   ImpressoraDLL.java
   → Interface responsável pela comunicação
     entre Java e a DLL da Elgin.

/Bibliotecas E1 Impressora
   /x64
      E1_Impressora01.dll
   /x86
      E1_Impressora01.dll

/libs Java
   jna-5.15.0.jar
```

---

## ⚙️ Instalação e Execução
### 1. Baixar o projeto

1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado.
3. Conecte e ligue a impressora.
4. Abra `Main.java` e clique em ▶️ **Run**.

*Observação: A interface ImpressoraDLL seleciona automaticamente a DLL conforme a arquitetura da JVM.*

---

## 🔐 Login

- **login:** *admin*
- **senha:** *1234*
- **Tentativas:** *3*

---

## 🔌 Comunicação com a Impressora

*A interface ImpressoraDLL.java disponibiliza métodos para:*

1. Abrir e fechar conexão com a impressora.
2. Imprimir textos.
3. Imprimir QR Codes.
4. Imprimir códigos de barras.
5. Avançar papel.
6. Realizar corte de papel.
7. Consultar status da impressora.
8. Abrir gaveta de dinheiro.
9. Emitir sinal sonoro.
10. Utilizar o modo de impressão por página.
11. Imprimir XML SAT e XML de cancelamento SAT.

---

## 🧪 Testes Realizados

*Login com senha 3 vezes erradas, impressões de textos, QR codes e códigos de barras, avisos sonoros e abertura da gaveta. Todos com sucesso.*

---

## 📚 Documentação Adicional
- Manual técnico da impressora Elgin.
- Documentação do SDK E1_Impressora.
- Documentação da biblioteca JNA.

---

## 👥 Autores

- Flávio Henrique da Costa Silva
- Luan Nogueira Cavalcante
- Samuel da Silva Pereira
- Vitor Bitencourt Martins
