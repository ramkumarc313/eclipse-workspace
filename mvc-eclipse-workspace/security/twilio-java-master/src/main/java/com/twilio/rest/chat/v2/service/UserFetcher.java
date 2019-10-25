/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.chat.v2.service;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class UserFetcher extends Fetcher<User> {
    private final String pathServiceSid;
    private final String pathSid;

    /**
     * Construct a new UserFetcher.
     *
     * @param pathServiceSid The SID of the Service to fetch the resource from
     * @param pathSid The unique string that identifies the resource
     */
    public UserFetcher(final String pathServiceSid,
                       final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched User
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public User fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.CHAT.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Users/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("User fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return User.fromJson(response.getStream(), client.getObjectMapper());
    }
}