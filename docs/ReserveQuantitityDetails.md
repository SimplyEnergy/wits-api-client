
# ReserveQuantitityDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tradingDateTime** | **kotlin.String** |  | 
**tradingPeriod** | **kotlin.Int** | A sequential 30-minute period starting from period 1 at midnight (00:00) and, on most days, ending at period 48 at 23:30.  The exceptions to this are on the spring and autumn daylight-time changeover days. The spring change-over day is 23 hours long (as the clock jumps forward from 2am to 3am) so only has 46 trading-periods and the autumn change-over day is 25 hours long (as the clock jumps back from 3am to 2am) and has 50 trading-periods. | 
**schedule** | **kotlin.String** |  | 
**island** | [**Island**](Island.md) |  |  [optional]
**runType** | **kotlin.String** |  |  [optional]
**reserveClass** | **kotlin.String** |  |  [optional]
**runClass** | **kotlin.String** |  |  [optional]
**price** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**reserveMw** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**riskMw** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**riskAdjustmentFactor** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]



