/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

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
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignedAddOn extends Resource {
    private static final long serialVersionUID = 62322787699673L;

    /**
     * Create a AssignedAddOnFetcher to execute fetch.
     *
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       fetch
     * @param pathResourceSid The SID of the Phone Number that installed this Add-on
     * @param pathSid The unique string that identifies the resource
     * @return AssignedAddOnFetcher capable of executing the fetch
     */
    public static AssignedAddOnFetcher fetcher(final String pathAccountSid,
                                               final String pathResourceSid,
                                               final String pathSid) {
        return new AssignedAddOnFetcher(pathAccountSid, pathResourceSid, pathSid);
    }

    /**
     * Create a AssignedAddOnFetcher to execute fetch.
     *
     * @param pathResourceSid The SID of the Phone Number that installed this Add-on
     * @param pathSid The unique string that identifies the resource
     * @return AssignedAddOnFetcher capable of executing the fetch
     */
    public static AssignedAddOnFetcher fetcher(final String pathResourceSid,
                                               final String pathSid) {
        return new AssignedAddOnFetcher(pathResourceSid, pathSid);
    }

    /**
     * Create a AssignedAddOnReader to execute read.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @param pathResourceSid The SID of the Phone Number that installed this Add-on
     * @return AssignedAddOnReader capable of executing the read
     */
    public static AssignedAddOnReader reader(final String pathAccountSid,
                                             final String pathResourceSid) {
        return new AssignedAddOnReader(pathAccountSid, pathResourceSid);
    }

    /**
     * Create a AssignedAddOnReader to execute read.
     *
     * @param pathResourceSid The SID of the Phone Number that installed this Add-on
     * @return AssignedAddOnReader capable of executing the read
     */
    public static AssignedAddOnReader reader(final String pathResourceSid) {
        return new AssignedAddOnReader(pathResourceSid);
    }

    /**
     * Create a AssignedAddOnCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param pathResourceSid The SID of the Phone Number to assign the Add-on
     * @param installedAddOnSid The SID that identifies the Add-on installation
     * @return AssignedAddOnCreator capable of executing the create
     */
    public static AssignedAddOnCreator creator(final String pathAccountSid,
                                               final String pathResourceSid,
                                               final String installedAddOnSid) {
        return new AssignedAddOnCreator(pathAccountSid, pathResourceSid, installedAddOnSid);
    }

    /**
     * Create a AssignedAddOnCreator to execute create.
     *
     * @param pathResourceSid The SID of the Phone Number to assign the Add-on
     * @param installedAddOnSid The SID that identifies the Add-on installation
     * @return AssignedAddOnCreator capable of executing the create
     */
    public static AssignedAddOnCreator creator(final String pathResourceSid,
                                               final String installedAddOnSid) {
        return new AssignedAddOnCreator(pathResourceSid, installedAddOnSid);
    }

    /**
     * Create a AssignedAddOnDeleter to execute delete.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       delete
     * @param pathResourceSid The SID of the Phone Number that installed this Add-on
     * @param pathSid The unique string that identifies the resource
     * @return AssignedAddOnDeleter capable of executing the delete
     */
    public static AssignedAddOnDeleter deleter(final String pathAccountSid,
                                               final String pathResourceSid,
                                               final String pathSid) {
        return new AssignedAddOnDeleter(pathAccountSid, pathResourceSid, pathSid);
    }

    /**
     * Create a AssignedAddOnDeleter to execute delete.
     *
     * @param pathResourceSid The SID of the Phone Number that installed this Add-on
     * @param pathSid The unique string that identifies the resource
     * @return AssignedAddOnDeleter capable of executing the delete
     */
    public static AssignedAddOnDeleter deleter(final String pathResourceSid,
                                               final String pathSid) {
        return new AssignedAddOnDeleter(pathResourceSid, pathSid);
    }

    /**
     * Converts a JSON String into a AssignedAddOn object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AssignedAddOn object represented by the provided JSON
     */
    public static AssignedAddOn fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssignedAddOn.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AssignedAddOn object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AssignedAddOn object represented by the provided JSON
     */
    public static AssignedAddOn fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssignedAddOn.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String resourceSid;
    private final String friendlyName;
    private final String description;
    private final Map<String, Object> configuration;
    private final String uniqueName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String uri;
    private final Map<String, String> subresourceUris;

    @JsonCreator
    private AssignedAddOn(@JsonProperty("sid")
                          final String sid,
                          @JsonProperty("account_sid")
                          final String accountSid,
                          @JsonProperty("resource_sid")
                          final String resourceSid,
                          @JsonProperty("friendly_name")
                          final String friendlyName,
                          @JsonProperty("description")
                          final String description,
                          @JsonProperty("configuration")
                          final Map<String, Object> configuration,
                          @JsonProperty("unique_name")
                          final String uniqueName,
                          @JsonProperty("date_created")
                          final String dateCreated,
                          @JsonProperty("date_updated")
                          final String dateUpdated,
                          @JsonProperty("uri")
                          final String uri,
                          @JsonProperty("subresource_uris")
                          final Map<String, String> subresourceUris) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.resourceSid = resourceSid;
        this.friendlyName = friendlyName;
        this.description = description;
        this.configuration = configuration;
        this.uniqueName = uniqueName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.uri = uri;
        this.subresourceUris = subresourceUris;
    }

    /**
     * Returns The The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
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
     * Returns The The SID of the Phone Number that installed this Add-on.
     *
     * @return The SID of the Phone Number that installed this Add-on
     */
    public final String getResourceSid() {
        return this.resourceSid;
    }

    /**
     * Returns The The string that you assigned to describe the resource.
     *
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The A short description of the Add-on functionality.
     *
     * @return A short description of the Add-on functionality
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * Returns The A JSON string that represents the current configuration.
     *
     * @return A JSON string that represents the current configuration
     */
    public final Map<String, Object> getConfiguration() {
        return this.configuration;
    }

    /**
     * Returns The An application-defined string that uniquely identifies the
     * resource.
     *
     * @return An application-defined string that uniquely identifies the resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was created.
     *
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was last
     * updated.
     *
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The URI of the resource, relative to `https://api.twilio.com`.
     *
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The A list of related resources identified by their relative URIs.
     *
     * @return A list of related resources identified by their relative URIs
     */
    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssignedAddOn other = (AssignedAddOn) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(resourceSid, other.resourceSid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(description, other.description) &&
               Objects.equals(configuration, other.configuration) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(uri, other.uri) &&
               Objects.equals(subresourceUris, other.subresourceUris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            resourceSid,
                            friendlyName,
                            description,
                            configuration,
                            uniqueName,
                            dateCreated,
                            dateUpdated,
                            uri,
                            subresourceUris);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("resourceSid", resourceSid)
                          .add("friendlyName", friendlyName)
                          .add("description", description)
                          .add("configuration", configuration)
                          .add("uniqueName", uniqueName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("uri", uri)
                          .add("subresourceUris", subresourceUris)
                          .toString();
    }
}