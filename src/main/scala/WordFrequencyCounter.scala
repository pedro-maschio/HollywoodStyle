package wfc
import wfapp.WordFrequencyFramework
import datastorage.DataStorage
import scala.collection.mutable.Map
import objects._
class WordFrequencyCounter(wfapp: WordFrequencyFramework, dataStorage: DataStorage) {
  var wordFreqs = Map[String, Int]()

  // Constructor
  val wordObject = new WordObject()
  dataStorage.registerForWordEvent(wordObject)
  val endObject = new EndObject()
  wfapp.registerForEndEvent(endObject)

}