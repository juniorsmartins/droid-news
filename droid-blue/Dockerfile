FROM amazoncorretto:17.0.8-al2023 AS builder

ARG DROID_NEWS=droid-news
ARG DROID_BLUE=droid-blue 

WORKDIR /$DROID_NEWS/blue 

COPY ./pom.xml /$DROID_NEWS
COPY ./$DROID_BLUE/.mvn ./.mvn 
COPY ./$DROID_BLUE/mvnw .
COPY ./$DROID_BLUE/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./$DROID_BLUE/src ./src 
RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid-blue 
RUN mkdir ./logs

COPY --from=builder /droid-news/blue/target/droid-blue-0.0.1-SNAPSHOT.jar .

ENV PORT 9014
EXPOSE $PORT

CMD ["java", "-jar", "droid-blue-0.0.1-SNAPSHOT.jar"]

