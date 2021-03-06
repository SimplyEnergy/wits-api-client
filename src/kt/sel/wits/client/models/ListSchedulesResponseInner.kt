/**
 * Market Prices
 *
 * #### Pre-requisites #### See [How To Call Our APIs](guides) for information on registration, authentication and authorisation requirements.  ## Overview ## The purpose of this API is to retrieve market energy or reserve prices for identified schedule(s).  Pricing information can be filtered in a variety of different ways. The minimum required parameters to filter data are a list of one or more schedules (market run types) and the market type being queried (either `E` for energy prices or `R` for reserve prices).  * A single schedule can be queried through the `/schedules/{schedule}/prices` path. * Multiple schedules can be queried through the `/prices` path, identifying one or more schedules in the `schedules` query parameter.  Schedules supported by this API can be obtained through a query to `/schedules`.  In either case, the market type being queried must be included in the `market-type` query parameter.  ## API Parameters ## ### Range Requests ### Pricing data can be filtered by a combination of trading datetime or sliding trading period ranges.  The available query parameters for specifying a range are: * `from` * `to` * `back` * `forward`  **From and To**  The `from` and `to` parameters specify a date-time for which to filter queried data by. None, one or both parameters may be provided. The date-time must conform to the `RFC3339` standard formatting, e.g. `yyyy-MM-dd'T'HH:mm:ssXXX`.   If both `from` and `to` are provided, this is an inclusive window of time to query data for.  If a `from` parameter is provided without a corresponding `to` parameter, this represents a query of data filtered from the trading period implied by the `from` date-time forward as far as possible for the queried schedule(s).  If a `to` parameter is provided without a corresponding `from` parameter, this represents a query of data filtered from the oldest data available forward to the trading period implied by the `to` date-time.  **Back and Forward**  Unlike the `from` and `to` parameters, the `back` and `forward` filter can be used to identify a sliding window of data to query. A request cannot include both `from` and/or `to` parameters __and__ `back` and/or `forward`.  The `back` parameter specifies a number of trading periods _before_ the current trading period to include data for. Correspondingly, the `to` parameter specifies a number of trading periods _ahead_ of the current trading period to include data for.  For example, if the current trading period is `23` (11:00:00 NZT - 11:29:59 NZT) and both `back` and `forward` are set to `5`, data from trading periods `18` - `28` will be queried. Note that not all schedules will have data available beyond the current trading period.  ### Node Filters ### The pricing data can also be filtered by providing the ID of one or more `nodes` (Grid injection or extraction points) in the corresponding query parameter. If this parameter is included, only data for nodes in the supplied list will be returned.  Nodes supported by this API can be obtained through a query to `/nodes`.  ### Island Filter ### The data can also be filtered by `Island` (`NI` or `SI`). When the `island` query parameter is set, only information pertaining to that island will be returned.  ### Pagination ### This API supports basic pagination. A maximum of 10,000 records will be returned for any API call. If further data is required, set the `offset` query parameter to retrieve further data. For example, to retrieve the second set of 10,000 records set the `offset` query parameter to `10000`. Subsequently to retrieve the third set of 10,000 records, set the `offset` parameter to `20000`.  
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package sel.wits.client.models

import sel.wits.client.models.MarketType

import com.squareup.moshi.Json

/**
 * 
 *
 * @param schedule 
 * @param runType Sub-type of schedule
 * @param marketType 
 */

data class ListSchedulesResponseInner (

    @Json(name = "schedule")
    val schedule: kotlin.String? = null,

    /* Sub-type of schedule */
    @Json(name = "run_type")
    val runType: kotlin.String? = null,

    @Json(name = "market_type")
    val marketType: MarketType? = null

)

