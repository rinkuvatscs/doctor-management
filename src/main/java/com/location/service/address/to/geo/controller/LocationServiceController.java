package com.location.service.address.to.geo.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.service.address.to.geo.service.LocationService;
import com.location.service.address.to.geo.service.response.LocationResponse;

@RestController
@RequestMapping("/api/location")
@Api(basePath = "/location", value = "location", description = "Operations with Landlords", produces = "application/json")
public class LocationServiceController {

	@Autowired
	private LocationService locationUtility;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{address}", method = RequestMethod.GET)
	@ResponseBody
	public LocationResponse getLocationGeoCode(@PathVariable String address) {
		return locationUtility.getGeoCodeFromAddress(address);
	}
}
