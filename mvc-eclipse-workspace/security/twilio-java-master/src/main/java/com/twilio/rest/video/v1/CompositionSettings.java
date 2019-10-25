/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompositionSettings extends Resource {
    private static final long serialVersionUID = 41622584466212L;

    /**
     * Create a CompositionSettingsFetcher to execute fetch.
     *
     * @return CompositionSettingsFetcher capable of executing the fetch
     */
    public static CompositionSettingsFetcher fetcher() {
        return new CompositionSettingsFetcher();
    }

    /**
     * Create a CompositionSettingsCreator to execute create.
     *
     * @param friendlyName Friendly name of the configuration to be shown in the
     *                     console
     * @return CompositionSettingsCreator capable of executing the create
     */
    public static CompositionSettingsCreator creator(final String friendlyName) {
        return new CompositionSettingsCreator(friendlyName);
    }

    /**
     * Converts a JSON String into a CompositionSettings object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return CompositionSettings object represented by the provided JSON
     */
    public static CompositionSettings fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CompositionSettings.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a CompositionSettings object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return CompositionSettings object represented by the provided JSON
     */
    public static CompositionSettings fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CompositionSettings.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String friendlyName;
    private final String awsCredentialsSid;
    private final URI awsS3Url;
    private final Boolean awsStorageEnabled;
    private final String encryptionKeySid;
    private final Boolean encryptionEnabled;
    private final URI url;

    @JsonCreator
    private CompositionSettings(@JsonProperty("account_sid")
                                final String accountSid,
                                @JsonProperty("friendly_name")
                                final String friendlyName,
                                @JsonProperty("aws_credentials_sid")
                                final String awsCredentialsSid,
                                @JsonProperty("aws_s3_url")
                                final URI awsS3Url,
                                @JsonProperty("aws_storage_enabled")
                                final Boolean awsStorageEnabled,
                                @JsonProperty("encryption_key_sid")
                                final String encryptionKeySid,
                                @JsonProperty("encryption_enabled")
                                final Boolean encryptionEnabled,
                                @JsonProperty("url")
                                final URI url) {
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.awsCredentialsSid = awsCredentialsSid;
        this.awsS3Url = awsS3Url;
        this.awsStorageEnabled = awsStorageEnabled;
        this.encryptionKeySid = encryptionKeySid;
        this.encryptionEnabled = encryptionEnabled;
        this.url = url;
    }

    /**
     * Returns The The Twilio Account SID associated with this item.
     *
     * @return The Twilio Account SID associated with this item
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Friendly name of the configuration to be shown in the console.
     *
     * @return Friendly name of the configuration to be shown in the console
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The SID of the Stored Credential resource CRxx.
     *
     * @return SID of the Stored Credential resource CRxx
     */
    public final String getAwsCredentialsSid() {
        return this.awsCredentialsSid;
    }

    /**
     * Returns The URL of the S3 bucket where the compositions should be stored. We
     * only support DNS-compliant URLs like
     * http://&lt;my-bucket&gt;.s3-&lt;aws-region&gt;.amazonaws.com/compositions,
     * where compositions is the path where you want compositions to be stored..
     *
     * @return URL of the S3 bucket where the compositions should be stored. We
     *         only support DNS-compliant URLs like
     *         http://&lt;my-bucket&gt;.s3-&lt;aws-region&gt;.amazonaws.com/compositions, where compositions is the path where you want compositions to be stored.
     */
    public final URI getAwsS3Url() {
        return this.awsS3Url;
    }

    /**
     * Returns The true|false When set to true, all Compositions will be written to
     * the AwsS3Url specified above. When set to false, all Compositions will be
     * stored in Twilio's cloud..
     *
     * @return true|false When set to true, all Compositions will be written to the
     *         AwsS3Url specified above. When set to false, all Compositions will be
     *         stored in Twilio's cloud.
     */
    public final Boolean getAwsStorageEnabled() {
        return this.awsStorageEnabled;
    }

    /**
     * Returns The SID of the Public Key resource CRxx.
     *
     * @return SID of the Public Key resource CRxx
     */
    public final String getEncryptionKeySid() {
        return this.encryptionKeySid;
    }

    /**
     * Returns The true|false When set to true, all Compositions will be stored
     * encrypted..
     *
     * @return true|false When set to true, all Compositions will be stored
     *         encrypted.
     */
    public final Boolean getEncryptionEnabled() {
        return this.encryptionEnabled;
    }

    /**
     * Returns The The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompositionSettings other = (CompositionSettings) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(awsCredentialsSid, other.awsCredentialsSid) &&
               Objects.equals(awsS3Url, other.awsS3Url) &&
               Objects.equals(awsStorageEnabled, other.awsStorageEnabled) &&
               Objects.equals(encryptionKeySid, other.encryptionKeySid) &&
               Objects.equals(encryptionEnabled, other.encryptionEnabled) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            friendlyName,
                            awsCredentialsSid,
                            awsS3Url,
                            awsStorageEnabled,
                            encryptionKeySid,
                            encryptionEnabled,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("friendlyName", friendlyName)
                          .add("awsCredentialsSid", awsCredentialsSid)
                          .add("awsS3Url", awsS3Url)
                          .add("awsStorageEnabled", awsStorageEnabled)
                          .add("encryptionKeySid", encryptionKeySid)
                          .add("encryptionEnabled", encryptionEnabled)
                          .add("url", url)
                          .toString();
    }
}