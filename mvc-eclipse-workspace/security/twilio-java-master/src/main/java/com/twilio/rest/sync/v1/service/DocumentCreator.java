/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class DocumentCreator extends Creator<Document> {
    private final String pathServiceSid;
    private String uniqueName;
    private Map<String, Object> data;
    private Integer ttl;

    /**
     * Construct a new DocumentCreator.
     *
     * @param pathServiceSid The service_sid
     */
    public DocumentCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    /**
     * Human-readable name for this document.
     *
     * @param uniqueName Human-readable name for this document
     * @return this
     */
    public DocumentCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * JSON data to be stored in this document.
     *
     * @param data JSON data to be stored in this document
     * @return this
     */
    public DocumentCreator setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    /**
     * Time-to-live of this Document in seconds, defaults to no expiration. In the
     * range [1, 31 536 000 (1 year)], or 0 for infinity..
     *
     * @param ttl Time-to-live of this Document in seconds, defaults to no
     *            expiration.
     * @return this
     */
    public DocumentCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Document
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Document create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Documents",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Document creation failed: Unable to connect to server");
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

        return Document.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }
    }
}