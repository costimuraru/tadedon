# Maven dependency #

```
    <dependency>
      <groupId>com.xemantic.tadedon</groupId>
      <artifactId>tadedon-guice-servlet-mock</artifactId>
      <scope>test</scope>
    </dependency>
```

Note: consider setting scope `test` if you are using this module only for unit testing purposes.

# Usage #

```
public class MyServletTest {

    private static FakeServletContainer servletContainer;

    @BeforeClass
    public static void startServletContainer() throws ServletException {
        Injector injector = Guice.createInjector(
                new FakeServletContainerModule(),
                new ServletModule() {
                    @Override
                    protected void configureServlets() {
                        serve("/MyServlet").with(MyServlet.class);
                    }
                });
        servletContainer = injector.getInstance(FakeServletContainer.class);
        servletContainer.start();
    }

    @Test
    public void shouldInvokeMyServlet() throws IOException, ServletException {
        // given
        MockHttpServletRequest request = servletContainer.newRequest("GET", "/MyServlet");
        MockHttpServletResponse response = new MockHttpServletResponse();

        // when
        servletContainer.service(request, response);

        // then
        // list of expectation ...
        // e.g. assertThat(response.getContentAsString(), is("My response"));
    }

    @AfterClass
    public static void stopServletContainer() {
        if (servletContainer != null) {
            servletContainer.stop();
        }
    }
}
```

Comprehensive example of [FakeServletContainerTest](http://code.google.com/p/tadedon/source/browse/tadedon-guice-servlet-mock/src/test/java/com/xemantic/tadedon/guice/servlet/mock/FakeServletContainerTest.java).