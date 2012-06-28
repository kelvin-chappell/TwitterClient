/**
 *
 */
package twitterclient

import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterFactory

/**
 *
 */
object Client {

  def main(args: Array[String]) {

    val tf = new TwitterFactory()
    val twitter = tf.getInstance()

    val statuses = twitter.getHomeTimeline
    println("Showing timeline")
    val it = statuses.iterator()
    while (it.hasNext()) {
      val status = it.next()
      println(status.getUser().getName() + ":" +
        status.getText());
    }

  }

}
