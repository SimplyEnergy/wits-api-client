# MarketPricesApi

All URIs are relative to *https://api.electricityinfo.co.nz/api/market-prices/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**nodesGet**](MarketPricesApi.md#nodesGet) | **GET** /nodes | Retrieve a list of GXP/GIP supported by this API
[**pricesGet**](MarketPricesApi.md#pricesGet) | **GET** /prices | Retrieve a list of prices across schedules
[**schedulesGet**](MarketPricesApi.md#schedulesGet) | **GET** /schedules | Retrieve a list of schedules for which pricing data is currently available
[**schedulesSchedulePricesGet**](MarketPricesApi.md#schedulesSchedulePricesGet) | **GET** /schedules/{schedule}/prices | Retrieve a list of prices for the given schedule


<a name="nodesGet"></a>
# **nodesGet**
> kotlin.collections.List&lt;kotlin.String&gt; nodesGet()

Retrieve a list of GXP/GIP supported by this API

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = MarketPricesApi()
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.nodesGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MarketPricesApi#nodesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MarketPricesApi#nodesGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pricesGet"></a>
# **pricesGet**
> GetPricesResponse pricesGet(schedules, marketType, nodes, from, to, back, forward, island, offset)

Retrieve a list of prices across schedules

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = MarketPricesApi()
val schedules : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val marketType : MarketType =  // MarketType | Mandatory market type filter
val nodes : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Optional node list filter
val from : kotlin.String = from_example // kotlin.String | Optional trading period to filter historical data
val to : kotlin.String = to_example // kotlin.String | Optional trading period to filter historical data
val back : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val forward : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val island : Island =  // Island | Return pricing data only for the selected island
val offset : kotlin.Int = 56 // kotlin.Int | Optional offset parameter for basic pagination
try {
    val result : GetPricesResponse = apiInstance.pricesGet(schedules, marketType, nodes, from, to, back, forward, island, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MarketPricesApi#pricesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MarketPricesApi#pricesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedules** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  |
 **marketType** | [**MarketType**](.md)| Mandatory market type filter | [enum: E, R]
 **nodes** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Optional node list filter | [optional]
 **from** | **kotlin.String**| Optional trading period to filter historical data | [optional]
 **to** | **kotlin.String**| Optional trading period to filter historical data | [optional]
 **back** | **kotlin.Int**| Optional trading period filter | [optional]
 **forward** | **kotlin.Int**| Optional trading period filter | [optional]
 **island** | [**Island**](.md)| Return pricing data only for the selected island | [optional] [enum: NI, SI]
 **offset** | **kotlin.Int**| Optional offset parameter for basic pagination | [optional] [default to 0]

### Return type

[**GetPricesResponse**](GetPricesResponse.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="schedulesGet"></a>
# **schedulesGet**
> kotlin.collections.List&lt;ListSchedulesResponseInner&gt; schedulesGet()

Retrieve a list of schedules for which pricing data is currently available

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = MarketPricesApi()
try {
    val result : kotlin.collections.List<ListSchedulesResponseInner> = apiInstance.schedulesGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MarketPricesApi#schedulesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MarketPricesApi#schedulesGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;ListSchedulesResponseInner&gt;**](ListSchedulesResponseInner.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="schedulesSchedulePricesGet"></a>
# **schedulesSchedulePricesGet**
> ScheduleDetails schedulesSchedulePricesGet(schedule, marketType, nodes, from, to, back, forward, island, offset)

Retrieve a list of prices for the given schedule

### Example
```kotlin
// Import classes:
//import sel.wits.client.infrastructure.*
//import sel.wits.client.models.*

val apiInstance = MarketPricesApi()
val schedule : kotlin.String = schedule_example // kotlin.String | 
val marketType : MarketType =  // MarketType | Mandatory market type filter
val nodes : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Optional node list filter
val from : kotlin.String = from_example // kotlin.String | Optional trading period to filter historical data
val to : kotlin.String = to_example // kotlin.String | Optional trading period to filter historical data
val back : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val forward : kotlin.Int = 56 // kotlin.Int | Optional trading period filter
val island : Island =  // Island | Return pricing data only for the selected island
val offset : kotlin.Int = 56 // kotlin.Int | Optional offset parameter for basic pagination
try {
    val result : ScheduleDetails = apiInstance.schedulesSchedulePricesGet(schedule, marketType, nodes, from, to, back, forward, island, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MarketPricesApi#schedulesSchedulePricesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MarketPricesApi#schedulesSchedulePricesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedule** | **kotlin.String**|  |
 **marketType** | [**MarketType**](.md)| Mandatory market type filter | [enum: E, R]
 **nodes** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Optional node list filter | [optional]
 **from** | **kotlin.String**| Optional trading period to filter historical data | [optional]
 **to** | **kotlin.String**| Optional trading period to filter historical data | [optional]
 **back** | **kotlin.Int**| Optional trading period filter | [optional]
 **forward** | **kotlin.Int**| Optional trading period filter | [optional]
 **island** | [**Island**](.md)| Return pricing data only for the selected island | [optional] [enum: NI, SI]
 **offset** | **kotlin.Int**| Optional offset parameter for basic pagination | [optional] [default to 0]

### Return type

[**ScheduleDetails**](ScheduleDetails.md)

### Authorization


Configure oAuthClientCredentials:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

