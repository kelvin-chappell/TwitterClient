/**
 *
 */
package twitterclient

import twitter4j._

/**
 *
 */
object StreamingClient {

  def main(args: Array[String]) {

    val listener = new StatusAdapter() {

      override def onStatus(status: Status) {
        println(status.getUser.getName + ": " + status.getText)
      }

      override def onDeletionNotice(notice: StatusDeletionNotice) {}

      override def onTrackLimitationNotice(num: Int) {}

      override def onException(ex: Exception) {
        ex.printStackTrace
      }

    }

    val twitterStream = new TwitterStreamFactory().getInstance
    twitterStream.addListener(listener)
    twitterStream.sample

  }

}
