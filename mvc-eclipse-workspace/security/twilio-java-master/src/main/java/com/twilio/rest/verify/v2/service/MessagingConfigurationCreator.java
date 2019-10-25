/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class MessagingConfigurationCreator extends Creator<MessagingConfiguration> {
    private final String pathServiceSid;
    private final String country;
    private final String messagingServiceSid;

    /**
     * Construct a new MessagingConfigurationCreator.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param country The ISO-3166-1 country code of the country or `all`.
     * @param messagingServiceSid The SID of the Messaging Service used for this
     *                            configuration.
     */
    public MessagingConfigurationCreator(final String pathServiceSid,
                                         final String country,
                                         final String messagingServiceSid) {
        this.pathServiceSid = pathServiceSid;
        this.country = country;
        this.messagingServiceSid = messagingServiceSid;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created MessagingConfiguration
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public MessagingConfiguration create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/MessagingConfigurations",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("MessagingConfiguration creation failed: Unable to connect to server");
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

        return MessagingConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (country != null) {
            request.addPostParam("Country", country);
        }

        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);
        }
    }
}