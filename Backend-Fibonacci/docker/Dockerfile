FROM openjdk:8-jdk-alpine
COPY backend-fibonacci.jar /opt/metrics/
EXPOSE 60002
CMD ["java","-Xmx192m","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/metrics/backend-fibonacci.jar"]
HEALTHCHECK --interval=10s --timeout=10s --start-period=120s --retries=3 CMD curl --fail http://localhost:60002/public/healthcheck || exit 1
