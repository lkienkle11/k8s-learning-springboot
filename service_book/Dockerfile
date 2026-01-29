FROM amazoncorretto:21 AS builder

WORKDIR /app/app

ENV GRADLE_OPTS="-Dorg.gradle.internal.http.connectionTimeout=60000 -Dorg.gradle.internal.http.socketTimeout=60000"

COPY common-object ../common-object

COPY service_book/gradlew .
COPY service_book/gradlew.bat .
COPY service_book/service_book.iml .
COPY service_book/gradle gradle
COPY service_book/build.gradle service_book/settings.gradle ./

RUN chmod +x gradlew && ./gradlew dependencies --no-daemon --stacktrace

COPY service_book/src src

RUN ./gradlew clean build -x test

FROM amazoncorretto:21

WORKDIR /app

# Copy JAR từ stage build
COPY --from=builder /app/app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]