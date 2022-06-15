# EnergyApi

All URIs are relative to *https://api.electricityinfo.co.nz/api/quantities/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**energyGet**](EnergyApi.md#energyGet) | **GET** /energy | Retrieve a list of energy quantities across schedules
[**schedulesGet**](EnergyApi.md#schedulesGet) | **GET** /schedules | Retrieve a list of schedules for which quantity data is currently available
[**schedulesScheduleEnergyGet**](EnergyApi.md#schedulesScheduleEnergyGet) | **GET** /schedules/{schedule}/energy | Retrieve a list of energy quantities for the given schedule


<a name="energyGet"></a>
# **energyGet**
> GetEnergyQuantitiesResponse energyGet(schedules, from, to, back, forward, island)

Retrieve a list of energy quantities across schedules

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = EnergyApi()
val schedules : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val from : kotlin.String = from_example // kotlin.String | Optional trading date-time to filter historical data
val to : kotlin.String = to_example // kotlin.String | Optional trading date-time to filter historical data
val back : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val forward : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val island : Island =  // Island | Return quantity data only for the selected island
try {
    val result : GetEnergyQuantitiesResponse = apiInstance.energyGet(schedules, from, to, back, forward, island)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EnergyApi#energyGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EnergyApi#energyGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedules** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  |
 **from** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **to** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **back** | **kotlin.Int**| Optional trading period filter | [optional]
 **forward** | **kotlin.Int**| Optional trading period filter | [optional]
 **island** | [**Island**](.md)| Return quantity data only for the selected island | [optional] [enum: NI, SI]

### Return type

[**GetEnergyQuantitiesResponse**](GetEnergyQuantitiesResponse.md)

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

val apiInstance = EnergyApi()
try {
    val result : ListSchedulesResponse = apiInstance.schedulesGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EnergyApi#schedulesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EnergyApi#schedulesGet")
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

<a name="schedulesScheduleEnergyGet"></a>
# **schedulesScheduleEnergyGet**
> EnergyScheduleDetails schedulesScheduleEnergyGet(schedule, from, to, back, forward, island)

Retrieve a list of energy quantities for the given schedule

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = EnergyApi()
val schedule : kotlin.String = schedule_example // kotlin.String | 
val from : kotlin.String = from_example // kotlin.String | Optional trading date-time to filter historical data
val to : kotlin.String = to_example // kotlin.String | Optional trading date-time to filter historical data
val back : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val forward : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val island : Island =  // Island | Return quantity data only for the selected island
try {
    val result : EnergyScheduleDetails = apiInstance.schedulesScheduleEnergyGet(schedule, from, to, back, forward, island)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EnergyApi#schedulesScheduleEnergyGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EnergyApi#schedulesScheduleEnergyGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedule** | **kotlin.String**|  |
 **from** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **to** | **kotlin.String**| Optional trading date-time to filter historical data | [optional]
 **back** | **kotlin.Int**| Optional trading period filter | [optional]
 **forward** | **kotlin.Int**| Optional trading period filter | [optional]
 **island** | [**Island**](.md)| Return quantity data only for the selected island | [optional] [enum: NI, SI]

### Return type

[**EnergyScheduleDetails**](EnergyScheduleDetails.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

