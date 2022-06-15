# Simply (SEL) Build log using wits-api spec and openapi generator

https://openapi-generator.tech/docs/generators/kotlin

```cli
openapi-generator generate -i energy-and-reserve-quantities.yaml -g kotlin --additional-properties=enumPropertyNaming=UPPERCASE --additional-properties=egroupId=sel.wits --additional-properties=packageName=sel.wits.client --additional-properties=sourceFolder=src/kt
```

```log
[main] INFO  o.o.codegen.DefaultGenerator - Generating with dryRun=false
[main] INFO  o.o.c.ignore.CodegenIgnoreProcessor - No .openapi-generator-ignore file found.
[main] INFO  o.o.codegen.DefaultGenerator - OpenAPI Generator: kotlin (client)
[main] INFO  o.o.codegen.DefaultGenerator - Generator 'kotlin' is considered stable.
[main] INFO  o.o.codegen.InlineModelResolver - Inline schema created as energyQuantitityDetails_allOf. To have complete control of the model name, set the `title` field or use the inlineSchemaNameMapping option (--inline-schema-name-mapping in CLI).
[main] INFO  o.o.codegen.InlineModelResolver - Inline schema created as reserveQuantitityDetails_allOf. To have complete control of the model name, set the `title` field or use the inlineSchemaNameMapping option (--inline-schema-name-mapping in CLI).
[main] INFO  o.o.c.l.AbstractKotlinCodegen - Environment variable KOTLIN_POST_PROCESS_FILE not defined so the Kotlin code may not be properly formatted. To define it, try 'export KOTLIN_POST_PROCESS_FILE="/usr/local/bin/ktlint -F"' (Linux/Mac)
[main] INFO  o.o.c.l.AbstractKotlinCodegen - NOTE: To enable file post-processing, 'enablePostProcessFile' must be set to `true` (--enable-post-process-file for CLI).
[main] WARN  o.o.codegen.DefaultCodegen - allOf with multiple schemas defined. Using only the first one: baseQuantityDetails
[main] WARN  o.o.codegen.DefaultCodegen - allOf with multiple schemas defined. Using only the first one: baseQuantityDetails
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/BaseQuantityDetails.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/BaseQuantityDetails.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/EnergyQuantitityDetails.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/EnergyQuantitityDetails.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/EnergyQuantitityDetailsAllOf.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/EnergyQuantitityDetailsAllOf.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/EnergyScheduleDetails.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/EnergyScheduleDetails.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/Fault.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/Fault.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/GetEnergyQuantitiesResponse.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/GetEnergyQuantitiesResponse.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/GetReserveQuantitiesResponse.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/GetReserveQuantitiesResponse.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/Island.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/Island.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/ListSchedulesResponse.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/ListSchedulesResponse.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/ReserveQuantitityDetails.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/ReserveQuantitityDetails.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/ReserveQuantitityDetailsAllOf.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/ReserveQuantitityDetailsAllOf.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/ReserveScheduleDetails.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/ReserveScheduleDetails.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/models/RunClass.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/RunClass.md
[main] WARN  o.o.codegen.DefaultCodegen - Empty operationId found for path: get /schedules. Renamed to auto-generated operationId: schedulesGet
[main] WARN  o.o.codegen.DefaultCodegen - Empty operationId found for path: get /schedules. Renamed to auto-generated operationId: schedulesGet
[main] WARN  o.o.codegen.DefaultCodegen - Empty operationId found for path: get /schedules/{schedule}/energy. Renamed to auto-generated operationId: schedulesScheduleEnergyGet
[main] WARN  o.o.codegen.DefaultCodegen - Empty operationId found for path: get /schedules/{schedule}/reserves. Renamed to auto-generated operationId: schedulesScheduleReservesGet
[main] WARN  o.o.codegen.DefaultCodegen - Empty operationId found for path: get /energy. Renamed to auto-generated operationId: energyGet
[main] WARN  o.o.codegen.DefaultCodegen - Empty operationId found for path: get /reserves. Renamed to auto-generated operationId: reservesGet
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/apis/EnergyApi.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/EnergyApi.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/apis/ReservesApi.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./docs/ReservesApi.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./README.md
[main] INFO  o.o.codegen.TemplateManager - writing file ./build.gradle
[main] INFO  o.o.codegen.TemplateManager - writing file ./settings.gradle
[main] INFO  o.o.codegen.TemplateManager - writing file ./gradlew
[main] INFO  o.o.codegen.TemplateManager - writing file ./gradlew.bat
[main] INFO  o.o.codegen.TemplateManager - writing file ./gradle/wrapper/gradle-wrapper.properties
[main] INFO  o.o.codegen.TemplateManager - writing file /Users/brad/simply/wits-api-client/./gradle/wrapper/gradle-wrapper.jar
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/ApiClient.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/ApiAbstractions.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/PartConfig.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/RequestConfig.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/RequestMethod.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/Serializer.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/ByteArrayAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/UUIDAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/LocalDateAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/LocalDateTimeAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/OffsetDateTimeAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/BigDecimalAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/BigIntegerAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/URIAdapter.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/Errors.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/ResponseExtensions.kt
[main] INFO  o.o.codegen.TemplateManager - writing file ./src/kt/sel/wits/client/infrastructure/ApiResponse.kt
[main] INFO  o.o.codegen.TemplateManager - writing file /Users/brad/simply/wits-api-client/./.openapi-generator-ignore
[main] INFO  o.o.codegen.TemplateManager - writing file ./.openapi-generator/VERSION
[main] INFO  o.o.codegen.TemplateManager - writing file ./.openapi-generator/FILES
################################################################################
# Thanks for using OpenAPI Generator.                                          #
# Please consider donation to help us maintain this project 🙏                 #
# https://opencollective.com/openapi_generator/donate                          #
#                                                                              #
# This generator's contributed by Jim Schubert (https://github.com/jimschubert)#
# Please support his work directly via https://patreon.com/jimschubert 🙏      #
################################################################################
```