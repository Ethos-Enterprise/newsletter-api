# Define a imagem base
FROM openjdk:17
WORKDIR /app
COPY target/newsletter-app.jar .
CMD ["java", "-jar", "newsletter-app.jar"]