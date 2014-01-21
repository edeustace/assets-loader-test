import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "assetLoaderTest"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaJpa,
    cache
  )

  val assetsLoader = "com.ee" %% "assets-loader" % "0.11.3"
  val assetsLoaderReleases = "ed eustace" at "http://edeustace.com/repository/releases"

  val main = play.Project(appName, appVersion, appDependencies).settings(
    ebeanEnabled := false,
    sbt.Keys.fork in Test := false,
    resolvers += Resolver.url("My GitHub Play Repository", url("http://branaway.github.com/releases/") ) (Resolver.ivyStylePatterns),
    libraryDependencies += assetsLoader,
    resolvers += assetsLoaderReleases
  )

}
