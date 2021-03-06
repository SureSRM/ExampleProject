FROM openjdk:8-jre-alpine

# External arguments provided by Maven on building
ARG APP_NAME=app
ARG APP_VERSION=none
ARG IMAGE_REPO=none
ARG VCS_REF=none

# Labels for registry maintenance
LABEL "org.label-schema.schema-version" = "1.0.0-rc.1" \
      "org.label-schema.vendor" = "dj-running" \
      "org.label-schema.name" = "${APP_NAME}" \
      "org.label-schema.version" = "${APP_VERSION}" \
      "org.label-schema.vcs-url"="${IMAGE_REPO}" \
      "org.label-schema.vcs-ref" ="${VCS_REF}"

# New Workdir
WORKDIR /app

# Copy uber-jar. NOTE: If failing, check out .dockerignore
COPY target/*.jar /app/app.jar

# Overrides server.port spring property and fixes it to :80.
#It can be overwriten by setting a new value in `docker run` o `docker-compose.yml`
ENV SERVER_PORT 80
# Documents wich port should be exposed
EXPOSE 80

# Add healthcheck
HEALTHCHECK --interval=5s --timeout=3s \
  CMD wget --spider http://localhost || exit 1

# Defines the command that will be executed as PID 0 when container is started
ENTRYPOINT ["/usr/bin/java", "-jar", "/app/app.jar"]
