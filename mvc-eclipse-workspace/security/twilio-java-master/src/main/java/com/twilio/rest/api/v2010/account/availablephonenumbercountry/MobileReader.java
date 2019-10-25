/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.availablephonenumbercountry;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MobileReader extends Reader<Mobile> {
    private String pathAccountSid;
    private final String pathCountryCode;
    private Integer areaCode;
    private String contains;
    private Boolean smsEnabled;
    private Boolean mmsEnabled;
    private Boolean voiceEnabled;
    private Boolean excludeAllAddressRequired;
    private Boolean excludeLocalAddressRequired;
    private Boolean excludeForeignAddressRequired;
    private Boolean beta;
    private com.twilio.type.PhoneNumber nearNumber;
    private String nearLatLong;
    private Integer distance;
    private String inPostalCode;
    private String inRegion;
    private String inRateCenter;
    private String inLata;
    private String inLocality;
    private Boolean faxEnabled;

    /**
     * Construct a new MobileReader.
     *
     * @param pathCountryCode The ISO Country code of the country from which to
     *                        read phone numbers
     */
    public MobileReader(final String pathCountryCode) {
        this.pathCountryCode = pathCountryCode;
    }

    /**
     * Construct a new MobileReader.
     *
     * @param pathAccountSid The SID of the Account requesting the
     *                       AvailablePhoneNumber resources
     * @param pathCountryCode The ISO Country code of the country from which to
     *                        read phone numbers
     */
    public MobileReader(final String pathAccountSid,
                        final String pathCountryCode) {
        this.pathAccountSid = pathAccountSid;
        this.pathCountryCode = pathCountryCode;
    }

    /**
     * The area code of the phone numbers to read. Applies to only phone numbers in
     * the US and Canada..
     *
     * @param areaCode The area code of the phone numbers to read
     * @return this
     */
    public MobileReader setAreaCode(final Integer areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    /**
     * The pattern on which to match phone numbers. Valid characters are `*`, `0-9`,
     * `a-z`, and `A-Z`. The `*` character matches any single digit. For examples,
     * see [Example
     * 2](https://www.twilio.com/docs/api/rest/available-phone-numbers#local-get-basic-example-2) and [Example 3](https://www.twilio.com/docs/api/rest/available-phone-numbers#local-get-basic-example-3). If specified, this value must have at least two characters..
     *
     * @param contains The pattern on which to match phone numbers
     * @return this
     */
    public MobileReader setContains(final String contains) {
        this.contains = contains;
        return this;
    }

    /**
     * Whether the phone numbers can receive text messages. Can be: `true` or
     * `false`..
     *
     * @param smsEnabled Whether the phone numbers can receive text messages
     * @return this
     */
    public MobileReader setSmsEnabled(final Boolean smsEnabled) {
        this.smsEnabled = smsEnabled;
        return this;
    }

    /**
     * Whether the phone numbers can receive MMS messages. Can be: `true` or
     * `false`..
     *
     * @param mmsEnabled Whether the phone numbers can receive MMS messages
     * @return this
     */
    public MobileReader setMmsEnabled(final Boolean mmsEnabled) {
        this.mmsEnabled = mmsEnabled;
        return this;
    }

    /**
     * Whether the phone numbers can receive calls. Can be: `true` or `false`..
     *
     * @param voiceEnabled Whether the phone numbers can receive calls.
     * @return this
     */
    public MobileReader setVoiceEnabled(final Boolean voiceEnabled) {
        this.voiceEnabled = voiceEnabled;
        return this;
    }

    /**
     * Whether to exclude phone numbers that require an
     * [Address](https://www.twilio.com/docs/usage/api/addresses). Can be: `true` or
     * `false` and the default is `false`..
     *
     * @param excludeAllAddressRequired Whether to exclude phone numbers that
     *                                  require an Address
     * @return this
     */
    public MobileReader setExcludeAllAddressRequired(final Boolean excludeAllAddressRequired) {
        this.excludeAllAddressRequired = excludeAllAddressRequired;
        return this;
    }

    /**
     * Whether to exclude phone numbers that require a local
     * [Address](https://www.twilio.com/docs/usage/api/addresses). Can be: `true` or
     * `false` and the default is `false`..
     *
     * @param excludeLocalAddressRequired Whether to exclude phone numbers that
     *                                    require a local address
     * @return this
     */
    public MobileReader setExcludeLocalAddressRequired(final Boolean excludeLocalAddressRequired) {
        this.excludeLocalAddressRequired = excludeLocalAddressRequired;
        return this;
    }

    /**
     * Whether to exclude phone numbers that require a foreign
     * [Address](https://www.twilio.com/docs/usage/api/addresses). Can be: `true` or
     * `false` and the default is `false`..
     *
     * @param excludeForeignAddressRequired Whether to exclude phone numbers that
     *                                      require a foreign address
     * @return this
     */
    public MobileReader setExcludeForeignAddressRequired(final Boolean excludeForeignAddressRequired) {
        this.excludeForeignAddressRequired = excludeForeignAddressRequired;
        return this;
    }

    /**
     * Whether to read phone numbers that are new to the Twilio platform. Can be:
     * `true` or `false` and the default is `true`..
     *
     * @param beta Whether to read phone numbers new to the Twilio platform
     * @return this
     */
    public MobileReader setBeta(final Boolean beta) {
        this.beta = beta;
        return this;
    }

    /**
     * Given a phone number, find a geographically close number within `distance`
     * miles. Distance defaults to 25 miles. Applies to only phone numbers in the US
     * and Canada..
     *
     * @param nearNumber Given a phone number, find a geographically close number
     *                   within distance miles. (US/Canada only)
     * @return this
     */
    public MobileReader setNearNumber(final com.twilio.type.PhoneNumber nearNumber) {
        this.nearNumber = nearNumber;
        return this;
    }

    /**
     * Given a phone number, find a geographically close number within `distance`
     * miles. Distance defaults to 25 miles. Applies to only phone numbers in the US
     * and Canada..
     *
     * @param nearNumber Given a phone number, find a geographically close number
     *                   within distance miles. (US/Canada only)
     * @return this
     */
    public MobileReader setNearNumber(final String nearNumber) {
        return setNearNumber(Promoter.phoneNumberFromString(nearNumber));
    }

    /**
     * Given a latitude/longitude pair `lat,long` find geographically close numbers
     * within `distance` miles. Applies to only phone numbers in the US and Canada..
     *
     * @param nearLatLong Given a latitude/longitude pair lat,long find
     *                    geographically close numbers within distance miles.
     *                    (US/Canada only)
     * @return this
     */
    public MobileReader setNearLatLong(final String nearLatLong) {
        this.nearLatLong = nearLatLong;
        return this;
    }

    /**
     * The search radius, in miles, for a `near_` query.  Can be up to `500` and the
     * default is `25`. Applies to only phone numbers in the US and Canada..
     *
     * @param distance The search radius, in miles, for a near_ query. (US/Canada
     *                 only)
     * @return this
     */
    public MobileReader setDistance(final Integer distance) {
        this.distance = distance;
        return this;
    }

    /**
     * Limit results to a particular postal code. Given a phone number, search
     * within the same postal code as that number. Applies to only phone numbers in
     * the US and Canada..
     *
     * @param inPostalCode Limit results to a particular postal code. (US/Canada
     *                     only)
     * @return this
     */
    public MobileReader setInPostalCode(final String inPostalCode) {
        this.inPostalCode = inPostalCode;
        return this;
    }

    /**
     * Limit results to a particular region, state, or province. Given a phone
     * number, search within the same region as that number. Applies to only phone
     * numbers in the US and Canada..
     *
     * @param inRegion Limit results to a particular region. (US/Canada only)
     * @return this
     */
    public MobileReader setInRegion(final String inRegion) {
        this.inRegion = inRegion;
        return this;
    }

    /**
     * Limit results to a specific rate center, or given a phone number search
     * within the same rate center as that number. Requires `in_lata` to be set as
     * well. Applies to only phone numbers in the US and Canada..
     *
     * @param inRateCenter Limit results to a specific rate center, or given a
     *                     phone number search within the same rate center as that
     *                     number. (US/Canada only)
     * @return this
     */
    public MobileReader setInRateCenter(final String inRateCenter) {
        this.inRateCenter = inRateCenter;
        return this;
    }

    /**
     * Limit results to a specific local access and transport area
     * ([LATA](http://en.wikipedia.org/wiki/Local_access_and_transport_area)). Given
     * a phone number, search within the same
     * [LATA](http://en.wikipedia.org/wiki/Local_access_and_transport_area) as that
     * number. Applies to only phone numbers in the US and Canada..
     *
     * @param inLata Limit results to a specific local access and transport area.
     *               (US/Canada only)
     * @return this
     */
    public MobileReader setInLata(final String inLata) {
        this.inLata = inLata;
        return this;
    }

    /**
     * Limit results to a particular locality or city. Given a phone number, search
     * within the same Locality as that number..
     *
     * @param inLocality Limit results to a particular locality
     * @return this
     */
    public MobileReader setInLocality(final String inLocality) {
        this.inLocality = inLocality;
        return this;
    }

    /**
     * Whether the phone numbers can receive faxes. Can be: `true` or `false`..
     *
     * @param faxEnabled Whether the phone numbers can receive faxes
     * @return this
     */
    public MobileReader setFaxEnabled(final Boolean faxEnabled) {
        this.faxEnabled = faxEnabled;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Mobile ResourceSet
     */
    @Override
    public ResourceSet<Mobile> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Mobile ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Mobile> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/AvailablePhoneNumbers/" + this.pathCountryCode + "/Mobile.json",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Mobile ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Mobile> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Mobile> nextPage(final Page<Mobile> page,
                                 final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Mobile> previousPage(final Page<Mobile> page,
                                     final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Mobile Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Mobile> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Mobile read failed: Unable to connect to server");
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

        return Page.fromJson(
            "available_phone_numbers",
            response.getContent(),
            Mobile.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (areaCode != null) {
            request.addQueryParam("AreaCode", areaCode.toString());
        }

        if (contains != null) {
            request.addQueryParam("Contains", contains);
        }

        if (smsEnabled != null) {
            request.addQueryParam("SmsEnabled", smsEnabled.toString());
        }

        if (mmsEnabled != null) {
            request.addQueryParam("MmsEnabled", mmsEnabled.toString());
        }

        if (voiceEnabled != null) {
            request.addQueryParam("VoiceEnabled", voiceEnabled.toString());
        }

        if (excludeAllAddressRequired != null) {
            request.addQueryParam("ExcludeAllAddressRequired", excludeAllAddressRequired.toString());
        }

        if (excludeLocalAddressRequired != null) {
            request.addQueryParam("ExcludeLocalAddressRequired", excludeLocalAddressRequired.toString());
        }

        if (excludeForeignAddressRequired != null) {
            request.addQueryParam("ExcludeForeignAddressRequired", excludeForeignAddressRequired.toString());
        }

        if (beta != null) {
            request.addQueryParam("Beta", beta.toString());
        }

        if (nearNumber != null) {
            request.addQueryParam("NearNumber", nearNumber.toString());
        }

        if (nearLatLong != null) {
            request.addQueryParam("NearLatLong", nearLatLong);
        }

        if (distance != null) {
            request.addQueryParam("Distance", distance.toString());
        }

        if (inPostalCode != null) {
            request.addQueryParam("InPostalCode", inPostalCode);
        }

        if (inRegion != null) {
            request.addQueryParam("InRegion", inRegion);
        }

        if (inRateCenter != null) {
            request.addQueryParam("InRateCenter", inRateCenter);
        }

        if (inLata != null) {
            request.addQueryParam("InLata", inLata);
        }

        if (inLocality != null) {
            request.addQueryParam("InLocality", inLocality);
        }

        if (faxEnabled != null) {
            request.addQueryParam("FaxEnabled", faxEnabled.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}