FROM openjdk:8-jre-alpine

ARG APP_NAME=app
ARG APP_VERSION=none
ARG IMAGE_REPO=none
ARG VCS_REF=none

LABEL "org.label-schema.schema-version" = "1.0.0-rc.1" \
      "org.label-schema.vendor" = "dj-running" \
      "org.label-schema.name" = "${APP_NAME}" \
      "org.label-schema.version" = "${APP_VERSION}" \
      "org.label-schema.vcs-url"="${IMAGE_REPO}" \
      "org.label-schema.vcs-ref" ="${VCS_REF}"

WORKDIR /app

COPY target/*.jar /app/app.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/app/app.jar"]