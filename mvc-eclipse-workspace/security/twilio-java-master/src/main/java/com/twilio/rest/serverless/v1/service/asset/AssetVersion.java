/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service.asset;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

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
public class AssetVersion extends Resource {
    private static final long serialVersionUID = 67271772185302L;

    public enum Visibility {
        PUBLIC("public"),
        PRIVATE("private"),
        PROTECTED("protected");

        private final String value;

        private Visibility(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Visibility from a string.
         * @param value string value
         * @return generated Visibility
         */
        @JsonCreator
        public static Visibility forValue(final String value) {
            return Promoter.enumFromString(value, Visibility.values());
        }
    }

    /**
     * Create a AssetVersionReader to execute read.
     *
     * @param pathServiceSid Service Sid.
     * @param pathAssetSid Asset Sid.
     * @return AssetVersionReader capable of executing the read
     */
    public static AssetVersionReader reader(final String pathServiceSid,
                                            final String pathAssetSid) {
        return new AssetVersionReader(pathServiceSid, pathAssetSid);
    }

    /**
     * Create a AssetVersionFetcher to execute fetch.
     *
     * @param pathServiceSid Service Sid.
     * @param pathAssetSid Asset Sid.
     * @param pathSid Asset Version Sid.
     * @return AssetVersionFetcher capable of executing the fetch
     */
    public static AssetVersionFetcher fetcher(final String pathServiceSid,
                                              final String pathAssetSid,
                                              final String pathSid) {
        return new AssetVersionFetcher(pathServiceSid, pathAssetSid, pathSid);
    }

    /**
     * Create a AssetVersionCreator to execute create.
     *
     * @param pathServiceSid Service Sid.
     * @param pathAssetSid Asset Sid.
     * @param path The URL-friendly string by which this Asset Version can be
     *             referenced.
     * @param visibility The access control which determines how the Asset Version
     *                   can be accessed.
     * @return AssetVersionCreator capable of executing the create
     */
    public static AssetVersionCreator creator(final String pathServiceSid,
                                              final String pathAssetSid,
                                              final String path,
                                              final AssetVersion.Visibility visibility) {
        return new AssetVersionCreator(pathServiceSid, pathAssetSid, path, visibility);
    }

    /**
     * Converts a JSON String into a AssetVersion object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AssetVersion object represented by the provided JSON
     */
    public static AssetVersion fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssetVersion.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AssetVersion object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AssetVersion object represented by the provided JSON
     */
    public static AssetVersion fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssetVersion.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String assetSid;
    private final String path;
    private final AssetVersion.Visibility visibility;
    private final Map<String, Object> preSignedUploadUrl;
    private final DateTime dateCreated;
    private final URI url;

    @JsonCreator
    private AssetVersion(@JsonProperty("sid")
                         final String sid,
                         @JsonProperty("account_sid")
                         final String accountSid,
                         @JsonProperty("service_sid")
                         final String serviceSid,
                         @JsonProperty("asset_sid")
                         final String assetSid,
                         @JsonProperty("path")
                         final String path,
                         @JsonProperty("visibility")
                         final AssetVersion.Visibility visibility,
                         @JsonProperty("pre_signed_upload_url")
                         final Map<String, Object> preSignedUploadUrl,
                         @JsonProperty("date_created")
                         final String dateCreated,
                         @JsonProperty("url")
                         final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.assetSid = assetSid;
        this.path = path;
        this.visibility = visibility;
        this.preSignedUploadUrl = preSignedUploadUrl;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

    /**
     * Returns The Asset Version Sid..
     *
     * @return Asset Version Sid.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Account Sid..
     *
     * @return Account Sid.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Service Sid..
     *
     * @return Service Sid.
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The Asset Sid..
     *
     * @return Asset Sid.
     */
    public final String getAssetSid() {
        return this.assetSid;
    }

    /**
     * Returns The The URL-friendly string by which this Asset Version can be
     * referenced..
     *
     * @return The URL-friendly string by which this Asset Version can be
     *         referenced.
     */
    public final String getPath() {
        return this.path;
    }

    /**
     * Returns The The access control which determines how the Asset Version can be
     * accessed..
     *
     * @return The access control which determines how the Asset Version can be
     *         accessed.
     */
    public final AssetVersion.Visibility getVisibility() {
        return this.visibility;
    }

    /**
     * Returns The The object which provides the details required for uploading this
     * Asset Version..
     *
     * @return The object which provides the details required for uploading this
     *         Asset Version.
     */
    public final Map<String, Object> getPreSignedUploadUrl() {
        return this.preSignedUploadUrl;
    }

    /**
     * Returns The The date that this Asset Version was created..
     *
     * @return The date that this Asset Version was created.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The URL of this Asset Version..
     *
     * @return The URL of this Asset Version.
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

        AssetVersion other = (AssetVersion) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(assetSid, other.assetSid) &&
               Objects.equals(path, other.path) &&
               Objects.equals(visibility, other.visibility) &&
               Objects.equals(preSignedUploadUrl, other.preSignedUploadUrl) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            assetSid,
                            path,
                            visibility,
                            preSignedUploadUrl,
                            dateCreated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("assetSid", assetSid)
                          .add("path", path)
                          .add("visibility", visibility)
                          .add("preSignedUploadUrl", preSignedUploadUrl)
                          .add("dateCreated", dateCreated)
                          .add("url", url)
                          .toString();
    }
}