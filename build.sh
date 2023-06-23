#!/bin/bash

# Executa o comando Maven para compilar o projeto
echo "Compilando o projeto Java..."
mvn compile
if [ $? -eq 0 ]; then
  echo "Compilação concluída com sucesso!"
else
  echo "A compilação falhou."
fi