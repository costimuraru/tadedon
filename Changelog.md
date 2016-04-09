#project changelog

# 1.1-SNAPSHOT #

  * dependencies updated:
    * gwt-2.2.0
    * guice-3.0
    * logback-0.9.28
    * gin-1.5.0
    * guava-[r08](https://code.google.com/p/tadedon/source/detail?r=08)
    * junit-4.8.2
  * commons-logging dependency excluded, will be replaced by jcl-over-slf4j where needed
  * more accurate logging for
DefaultTransactionManager and TransactionalMethodInterceptor
  * LoggerModule now injects logger named after the type to which the logger is injected
  * new MemoizingSupplier.reset() method
  * tadedon depends on JRE 1.6 now

# 1.0 #

Initial release