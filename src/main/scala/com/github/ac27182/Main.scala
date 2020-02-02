package com.github.ac27182

import com.amazonaws.ClientConfiguration
import com.amazonaws.monitoring.CsmConfigurationProvider
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.metrics.RequestMetricCollector
import com.amazonaws.monitoring.MonitoringListener
import com.amazonaws.regions.Regions
import com.amazonaws.handlers.RequestHandler2
import shapeless.Generic
import shapeless.PolyDefns.Case
import com.amazonaws.services.datapipeline.DataPipelineAsyncClientBuilder
import cats.implicits._
import shapeless._
import com.amazonaws.services.datapipeline.DataPipelineAsync

// import com.amazonaws.services.datapipeline.DataPipeline
// import com.amazonaws.services.datapipeline.DataPipelineAsync
// import com.amazonaws.services.datapipeline.DataPipelineAsyncClientBuilder

object Main {

  case class Foo(
      clientSideMonitoringConfigurationProvider: Option[CsmConfigurationProvider],
      client:                                    Option[ClientConfiguration],
      credentials:                               Option[AWSCredentialsProvider],
      endPointConfiguration:                     Option[EndpointConfiguration],
      metricsCollector:                          Option[RequestMetricCollector],
      monitoringListner:                         Option[MonitoringListener],
      region:                                    Option[Regions],
      requestHandlers:                           Option[RequestHandler2]
  )

  val fooGeneric = Generic[Foo]

  // asyncClientBuilder
  case class DataPipelineAsyncClient(
      clientSideMonitoringConfigurationProvider: Option[CsmConfigurationProvider],
      client:                                    Option[ClientConfiguration],
      credentials:                               Option[AWSCredentialsProvider],
      endPointConfiguration:                     Option[EndpointConfiguration],
      metricsCollector:                          Option[RequestMetricCollector],
      monitoringListner:                         Option[MonitoringListener],
      region:                                    Option[Regions],
      requestHandlers:                           Option[RequestHandler2]
  )

  object DataPipelineAsyncClient {

    // def apply(
    //     clientSideMonitoringConfigurationProvider: Option[CsmConfigurationProvider] = None,
    //     client:                                    Option[ClientConfiguration]      = None,
    //     credentials:                               Option[AWSCredentialsProvider]   = None,
    //     endPointConfiguration:                     Option[EndpointConfiguration]    = None,
    //     metricsCollector:                          Option[RequestMetricCollector]   = None,
    //     monitoringListner:                         Option[MonitoringListener]       = None,
    //     region:                                    Option[Regions]                  = None,
    //     requestHandlers:                           Option[RequestHandler2]          = None
    // ): DataPipelineAsync = {

    //   // we can make this more generic
    //   object customFolder1 extends Poly2 {
    //     implicit val case1: Case.Aux[DataPipelineAsyncClientBuilder, Option[CsmConfigurationProvider], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withClientSideMonitoringConfigurationProvider(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case2: Case.Aux[DataPipelineAsyncClientBuilder, Option[ClientConfiguration], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withClientConfiguration(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case3: Case.Aux[DataPipelineAsyncClientBuilder, Option[AWSCredentialsProvider], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withCredentials(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case4: Case.Aux[DataPipelineAsyncClientBuilder, Option[EndpointConfiguration], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withEndpointConfiguration(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case5: Case.Aux[DataPipelineAsyncClientBuilder, Option[RequestMetricCollector], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withMetricsCollector(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case6: Case.Aux[DataPipelineAsyncClientBuilder, Option[MonitoringListener], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withMonitoringListener(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case7: Case.Aux[DataPipelineAsyncClientBuilder, Option[RequestHandler2], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withRequestHandlers(value)
    //         case None => acc
    //       }
    //     )
    //     implicit val case8: Case.Aux[DataPipelineAsyncClientBuilder, Option[Regions], DataPipelineAsyncClientBuilder] = at((acc, i) =>
    //       i match {
    //         case Some(value) => acc.withRegion(value)
    //         case None => acc
    //       }
    //     )
    //   }

    //   val hList0 =
    //     clientSideMonitoringConfigurationProvider ::
    //       client ::
    //       credentials ::
    //       endPointConfiguration ::
    //       metricsCollector ::
    //       monitoringListner ::
    //       region ::
    //       requestHandlers ::
    //       HNil
    //   val client0 = DataPipelineAsyncClientBuilder.standard()
    //   val client1 = hList0
    //     .foldLeft(client0)(customFolder1)
    //     .build

    //   client1
    // }
  }

  case class GetPipelineDefinitionRequest()
  object GetPipelineDefinitionRequest {}
  // case class Desci

  // val client = DataPipelineAsyncClient().describePipelinesAsync()
}
