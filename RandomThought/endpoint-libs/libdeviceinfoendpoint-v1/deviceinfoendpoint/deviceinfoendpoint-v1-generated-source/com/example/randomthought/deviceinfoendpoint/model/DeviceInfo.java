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
 * (build: 2014-07-22 21:53:01 UTC)
 * on 2014-07-29 at 01:27:54 UTC 
 * Modify at your own risk.
 */

package com.example.randomthought.deviceinfoendpoint.model;

/**
 * Model definition for DeviceInfo.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the deviceinfoendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class DeviceInfo extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String deviceInformation;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String deviceRegistrationID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long timestamp;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDeviceInformation() {
    return deviceInformation;
  }

  /**
   * @param deviceInformation deviceInformation or {@code null} for none
   */
  public DeviceInfo setDeviceInformation(java.lang.String deviceInformation) {
    this.deviceInformation = deviceInformation;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDeviceRegistrationID() {
    return deviceRegistrationID;
  }

  /**
   * @param deviceRegistrationID deviceRegistrationID or {@code null} for none
   */
  public DeviceInfo setDeviceRegistrationID(java.lang.String deviceRegistrationID) {
    this.deviceRegistrationID = deviceRegistrationID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * @param timestamp timestamp or {@code null} for none
   */
  public DeviceInfo setTimestamp(java.lang.Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  @Override
  public DeviceInfo set(String fieldName, Object value) {
    return (DeviceInfo) super.set(fieldName, value);
  }

  @Override
  public DeviceInfo clone() {
    return (DeviceInfo) super.clone();
  }

}
