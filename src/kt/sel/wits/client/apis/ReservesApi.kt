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

package sel.wits.client.apis

import java.io.IOException
import okhttp3.OkHttpClient

import sel.wits.client.models.Fault
import sel.wits.client.models.GetReserveQuantitiesResponse
import sel.wits.client.models.Island
import sel.wits.client.models.ListSchedulesResponse
import sel.wits.client.models.ReserveScheduleDetails
import sel.wits.client.models.RunClass

import com.squareup.moshi.Json

import sel.wits.client.infrastructure.ApiClient
import sel.wits.client.infrastructure.ApiResponse
import sel.wits.client.infrastructure.ClientException
import sel.wits.client.infrastructure.ClientError
import sel.wits.client.infrastructure.ServerException
import sel.wits.client.infrastructure.ServerError
import sel.wits.client.infrastructure.MultiValueMap
import sel.wits.client.infrastructure.PartConfig
import sel.wits.client.infrastructure.RequestConfig
import sel.wits.client.infrastructure.RequestMethod
import sel.wits.client.infrastructure.ResponseType
import sel.wits.client.infrastructure.Success
import sel.wits.client.infrastructure.toMultiValue

class ReservesApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api.electricityinfo.co.nz/api/quantities/v1")
        }
    }

    /**
     * Retrieve a list of reserve quantities across schedules
     * 
     * @param schedules 
     * @param runClass Mandatory run class filter
     * @param from Optional trading date-time to filter historical data (optional)
     * @param to Optional trading date-time to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return quantity data only for the selected island (optional)
     * @return GetReserveQuantitiesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun reservesGet(schedules: kotlin.collections.List<kotlin.String>, runClass: RunClass, from: kotlin.String? = null, to: kotlin.String? = null, back: kotlin.Int? = null, forward: kotlin.Int? = null, island: Island? = null) : GetReserveQuantitiesResponse {
        val localVarResponse = reservesGetWithHttpInfo(schedules = schedules, runClass = runClass, from = from, to = to, back = back, forward = forward, island = island)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GetReserveQuantitiesResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Retrieve a list of reserve quantities across schedules
     * 
     * @param schedules 
     * @param runClass Mandatory run class filter
     * @param from Optional trading date-time to filter historical data (optional)
     * @param to Optional trading date-time to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return quantity data only for the selected island (optional)
     * @return ApiResponse<GetReserveQuantitiesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun reservesGetWithHttpInfo(schedules: kotlin.collections.List<kotlin.String>, runClass: RunClass, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?) : ApiResponse<GetReserveQuantitiesResponse?> {
        val localVariableConfig = reservesGetRequestConfig(schedules = schedules, runClass = runClass, from = from, to = to, back = back, forward = forward, island = island)

        return request<Unit, GetReserveQuantitiesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation reservesGet
     *
     * @param schedules 
     * @param runClass Mandatory run class filter
     * @param from Optional trading date-time to filter historical data (optional)
     * @param to Optional trading date-time to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return quantity data only for the selected island (optional)
     * @return RequestConfig
     */
    fun reservesGetRequestConfig(schedules: kotlin.collections.List<kotlin.String>, runClass: RunClass, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("schedules", toMultiValue(schedules.toList(), "csv"))
                put("runClass", listOf(runClass.toString()))
                if (from != null) {
                    put("from", listOf(from.toString()))
                }
                if (to != null) {
                    put("to", listOf(to.toString()))
                }
                if (back != null) {
                    put("back", listOf(back.toString()))
                }
                if (forward != null) {
                    put("forward", listOf(forward.toString()))
                }
                if (island != null) {
                    put("island", listOf(island.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/reserves",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Retrieve a list of schedules for which quantity data is currently available
     * 
     * @return ListSchedulesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun schedulesGet() : ListSchedulesResponse {
        val localVarResponse = schedulesGetWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as ListSchedulesResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Retrieve a list of schedules for which quantity data is currently available
     * 
     * @return ApiResponse<ListSchedulesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun schedulesGetWithHttpInfo() : ApiResponse<ListSchedulesResponse?> {
        val localVariableConfig = schedulesGetRequestConfig()

        return request<Unit, ListSchedulesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation schedulesGet
     *
     * @return RequestConfig
     */
    fun schedulesGetRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/schedules",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Retrieve a list of reserve quantities for the given schedule
     * 
     * @param schedule 
     * @param runClass Mandatory run class filter
     * @param from Optional trading date-time to filter historical data (optional)
     * @param to Optional trading date-time to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return quantity data only for the selected island (optional)
     * @return ReserveScheduleDetails
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun schedulesScheduleReservesGet(schedule: kotlin.String, runClass: RunClass, from: kotlin.String? = null, to: kotlin.String? = null, back: kotlin.Int? = null, forward: kotlin.Int? = null, island: Island? = null) : ReserveScheduleDetails {
        val localVarResponse = schedulesScheduleReservesGetWithHttpInfo(schedule = schedule, runClass = runClass, from = from, to = to, back = back, forward = forward, island = island)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as ReserveScheduleDetails
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Retrieve a list of reserve quantities for the given schedule
     * 
     * @param schedule 
     * @param runClass Mandatory run class filter
     * @param from Optional trading date-time to filter historical data (optional)
     * @param to Optional trading date-time to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return quantity data only for the selected island (optional)
     * @return ApiResponse<ReserveScheduleDetails?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun schedulesScheduleReservesGetWithHttpInfo(schedule: kotlin.String, runClass: RunClass, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?) : ApiResponse<ReserveScheduleDetails?> {
        val localVariableConfig = schedulesScheduleReservesGetRequestConfig(schedule = schedule, runClass = runClass, from = from, to = to, back = back, forward = forward, island = island)

        return request<Unit, ReserveScheduleDetails>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation schedulesScheduleReservesGet
     *
     * @param schedule 
     * @param runClass Mandatory run class filter
     * @param from Optional trading date-time to filter historical data (optional)
     * @param to Optional trading date-time to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return quantity data only for the selected island (optional)
     * @return RequestConfig
     */
    fun schedulesScheduleReservesGetRequestConfig(schedule: kotlin.String, runClass: RunClass, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("runClass", listOf(runClass.toString()))
                if (from != null) {
                    put("from", listOf(from.toString()))
                }
                if (to != null) {
                    put("to", listOf(to.toString()))
                }
                if (back != null) {
                    put("back", listOf(back.toString()))
                }
                if (forward != null) {
                    put("forward", listOf(forward.toString()))
                }
                if (island != null) {
                    put("island", listOf(island.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/schedules/{schedule}/reserves".replace("{"+"schedule"+"}", "$schedule"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
