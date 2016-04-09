# Aggregated javadoc #

https://xemantic.ci.cloudbees.com/job/tadedon/javadoc/

# Maven dependencies #

```
    <dependency>
      <groupId>com.xemantic.tadedon</groupId>
      <artifactId>tadedon-logging</artifactId>
      <version>${tadedon.version}</version>
    </dependency>
```

Where `tadedon-logging` is one of tadedon modules, see the full list:

https://code.google.com/p/tadedon/source/browse/tadedon

Stable `tadedon.version`: `1.3`

Development `tadedon.version`: `1.4-SNAPSHOT`

# Meven snapshots #

```
    <repository>
      <id>xemantic-snapshots</id>
      <url>http://repository-xemantic.forge.cloudbees.com/snapshot/</url>
      <snapshots>
        <enabled>true</enabled>
      </snapshots>
    </repository>
```

# Continuous Integration #

https://xemantic.ci.cloudbees.com/

[![](http://web-static-cloudfront.s3.amazonaws.com/images/badges/BuiltOnDEV.png)](http://www.cloudbees.com/)


# Tadedon project #

See also AboutTadedon

Thanks to tadedon you can:

  * General
    * [Specify default configuration](ConfigurationModule.md) of your application and upgrade it automatically on each new release.
    * [Redirect all java.util.logging to slf4j and easily configure logback](LoggingModule.md)
    * [Retrieve version](GuavaModule.md) of your application from jar's manifest file.
  * Guice
    * [Bind application configuration](GuiceConfigurationModule.md) in [Guice](http://code.google.com/p/google-guice/) module.
    * [Support @PostConstruct and @PreDestroy annotations (JSR 250)](GuiceLifecycleModule.md) in [Guice](http://code.google.com/p/google-guice/) application.
    * [incject slf4j loggers](GuiceLoggingModule.md).
    * [annotate your methods with @Transactional annotation](GuicePersistenceModule.md).
    * [Support guice stage](GuiceServletModule.md) in your web application.
    * [test your guice managed servlets and filters](GuiceServletMockModule.md) without need of real servlet container.
    * [use guice Matchers for matching super class, interface and type literal annotations](GuiceUtilsModule.md)
  * GWT
    * [Inject event bus to your GWT applications](GwtModule.md) with help of [GIN](http://code.google.com/p/google-gin/).
    * [adjust HTTP headers according to GWT cache, and nocache resources](GwtModule.md) which prevents from strange browser cache issues which might occur during development
    * [access @UiField annotated fields by name](GwtModule.md).
    * [launch your GWT applications using project's classpath](GwtDevModule.md) which is very convenient for maven based projects.
    * [Test your GWT RPC services](GwtRpcMockModule.md) without need of real servlet container.

# Tadedon modules #

See TadedonModules for details

  * [servlet](ServletModule.md): servlet utilities.
  * [configuration](ConfigurationModule.md): abstraction above [commons-configuration](http://commons.apache.org/configuration/).
  * [logging](LoggingModule.md): [slf4j](http://www.slf4j.org/) and [logback](http://logback.qos.ch/) utilities.
  * [guava](GuavaModule.md): extensions to JRE and [guava](http://code.google.com/p/guava-libraries/) functions.
  * guice
    * [configuration](GuiceConfigurationModule.md): provides [configuration](ConfigurationModule.md) module functionalities to [Guice](http://code.google.com/p/google-guice/).
    * [lifecycle](GuiceLifecycleModule.md): general initialization and cleanup lifecycle support based on @PostConstruct and @PreDestroy annotations
    * [logging](GuiceLoggingModule.md): injecton of [slf4j](http://www.slf4j.org/) loggers
    * [persistence](GuicePersistenceModule.md): interception of @Transactional annotation
    * [servlet](GuiceServletModule.md): servlet utilities
    * [servlet-mock](GuiceServletMockModule.md): testing of guice managed servlets and filters
    * [utils](GuiceUtilsModule.md): extensions to [Guice](http://code.google.com/p/google-guice/) like annotation matchers.
  * [gwt](GwtModule.md): GWT utilities.
    * [dev](GwtDevModule.md) GWT development utilities.
    * [gwt-rpc-mock](GwtRpcMockModule.md): GWT RPC testing