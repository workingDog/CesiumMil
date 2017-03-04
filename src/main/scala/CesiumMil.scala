import cesium._
import cesiumOptions._
import com.kodekutters.ms._
import CesiumImplicits._
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

  implicit def ImageToMaterialPosProp(value: Any): ImageMaterialProperty =
    new ImageMaterialProperty(
      ImageMaterialPropertyOptions.
        image(value).
        transparent(false))


  def main(): Unit = {

    // launch the Cesium viewer
    val viewer = new Viewer("cesiumContainer")

    // if using scala.js-2.11.x
    val options = new SymbolOptions {
      override val size: js.UndefOr[Double] = 80
      override val quantity: js.UndefOr[String] = "200"
      override val staffComments: js.UndefOr[String] = "for reinforcements".toUpperCase
      override val direction: js.UndefOr[Double] = 750 * 360 / 6400
      override val `type`: js.UndefOr[String] = "machine gun"
      override val dtg: js.UndefOr[String] = "30140000ZSEP97"
      override val fill: js.UndefOr[Boolean] = true
      override val location: js.UndefOr[String] = "0900000.0E570306.0N"
      override val outlineWidth: js.UndefOr[Double] = 6
      override val outlineColor: js.UndefOr[String] = "rgb(255,255,0)"
    }

    // if using scala.js-2.12.x
    //    val options = new SymbolOptions {
    //      override val size = 80
    //      override val quantity = "200"
    //      override val staffComments = "for reinforcements".toUpperCase
    //      override val direction = 750 * 360 / 6400
    //      override val `type` = "machine gun"
    //      override val dtg = "30140000ZSEP97"
    //      override val fill = true
    //      override val location = "0900000.0E570306.0N"
    //      override val outlineWidth = 6
    //      override val outlineColor = "rgb(255,255,0)"
    //    }

    // create a MIL-2525 symbol
    val sym = new Symbol("sfgpewrh--mt", options)

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

