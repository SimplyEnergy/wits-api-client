# ReservesApi

All URIs are relative to *https://api.electricityinfo.co.nz/api/quantities/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**reservesGet**](ReservesApi.md#reservesGet) | **GET** /reserves | Retrieve a list of reserve quantities across schedules
[**schedulesGet**](ReservesApi.md#schedulesGet) | **GET** /schedules | Retrieve a list of schedules for which quantity data is currently available
[**schedulesScheduleReservesGet**](ReservesApi.md#schedulesScheduleReservesGet) | **GET** /schedules/{schedule}/reserves | Retrieve a list of reserve quantities for the given schedule


<a name="reservesGet"></a>
# **reservesGet**
> GetReserveQuantitiesResponse reservesGet(schedules, runClass, from, to, back, forward, island)

Retrieve a list of reserve quantities across schedules

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = ReservesApi()
val schedules : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val runClass : RunClass =  // RunClass | Mandatory run class filter
val from : kotlin.String = from_example // kotlin.String | Optional trading date-time to filter historical data
val to : kotlin.String = to_example // kotlin.String | Optional trading date-time to filter historical data
val back : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val forward : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val island : Island =  // Island | Return quantity data only for the selected island
try {
    val result : GetReserveQuantitiesResponse = apiInstance.reservesGet(schedules, runClass, from, to, back, forward, island)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReservesApi#reservesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReservesApi#reservesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedules** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  |
 **runClass** | [**RunClass**](.md)| Mandatory run class filter | [enum: InstantaneousReserve, ReserveOffers, AdjustedReserveOffers]
 **from** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **to** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **back** | **kotlin.Int**| Optional trading period filter | [optional]
 **forward** | **kotlin.Int**| Optional trading period filter | [optional]
 **island** | [**Island**](.md)| Return quantity data only for the selected island | [optional] [enum: NI, SI]

### Return type

[**GetReserveQuantitiesResponse**](GetReserveQuantitiesResponse.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="schedulesGet"></a>
# **schedulesGet**
> ListSchedulesResponse schedulesGet()

Retrieve a list of schedules for which quantity data is currently available

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = ReservesApi()
try {
    val result : ListSchedulesResponse = apiInstance.schedulesGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReservesApi#schedulesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReservesApi#schedulesGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListSchedulesResponse**](ListSchedulesResponse.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="schedulesScheduleReservesGet"></a>
# **schedulesScheduleReservesGet**
> ReserveScheduleDetails schedulesScheduleReservesGet(schedule, runClass, from, to, back, forward, island)

Retrieve a list of reserve quantities for the given schedule

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = ReservesApi()
val schedule : kotlin.String = schedule_example // kotlin.String | 
val runClass : RunClass =  // RunClass | Mandatory run class filter
val from : kotlin.String = from_example // kotlin.String | Optional trading date-time to filter historical data
val to : kotlin.String = to_example // kotlin.String | Optional trading date-time to filter historical data
val back : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val forward : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val island : Island =  // Island | Return quantity data only for the selected island
try {
    val result : ReserveScheduleDetails = apiInstance.schedulesScheduleReservesGet(schedule, runClass, from, to, back, forward, island)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReservesApi#schedulesScheduleReservesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReservesApi#schedulesScheduleReservesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedule** | **kotlin.String**|  |
 **runClass** | [**RunClass**](.md)| Mandatory run class filter | [enum: InstantaneousReserve, ReserveOffers, AdjustedReserveOffers]
 **from** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **to** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **back** | **kotlin.Int**| Optional trading period filter | [optional]
 **forward** | **kotlin.Int**| Optional trading period filter | [optional]
 **island** | [**Island**](.md)| Return quantity data only for the selected island | [optional] [enum: NI, SI]

### Return type

[**ReserveScheduleDetails**](ReserveScheduleDetails.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

