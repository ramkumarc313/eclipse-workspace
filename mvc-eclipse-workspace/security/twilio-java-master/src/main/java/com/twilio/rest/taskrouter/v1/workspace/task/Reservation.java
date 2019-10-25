/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation extends Resource {
    private static final long serialVersionUID = 63448280807644L;

    public enum Status {
        PENDING("pending"),
        ACCEPTED("accepted"),
        REJECTED("rejected"),
        TIMEOUT("timeout"),
        CANCELED("canceled"),
        RESCINDED("rescinded"),
        WRAPPING("wrapping"),
        COMPLETED("completed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    public enum CallStatus {
        INITIATED("initiated"),
        RINGING("ringing"),
        ANSWERED("answered"),
        COMPLETED("completed");

        private final String value;

        private CallStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a CallStatus from a string.
         * @param value string value
         * @return generated CallStatus
         */
        @JsonCreator
        public static CallStatus forValue(final String value) {
            return Promoter.enumFromString(value, CallStatus.values());
        }
    }

    public enum ConferenceEvent {
        START("start"),
        END("end"),
        JOIN("join"),
        LEAVE("leave"),
        MUTE("mute"),
        HOLD("hold"),
        SPEAKER("speaker");

        private final String value;

        private ConferenceEvent(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ConferenceEvent from a string.
         * @param value string value
         * @return generated ConferenceEvent
         */
        @JsonCreator
        public static ConferenceEvent forValue(final String value) {
            return Promoter.enumFromString(value, ConferenceEvent.values());
        }
    }

    public enum SupervisorMode {
        MONITOR("monitor"),
        WHISPER("whisper"),
        BARGE("barge");

        private final String value;

        private SupervisorMode(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a SupervisorMode from a string.
         * @param value string value
         * @return generated SupervisorMode
         */
        @JsonCreator
        public static SupervisorMode forValue(final String value) {
            return Promoter.enumFromString(value, SupervisorMode.values());
        }
    }

    /**
     * Create a ReservationReader to execute read.
     *
     * @param pathWorkspaceSid The workspace_sid
     * @param pathTaskSid The task_sid
     * @return ReservationReader capable of executing the read
     */
    public static ReservationReader reader(final String pathWorkspaceSid,
                                           final String pathTaskSid) {
        return new ReservationReader(pathWorkspaceSid, pathTaskSid);
    }

    /**
     * Create a ReservationFetcher to execute fetch.
     *
     * @param pathWorkspaceSid The workspace_sid
     * @param pathTaskSid The task_sid
     * @param pathSid The sid
     * @return ReservationFetcher capable of executing the fetch
     */
    public static ReservationFetcher fetcher(final String pathWorkspaceSid,
                                             final String pathTaskSid,
                                             final String pathSid) {
        return new ReservationFetcher(pathWorkspaceSid, pathTaskSid, pathSid);
    }

    /**
     * Create a ReservationUpdater to execute update.
     *
     * @param pathWorkspaceSid The workspace_sid
     * @param pathTaskSid The task_sid
     * @param pathSid The sid
     * @return ReservationUpdater capable of executing the update
     */
    public static ReservationUpdater updater(final String pathWorkspaceSid,
                                             final String pathTaskSid,
                                             final String pathSid) {
        return new ReservationUpdater(pathWorkspaceSid, pathTaskSid, pathSid);
    }

    /**
     * Converts a JSON String into a Reservation object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Reservation object represented by the provided JSON
     */
    public static Reservation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Reservation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Reservation object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Reservation object represented by the provided JSON
     */
    public static Reservation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Reservation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final Reservation.Status reservationStatus;
    private final String sid;
    private final String taskSid;
    private final String workerName;
    private final String workerSid;
    private final String workspaceSid;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Reservation(@JsonProperty("account_sid")
                        final String accountSid,
                        @JsonProperty("date_created")
                        final String dateCreated,
                        @JsonProperty("date_updated")
                        final String dateUpdated,
                        @JsonProperty("reservation_status")
                        final Reservation.Status reservationStatus,
                        @JsonProperty("sid")
                        final String sid,
                        @JsonProperty("task_sid")
                        final String taskSid,
                        @JsonProperty("worker_name")
                        final String workerName,
                        @JsonProperty("worker_sid")
                        final String workerSid,
                        @JsonProperty("workspace_sid")
                        final String workspaceSid,
                        @JsonProperty("url")
                        final URI url,
                        @JsonProperty("links")
                        final Map<String, String> links) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.reservationStatus = reservationStatus;
        this.sid = sid;
        this.taskSid = taskSid;
        this.workerName = workerName;
        this.workerSid = workerSid;
        this.workspaceSid = workspaceSid;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The The ID of the Account that owns this Task.
     *
     * @return The ID of the Account that owns this Task
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date_created.
     *
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     *
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The current status of the reservation..
     *
     * @return The current status of the reservation.
     */
    public final Reservation.Status getReservationStatus() {
        return this.reservationStatus;
    }

    /**
     * Returns The The unique ID of this Reservation..
     *
     * @return The unique ID of this Reservation.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The ID of the reserved Task.
     *
     * @return The ID of the reserved Task
     */
    public final String getTaskSid() {
        return this.taskSid;
    }

    /**
     * Returns The Human readable description of the Worker that is reserved.
     *
     * @return Human readable description of the Worker that is reserved
     */
    public final String getWorkerName() {
        return this.workerName;
    }

    /**
     * Returns The The ID of the reserved Worker.
     *
     * @return The ID of the reserved Worker
     */
    public final String getWorkerSid() {
        return this.workerSid;
    }

    /**
     * Returns The The ID of the Workspace that this task is contained within..
     *
     * @return The ID of the Workspace that this task is contained within.
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The links.
     *
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Reservation other = (Reservation) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(reservationStatus, other.reservationStatus) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(taskSid, other.taskSid) &&
               Objects.equals(workerName, other.workerName) &&
               Objects.equals(workerSid, other.workerSid) &&
               Objects.equals(workspaceSid, other.workspaceSid) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            reservationStatus,
                            sid,
                            taskSid,
                            workerName,
                            workerSid,
                            workspaceSid,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("reservationStatus", reservationStatus)
                          .add("sid", sid)
                          .add("taskSid", taskSid)
                          .add("workerName", workerName)
                          .add("workerSid", workerSid)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}