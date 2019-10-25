/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class EnvironmentTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SERVERLESS.toString(),
                                          "/v1/Services/ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Environments");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Environment.reader("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"environments\": [],\"meta\": {\"first_page_url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments?PageSize=50&Page=0\",\"key\": \"environments\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Environment.reader("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SERVERLESS.toString(),
                                          "/v1/Services/ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Environments/ZEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Environment.fetcher("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ZEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"ZE00000000000000000000000000000000\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"build_sid\": \"ZB00000000000000000000000000000000\",\"unique_name\": \"testing-environment\",\"domain_suffix\": \"testing\",\"domain_name\": \"foobar-1234-testing.twil.io\",\"date_created\": \"2018-11-10T20:00:00Z\",\"date_updated\": \"2018-11-10T20:00:00Z\",\"url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments/ZE00000000000000000000000000000000\",\"links\": {\"variables\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments/ZE00000000000000000000000000000000/Variables\",\"deployments\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments/ZE00000000000000000000000000000000/Deployments\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Environment.fetcher("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ZEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.SERVERLESS.toString(),
                                          "/v1/Services/ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Environments");
            request.addPostParam("UniqueName", serialize("unique_name"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Environment.creator("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "unique_name").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"ZE00000000000000000000000000000000\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"build_sid\": null,\"unique_name\": \"staging\",\"domain_suffix\": \"stage\",\"domain_name\": \"foobar-1234-stage.twil.io\",\"date_created\": \"2018-11-10T20:00:00Z\",\"date_updated\": \"2018-11-10T20:00:00Z\",\"url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments/ZE00000000000000000000000000000000\",\"links\": {\"variables\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments/ZE00000000000000000000000000000000/Variables\",\"deployments\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Environments/ZE00000000000000000000000000000000/Deployments\"}}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Environment.creator("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "unique_name").create();
    }
}