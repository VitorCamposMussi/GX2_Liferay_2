# Converter imports de Maven para Gradle (Usando o Poi como exemplo)

### 1 - Vamos pegar a dependência no nexus:
[Nexus Repository Manager](https://repository.liferay.com/nexus/#nexus-search;quick~poi)

<br>

### 2 - Agora vamos copiar o código do importe modificando conforme segue:

```xml
<!--Dependencia inicial Como import Maven -->
<dependency>
  <groupId>json-batch-pointer</groupId>
  <artifactId>json-batch-pointer</artifactId>
  <version>0.2.0</version>
  <type>pom</type>
</dependency>
```

```xml
<!--Dependencia inicial convertida para Gradle -->
dependencies {
    compileOnly group: 'json-batch-pointer', name: 'json-batch-pointer', version: '0.2.0', ext: 'pom'
}
```