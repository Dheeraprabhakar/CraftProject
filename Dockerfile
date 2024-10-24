# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Set environment variable
ENV JAVA_OPTS=""

# Copy the Spring Boot app jar to the container
COPY target/CraftProject-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]

vykhy1-tuwGab-dopcos