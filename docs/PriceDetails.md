
# PriceDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**node** | **kotlin.String** | The name of the Grid Injection Point(GIP) or Grid Exit Point (GXP). This is the first 8 characters of the Market Node ID. | 
**schedule** | **kotlin.String** |  |  [optional]
**tradingDate** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  [optional]
**tradingTime** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  [optional]
**tradingPeriod** | **kotlin.Int** | A sequential 30-minute period starting from period 1 at midnight (00:00) and, on most days, ending at period 48 at 23:30.  The exceptions to this are on the spring and autumn daylight-time changeover days. The spring change-over day is 23 hours long (as the clock jumps forward from 2am to 3am) so only has 46 trading-periods and the autumn change-over day is 25 hours long (as the clock jumps back from 3am to 2am) and has 50 trading-periods. |  [optional]
**runType** | **kotlin.String** | Sub-type of schedule |  [optional]
**lastRunTime** | **kotlin.String** | Solution run-time |  [optional]
**price** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**price6s** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**price60s** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**reserveNode** | **kotlin.String** | The name of the Grid Injection Point(GIP) or Grid Exit Point (GXP). This is the first 8 characters of the Market Node ID. |  [optional]



