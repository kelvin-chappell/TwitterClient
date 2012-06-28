/**
 *
 */
package twitterclient

import java.util.Date
import com.novus.salat.dao.SalatDAO
import org.bson.types.ObjectId
import com.mongodb.casbah.MongoCollection

/**
 *
 */
case class Tweet(createdAt: Date, userName: String, text: String)

//object Tweet extends SalatDAO[Tweet, ObjectId](collection = MongoCollection("tweets")) {
object Tweet {

  def persist = {
    //    update(MongoDBObject("_id" -> id), grater[Tweet].asDBObject(tweet))
  }

}
