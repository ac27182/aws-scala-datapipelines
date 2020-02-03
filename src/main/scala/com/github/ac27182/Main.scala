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
import com.amazonaws.services.datapipeline.DataPipelineAsync
import com.amazonaws.monitoring.CsmConfigurationProviderChain
import scala.reflect.{ClassTag, classTag}

import cats.implicits._
import shapeless._
import shapeless.ops.hlist._

object Main {

  case class TestClient(
      clientSideMonitoringConfigurationProvider: Option[CsmConfigurationProvider],
      client:                                    Option[ClientConfiguration],
      credentials:                               Option[AWSCredentialsProvider],
      endPointConfiguration:                     Option[EndpointConfiguration],
      metricsCollector:                          Option[RequestMetricCollector],
      monitoringListner:                         Option[MonitoringListener],
      region:                                    Option[Regions],
      requestHandlers:                           Option[RequestHandler2]
  )
  object TestClient {

    def apply(
        clientSideMonitoringConfigurationProvider: Option[CsmConfigurationProvider] = None,
        client:                                    Option[ClientConfiguration]      = None,
        credentials:                               Option[AWSCredentialsProvider]   = None,
        endPointConfiguration:                     Option[EndpointConfiguration]    = None,
        metricsCollector:                          Option[RequestMetricCollector]   = None,
        monitoringListner:                         Option[MonitoringListener]       = None,
        region:                                    Option[Regions]                  = None,
        requestHandlers:                           Option[RequestHandler2]          = None
    ): DataPipelineAsync = {

      val hList0 =
        clientSideMonitoringConfigurationProvider ::
          client ::
          credentials ::
          endPointConfiguration ::
          metricsCollector ::
          monitoringListner ::
          region ::
          requestHandlers ::
          HNil

      val dpClient = DataPipelineAsyncClientBuilder.standard()

      object customFolder extends Poly2 {

        // we can make this more generic
        // perhaps this is the right tact...
        // implicit def omniCase[
        //     A <: CsmConfigurationProvider,
        //     ClientConfiguration,
        //     AWSCredentialsProvider,
        //     EndpointConfiguration,
        //     RequestMetricCollector,
        //     MonitoringListener,
        //     Regions,
        //     RequestHandler2
        // ]: Case.Aux[DataPipelineAsyncClientBuilder, Option[A], DataPipelineAsyncClientBuilder] = {
        //   at((acc, v) =>
        //     v match {
        //       case Some(value) =>
        //         value match {
        //           case e: CsmConfigurationProvider => acc.withClientSideMonitoringConfigurationProvider(value)
        //           // problems with erasure
        //           // case e: ClientConfiguration => acc.withClientConfiguration(value)
        //         }
        //       case None => acc
        //     }
        //   )
        // }

        // boiler plate, can we condense this?
        implicit val case1: Case.Aux[DataPipelineAsyncClientBuilder, Option[CsmConfigurationProvider], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withClientSideMonitoringConfigurationProvider(value)
            case None => acc
          }
        )
        implicit val case2: Case.Aux[DataPipelineAsyncClientBuilder, Option[ClientConfiguration], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withClientConfiguration(value)
            case None => acc
          }
        )
        implicit val case3: Case.Aux[DataPipelineAsyncClientBuilder, Option[AWSCredentialsProvider], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withCredentials(value)
            case None => acc
          }
        )
        implicit val case4: Case.Aux[DataPipelineAsyncClientBuilder, Option[EndpointConfiguration], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withEndpointConfiguration(value)
            case None => acc
          }
        )
        implicit val case5: Case.Aux[DataPipelineAsyncClientBuilder, Option[RequestMetricCollector], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withMetricsCollector(value)
            case None => acc
          }
        )
        implicit val case6: Case.Aux[DataPipelineAsyncClientBuilder, Option[MonitoringListener], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withMonitoringListener(value)
            case None => acc
          }
        )
        implicit val case7: Case.Aux[DataPipelineAsyncClientBuilder, Option[RequestHandler2], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withRequestHandlers(value)
            case None => acc
          }
        )
        implicit val case8: Case.Aux[DataPipelineAsyncClientBuilder, Option[Regions], DataPipelineAsyncClientBuilder] = at((acc, i) =>
          i match {
            case Some(value) => acc.withRegion(value)
            case None => acc
          }
        )
      }

      hList0
        .foldLeft(dpClient)(customFolder)
        .build
    }
  }

  val client = TestClient()
}
