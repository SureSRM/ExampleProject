# Maven on-premise CI

## Maven-ize a multimodule project

First, add the common config to the base `pom.xml`

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <java.version>1.8</java.version>

    <es.djrunning.docker.repository>DOCKER_REGISTRY_HOST/PROJECT_NAMESPACE</es.djrunning.docker.repository>
    <es.djrunning.docker.pluginVersion>1.4.3</es.djrunning.docker.pluginVersion>
    <es.djrunning.vcs.url>SOURCE_VCS_URL</es.djrunning.vcs.url>
</properties>
```
**Note:** The VCS URL is optional but recommended because it's used in container tags.

Then, add a `dockerfile-maven-plugin` plugin into every single `pom.xml` that will be a running service.

```xml
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>dockerfile-maven-plugin</artifactId>
    <version>${es.djrunning.docker.pluginVersion}</version>
  <executions>
    <execution>
      <id>build-and-tag-latest</id>
      <goals>
        <goal>build</goal>
      </goals>
      <configuration>
        <repository>${es.djrunning.docker.repository}/${project.artifactId}</repository>
        <tag>latest</tag>
        <buildArgs>
          <APP_NAME>${project.artifactId}</APP_NAME>
          <APP_VERSION>${project.version}</APP_VERSION>
          <IMAGE_REPO>${es.djrunning.vcs.url}</IMAGE_REPO>
        </buildArgs>
      </configuration>
    </execution>
    <execution>
      <id>tag-version</id>
      <goals>
        <goal>tag</goal>
      </goals>
      <configuration>
        <repository>${es.djrunning.docker.repository}/${project.artifactId}</repository>
        <tag>${project.version}</tag>
      </configuration>
    </execution>
  </executions>
</plugin>
```

Now, it's time to `Dockerfile`s. Create one for each running service. This `Dockerfile`s may be identical depending on the framework it's been used. In Spring, for example, any special dependency is required so the default `Dockerfile` will be something like:

```docker

```
