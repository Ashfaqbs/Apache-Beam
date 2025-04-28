(beamenv) Ubuntu-VM% python3 -m apache_beam.yaml.main --yaml_pipeline_file=pipeline.yaml
INFO:root:Missing pipeline option (runner). Executing pipeline using the default runner: DirectRunner.
Building pipeline...
INFO:apache_beam.yaml.yaml_transform:Expanding "ReadFromCsv" at line 3 
INFO:root:Computing dataframe stage <ComputeStage(PTransform) label=[[ComputedExpression[get_column_Series_126579310057104], ComputedExpression[astype_Series_126579310058448], ComputedExpression[set_column_DataFrame_126579310054800], ComputedExpression[get_column_Series_126579310441616], ComputedExpression[astype_Series_126579310440992], ComputedExpression[set_column_DataFrame_126579310434512]]:126579310439312]> for Stage[inputs={PlaceholderExpression[placeholder_DataFrame_126579310059744]}, partitioning=Arbitrary, ops=[ComputedExpression[get_column_Series_126579310057104], ComputedExpression[astype_Series_126579310058448], ComputedExpression[set_column_DataFrame_126579310054800], ComputedExpression[get_column_Series_126579310441616], ComputedExpression[astype_Series_126579310440992], ComputedExpression[set_column_DataFrame_126579310434512]], outputs={PlaceholderExpression[placeholder_DataFrame_126579310059744], ComputedExpression[set_column_DataFrame_126579310434512]}]
INFO:apache_beam.yaml.yaml_transform:Expanding "Filter" at line 6 
INFO:apache_beam.yaml.yaml_transform:Expanding "Sql" at line 11 
INFO:apache_beam.utils.subprocess_server:Downloading job server jar from https://repo.maven.apache.org/maven2/org/apache/beam/beam-sdks-java-extensions-sql-expansion-service/2.64.0/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar
INFO:root:Starting a JAR-based expansion service from JAR /home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar 
INFO:apache_beam.utils.subprocess_server:Starting service with ['/home/ashu/Desktop/Ash/java/zulu17.58.21-ca-jdk17.0.15-linux_x64/bin/java' '-jar' '/home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar' '56885' '--filesToStage=/home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar' '--alsoStartLoopbackWorker']
INFO:apache_beam.utils.subprocess_server:Starting expansion service at localhost:56885
WARNING:root:Waiting for grpc channel to be ready at localhost:56885.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:18 PM org.apache.beam.sdk.expansion.service.ExpansionService loadRegisteredTransforms
INFO:apache_beam.utils.subprocess_server:INFO: Registering external transforms: [beam:transform:org.apache.beam:spanner_insert_or_update:v1, beam:directrunner:transforms:test_stream:v1, beam:transform:org.apache.beam:pubsublite_write:v1, beam:transform:org.apache.beam:kafka_write:v1, beam:transform:combine_grouped_values:v1, beam:transform:combine_globally:v1, beam:external:java:generate_sequence:v1, beam:schematransform:org.apache.beam:bigquery_storage_read:v1, beam:transform:redistribute_by_key:v1, beam:transform:window_into:v1, beam:directrunner:transforms:gabw:v1, beam:transform:org.apache.beam:spanner_update:v1, beam:transform:org.apache.beam:pubsub_write:v1, beam:schematransform:org.apache.beam:kafka_read:v1, beam:schematransform:org.apache.beam:kafka_write:v1, beam:transform:combine_per_key:v1, beam:schematransform:org.apache.beam:bigquery_write:v1, beam:transform:org.apache.beam:kafka_read_with_metadata:v1, beam:transform:group_by_key:v1, beam:transform:pubsub_read:v1, beam:transform:org.apache.beam:spanner_delete:v1, beam:transform:group_into_batches:v1, beam:transform:org.apache.beam:spanner_read:v1, beam:transform:pubsub_write:v1, beam:transform:org.apache.beam:spanner_insert:v1, beam:transform:group_into_batches_with_sharded_key:v1, beam:transform:pubsub_write:v2, beam:transform:create_view:v1, beam:transform:teststream:v1, beam:transform:sdf_process_keyed_elements:v1, beam:transform:org.apache.beam:pubsub_read:v1, beam:external:java:sql:v1, beam:directrunner:transforms:write_view:v1, beam:transform:org.apache.beam:spanner_replace:v1, beam:directrunner:transforms:gbko:v1, beam:transform:org.apache.beam:pubsublite_read:v1, beam:transform:org.apache.beam:bigquery_write:v1, beam:transform:flatten:v1, beam:transform:impulse:v1, beam:transform:write_files:v1, beam:runners_core:transforms:splittable_process:v1, beam:directrunner:transforms:stateful_pardo:v1, beam:transform:org.apache.beam:bigquery_read:v1, beam:transform:org.apache.beam:kafka_read_without_metadata:v1, beam:transform:redistribute_arbitrarily:v1, beam:transform:reshuffle:v1]
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.utils.subprocess_server:Registered transforms:
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_insert_or_update:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@3b00856b
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:test_stream:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@3016fd5e
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsublite_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@35d08e6c
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:kafka_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@53d102a2
INFO:apache_beam.utils.subprocess_server:       beam:transform:combine_grouped_values:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@6c45ee6e
INFO:apache_beam.utils.subprocess_server:       beam:transform:combine_globally:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@6b3e12b5
INFO:apache_beam.utils.subprocess_server:       beam:external:java:generate_sequence:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@5aac4250
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_storage_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@1338fb5
INFO:apache_beam.utils.subprocess_server:       beam:transform:redistribute_by_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@42463763
INFO:apache_beam.utils.subprocess_server:       beam:transform:window_into:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@59f63e24
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:gabw:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@61f05988
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_update:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@7ca33c24
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsub_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@fade1fc
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@67c2e933
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@41dd05a
INFO:apache_beam.utils.subprocess_server:       beam:transform:combine_per_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@613a8ee1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@178213b
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:kafka_read_with_metadata:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@7103cb56
INFO:apache_beam.utils.subprocess_server:       beam:transform:group_by_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@1b765a2c
INFO:apache_beam.utils.subprocess_server:       beam:transform:pubsub_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2e8e8225
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_delete:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@6ebf0f36
INFO:apache_beam.utils.subprocess_server:       beam:transform:group_into_batches:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@18920cc
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@2807bdeb
INFO:apache_beam.utils.subprocess_server:       beam:transform:pubsub_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@72c28d64
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_insert:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@6492fab5
INFO:apache_beam.utils.subprocess_server:       beam:transform:group_into_batches_with_sharded_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2c5529ab
INFO:apache_beam.utils.subprocess_server:       beam:transform:pubsub_write:v2: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@39a8312f
INFO:apache_beam.utils.subprocess_server:       beam:transform:create_view:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@5f6722d3
INFO:apache_beam.utils.subprocess_server:       beam:transform:teststream:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2c532cd8
INFO:apache_beam.utils.subprocess_server:       beam:transform:sdf_process_keyed_elements:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@294e5088
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsub_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@51972dc7
INFO:apache_beam.utils.subprocess_server:       beam:external:java:sql:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@3700ec9c
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:write_view:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2002348
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_replace:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@5911e990
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:gbko:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@31000e60
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsublite_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@1d470d0
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:bigquery_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@24d09c1
INFO:apache_beam.utils.subprocess_server:       beam:transform:flatten:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@54c62d71
INFO:apache_beam.utils.subprocess_server:       beam:transform:impulse:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@65045a87
INFO:apache_beam.utils.subprocess_server:       beam:transform:write_files:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@47f4e407
INFO:apache_beam.utils.subprocess_server:       beam:runners_core:transforms:splittable_process:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2d1dee39
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:stateful_pardo:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@48d5f34e
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:bigquery_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@fc258b1
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:kafka_read_without_metadata:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@6ff65192
INFO:apache_beam.utils.subprocess_server:       beam:transform:redistribute_arbitrarily:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2dd80673
INFO:apache_beam.utils.subprocess_server:       beam:transform:reshuffle:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@4af0df05
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.utils.subprocess_server:Registered SchemaTransformProviders:
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_fileloads:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:filter-java:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:flatten:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:spanner_cdc_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:map_to_fields-java:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigtable_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:spanner_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:log_for_testing:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsublite_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_storage_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:spanner_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_export_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_storage_write:v2
INFO:apache_beam.utils.subprocess_server:       schematransform:org.apache.beam:sql_transform:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsub_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsub_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:window_into_strategy:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigtable_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsublite_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:generate_sequence:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:explode:v1
WARNING:root:Waiting for grpc channel to be ready at localhost:56885.
WARNING:root:Waiting for grpc channel to be ready at localhost:56885.
WARNING:root:Waiting for grpc channel to be ready at localhost:56885.
INFO:root:Starting a JAR-based expansion service from JAR /home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar 
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:23 PM org.apache.beam.sdk.expansion.service.ExpansionService expand
INFO:apache_beam.utils.subprocess_server:INFO: Expanding 'Sql' with URN 'beam:external:java:sql:v1'
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:24 PM org.apache.beam.sdk.expansion.service.ExpansionService payloadToConfig
INFO:apache_beam.utils.subprocess_server:WARNING: Configuration class 'org.apache.beam.sdk.extensions.sql.expansion.ExternalSqlTransformRegistrar$Configuration' has no schema registered. Attempting to construct with setter approach.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:24 PM org.apache.beam.sdk.expansion.service.ExpansionService payloadToConfig
INFO:apache_beam.utils.subprocess_server:WARNING: Configuration class 'org.apache.beam.sdk.extensions.sql.expansion.ExternalSqlTransformRegistrar$Configuration' has no schema registered. Attempting to construct with setter approach.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:26 PM org.apache.beam.sdk.extensions.sql.impl.CalciteQueryPlanner convertToBeamRel
INFO:apache_beam.utils.subprocess_server:INFO: SQL:
INFO:apache_beam.utils.subprocess_server:SELECT `PCOLLECTION`.`col1`, COUNT(*) AS `cnt`
INFO:apache_beam.utils.subprocess_server:FROM `beam`.`PCOLLECTION` AS `PCOLLECTION`
INFO:apache_beam.utils.subprocess_server:GROUP BY `PCOLLECTION`.`col1`
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:27 PM org.apache.beam.sdk.extensions.sql.impl.CalciteQueryPlanner convertToBeamRel
INFO:apache_beam.utils.subprocess_server:INFO: SQLPlan>
INFO:apache_beam.utils.subprocess_server:LogicalAggregate(group=[{0}], cnt=[COUNT()])
INFO:apache_beam.utils.subprocess_server:  LogicalProject(col1=[$0])
INFO:apache_beam.utils.subprocess_server:    BeamIOSourceRel(table=[[beam, PCOLLECTION]])
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:27 PM org.apache.beam.sdk.extensions.sql.impl.CalciteQueryPlanner convertToBeamRel
INFO:apache_beam.utils.subprocess_server:INFO: BEAMPlan>
INFO:apache_beam.utils.subprocess_server:BeamAggregationRel(group=[{0}], cnt=[COUNT()])
INFO:apache_beam.utils.subprocess_server:  BeamCalcRel(expr#0..2=[{inputs}], col1=[$t0])
INFO:apache_beam.utils.subprocess_server:    BeamIOSourceRel(table=[[beam, PCOLLECTION]])
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.yaml.yaml_transform:Expanding "WriteToJson" at line 15 
WARNING:apache_beam.transforms.core:('No iterator is returned by the process method in %s.', <class 'apache_beam.dataframe.convert.RowsToDataFrameFn'>)
INFO:apache_beam.io.fileio:Added temporary directory /home/ashu/Desktop/Ash/Code/beam-yaml/jobs/eg2/.temp6fd5e9f9-7a9d-4824-b2ae-e9225d56d124
Running pipeline...
INFO:apache_beam.runners.worker.statecache:Creating state cache with size 104857600
INFO:apache_beam.runners.portability.fn_api_runner.worker_handlers:starting control server on port 37951
INFO:apache_beam.runners.portability.fn_api_runner.worker_handlers:starting data server on port 35293
INFO:apache_beam.runners.portability.fn_api_runner.worker_handlers:starting state server on port 38583
INFO:apache_beam.runners.portability.fn_api_runner.worker_handlers:starting logging server on port 34647
INFO:apache_beam.runners.portability.fn_api_runner.worker_handlers:Requesting worker at localhost:56885
INFO:apache_beam.runners.portability.fn_api_runner.worker_handlers:self.control_address: Ubuntu-VM.myguest.virtualbox.org:37951
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:49 PM org.apache.beam.fn.harness.ExternalWorkerService startWorker
INFO:apache_beam.utils.subprocess_server:INFO: Starting worker worker_1 pointing at Ubuntu-VM.myguest.virtualbox.org:37951.
INFO:root:severity: INFO
timestamp {
  seconds: 1744992951
  nanos: 571000000
}
message: "Fn Harness started"
log_location: "org.apache.beam.fn.harness.FnHarness"
thread: "21"

INFO:root:severity: INFO
timestamp {
  seconds: 1744992951
  nanos: 731000000
}
message: "Running JvmInitializer#beforeProcessing for org.apache.beam.sdk.io.kafka.KafkaIOInitializer@471248d0"
log_location: "org.apache.beam.sdk.fn.JvmInitializers"
thread: "21"

INFO:root:severity: INFO
timestamp {
  seconds: 1744992951
  nanos: 732000000
}
message: "Completed JvmInitializer#beforeProcessing for org.apache.beam.sdk.io.kafka.KafkaIOInitializer@471248d0"
log_location: "org.apache.beam.sdk.fn.JvmInitializers"
thread: "21"

INFO:root:severity: INFO
timestamp {
  seconds: 1744992951
  nanos: 732000000
}
message: "Entering instruction processing loop"
log_location: "org.apache.beam.fn.harness.FnHarness"
thread: "21"

ERROR:root:severity: ERROR
timestamp {
  seconds: 1744992952
  nanos: 469000000
}
message: "*~*~*~ Previous channel ManagedChannelImpl{logId=8, target=Ubuntu-VM.myguest.virtualbox.org:37951} was garbage collected without being shut down! ~*~*~*\n    Make sure to call shutdown()/shutdownNow()"
trace: "java.lang.RuntimeException: ManagedChannel allocation site\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ManagedChannelOrphanWrapper$ManagedChannelReference.<init>(ManagedChannelOrphanWrapper.java:102)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ManagedChannelOrphanWrapper.<init>(ManagedChannelOrphanWrapper.java:60)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ManagedChannelOrphanWrapper.<init>(ManagedChannelOrphanWrapper.java:51)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ManagedChannelImplBuilder.build(ManagedChannelImplBuilder.java:710)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.ForwardingChannelBuilder2.build(ForwardingChannelBuilder2.java:272)\n\tat org.apache.beam.sdk.fn.channel.ManagedChannelFactory.forDescriptor(ManagedChannelFactory.java:101)\n\tat org.apache.beam.fn.harness.ExternalWorkerService.startWorker(ExternalWorkerService.java:83)\n\tat org.apache.beam.model.fnexecution.v1.BeamFnExternalWorkerPoolGrpc$MethodHandlers.invoke(BeamFnExternalWorkerPoolGrpc.java:296)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.stub.ServerCalls$UnaryServerCallHandler$UnaryServerCallListener.onHalfClose(ServerCalls.java:182)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ServerCallImpl$ServerStreamListenerImpl.halfClosed(ServerCallImpl.java:356)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ServerImpl$JumpToApplicationThreadServerStreamListener$1HalfClosed.runInContext(ServerImpl.java:861)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37)\n\tat org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:133)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)\n\tat java.base/java.lang.Thread.run(Thread.java:840)\n"
instruction_id: "bundle_5"
log_location: "org.apache.beam.vendor.grpc.v1p69p0.io.grpc.internal.ManagedChannelOrphanWrapper"
thread: "26"

INFO:apache_beam.io.fileio:Moving 1 temporary files to dir: /home/ashu/Desktop/Ash/Code/beam-yaml/jobs/eg2 as ['output.json-00000-of-00001']
INFO:root:severity: INFO
timestamp {
  seconds: 1744992954
  nanos: 813000000
}
message: "Hanged up for url: \"Ubuntu-VM.myguest.virtualbox.org:35293\"\n."
log_location: "org.apache.beam.sdk.fn.data.BeamFnDataGrpcMultiplexer"
thread: "17"

INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:55 PM org.apache.beam.fn.harness.FnHarness main
INFO:apache_beam.utils.subprocess_server:INFO: Shutting SDK harness down.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:45:55 PM org.apache.beam.fn.harness.ExternalWorkerService lambda$startWorker$0
INFO:apache_beam.utils.subprocess_server:INFO: Successfully started worker worker_1.
(beamenv) Ubuntu-VM% 






(beamenv) Ubuntu-VM% ls
commands.md  input.csv  output.json-00000-of-00001  pipeline.yaml
(beamenv) Ubuntu-VM% export BEAM_FN_API_USE_MULTIPROCESS_SDK=True
(beamenv) Ubuntu-VM% export PYTHONPATH=$(pwd)
(beamenv) Ubuntu-VM% 
(beamenv) Ubuntu-VM% python3 -m apache_beam.yaml.main \
  --yaml_pipeline_file=pipeline.yaml \
  --runner=FlinkRunner \
  --flink_master=localhost:8081 \
  --environment_type=LOOPBACK \
  --environment_config=""
Building pipeline...
INFO:apache_beam.yaml.yaml_transform:Expanding "ReadFromCsv" at line 3 
INFO:root:Computing dataframe stage <ComputeStage(PTransform) label=[[ComputedExpression[get_column_Series_124336881390672], ComputedExpression[astype_Series_124336881393792], ComputedExpression[set_column_DataFrame_124336881395856], ComputedExpression[get_column_Series_124336879805120], ComputedExpression[astype_Series_124336879805984], ComputedExpression[set_column_DataFrame_124336879799456]]:124336879803536]> for Stage[inputs={PlaceholderExpression[placeholder_DataFrame_124336881398880]}, partitioning=Arbitrary, ops=[ComputedExpression[get_column_Series_124336881390672], ComputedExpression[astype_Series_124336881393792], ComputedExpression[set_column_DataFrame_124336881395856], ComputedExpression[get_column_Series_124336879805120], ComputedExpression[astype_Series_124336879805984], ComputedExpression[set_column_DataFrame_124336879799456]], outputs={PlaceholderExpression[placeholder_DataFrame_124336881398880], ComputedExpression[set_column_DataFrame_124336879799456]}]
INFO:apache_beam.yaml.yaml_transform:Expanding "Filter" at line 6 
INFO:apache_beam.yaml.yaml_transform:Expanding "Sql" at line 11 
INFO:apache_beam.utils.subprocess_server:Using cached job server jar from https://repo.maven.apache.org/maven2/org/apache/beam/beam-sdks-java-extensions-sql-expansion-service/2.64.0/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar
INFO:root:Starting a JAR-based expansion service from JAR /home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar 
INFO:apache_beam.utils.subprocess_server:Starting service with ['/home/ashu/Desktop/Ash/java/zulu17.58.21-ca-jdk17.0.15-linux_x64/bin/java' '-jar' '/home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar' '35933' '--filesToStage=/home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar' '--alsoStartLoopbackWorker']
INFO:apache_beam.utils.subprocess_server:Starting expansion service at localhost:35933
WARNING:root:Waiting for grpc channel to be ready at localhost:35933.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:28 PM org.apache.beam.sdk.expansion.service.ExpansionService loadRegisteredTransforms
INFO:apache_beam.utils.subprocess_server:INFO: Registering external transforms: [beam:transform:org.apache.beam:spanner_insert_or_update:v1, beam:directrunner:transforms:test_stream:v1, beam:transform:org.apache.beam:pubsublite_write:v1, beam:transform:org.apache.beam:kafka_write:v1, beam:transform:combine_grouped_values:v1, beam:transform:combine_globally:v1, beam:external:java:generate_sequence:v1, beam:schematransform:org.apache.beam:bigquery_storage_read:v1, beam:transform:redistribute_by_key:v1, beam:transform:window_into:v1, beam:directrunner:transforms:gabw:v1, beam:transform:org.apache.beam:spanner_update:v1, beam:transform:org.apache.beam:pubsub_write:v1, beam:schematransform:org.apache.beam:kafka_read:v1, beam:schematransform:org.apache.beam:kafka_write:v1, beam:transform:combine_per_key:v1, beam:schematransform:org.apache.beam:bigquery_write:v1, beam:transform:org.apache.beam:kafka_read_with_metadata:v1, beam:transform:group_by_key:v1, beam:transform:pubsub_read:v1, beam:transform:org.apache.beam:spanner_delete:v1, beam:transform:group_into_batches:v1, beam:transform:org.apache.beam:spanner_read:v1, beam:transform:pubsub_write:v1, beam:transform:org.apache.beam:spanner_insert:v1, beam:transform:group_into_batches_with_sharded_key:v1, beam:transform:pubsub_write:v2, beam:transform:create_view:v1, beam:transform:teststream:v1, beam:transform:sdf_process_keyed_elements:v1, beam:transform:org.apache.beam:pubsub_read:v1, beam:external:java:sql:v1, beam:directrunner:transforms:write_view:v1, beam:transform:org.apache.beam:spanner_replace:v1, beam:directrunner:transforms:gbko:v1, beam:transform:org.apache.beam:pubsublite_read:v1, beam:transform:org.apache.beam:bigquery_write:v1, beam:transform:flatten:v1, beam:transform:impulse:v1, beam:transform:write_files:v1, beam:runners_core:transforms:splittable_process:v1, beam:directrunner:transforms:stateful_pardo:v1, beam:transform:org.apache.beam:bigquery_read:v1, beam:transform:org.apache.beam:kafka_read_without_metadata:v1, beam:transform:redistribute_arbitrarily:v1, beam:transform:reshuffle:v1]
WARNING:root:Waiting for grpc channel to be ready at localhost:35933.
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.utils.subprocess_server:Registered transforms:
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_insert_or_update:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@3b00856b
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:test_stream:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@3016fd5e
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsublite_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@35d08e6c
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:kafka_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@53d102a2
INFO:apache_beam.utils.subprocess_server:       beam:transform:combine_grouped_values:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@6c45ee6e
INFO:apache_beam.utils.subprocess_server:       beam:transform:combine_globally:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@6b3e12b5
INFO:apache_beam.utils.subprocess_server:       beam:external:java:generate_sequence:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@5aac4250
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_storage_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@1338fb5
INFO:apache_beam.utils.subprocess_server:       beam:transform:redistribute_by_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@42463763
INFO:apache_beam.utils.subprocess_server:       beam:transform:window_into:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@59f63e24
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:gabw:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@61f05988
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_update:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@7ca33c24
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsub_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@fade1fc
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@67c2e933
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@41dd05a
INFO:apache_beam.utils.subprocess_server:       beam:transform:combine_per_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@613a8ee1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@178213b
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:kafka_read_with_metadata:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@7103cb56
INFO:apache_beam.utils.subprocess_server:       beam:transform:group_by_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@1b765a2c
INFO:apache_beam.utils.subprocess_server:       beam:transform:pubsub_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2e8e8225
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_delete:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@6ebf0f36
INFO:apache_beam.utils.subprocess_server:       beam:transform:group_into_batches:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@18920cc
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@2807bdeb
INFO:apache_beam.utils.subprocess_server:       beam:transform:pubsub_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@72c28d64
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_insert:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@6492fab5
INFO:apache_beam.utils.subprocess_server:       beam:transform:group_into_batches_with_sharded_key:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2c5529ab
INFO:apache_beam.utils.subprocess_server:       beam:transform:pubsub_write:v2: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@39a8312f
INFO:apache_beam.utils.subprocess_server:       beam:transform:create_view:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@5f6722d3
INFO:apache_beam.utils.subprocess_server:       beam:transform:teststream:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2c532cd8
INFO:apache_beam.utils.subprocess_server:       beam:transform:sdf_process_keyed_elements:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@294e5088
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsub_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@51972dc7
INFO:apache_beam.utils.subprocess_server:       beam:external:java:sql:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@3700ec9c
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:write_view:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2002348
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:spanner_replace:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@5911e990
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:gbko:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@31000e60
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:pubsublite_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@1d470d0
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:bigquery_write:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@24d09c1
INFO:apache_beam.utils.subprocess_server:       beam:transform:flatten:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@54c62d71
INFO:apache_beam.utils.subprocess_server:       beam:transform:impulse:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@65045a87
INFO:apache_beam.utils.subprocess_server:       beam:transform:write_files:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@47f4e407
INFO:apache_beam.utils.subprocess_server:       beam:runners_core:transforms:splittable_process:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2d1dee39
INFO:apache_beam.utils.subprocess_server:       beam:directrunner:transforms:stateful_pardo:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@48d5f34e
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:bigquery_read:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@fc258b1
INFO:apache_beam.utils.subprocess_server:       beam:transform:org.apache.beam:kafka_read_without_metadata:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForBuilder@6ff65192
INFO:apache_beam.utils.subprocess_server:       beam:transform:redistribute_arbitrarily:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@2dd80673
INFO:apache_beam.utils.subprocess_server:       beam:transform:reshuffle:v1: org.apache.beam.sdk.expansion.service.ExpansionService$TransformProviderForPayloadTranslator@4af0df05
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.utils.subprocess_server:Registered SchemaTransformProviders:
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_fileloads:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:filter-java:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:flatten:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:spanner_cdc_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:map_to_fields-java:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigtable_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:spanner_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:log_for_testing:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsublite_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_storage_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:spanner_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_export_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:kafka_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_storage_write:v2
INFO:apache_beam.utils.subprocess_server:       schematransform:org.apache.beam:sql_transform:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsub_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsub_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:window_into_strategy:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigtable_read:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:bigquery_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:pubsublite_write:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:generate_sequence:v1
INFO:apache_beam.utils.subprocess_server:       beam:schematransform:org.apache.beam:yaml:explode:v1
WARNING:root:Waiting for grpc channel to be ready at localhost:35933.
WARNING:root:Waiting for grpc channel to be ready at localhost:35933.
INFO:root:Starting a JAR-based expansion service from JAR /home/ashu/.apache_beam/cache/jars/beam-sdks-java-extensions-sql-expansion-service-2.64.0.jar 
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:33 PM org.apache.beam.sdk.expansion.service.ExpansionService expand
INFO:apache_beam.utils.subprocess_server:INFO: Expanding 'Sql' with URN 'beam:external:java:sql:v1'
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:33 PM org.apache.beam.sdk.expansion.service.ExpansionService payloadToConfig
INFO:apache_beam.utils.subprocess_server:WARNING: Configuration class 'org.apache.beam.sdk.extensions.sql.expansion.ExternalSqlTransformRegistrar$Configuration' has no schema registered. Attempting to construct with setter approach.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:34 PM org.apache.beam.sdk.expansion.service.ExpansionService payloadToConfig
INFO:apache_beam.utils.subprocess_server:WARNING: Configuration class 'org.apache.beam.sdk.extensions.sql.expansion.ExternalSqlTransformRegistrar$Configuration' has no schema registered. Attempting to construct with setter approach.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:37 PM org.apache.beam.sdk.extensions.sql.impl.CalciteQueryPlanner convertToBeamRel
INFO:apache_beam.utils.subprocess_server:INFO: SQL:
INFO:apache_beam.utils.subprocess_server:SELECT `PCOLLECTION`.`col1`, COUNT(*) AS `cnt`
INFO:apache_beam.utils.subprocess_server:FROM `beam`.`PCOLLECTION` AS `PCOLLECTION`
INFO:apache_beam.utils.subprocess_server:GROUP BY `PCOLLECTION`.`col1`
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:38 PM org.apache.beam.sdk.extensions.sql.impl.CalciteQueryPlanner convertToBeamRel
INFO:apache_beam.utils.subprocess_server:INFO: SQLPlan>
INFO:apache_beam.utils.subprocess_server:LogicalAggregate(group=[{0}], cnt=[COUNT()])
INFO:apache_beam.utils.subprocess_server:  LogicalProject(col1=[$0])
INFO:apache_beam.utils.subprocess_server:    BeamIOSourceRel(table=[[beam, PCOLLECTION]])
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:49:39 PM org.apache.beam.sdk.extensions.sql.impl.CalciteQueryPlanner convertToBeamRel
INFO:apache_beam.utils.subprocess_server:INFO: BEAMPlan>
INFO:apache_beam.utils.subprocess_server:BeamAggregationRel(group=[{0}], cnt=[COUNT()])
INFO:apache_beam.utils.subprocess_server:  BeamCalcRel(expr#0..2=[{inputs}], col1=[$t0])
INFO:apache_beam.utils.subprocess_server:    BeamIOSourceRel(table=[[beam, PCOLLECTION]])
INFO:apache_beam.utils.subprocess_server:
INFO:apache_beam.yaml.yaml_transform:Expanding "WriteToJson" at line 15 
WARNING:apache_beam.transforms.core:('No iterator is returned by the process method in %s.', <class 'apache_beam.dataframe.convert.RowsToDataFrameFn'>)
INFO:apache_beam.io.fileio:Added temporary directory /home/ashu/Desktop/Ash/Code/beam-yaml/jobs/eg2/.temp8dbdfe42-c8d7-4d6e-a12c-5ebeb72bf03e
Running pipeline...
INFO:apache_beam.runners.worker.worker_pool_main:Listening for workers at localhost:44163
INFO:apache_beam.runners.portability.flink_runner:Adding HTTP protocol scheme to flink_master parameter: http://localhost:8081
INFO:apache_beam.utils.subprocess_server:Using cached job server jar from https://repo.maven.apache.org/maven2/org/apache/beam/beam-runners-flink-1.19-job-server/2.64.0/beam-runners-flink-1.19-job-server-2.64.0.jar
INFO:apache_beam.utils.subprocess_server:Starting service with ('java' '-jar' '/home/ashu/.apache_beam/cache/jars/beam-runners-flink-1.19-job-server-2.64.0.jar' '--flink-master' 'http://localhost:8081' '--artifacts-dir' '/tmp/beam-tempjmdhnxgc/artifactsr3vi2kuh' '--job-port' '45805' '--artifact-port' '0' '--expansion-port' '0')
INFO:apache_beam.utils.subprocess_server:SLF4J(W): Class path contains multiple SLF4J providers.
INFO:apache_beam.utils.subprocess_server:SLF4J(W): Found provider [org.slf4j.jul.JULServiceProvider@3e3abc88]
INFO:apache_beam.utils.subprocess_server:SLF4J(W): Found provider [org.slf4j.simple.SimpleServiceProvider@6ce253f1]
INFO:apache_beam.utils.subprocess_server:SLF4J(W): See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.
INFO:apache_beam.utils.subprocess_server:SLF4J(I): Actual provider is of type [org.slf4j.jul.JULServiceProvider@3e3abc88]
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:16 PM org.apache.beam.runners.jobsubmission.JobServerDriver createArtifactStagingService
INFO:apache_beam.utils.subprocess_server:INFO: ArtifactStagingService started on localhost:38503
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:17 PM org.apache.beam.runners.jobsubmission.JobServerDriver createExpansionService
INFO:apache_beam.utils.subprocess_server:INFO: Java ExpansionService started on localhost:33989
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:17 PM org.apache.beam.runners.jobsubmission.JobServerDriver createJobServer
INFO:apache_beam.utils.subprocess_server:INFO: JobService started on localhost:45805
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:17 PM org.apache.beam.runners.jobsubmission.JobServerDriver run
INFO:apache_beam.utils.subprocess_server:INFO: Job server now running, terminate with Ctrl+C
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
WARNING:root:Waiting for grpc channel to be ready at localhost:45805.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:24 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 onNext
INFO:apache_beam.utils.subprocess_server:INFO: Staging artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:24 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 resolveNextEnvironment
INFO:apache_beam.utils.subprocess_server:INFO: Resolving artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.0:ref_Environment_default_environment_2.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:24 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 onNext
INFO:apache_beam.utils.subprocess_server:INFO: Getting 1 artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.0:external_1beam:env:anyof:v1.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:25 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 resolveNextEnvironment
INFO:apache_beam.utils.subprocess_server:INFO: Resolving artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.0:external_1beam:env:anyof:v1.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:25 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 onNext
INFO:apache_beam.utils.subprocess_server:INFO: Getting 1 artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.1:external_1beam:env:anyof:v1.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:37 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 resolveNextEnvironment
INFO:apache_beam.utils.subprocess_server:INFO: Resolving artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.1:external_1beam:env:anyof:v1.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:37 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 onNext
INFO:apache_beam.utils.subprocess_server:INFO: Getting 0 artifacts for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.null.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:37 PM org.apache.beam.runners.fnexecution.artifact.ArtifactStagingService$2 finishStaging
INFO:apache_beam.utils.subprocess_server:INFO: Artifacts fully staged for job_5ccd4a5b-2e20-4d13-9b58-e4a0c7607f9a.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:42 PM org.apache.beam.runners.flink.FlinkJobInvoker invokeWithExecutor
INFO:apache_beam.utils.subprocess_server:INFO: Invoking job BeamApp-ashu-0418162039-5997b314_38a0dd07-d055-408b-8532-4d5bdbbf6d31 with pipeline runner org.apache.beam.runners.flink.FlinkPipelineRunner@44a923e3
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:43 PM org.apache.beam.runners.jobsubmission.JobInvocation start
INFO:apache_beam.utils.subprocess_server:INFO: Starting job invocation BeamApp-ashu-0418162039-5997b314_38a0dd07-d055-408b-8532-4d5bdbbf6d31
INFO:apache_beam.runners.portability.portable_runner:Environment "LOOPBACK" has started a component necessary for the execution. Be sure to run the pipeline using
  with Pipeline() as p:
    p.apply(..)
This ensures that the pipeline finishes before this program exits.
INFO:apache_beam.runners.portability.portable_runner:Job state changed to STOPPED
INFO:apache_beam.runners.portability.portable_runner:Job state changed to STARTING
INFO:apache_beam.runners.portability.portable_runner:Job state changed to RUNNING
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:43 PM org.apache.beam.runners.flink.FlinkPipelineRunner runPipelineWithTranslator
INFO:apache_beam.utils.subprocess_server:INFO: Translating pipeline to Flink program.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:43 PM org.apache.beam.runners.flink.FlinkExecutionEnvironments createBatchExecutionEnvironment
INFO:apache_beam.utils.subprocess_server:INFO: Creating a Batch Execution Environment.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:44 PM org.apache.beam.runners.flink.FlinkExecutionEnvironments createBatchExecutionEnvironment
INFO:apache_beam.utils.subprocess_server:INFO: Using Flink Master URL localhost:8081.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:52 PM org.apache.flink.api.java.utils.PlanGenerator logTypeRegistrationDetails
INFO:apache_beam.utils.subprocess_server:INFO: The job has 0 registered types and 0 default Kryo serializers
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:50:55 PM org.apache.flink.client.program.rest.RestClusterClient lambda$submitJob$7
INFO:apache_beam.utils.subprocess_server:INFO: Submitting job 'BeamApp-ashu-0418162039-5997b314' (f576f0bcadea655f338d5f6a7bfba640).
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:51:39 PM org.apache.flink.client.program.rest.RestClusterClient lambda$null$6
INFO:apache_beam.utils.subprocess_server:INFO: Successfully submitted job 'BeamApp-ashu-0418162039-5997b314' (f576f0bcadea655f338d5f6a7bfba640) to 'http://localhost:8081'.
INFO:apache_beam.utils.subprocess_server:Apr 18, 2025 9:52:21 PM org.apache.beam.runners.jobsubmission.JobInvocation$1 onFailure
INFO:apache_beam.utils.subprocess_server:SEVERE: Error during job invocation BeamApp-ashu-0418162039-5997b314_38a0dd07-d055-408b-8532-4d5bdbbf6d31.
INFO:apache_beam.utils.subprocess_server:org.apache.flink.client.program.ProgramInvocationException: Job failed (JobID: f576f0bcadea655f338d5f6a7bfba640)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.client.deployment.ClusterClientJobClientAdapter.lambda$null$6(ClusterClientJobClientAdapter.java:130)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$UniApply.tryFire(CompletableFuture.java:646)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2147)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.util.concurrent.FutureUtils.lambda$retryOperationWithDelay$6(FutureUtils.java:302)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2147)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.client.program.rest.RestClusterClient.lambda$pollResourceAsync$35(RestClusterClient.java:901)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2147)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.util.concurrent.FutureUtils.lambda$retryOperationWithDelay$6(FutureUtils.java:302)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.postFire(CompletableFuture.java:614)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$UniCompose.tryFire(CompletableFuture.java:1163)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$Completion.run(CompletableFuture.java:482)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.lang.Thread.run(Thread.java:840)
INFO:apache_beam.utils.subprocess_server:Caused by: org.apache.flink.runtime.client.JobExecutionException: Job execution failed.
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.jobmaster.JobResult.toJobExecutionResult(JobResult.java:144)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.client.deployment.ClusterClientJobClientAdapter.lambda$null$6(ClusterClientJobClientAdapter.java:128)
INFO:apache_beam.utils.subprocess_server:       ... 23 more
INFO:apache_beam.utils.subprocess_server:Caused by: org.apache.flink.runtime.JobException: org.apache.flink.runtime.JobException: Recovery is suppressed by NoRestartBackoffTimeStrategy
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.failover.ExecutionFailureHandler.handleFailure(ExecutionFailureHandler.java:180)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.failover.ExecutionFailureHandler.getFailureHandlingResult(ExecutionFailureHandler.java:107)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.scheduler.DefaultScheduler.recordTaskFailure(DefaultScheduler.java:277)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.scheduler.DefaultScheduler.handleTaskFailure(DefaultScheduler.java:268)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.scheduler.DefaultScheduler.onTaskFailed(DefaultScheduler.java:261)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.scheduler.SchedulerBase.onTaskExecutionStateUpdate(SchedulerBase.java:787)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.scheduler.SchedulerBase.updateTaskExecutionState(SchedulerBase.java:764)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.scheduler.UpdateSchedulerNgOnInternalFailuresListener.notifyTaskFailure(UpdateSchedulerNgOnInternalFailuresListener.java:51)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.DefaultExecutionGraph.notifySchedulerNgAboutInternalTaskFailure(DefaultExecutionGraph.java:1636)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.Execution.processFail(Execution.java:1144)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.Execution.processFail(Execution.java:1084)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.Execution.markFailed(Execution.java:923)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.Execution.lambda$deploy$5(Execution.java:611)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$Completion.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.lambda$handleRunAsync$4(PekkoRpcActor.java:451)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.concurrent.ClassLoadingUtils.runWithContextClassLoader(ClassLoadingUtils.java:68)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.handleRunAsync(PekkoRpcActor.java:451)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.handleRpcMessage(PekkoRpcActor.java:218)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.rpc.pekko.FencedPekkoRpcActor.handleRpcMessage(FencedPekkoRpcActor.java:85)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.handleMessage(PekkoRpcActor.java:168)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.japi.pf.UnitCaseStatement.apply(CaseStatements.scala:33)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.japi.pf.UnitCaseStatement.apply(CaseStatements.scala:29)
INFO:apache_beam.utils.subprocess_server:       at scala.PartialFunction.applyOrElse(PartialFunction.scala:127)
INFO:apache_beam.utils.subprocess_server:       at scala.PartialFunction.applyOrElse$(PartialFunction.scala:126)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.japi.pf.UnitCaseStatement.applyOrElse(CaseStatements.scala:29)
INFO:apache_beam.utils.subprocess_server:       at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:175)
INFO:apache_beam.utils.subprocess_server:       at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:176)
INFO:apache_beam.utils.subprocess_server:       at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:176)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.actor.Actor.aroundReceive(Actor.scala:547)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.actor.Actor.aroundReceive$(Actor.scala:545)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.actor.AbstractActor.aroundReceive(AbstractActor.scala:229)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.actor.ActorCell.receiveMessage(ActorCell.scala:590)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.actor.ActorCell.invoke(ActorCell.scala:557)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.dispatch.Mailbox.processMailbox(Mailbox.scala:272)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.dispatch.Mailbox.run(Mailbox.scala:233)
INFO:apache_beam.utils.subprocess_server:       at org.apache.pekko.dispatch.Mailbox.exec(Mailbox.scala:245)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ForkJoinTask.doExec(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ForkJoinPool.scan(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ForkJoinPool.runWorker(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ForkJoinWorkerThread.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:Caused by: java.lang.Exception: java.lang.Exception: Cannot deploy task CHAIN MapPartition (MapPartition at [3]ReadFromCsv/_ReadFromPandas/{Create, MatchAll}) -> FlatMap (FlatMap at ExtractOutput[0]) (1/1) (18821d83f7d0ddf8ade7b62dde6e80b1_28c89beaabf5cd2afaa798e857bacaec_0_0) - TaskManager (127.0.1.1:43935-208e2e @ Ubuntu-VM.myguest.virtualbox.org (dataPort=35773)) not responding after a rpcTimeout of 10000 ms
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.Execution.lambda$deploy$5(Execution.java:616)
INFO:apache_beam.utils.subprocess_server:       ... 30 more
INFO:apache_beam.utils.subprocess_server:Caused by: java.util.concurrent.TimeoutException: java.util.concurrent.TimeoutException: Invocation of [RemoteRpcInvocation(TaskExecutorGateway.submitTask(TaskDeploymentDescriptor, JobMasterId, Time))] at recipient [pekko.tcp://flink@127.0.1.1:43935/user/rpc/taskmanager_0] timed out. This is usually caused by: 1) Pekko failed sending the message silently, due to problems like oversized payload or serialization failures. In that case, you should find detailed error information in the logs. 2) The recipient needs more time for responding, due to problems like slow machines or network jitters. In that case, you can try to increase pekko.ask.timeout.
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.jobmaster.RpcTaskManagerGateway.submitTask(RpcTaskManagerGateway.java:59)
INFO:apache_beam.utils.subprocess_server:       at org.apache.flink.runtime.executiongraph.Execution.lambda$deploy$4(Execution.java:594)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.FutureTask.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:       at java.base/java.lang.Thread.run(Unknown Source)
INFO:apache_beam.utils.subprocess_server:Caused by: org.apache.pekko.pattern.AskTimeoutException: org.apache.pekko.pattern.AskTimeoutException: Ask timed out on [Actor[pekko.tcp://flink@127.0.1.1:43935/user/rpc/taskmanager_0#-59194869]] after [10000 ms]. Message of type [org.apache.flink.runtime.rpc.messages.RemoteRpcInvocation]. A typical reason for `AskTimeoutException` is that the recipient actor didn't send a reply.
INFO:apache_beam.utils.subprocess_server:
ERROR:root:org.apache.pekko.pattern.AskTimeoutException: org.apache.pekko.pattern.AskTimeoutException: Ask timed out on [Actor[pekko.tcp://flink@127.0.1.1:43935/user/rpc/taskmanager_0#-59194869]] after [10000 ms]. Message of type [org.apache.flink.runtime.rpc.messages.RemoteRpcInvocation]. A typical reason for `AskTimeoutException` is that the recipient actor didn't send a reply.
INFO:apache_beam.runners.portability.portable_runner:Job state changed to FAILED
Traceback (most recent call last):
  File "/usr/lib/python3.10/runpy.py", line 196, in _run_module_as_main
    return _run_code(code, main_globals, None,
  File "/usr/lib/python3.10/runpy.py", line 86, in _run_code
    exec(code, run_globals)
  File "/home/ashu/Desktop/Ash/Code/beam-yaml/beamenv/lib/python3.10/site-packages/apache_beam/yaml/main.py", line 183, in <module>
    run()
  File "/home/ashu/Desktop/Ash/Code/beam-yaml/beamenv/lib/python3.10/site-packages/apache_beam/yaml/main.py", line 127, in run
    with beam.Pipeline(options=options, display_data=display_data) as p:
  File "/home/ashu/Desktop/Ash/Code/beam-yaml/beamenv/lib/python3.10/site-packages/apache_beam/pipeline.py", line 646, in __exit__
    self.result.wait_until_finish()
  File "/home/ashu/Desktop/Ash/Code/beam-yaml/beamenv/lib/python3.10/site-packages/apache_beam/runners/portability/portable_runner.py", line 569, in wait_until_finish
    raise self._runtime_exception
RuntimeError: Pipeline BeamApp-ashu-0418162039-5997b314_38a0dd07-d055-408b-8532-4d5bdbbf6d31 failed in state FAILED: org.apache.pekko.pattern.AskTimeoutException: org.apache.pekko.pattern.AskTimeoutException: Ask timed out on [Actor[pekko.tcp://flink@127.0.1.1:43935/user/rpc/taskmanager_0#-59194869]] after [10000 ms]. Message of type [org.apache.flink.runtime.rpc.messages.RemoteRpcInvocation]. A typical reason for `AskTimeoutException` is that the recipient actor didn't send a reply.
(beamenv) Ubuntu-VM% 
