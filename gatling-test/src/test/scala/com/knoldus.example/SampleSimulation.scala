package com.knoldus.example.gatling

import com.knoldus.example.configuration.Configuration._
import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
class SampleSimulation extends Simulation {

  object getMyItenary {
    val scenario = repeat(REPETITION) {
      exec(http("Demo Project")
        .get("/api/hello/:id").check(status.find.in(200))
    }
  }

  val httpConf = http
    .baseURL(BASE_URL)
    .acceptHeader("application/json; charset=utf-8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    
  private def perMinute(rate: Double): Double = rate /  60
  
  setUp(scenario.inject(constantUsersPerSec(perMinute(USERS_PER_MINUTE)) during(DURING_TIME minutes)))
    .protocols(httpConf)
}
