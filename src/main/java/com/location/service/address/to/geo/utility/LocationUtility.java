package com.location.service.address.to.geo.utility;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.location.service.address.to.geo.utility.response.LocationResponse;

@Service
public class LocationUtility {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LocationUtility.class);

	private static final String GOOGLE_API_FOR_ADDRESS_TO_GEO = "https://maps.googleapis.com/maps/api/geocode/json?address={address}&key=AIzaSyDmBJYFTBQStGvEi9HcFjfVYjI27ju20IY";

	private RestTemplate restTemplate = new RestTemplate();

	public LocationResponse getGeoCodeFromAddress(String address) {
		try {
			Map<String, String> urlVariables = new HashMap<>();
			urlVariables.put("address", address);
			LOGGER.info("Google API detail URL ={} and address is={}",
					GOOGLE_API_FOR_ADDRESS_TO_GEO, address);
			LocationResponse locationResponse = restTemplate.getForObject(
					GOOGLE_API_FOR_ADDRESS_TO_GEO, LocationResponse.class,
					urlVariables);
			if (null != locationResponse
					&& !StringUtils.isEmpty(locationResponse.getStatus())
					&& "200".equalsIgnoreCase(locationResponse.getStatus())) {
				return locationResponse;
			} else {
				return new LocationResponse();
			}

		} catch (RestClientException ex) {
			LOGGER.error("message=errorGettingProjectName", ex);
			return new LocationResponse();
		}
	}

}
