FROM maven:latest
RUN mkdir /app
WORKDIR /app
COPY . .
CMD ["mvn", "spring-boot:run"]
