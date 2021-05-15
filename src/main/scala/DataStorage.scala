package datastorage

import stopwords.StopWordFilter
import wfapp.WordFrequencyFramework
import objects._

class DataStorage(wfapp: WordFrequencyFramework, _stopWordFilter: StopWordFilter) {
  var data : String = _
  var stopWordFilter : StopWordFilter = _
  var wordEventHandler : List[WordObject] = List()

  // Constructor
  stopWordFilter = _stopWordFilter
  val loadObject = new LoadObject()
  val doWorkObject = new DoWorkObject()
  wfapp.registerForLoadEvent(loadObject)
  wfapp.registerForDoWorkEvent(doWorkObject)

  def registerForWordEvent(handler: WordObject): Unit = {
    wordEventHandler = wordEventHandler :+ handler
  }
}