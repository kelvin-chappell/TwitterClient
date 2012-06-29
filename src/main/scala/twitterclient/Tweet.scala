/**
 *
 */
package twitterclient

import java.util.Date
import org.bson.types.ObjectId
import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON
import com.mongodb.DBCollection
import com.mongodb.DBObject
import com.codahale.jerkson.Json._

/**
 *
 */
case class Tweet(id: ObjectId = new ObjectId, tweetId: Long, createdAt: Date, userName: String, text: String)

object TweetDao {

  def save(tweet: Tweet) {
    // TODO
    val mongoConn = MongoConnection()
    val mongoDb = mongoConn("second-screen")
    val collection = mongoDb.getCollection("tweets")

    val dbObject = JSON
      .parse(generate(tweet))

    dbObject match {
      case o: DBObject => collection.insert(o)
      case _           => throw new ClassCastException
    }

  }
}
