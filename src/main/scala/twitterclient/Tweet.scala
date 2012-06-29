/**
 *
 */
package twitterclient

import java.util.Date
import com.novus.salat.dao.SalatDAO
import com.novus.salat._
import org.bson.types.ObjectId
import play.api.Play.current
import se.radley.plugin.salat._
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoCollection

/**
 *
 */
case class Tweet(id: ObjectId = new ObjectId, tweetId: Long, createdAt: Date, userName: String, text: String)

object TweetDao extends SalatDAO[Tweet, ObjectId](collection = mongoCollection("tweets")) {}
