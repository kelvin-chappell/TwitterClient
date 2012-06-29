resolvers += "repo.novus snaps" at "http://repo.novus.com/snapshots/"

libraryDependencies ++= Seq(
    "org.twitter4j" % "twitter4j-core" % "2.2.5",
    "org.twitter4j" % "twitter4j-async" % "2.2.5",
    "org.twitter4j" % "twitter4j-stream" % "2.2.5",
    "ch.qos.logback" % "logback-classic" % "1.0.3",
    "com.codahale" %% "jerkson" % "0.5.0",
    "com.mongodb.casbah" %% "casbah" % "2.1.5.0"
)
