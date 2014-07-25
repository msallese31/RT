/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-07-09 17:08:39 UTC)
 * on 2014-07-23 at 00:32:59 UTC 
 * Modify at your own risk.
 */

package com.example.randomthought.thoughtendpoint;

/**
 * Service definition for Thoughtendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link ThoughtendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Thoughtendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the thoughtendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://rtbe12345.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "thoughtendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Thoughtendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Thoughtendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getThought".
   *
   * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
   * optional parameters, call the {@link GetThought#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetThought getThought(java.lang.String id) throws java.io.IOException {
    GetThought result = new GetThought(id);
    initialize(result);
    return result;
  }

  public class GetThought extends ThoughtendpointRequest<com.example.randomthought.thoughtendpoint.model.Thought> {

    private static final String REST_PATH = "thought/{id}";

    /**
     * Create a request for the method "getThought".
     *
     * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
     * optional parameters, call the {@link GetThought#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetThought#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetThought(java.lang.String id) {
      super(Thoughtendpoint.this, "GET", REST_PATH, null, com.example.randomthought.thoughtendpoint.model.Thought.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetThought setAlt(java.lang.String alt) {
      return (GetThought) super.setAlt(alt);
    }

    @Override
    public GetThought setFields(java.lang.String fields) {
      return (GetThought) super.setFields(fields);
    }

    @Override
    public GetThought setKey(java.lang.String key) {
      return (GetThought) super.setKey(key);
    }

    @Override
    public GetThought setOauthToken(java.lang.String oauthToken) {
      return (GetThought) super.setOauthToken(oauthToken);
    }

    @Override
    public GetThought setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetThought) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetThought setQuotaUser(java.lang.String quotaUser) {
      return (GetThought) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetThought setUserIp(java.lang.String userIp) {
      return (GetThought) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetThought setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetThought set(String parameterName, Object value) {
      return (GetThought) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertThought".
   *
   * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
   * optional parameters, call the {@link InsertThought#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.randomthought.thoughtendpoint.model.Thought}
   * @return the request
   */
  public InsertThought insertThought(com.example.randomthought.thoughtendpoint.model.Thought content) throws java.io.IOException {
    InsertThought result = new InsertThought(content);
    initialize(result);
    return result;
  }

  public class InsertThought extends ThoughtendpointRequest<com.example.randomthought.thoughtendpoint.model.Thought> {

    private static final String REST_PATH = "thought";

    /**
     * Create a request for the method "insertThought".
     *
     * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
     * optional parameters, call the {@link InsertThought#execute()} method to invoke the remote
     * operation. <p> {@link InsertThought#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.example.randomthought.thoughtendpoint.model.Thought}
     * @since 1.13
     */
    protected InsertThought(com.example.randomthought.thoughtendpoint.model.Thought content) {
      super(Thoughtendpoint.this, "POST", REST_PATH, content, com.example.randomthought.thoughtendpoint.model.Thought.class);
    }

    @Override
    public InsertThought setAlt(java.lang.String alt) {
      return (InsertThought) super.setAlt(alt);
    }

    @Override
    public InsertThought setFields(java.lang.String fields) {
      return (InsertThought) super.setFields(fields);
    }

    @Override
    public InsertThought setKey(java.lang.String key) {
      return (InsertThought) super.setKey(key);
    }

    @Override
    public InsertThought setOauthToken(java.lang.String oauthToken) {
      return (InsertThought) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertThought setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertThought) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertThought setQuotaUser(java.lang.String quotaUser) {
      return (InsertThought) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertThought setUserIp(java.lang.String userIp) {
      return (InsertThought) super.setUserIp(userIp);
    }

    @Override
    public InsertThought set(String parameterName, Object value) {
      return (InsertThought) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listThought".
   *
   * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
   * optional parameters, call the {@link ListThought#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListThought listThought() throws java.io.IOException {
    ListThought result = new ListThought();
    initialize(result);
    return result;
  }

  public class ListThought extends ThoughtendpointRequest<com.example.randomthought.thoughtendpoint.model.CollectionResponseThought> {

    private static final String REST_PATH = "thought";

    /**
     * Create a request for the method "listThought".
     *
     * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
     * optional parameters, call the {@link ListThought#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListThought#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListThought() {
      super(Thoughtendpoint.this, "GET", REST_PATH, null, com.example.randomthought.thoughtendpoint.model.CollectionResponseThought.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListThought setAlt(java.lang.String alt) {
      return (ListThought) super.setAlt(alt);
    }

    @Override
    public ListThought setFields(java.lang.String fields) {
      return (ListThought) super.setFields(fields);
    }

    @Override
    public ListThought setKey(java.lang.String key) {
      return (ListThought) super.setKey(key);
    }

    @Override
    public ListThought setOauthToken(java.lang.String oauthToken) {
      return (ListThought) super.setOauthToken(oauthToken);
    }

    @Override
    public ListThought setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListThought) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListThought setQuotaUser(java.lang.String quotaUser) {
      return (ListThought) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListThought setUserIp(java.lang.String userIp) {
      return (ListThought) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListThought setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListThought setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListThought set(String parameterName, Object value) {
      return (ListThought) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeThought".
   *
   * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
   * optional parameters, call the {@link RemoveThought#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveThought removeThought(java.lang.String id) throws java.io.IOException {
    RemoveThought result = new RemoveThought(id);
    initialize(result);
    return result;
  }

  public class RemoveThought extends ThoughtendpointRequest<Void> {

    private static final String REST_PATH = "thought/{id}";

    /**
     * Create a request for the method "removeThought".
     *
     * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
     * optional parameters, call the {@link RemoveThought#execute()} method to invoke the remote
     * operation. <p> {@link RemoveThought#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveThought(java.lang.String id) {
      super(Thoughtendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveThought setAlt(java.lang.String alt) {
      return (RemoveThought) super.setAlt(alt);
    }

    @Override
    public RemoveThought setFields(java.lang.String fields) {
      return (RemoveThought) super.setFields(fields);
    }

    @Override
    public RemoveThought setKey(java.lang.String key) {
      return (RemoveThought) super.setKey(key);
    }

    @Override
    public RemoveThought setOauthToken(java.lang.String oauthToken) {
      return (RemoveThought) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveThought setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveThought) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveThought setQuotaUser(java.lang.String quotaUser) {
      return (RemoveThought) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveThought setUserIp(java.lang.String userIp) {
      return (RemoveThought) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveThought setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveThought set(String parameterName, Object value) {
      return (RemoveThought) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateThought".
   *
   * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
   * optional parameters, call the {@link UpdateThought#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.randomthought.thoughtendpoint.model.Thought}
   * @return the request
   */
  public UpdateThought updateThought(com.example.randomthought.thoughtendpoint.model.Thought content) throws java.io.IOException {
    UpdateThought result = new UpdateThought(content);
    initialize(result);
    return result;
  }

  public class UpdateThought extends ThoughtendpointRequest<com.example.randomthought.thoughtendpoint.model.Thought> {

    private static final String REST_PATH = "thought";

    /**
     * Create a request for the method "updateThought".
     *
     * This request holds the parameters needed by the the thoughtendpoint server.  After setting any
     * optional parameters, call the {@link UpdateThought#execute()} method to invoke the remote
     * operation. <p> {@link UpdateThought#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.example.randomthought.thoughtendpoint.model.Thought}
     * @since 1.13
     */
    protected UpdateThought(com.example.randomthought.thoughtendpoint.model.Thought content) {
      super(Thoughtendpoint.this, "PUT", REST_PATH, content, com.example.randomthought.thoughtendpoint.model.Thought.class);
    }

    @Override
    public UpdateThought setAlt(java.lang.String alt) {
      return (UpdateThought) super.setAlt(alt);
    }

    @Override
    public UpdateThought setFields(java.lang.String fields) {
      return (UpdateThought) super.setFields(fields);
    }

    @Override
    public UpdateThought setKey(java.lang.String key) {
      return (UpdateThought) super.setKey(key);
    }

    @Override
    public UpdateThought setOauthToken(java.lang.String oauthToken) {
      return (UpdateThought) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateThought setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateThought) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateThought setQuotaUser(java.lang.String quotaUser) {
      return (UpdateThought) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateThought setUserIp(java.lang.String userIp) {
      return (UpdateThought) super.setUserIp(userIp);
    }

    @Override
    public UpdateThought set(String parameterName, Object value) {
      return (UpdateThought) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Thoughtendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Thoughtendpoint}. */
    @Override
    public Thoughtendpoint build() {
      return new Thoughtendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link ThoughtendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setThoughtendpointRequestInitializer(
        ThoughtendpointRequestInitializer thoughtendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(thoughtendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
