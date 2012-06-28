resolvers += "repo.novus snaps" at "http://repo.novus.com/snapshots/"

libraryDependencies ++= Seq(
    "org.twitter4j" % "twitter4j-core" % "2.2.5",
    "org.twitter4j" % "twitter4j-async" % "2.2.5",
    "org.twitter4j" % "twitter4j-stream" % "2.2.5",
    "ch.qos.logback" % "logback-classic" % "1.0.3",
    "com.codahale" %% "jerkson" % "0.5.0",
    "se.radley" %% "play-plugins-salat" % "1.0.4",
    "com.novus" %% "salat-core" % "0.0.8-SNAPSHOT"
)
