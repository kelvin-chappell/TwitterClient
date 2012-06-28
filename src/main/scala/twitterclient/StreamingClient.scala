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

    val userStreamListener = new UserStreamAdapter() {

      override def onStatus(status: Status) {
        if (status.getInReplyToStatusId == -1) print(" > ")
        println("(%s) (%s) [%s] %s: %s\n" format (status.getInReplyToStatusId, status.getInReplyToUserId, status.getCreatedAt, status.getUser.getName, status.getText))
      }

      override def onRetweet(source: User, target: User, retweetedStatus: Status) {
        println("retweet source: %s, target: %s, status: %s\n" format (source.getName, target.getName, retweetedStatus.getText))
      }

      override def onUserListCreation(listOwner: User, list: UserList) {
        println("created list %s from %s\n" format (list.getFullName, listOwner.getName))
      }

      override def onUserListUpdate(listOwner: User, list: UserList) {
        println("updated list %s from %s\n" format (list.getFullName, listOwner.getName))
      }

      override def onUserListDeletion(listOwner: User, list: UserList) {
        println("deleted list %s from %s\n" format (list.getFullName, listOwner.getName))
      }

      override def onUserListSubscription(subscriber: User, listOwner: User, list: UserList) {
        println("subscribed to %s from %s\n" format (list.getFullName, listOwner.getName))
      }

      override def onUserListUnsubscription(subscriber: User, listOwner: User, list: UserList) {
        println("unsubscribed from %s\n" format (list.getFullName))
      }

      override def onFollow(source: User, followedUser: User) {
        println("%s is following %s\n" format (source.getName, followedUser.getName))
      }

      override def onException(ex: Exception) {
        ex.printStackTrace
      }

    }

    val twitterStream = new TwitterStreamFactory().getInstance
    //    twitterStream.addListener(listener)
    twitterStream.addListener(userStreamListener)
    //    twitterStream.stream
    twitterStream.user

    // TODO: get backlog before streaming

  }

}
