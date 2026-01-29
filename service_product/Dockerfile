FROM amazoncorretto:21 AS builder

WORKDIR /app/app

ENV GRADLE_OPTS="-Dorg.gradle.internal.http.connectionTimeout=60000 -Dorg.gradle.internal.http.socketTimeout=60000"

COPY common-object ../common-object

COPY service_product/gradlew .
COPY service_product/gradlew.bat .
COPY service_product/service_product.iml .
COPY service_product/gradle gradle
COPY service_product/build.gradle service_product/settings.gradle ./

RUN chmod +x gradlew && ./gradlew dependencies --no-daemon --stacktrace

COPY service_product/src src

RUN ./gradlew clean build -x test

FROM amazoncorretto:21

WORKDIR /app

# Copy JAR từ stage build
COPY --from=builder /app/app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]