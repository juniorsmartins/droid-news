FROM amazoncorretto:17.0.8-al2023 AS builder

ARG DROID_NEWS=droid-news
ARG DROID_BLACK=droid-black

WORKDIR /${DROID_NEWS}/${DROID_BLACK}

COPY ./pom.xml /${DROID_NEWS}
COPY ./${DROID_BLACK}/.mvn ./.mvn
COPY ./${DROID_BLACK}/mvnw .
COPY ./${DROID_BLACK}/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./${DROID_BLACK}/src ./src
RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17.0.8-al2023

ARG DROID_NEWS=droid-news
ARG DROID_BLACK=droid-black

WORKDIR /${DROID_NEWS}/${DROID_BLACK}
RUN mkdir ./logs

COPY --from=builder /${DROID_NEWS}/${DROID_BLACK}/target/droid-black-0.0.1-SNAPSHOT.jar .

ENV PORT 8003
EXPOSE ${PORT}

CMD ["java", "-jar", "droid-black-0.0.1-SNAPSHOT.jar"]

