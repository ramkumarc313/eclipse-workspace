/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.deployedDevices.fleet;

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
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deployment extends Resource {
    private static final long serialVersionUID = 277943167449675L;

    /**
     * Create a DeploymentFetcher to execute fetch.
     *
     * @param pathFleetSid The fleet_sid
     * @param pathSid A string that uniquely identifies the Deployment.
     * @return DeploymentFetcher capable of executing the fetch
     */
    public static DeploymentFetcher fetcher(final String pathFleetSid,
                                            final String pathSid) {
        return new DeploymentFetcher(pathFleetSid, pathSid);
    }

    /**
     * Create a DeploymentDeleter to execute delete.
     *
     * @param pathFleetSid The fleet_sid
     * @param pathSid A string that uniquely identifies the Deployment.
     * @return DeploymentDeleter capable of executing the delete
     */
    public static DeploymentDeleter deleter(final String pathFleetSid,
                                            final String pathSid) {
        return new DeploymentDeleter(pathFleetSid, pathSid);
    }

    /**
     * Create a DeploymentCreator to execute create.
     *
     * @param pathFleetSid The fleet_sid
     * @return DeploymentCreator capable of executing the create
     */
    public static DeploymentCreator creator(final String pathFleetSid) {
        return new DeploymentCreator(pathFleetSid);
    }

    /**
     * Create a DeploymentReader to execute read.
     *
     * @param pathFleetSid The fleet_sid
     * @return DeploymentReader capable of executing the read
     */
    public static DeploymentReader reader(final String pathFleetSid) {
        return new DeploymentReader(pathFleetSid);
    }

    /**
     * Create a DeploymentUpdater to execute update.
     *
     * @param pathFleetSid The fleet_sid
     * @param pathSid A string that uniquely identifies the Deployment.
     * @return DeploymentUpdater capable of executing the update
     */
    public static DeploymentUpdater updater(final String pathFleetSid,
                                            final String pathSid) {
        return new DeploymentUpdater(pathFleetSid, pathSid);
    }

    /**
     * Converts a JSON String into a Deployment object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Deployment object represented by the provided JSON
     */
    public static Deployment fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Deployment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Deployment object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Deployment object represented by the provided JSON
     */
    public static Deployment fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Deployment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final URI url;
    private final String friendlyName;
    private final String fleetSid;
    private final String accountSid;
    private final String syncServiceSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private Deployment(@JsonProperty("sid")
                       final String sid,
                       @JsonProperty("url")
                       final URI url,
                       @JsonProperty("friendly_name")
                       final String friendlyName,
                       @JsonProperty("fleet_sid")
                       final String fleetSid,
                       @JsonProperty("account_sid")
                       final String accountSid,
                       @JsonProperty("sync_service_sid")
                       final String syncServiceSid,
                       @JsonProperty("date_created")
                       final String dateCreated,
                       @JsonProperty("date_updated")
                       final String dateUpdated) {
        this.sid = sid;
        this.url = url;
        this.friendlyName = friendlyName;
        this.fleetSid = fleetSid;
        this.accountSid = accountSid;
        this.syncServiceSid = syncServiceSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The A string that uniquely identifies this Deployment..
     *
     * @return A string that uniquely identifies this Deployment.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The URL of this Deployment..
     *
     * @return URL of this Deployment.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The A human readable description for this Deployment.
     *
     * @return A human readable description for this Deployment
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The unique identifier of the Fleet..
     *
     * @return The unique identifier of the Fleet.
     */
    public final String getFleetSid() {
        return this.fleetSid;
    }

    /**
     * Returns The The unique SID that identifies this Account..
     *
     * @return The unique SID that identifies this Account.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The unique identifier of the Sync service instance..
     *
     * @return The unique identifier of the Sync service instance.
     */
    public final String getSyncServiceSid() {
        return this.syncServiceSid;
    }

    /**
     * Returns The The date this Deployment was created..
     *
     * @return The date this Deployment was created.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this Deployment was updated..
     *
     * @return The date this Deployment was updated.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Deployment other = (Deployment) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(url, other.url) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(fleetSid, other.fleetSid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(syncServiceSid, other.syncServiceSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            url,
                            friendlyName,
                            fleetSid,
                            accountSid,
                            syncServiceSid,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("url", url)
                          .add("friendlyName", friendlyName)
                          .add("fleetSid", fleetSid)
                          .add("accountSid", accountSid)
                          .add("syncServiceSid", syncServiceSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}