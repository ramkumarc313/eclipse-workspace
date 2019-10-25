/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.accSecurity;

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
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ServiceCreator extends Creator<Service> {
    private final String name;
    private Integer codeLength;

    /**
     * Construct a new ServiceCreator.
     *
     * @param name Friendly name of the service
     */
    public ServiceCreator(final String name) {
        this.name = name;
    }

    /**
     * The length of the verification code to be generated. Must be an integer value
     * between 4-10.
     *
     * @param codeLength Length of verification code. Valid values are 4-10
     * @return this
     */
    public ServiceCreator setCodeLength(final Integer codeLength) {
        this.codeLength = codeLength;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Service
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Service create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/Verification/Services",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Service creation failed: Unable to connect to server");
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

        return Service.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (name != null) {
            request.addPostParam("Name", name);
        }

        if (codeLength != null) {
            request.addPostParam("CodeLength", codeLength.toString());
        }
    }
}