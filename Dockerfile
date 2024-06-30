# Use a imagem Maven para construir o projeto
FROM amazoncorretto:21

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o diretório de trabalho no contêiner
COPY target/oppensocial-0.0.1-SNAPSHOT.jar /app/oppensocial-0.0.1-SNAPSHOT.jar

# Exponha a porta em que sua aplicação é executada
EXPOSE 8080

# Comando para executar sua aplicação Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "oppensocial-0.0.1-SNAPSHOT.jar"]