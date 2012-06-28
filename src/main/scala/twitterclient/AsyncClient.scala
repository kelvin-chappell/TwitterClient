/**
 *
 */
package twitterclient

import twitter4j.conf.ConfigurationBuilder
import twitter4j._
import scala.collection.JavaConversions._

/**
 *
 */
object AsyncClient {

  private val LOCK = new Object();

  def main(args: Array[String]) {

    val listener = new TwitterAdapter() {

      override def gotHomeTimeline(statuses: ResponseList[Status]) {
        statuses.toList foreach { status: Status =>
          println(status.getUser.getName + ": " + status.getText)
        }
      }

      override def onException(ex: TwitterException, method: TwitterMethod) {
        ex.printStackTrace
      }

    }

    val twitter = new AsyncTwitterFactory().getInstance
    twitter.addListener(listener)
    val statuses = twitter.getHomeTimeline

    Thread.sleep(5000)
  }

}
