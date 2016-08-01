import cesium._
import cesiumOptions._
import com.kodekutters.ms._

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.JSApp

/**
  * a basic example using ScalaMS the Scala.js interface to milsymbol.js with CesiumScala.
  *
  * to compile and generate CesiumMil, type "sbt fastOptJS".
  * This will generate "cesiummil-fastopt.js" in the "./target/scala-2.11" directory.
  * Put "CesiumMS.html" and "cesiummil-fastopt.js" (and of course the milsymbol.js) files in the "Cesium/Apps" directory and
  * launch Cesium (node server.js).
  * Then point your browser to http://localhost:8080/Apps/CesiumMS.html
  *
  * P.S
  * you may need to get a key for Bing Map, see: https://www.bingmapsportal.com/
  * and put it in the CesiumMS.html.
  */
object CesiumMil extends JSApp {

  implicit def Cartesian3ToConstPosProp(value: Cartesian3): ConstantPositionProperty = new ConstantPositionProperty(value)
  implicit def ValueToConstProp(value: Any): ConstantProperty = new ConstantProperty(value.asInstanceOf[js.Any])

  def main(): Unit = {

    // launch the Cesium viewer
    val viewer = new Viewer("cesiumContainer")

    // create a MIL-2525 symbol
    val sym = new Symbol("sfgpewrh--mt", SymbolOptions.
      size(80).
      quantity("200").
      staffComments("for reinforcements".toUpperCase).
      direction(750 * 360 / 6400).
      `type`("machine gun").
      dtg("30140000ZSEP97").
      location("0900000.0E570306.0N"))

    // add a billboard with the symbol as the image
    viewer.entities.add(new Entity(EntityOptions.
      position(Cartesian3.fromDegrees(151.2093, -33.8688)). // Sydney
      billboard(new BillboardGraphics(
      BillboardGraphicsOptions.
        image(sym.getMarker().asCanvas()). // <--- the billboard image is the symbol
        show(true).
        scale(1.2).
        width(240.0).
        height(80.0)))))

  }

}

