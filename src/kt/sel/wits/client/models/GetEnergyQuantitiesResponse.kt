/**
 * Energy and Reserve Quantities
 *
 * #### Pre-requisites #### See [How To Call Our APIs](guides) for information on registration, authentication and authorisation requirements. ## Overview ## The purpose of this API is to retrieve energy and reserve quantities for identified schedule(s).  Quantity information can be filtered in a variety of different ways. The minimum required parameters to filter data are a list of one or more schedules (market run types) and the market type being queried (Energy or Reserves).  * Energy quantities for a single schedule can be queried through the `/schedules/{schedule}/energy` path. * Reserve quantities for a single schedule can be queried through the `/schedules/{schedule}/reserves` path. * Energy quantities for multiple schedules can be queried through the `/energy` path, identifying one or more schedules in the `schedules` query parameter. * Reserve quantities for multiple schedules can be queried through the `/reserves` path, identifying one or more schedules in the `schedules` query parameter. Schedules supported by this API can be obtained through a query to `/schedules`.  ## API Parameters ## ### Run Class Filter ### Reserve Quantities must include a `runClass` filter. This query parameter must be set to one of `InstantaneousReserve`, `ReserveOffers` or `AdjustedReserveOffers`.   ### Range Requests ### Quantity data can be filtered using date-times for absolute windows, or by period offsets for rolling windows.  The available query parameters for specifying a range are: * `from` * `to` * `back` * `forward`  **From and To**  The `from` and `to` parameters specify a date-time for which to filter queried data by. None, one or both parameters may be provided. The date-time must conform to the `RFC3339` standard formatting, e.g. `yyyy-MM-dd'T'HH:mm:ssXXX`.   If both `from` and `to` are provided, this is an inclusive window of time to query data for.       If a `from` parameter is provided without a corresponding `to` parameter, this represents a query of data filtered from the trading period implied by the `from` date-time forward as far as possible for the queried schedule(s).  If a `to` parameter is provided without a corresponding `from` parameter, this represents a query of data filtered from the oldest data available forward to the trading period implied by the `to` date-time.  **Back and Forward**  Unlike the `from` and `to` parameters, the `back` and `forward` filter can be used to identify a sliding window of data to query. A request cannot include both `from` and/or `to` parameters __and__ `back` and/or `forward`.  The `back` parameter specifies a number of trading periods _before_ the current trading period to include data for. Correspondingly, the `to` parameter specifies a number of trading periods _ahead_ of the current trading period to include data for.  For example, if the current trading period is `23` (11:00:00 NZT - 11:29:59 NZT) and both `back` and `forward` are set to `5`, data from trading periods `18` - `28` will be queried. Note that not all schedules will have data available beyond the current trading period. ### Island Filter ### The data can also be filtered by `Island` (`NI` or `SI`). When the `island` query parameter is set, only information pertaining to that island will be returned.  
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

import sel.wits.client.models.EnergyScheduleDetails

import com.squareup.moshi.Json

/**
 * 
 *
 * @param schedules 
 */

data class GetEnergyQuantitiesResponse (

    @Json(name = "schedules")
    val schedules: kotlin.collections.List<EnergyScheduleDetails>

)

