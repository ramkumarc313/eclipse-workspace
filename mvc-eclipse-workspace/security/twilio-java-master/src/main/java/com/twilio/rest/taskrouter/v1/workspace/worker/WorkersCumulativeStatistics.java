/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

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
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkersCumulativeStatistics extends Resource {
    private static final long serialVersionUID = 89273605202076L;

    /**
     * Create a WorkersCumulativeStatisticsFetcher to execute fetch.
     *
     * @param pathWorkspaceSid The workspace_sid
     * @return WorkersCumulativeStatisticsFetcher capable of executing the fetch
     */
    public static WorkersCumulativeStatisticsFetcher fetcher(final String pathWorkspaceSid) {
        return new WorkersCumulativeStatisticsFetcher(pathWorkspaceSid);
    }

    /**
     * Converts a JSON String into a WorkersCumulativeStatistics object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WorkersCumulativeStatistics object represented by the provided JSON
     */
    public static WorkersCumulativeStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkersCumulativeStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WorkersCumulativeStatistics object using
     * the provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WorkersCumulativeStatistics object represented by the provided JSON
     */
    public static WorkersCumulativeStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkersCumulativeStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime startTime;
    private final DateTime endTime;
    private final List<Map<String, Object>> activityDurations;
    private final Integer reservationsCreated;
    private final Integer reservationsAccepted;
    private final Integer reservationsRejected;
    private final Integer reservationsTimedOut;
    private final Integer reservationsCanceled;
    private final Integer reservationsRescinded;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private WorkersCumulativeStatistics(@JsonProperty("account_sid")
                                        final String accountSid,
                                        @JsonProperty("start_time")
                                        final String startTime,
                                        @JsonProperty("end_time")
                                        final String endTime,
                                        @JsonProperty("activity_durations")
                                        final List<Map<String, Object>> activityDurations,
                                        @JsonProperty("reservations_created")
                                        final Integer reservationsCreated,
                                        @JsonProperty("reservations_accepted")
                                        final Integer reservationsAccepted,
                                        @JsonProperty("reservations_rejected")
                                        final Integer reservationsRejected,
                                        @JsonProperty("reservations_timed_out")
                                        final Integer reservationsTimedOut,
                                        @JsonProperty("reservations_canceled")
                                        final Integer reservationsCanceled,
                                        @JsonProperty("reservations_rescinded")
                                        final Integer reservationsRescinded,
                                        @JsonProperty("workspace_sid")
                                        final String workspaceSid,
                                        @JsonProperty("url")
                                        final URI url) {
        this.accountSid = accountSid;
        this.startTime = DateConverter.iso8601DateTimeFromString(startTime);
        this.endTime = DateConverter.iso8601DateTimeFromString(endTime);
        this.activityDurations = activityDurations;
        this.reservationsCreated = reservationsCreated;
        this.reservationsAccepted = reservationsAccepted;
        this.reservationsRejected = reservationsRejected;
        this.reservationsTimedOut = reservationsTimedOut;
        this.reservationsCanceled = reservationsCanceled;
        this.reservationsRescinded = reservationsRescinded;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

    /**
     * Returns The The account_sid.
     *
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The start_time.
     *
     * @return The start_time
     */
    public final DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns The The end_time.
     *
     * @return The end_time
     */
    public final DateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns The The minimum, average, maximum and total time Workers spent in
     * each Activity.
     *
     * @return The minimum, average, maximum and total time Workers spent in each
     *         Activity
     */
    public final List<Map<String, Object>> getActivityDurations() {
        return this.activityDurations;
    }

    /**
     * Returns The The total number of Reservations that were created.
     *
     * @return The total number of Reservations that were created
     */
    public final Integer getReservationsCreated() {
        return this.reservationsCreated;
    }

    /**
     * Returns The The total number of Reservations that were accepted.
     *
     * @return The total number of Reservations that were accepted
     */
    public final Integer getReservationsAccepted() {
        return this.reservationsAccepted;
    }

    /**
     * Returns The The total number of Reservations that were rejected.
     *
     * @return The total number of Reservations that were rejected
     */
    public final Integer getReservationsRejected() {
        return this.reservationsRejected;
    }

    /**
     * Returns The The total number of Reservations that were timed out.
     *
     * @return The total number of Reservations that were timed out
     */
    public final Integer getReservationsTimedOut() {
        return this.reservationsTimedOut;
    }

    /**
     * Returns The The total number of Reservations that were canceled.
     *
     * @return The total number of Reservations that were canceled
     */
    public final Integer getReservationsCanceled() {
        return this.reservationsCanceled;
    }

    /**
     * Returns The The total number of Reservations that were rescinded.
     *
     * @return The total number of Reservations that were rescinded
     */
    public final Integer getReservationsRescinded() {
        return this.reservationsRescinded;
    }

    /**
     * Returns The The workspace_sid.
     *
     * @return The workspace_sid
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WorkersCumulativeStatistics other = (WorkersCumulativeStatistics) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(startTime, other.startTime) &&
               Objects.equals(endTime, other.endTime) &&
               Objects.equals(activityDurations, other.activityDurations) &&
               Objects.equals(reservationsCreated, other.reservationsCreated) &&
               Objects.equals(reservationsAccepted, other.reservationsAccepted) &&
               Objects.equals(reservationsRejected, other.reservationsRejected) &&
               Objects.equals(reservationsTimedOut, other.reservationsTimedOut) &&
               Objects.equals(reservationsCanceled, other.reservationsCanceled) &&
               Objects.equals(reservationsRescinded, other.reservationsRescinded) &&
               Objects.equals(workspaceSid, other.workspaceSid) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            startTime,
                            endTime,
                            activityDurations,
                            reservationsCreated,
                            reservationsAccepted,
                            reservationsRejected,
                            reservationsTimedOut,
                            reservationsCanceled,
                            reservationsRescinded,
                            workspaceSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("startTime", startTime)
                          .add("endTime", endTime)
                          .add("activityDurations", activityDurations)
                          .add("reservationsCreated", reservationsCreated)
                          .add("reservationsAccepted", reservationsAccepted)
                          .add("reservationsRejected", reservationsRejected)
                          .add("reservationsTimedOut", reservationsTimedOut)
                          .add("reservationsCanceled", reservationsCanceled)
                          .add("reservationsRescinded", reservationsRescinded)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .toString();
    }
}