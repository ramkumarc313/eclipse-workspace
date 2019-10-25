/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Deleter;
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
public class MessagingConfigurationDeleter extends Deleter<MessagingConfiguration> {
    private final String pathServiceSid;
    private final String pathCountry;

    /**
     * Construct a new MessagingConfigurationDeleter.
     *
     * @param pathServiceSid The SID of the Service that the resource is associated
     *                       with
     * @param pathCountry The ISO-3166-1 country code of the country or `all`.
     */
    public MessagingConfigurationDeleter(final String pathServiceSid,
                                         final String pathCountry) {
        this.pathServiceSid = pathServiceSid;
        this.pathCountry = pathCountry;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     *
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/MessagingConfigurations/" + this.pathCountry + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("MessagingConfiguration delete failed: Unable to connect to server");
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

        return response.getStatusCode() == 204;
    }
}