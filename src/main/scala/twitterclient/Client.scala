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

    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("2L19WvwxwQspIYdZyjYxQ")
      .setOAuthConsumerSecret("tVkClERxjPLecfxu4tPECcjQnrIIMPTAJotWTCp7xU")
      .setOAuthAccessToken("620893056-EZsrKROHgv9eAuIW5Ax3Pcqt5wuisc7i1Qr2x3s")
      .setOAuthAccessTokenSecret("wXK7eybV3bNZlLkNS6kjwDnd2HG0As2gUC12y7oFM")
    val tf = new TwitterFactory(cb.build())
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
