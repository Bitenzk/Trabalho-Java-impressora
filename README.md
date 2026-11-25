# Trabalho-Java-impressora

 🖨️ Sistema de Comunicação com Impressora Elgin
📘 Sobre o Projeto

Este projeto consiste em uma aplicação Java desenvolvida para realizar a comunicação com impressoras térmicas Elgin por meio da biblioteca JNA e da DLL E1_Impressora01. O sistema disponibiliza métodos para impressão de textos, QR Codes, códigos de barras e controle de recursos da impressora. A comunicação é realizada conforme a arquitetura da JVM (x86 ou x64).

🧰 Tecnologias Utilizadas
Java (versão utilizada no projeto).
IntelliJ IDEA (ambiente de desenvolvimento).
JNA (Java Native Access).
JNA 5.15.0 (se utilizada).
DLL E1_Impressora01 (SDK Elgin).
Impressora térmica Elgin compatível.
📁 Estrutura do Projeto
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

⚙️ Instalação e Execução
Baixe ou clone o projeto do GitHub.
Extraia os arquivos, caso tenha baixado em ZIP.
Abra a pasta do projeto no IntelliJ IDEA.
Adicione a biblioteca JNA às dependências do projeto.
Verifique se as DLLs estão nas pastas x64 e x86.
Conecte a impressora ao computador.
Execute a classe principal da aplicação.

Observação: A interface ImpressoraDLL seleciona automaticamente a DLL conforme a arquitetura da JVM.

🔌 Comunicação com a Impressora

A interface ImpressoraDLL.java disponibiliza métodos para:

Abrir e fechar conexão com a impressora.
Imprimir textos.
Imprimir QR Codes.
Imprimir códigos de barras.
Avançar papel.
Realizar corte de papel.
Consultar status da impressora.
Abrir gaveta de dinheiro.
Emitir sinal sonoro.
Utilizar o modo de impressão por página.
Imprimir XML SAT e XML de cancelamento SAT.
🧪 Testes Realizados

(Preencher conforme os testes executados: conexão, impressão de textos, QR Codes, códigos de barras, corte, gaveta e demais recursos.)

📚 Documentação Adicional
Manual técnico da impressora Elgin.
Documentação do SDK E1_Impressora.
Documentação da biblioteca JNA.
👥 Autores
Vitor Bitencourt
Luan Nogueira

