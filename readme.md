# CesiumScala example with ScalaMS 

An example of using [ScalaMS](https://github.com/workingDog/ScalaMS) and [CesiumScala](https://github.com/workingDog/CesiumScala) 

To compile and generate this example **CesiumMil** type:
 
    sbt fastOptJS

This will generate "cesiummil-fastopt.js" in the "./target/scala-2.11" directory.

Put "CesiumMS.html" and "cesiummil-fastopt.js" (and of course [milsymbol.js](https://github.com/spatialillusions/milsymbol)) 
files in the "Cesium/Apps" directory.
 
Launch [Cesium](http://cesiumjs.org/) (node server.js).

Then point your browser to http://localhost:8080/Apps/CesiumMS.html

