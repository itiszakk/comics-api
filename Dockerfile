FROM amazoncorretto:17
LABEL maintainer="https://github.com/itiszakk"
ADD build/libs/comics-0.0.1.jar comics.jar
ENTRYPOINT ["java", "-jar","/comics.jar"]