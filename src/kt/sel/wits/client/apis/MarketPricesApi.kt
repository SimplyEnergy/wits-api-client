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

package sel.wits.client.apis

import java.io.IOException
import okhttp3.OkHttpClient

import sel.wits.client.models.Fault
import sel.wits.client.models.GetPricesResponse
import sel.wits.client.models.Island
import sel.wits.client.models.ListSchedulesResponseInner
import sel.wits.client.models.MarketType
import sel.wits.client.models.ScheduleDetails

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

class MarketPricesApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api.electricityinfo.co.nz/api/market-prices/v1")
        }
    }

    /**
     * Retrieve a list of GXP/GIP supported by this API
     * 
     * @return kotlin.collections.List<kotlin.String>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun nodesGet() : kotlin.collections.List<kotlin.String> {
        val localVarResponse = nodesGetWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.String>
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
     * Retrieve a list of GXP/GIP supported by this API
     * 
     * @return ApiResponse<kotlin.collections.List<kotlin.String>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun nodesGetWithHttpInfo() : ApiResponse<kotlin.collections.List<kotlin.String>?> {
        val localVariableConfig = nodesGetRequestConfig()

        return request<Unit, kotlin.collections.List<kotlin.String>>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation nodesGet
     *
     * @return RequestConfig
     */
    fun nodesGetRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/nodes",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Retrieve a list of prices across schedules
     * 
     * @param schedules 
     * @param marketType Mandatory market type filter
     * @param nodes Optional node list filter (optional)
     * @param from Optional trading period to filter historical data (optional)
     * @param to Optional trading period to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return pricing data only for the selected island (optional)
     * @param offset Optional offset parameter for basic pagination (optional, default to 0)
     * @return GetPricesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun pricesGet(schedules: kotlin.collections.List<kotlin.String>, marketType: MarketType, nodes: kotlin.collections.List<kotlin.String>? = null, from: kotlin.String? = null, to: kotlin.String? = null, back: kotlin.Int? = null, forward: kotlin.Int? = null, island: Island? = null, offset: kotlin.Int? = 0) : GetPricesResponse {
        val localVarResponse = pricesGetWithHttpInfo(schedules = schedules, marketType = marketType, nodes = nodes, from = from, to = to, back = back, forward = forward, island = island, offset = offset)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GetPricesResponse
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
     * Retrieve a list of prices across schedules
     * 
     * @param schedules 
     * @param marketType Mandatory market type filter
     * @param nodes Optional node list filter (optional)
     * @param from Optional trading period to filter historical data (optional)
     * @param to Optional trading period to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return pricing data only for the selected island (optional)
     * @param offset Optional offset parameter for basic pagination (optional, default to 0)
     * @return ApiResponse<GetPricesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun pricesGetWithHttpInfo(schedules: kotlin.collections.List<kotlin.String>, marketType: MarketType, nodes: kotlin.collections.List<kotlin.String>?, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?, offset: kotlin.Int?) : ApiResponse<GetPricesResponse?> {
        val localVariableConfig = pricesGetRequestConfig(schedules = schedules, marketType = marketType, nodes = nodes, from = from, to = to, back = back, forward = forward, island = island, offset = offset)

        return request<Unit, GetPricesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation pricesGet
     *
     * @param schedules 
     * @param marketType Mandatory market type filter
     * @param nodes Optional node list filter (optional)
     * @param from Optional trading period to filter historical data (optional)
     * @param to Optional trading period to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return pricing data only for the selected island (optional)
     * @param offset Optional offset parameter for basic pagination (optional, default to 0)
     * @return RequestConfig
     */
    fun pricesGetRequestConfig(schedules: kotlin.collections.List<kotlin.String>, marketType: MarketType, nodes: kotlin.collections.List<kotlin.String>?, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?, offset: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("schedules", toMultiValue(schedules.toList(), "csv"))
                put("marketType", listOf(marketType.toString()))
                if (nodes != null) {
                    put("nodes", toMultiValue(nodes.toList(), "csv"))
                }
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
                if (offset != null) {
                    put("offset", listOf(offset.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/prices",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Retrieve a list of schedules for which pricing data is currently available
     * 
     * @return kotlin.collections.List<ListSchedulesResponseInner>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun schedulesGet() : kotlin.collections.List<ListSchedulesResponseInner> {
        val localVarResponse = schedulesGetWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<ListSchedulesResponseInner>
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
     * Retrieve a list of schedules for which pricing data is currently available
     * 
     * @return ApiResponse<kotlin.collections.List<ListSchedulesResponseInner>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun schedulesGetWithHttpInfo() : ApiResponse<kotlin.collections.List<ListSchedulesResponseInner>?> {
        val localVariableConfig = schedulesGetRequestConfig()

        return request<Unit, kotlin.collections.List<ListSchedulesResponseInner>>(
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
     * Retrieve a list of prices for the given schedule
     * 
     * @param schedule 
     * @param marketType Mandatory market type filter
     * @param nodes Optional node list filter (optional)
     * @param from Optional trading period to filter historical data (optional)
     * @param to Optional trading period to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return pricing data only for the selected island (optional)
     * @param offset Optional offset parameter for basic pagination (optional, default to 0)
     * @return ScheduleDetails
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun schedulesSchedulePricesGet(schedule: kotlin.String, marketType: MarketType, nodes: kotlin.collections.List<kotlin.String>? = null, from: kotlin.String? = null, to: kotlin.String? = null, back: kotlin.Int? = null, forward: kotlin.Int? = null, island: Island? = null, offset: kotlin.Int? = 0) : ScheduleDetails {
        val localVarResponse = schedulesSchedulePricesGetWithHttpInfo(schedule = schedule, marketType = marketType, nodes = nodes, from = from, to = to, back = back, forward = forward, island = island, offset = offset)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as ScheduleDetails
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
     * Retrieve a list of prices for the given schedule
     * 
     * @param schedule 
     * @param marketType Mandatory market type filter
     * @param nodes Optional node list filter (optional)
     * @param from Optional trading period to filter historical data (optional)
     * @param to Optional trading period to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return pricing data only for the selected island (optional)
     * @param offset Optional offset parameter for basic pagination (optional, default to 0)
     * @return ApiResponse<ScheduleDetails?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun schedulesSchedulePricesGetWithHttpInfo(schedule: kotlin.String, marketType: MarketType, nodes: kotlin.collections.List<kotlin.String>?, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?, offset: kotlin.Int?) : ApiResponse<ScheduleDetails?> {
        val localVariableConfig = schedulesSchedulePricesGetRequestConfig(schedule = schedule, marketType = marketType, nodes = nodes, from = from, to = to, back = back, forward = forward, island = island, offset = offset)

        return request<Unit, ScheduleDetails>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation schedulesSchedulePricesGet
     *
     * @param schedule 
     * @param marketType Mandatory market type filter
     * @param nodes Optional node list filter (optional)
     * @param from Optional trading period to filter historical data (optional)
     * @param to Optional trading period to filter historical data (optional)
     * @param back Optional trading period filter (optional)
     * @param forward Optional trading period filter (optional)
     * @param island Return pricing data only for the selected island (optional)
     * @param offset Optional offset parameter for basic pagination (optional, default to 0)
     * @return RequestConfig
     */
    fun schedulesSchedulePricesGetRequestConfig(schedule: kotlin.String, marketType: MarketType, nodes: kotlin.collections.List<kotlin.String>?, from: kotlin.String?, to: kotlin.String?, back: kotlin.Int?, forward: kotlin.Int?, island: Island?, offset: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("marketType", listOf(marketType.toString()))
                if (nodes != null) {
                    put("nodes", toMultiValue(nodes.toList(), "csv"))
                }
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
                if (offset != null) {
                    put("offset", listOf(offset.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/schedules/{schedule}/prices".replace("{"+"schedule"+"}", "$schedule"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
