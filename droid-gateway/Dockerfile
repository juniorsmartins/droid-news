FROM amazoncorretto:17.0.8-al2023 AS builder

ARG DROID_NEWS=droid-news
ARG DROID_GATEWAY=droid-gateway

WORKDIR /$DROID_NEWS/$DROID_GATEWAY

COPY ./pom.xml /$DROID_NEWS
COPY ./$DROID_GATEWAY/.mvn ./.mvn
COPY ./$DROID_GATEWAY/mvnw .
COPY ./$DROID_GATEWAY/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./$DROID_GATEWAY/src ./src
RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid-news/droid-gateway
RUN mkdir ./logs

COPY --from=builder /droid-news/droid-gateway/target/droid-gateway-0.0.1-SNAPSHOT.jar .

ENV PORT 8090
EXPOSE $PORT

CMD ["java", "-jar", "droid-gateway-0.0.1-SNAPSHOT.jar"]

