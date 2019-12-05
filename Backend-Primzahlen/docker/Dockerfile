FROM openjdk:8-jdk-alpine
COPY backend-primzahlen.jar /opt/metrics/
EXPOSE 60001
CMD ["java","-Xmx192m","-Djava.security.egd=file:/dev/./urandom","-jar","opt/metrics/backend-primzahlen.jar"]
HEALTHCHECK --interval=10s --timeout=10s --start-period=120s --retries=3 CMD curl --fail http://localhost:60001/public/healthcheck || exit 1
