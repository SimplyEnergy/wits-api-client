# sel.wits.client - Kotlin client library for Energy and Reserve Quantities

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.electricityinfo.co.nz/api/quantities/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*EnergyApi* | [**energyGet**](docs/EnergyApi.md#energyget) | **GET** /energy | Retrieve a list of energy quantities across schedules
*EnergyApi* | [**schedulesGet**](docs/EnergyApi.md#schedulesget) | **GET** /schedules | Retrieve a list of schedules for which quantity data is currently available
*EnergyApi* | [**schedulesScheduleEnergyGet**](docs/EnergyApi.md#schedulesscheduleenergyget) | **GET** /schedules/{schedule}/energy | Retrieve a list of energy quantities for the given schedule
*ReservesApi* | [**reservesGet**](docs/ReservesApi.md#reservesget) | **GET** /reserves | Retrieve a list of reserve quantities across schedules
*ReservesApi* | [**schedulesGet**](docs/ReservesApi.md#schedulesget) | **GET** /schedules | Retrieve a list of schedules for which quantity data is currently available
*ReservesApi* | [**schedulesScheduleReservesGet**](docs/ReservesApi.md#schedulesschedulereservesget) | **GET** /schedules/{schedule}/reserves | Retrieve a list of reserve quantities for the given schedule


<a name="documentation-for-models"></a>
## Documentation for Models

 - [sel.wits.client.models.BaseQuantityDetails](docs/BaseQuantityDetails.md)
 - [sel.wits.client.models.EnergyQuantitityDetails](docs/EnergyQuantitityDetails.md)
 - [sel.wits.client.models.EnergyQuantitityDetailsAllOf](docs/EnergyQuantitityDetailsAllOf.md)
 - [sel.wits.client.models.EnergyScheduleDetails](docs/EnergyScheduleDetails.md)
 - [sel.wits.client.models.Fault](docs/Fault.md)
 - [sel.wits.client.models.GetEnergyQuantitiesResponse](docs/GetEnergyQuantitiesResponse.md)
 - [sel.wits.client.models.GetReserveQuantitiesResponse](docs/GetReserveQuantitiesResponse.md)
 - [sel.wits.client.models.Island](docs/Island.md)
 - [sel.wits.client.models.ListSchedulesResponse](docs/ListSchedulesResponse.md)
 - [sel.wits.client.models.ReserveQuantitityDetails](docs/ReserveQuantitityDetails.md)
 - [sel.wits.client.models.ReserveQuantitityDetailsAllOf](docs/ReserveQuantitityDetailsAllOf.md)
 - [sel.wits.client.models.ReserveScheduleDetails](docs/ReserveScheduleDetails.md)
 - [sel.wits.client.models.RunClass](docs/RunClass.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="oAuthClientCredentials"></a>
### oAuthClientCredentials

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: N/A

