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
  * you may need a key for Bing Map, see: https://www.bingmapsportal.com/
  * and put it in the CesiumMS.html.
  */
object CesiumMil extends JSApp {

  implicit def Cartesian3ToConstPosProp(value: Cartesian3): ConstantPositionProperty = new ConstantPositionProperty(value)

  implicit def ValueToConstProp(value: Any): ConstantProperty = new ConstantProperty(value.asInstanceOf[js.Any])


  def main(): Unit = {
    Console.println("---> hello from CesiumMil")

    // launch the Cesium viewer
    val viewer = new Viewer("cesiumContainer", ViewerOptions.
      scene3DOnly(true).
      animation(false).
      timeline(false).
      infoBox(false))

    def addBillboard() = {
      // create a MIL-2525 symbol
      val sym = new Symbol("SFG-UCI----D", SymbolOptions.size(35))

      viewer.entities.add(new Entity(EntityOptions.
        position(Cartesian3.fromDegrees(-75.59777, 40.03883)).
        billboard(new BillboardGraphics(
          BillboardGraphicsOptions.
            image(sym.getMarker().asCanvas()). // <--- the billboard image is the symbol
            show(true).
            scale(2.0).
            rotation(Math.PI / 4.0).
            horizontalOrigin(HorizontalOrigin.CENTER).
            pixelOffset(new Cartesian2(-sym.markerAnchor.x, -sym.markerAnchor.y)).
            verticalOrigin(VerticalOrigin.BOTTOM).
            alignedAxis(Cartesian3.ZERO).
            width(50.0).
            height(25.0)))))
    }

    addBillboard()
  }
}

