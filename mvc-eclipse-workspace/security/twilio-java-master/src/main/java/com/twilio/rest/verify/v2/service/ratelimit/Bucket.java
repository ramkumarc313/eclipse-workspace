/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.ratelimit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
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
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bucket extends Resource {
    private static final long serialVersionUID = 11459173991897L;

    /**
     * Create a BucketCreator to execute create.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param pathRateLimitSid Rate Limit Sid.
     * @param max Max number of requests.
     * @param interval Number of seconds that the rate limit will be enforced over.
     * @return BucketCreator capable of executing the create
     */
    public static BucketCreator creator(final String pathServiceSid,
                                        final String pathRateLimitSid,
                                        final Integer max,
                                        final Integer interval) {
        return new BucketCreator(pathServiceSid, pathRateLimitSid, max, interval);
    }

    /**
     * Create a BucketUpdater to execute update.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param pathRateLimitSid Rate Limit Sid.
     * @param pathSid A string that uniquely identifies this Bucket.
     * @return BucketUpdater capable of executing the update
     */
    public static BucketUpdater updater(final String pathServiceSid,
                                        final String pathRateLimitSid,
                                        final String pathSid) {
        return new BucketUpdater(pathServiceSid, pathRateLimitSid, pathSid);
    }

    /**
     * Create a BucketFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param pathRateLimitSid Rate Limit Sid.
     * @param pathSid A string that uniquely identifies this Bucket.
     * @return BucketFetcher capable of executing the fetch
     */
    public static BucketFetcher fetcher(final String pathServiceSid,
                                        final String pathRateLimitSid,
                                        final String pathSid) {
        return new BucketFetcher(pathServiceSid, pathRateLimitSid, pathSid);
    }

    /**
     * Create a BucketReader to execute read.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param pathRateLimitSid Rate Limit Sid.
     * @return BucketReader capable of executing the read
     */
    public static BucketReader reader(final String pathServiceSid,
                                      final String pathRateLimitSid) {
        return new BucketReader(pathServiceSid, pathRateLimitSid);
    }

    /**
     * Create a BucketDeleter to execute delete.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param pathRateLimitSid Rate Limit Sid.
     * @param pathSid A string that uniquely identifies this Bucket.
     * @return BucketDeleter capable of executing the delete
     */
    public static BucketDeleter deleter(final String pathServiceSid,
                                        final String pathRateLimitSid,
                                        final String pathSid) {
        return new BucketDeleter(pathServiceSid, pathRateLimitSid, pathSid);
    }

    /**
     * Converts a JSON String into a Bucket object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Bucket object represented by the provided JSON
     */
    public static Bucket fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Bucket.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Bucket object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Bucket object represented by the provided JSON
     */
    public static Bucket fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Bucket.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String rateLimitSid;
    private final String serviceSid;
    private final String accountSid;
    private final Integer max;
    private final Integer interval;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Bucket(@JsonProperty("sid")
                   final String sid,
                   @JsonProperty("rate_limit_sid")
                   final String rateLimitSid,
                   @JsonProperty("service_sid")
                   final String serviceSid,
                   @JsonProperty("account_sid")
                   final String accountSid,
                   @JsonProperty("max")
                   final Integer max,
                   @JsonProperty("interval")
                   final Integer interval,
                   @JsonProperty("date_created")
                   final String dateCreated,
                   @JsonProperty("date_updated")
                   final String dateUpdated,
                   @JsonProperty("url")
                   final URI url) {
        this.sid = sid;
        this.rateLimitSid = rateLimitSid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.max = max;
        this.interval = interval;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The A string that uniquely identifies this Bucket..
     *
     * @return A string that uniquely identifies this Bucket.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Rate Limit Sid..
     *
     * @return Rate Limit Sid.
     */
    public final String getRateLimitSid() {
        return this.rateLimitSid;
    }

    /**
     * Returns The The SID of the Service that the resource is associated with.
     *
     * @return The SID of the Service that the resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Max number of requests..
     *
     * @return Max number of requests.
     */
    public final Integer getMax() {
        return this.max;
    }

    /**
     * Returns The Number of seconds that the rate limit will be enforced over..
     *
     * @return Number of seconds that the rate limit will be enforced over.
     */
    public final Integer getInterval() {
        return this.interval;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the resource was created.
     *
     * @return The RFC 2822 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the resource was last
     * updated.
     *
     * @return The RFC 2822 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The URL of this resource..
     *
     * @return The URL of this resource.
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

        Bucket other = (Bucket) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(rateLimitSid, other.rateLimitSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(max, other.max) &&
               Objects.equals(interval, other.interval) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            rateLimitSid,
                            serviceSid,
                            accountSid,
                            max,
                            interval,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("rateLimitSid", rateLimitSid)
                          .add("serviceSid", serviceSid)
                          .add("accountSid", accountSid)
                          .add("max", max)
                          .add("interval", interval)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}