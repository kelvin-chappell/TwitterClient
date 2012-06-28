/**
 *
 */
package twitterclient

import scala.collection.JavaConversions._
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterFactory

/**
 *
 */
object Client {

  def main(args: Array[String]) {
    val twitter = new TwitterFactory().getInstance
    val statuses = twitter.getHomeTimeline.toList
    statuses foreach { status =>
      println(status.getUser.getName + ": " + status.getText)
    }
  }

}
