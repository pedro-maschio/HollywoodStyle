package wfapp

import objects._
import stopwords._
import datastorage.DataStorage
import wfc.WordFrequencyCounter

class WordFrequencyFramework {
  var loadEventHandler : List[LoadObject] = List()
  var doWorkEventHandler: List[DoWorkObject] = List()
  var endEventHandler: List[EndObject] = List()

  def registerForLoadEvent(handler: LoadObject): Unit = {
    loadEventHandler = loadEventHandler :+ handler
  }

  def registerForDoWorkEvent(handler: DoWorkObject): Unit = {
    doWorkEventHandler = doWorkEventHandler :+ handler
  }

  def registerForEndEvent(handler: EndObject): Unit = {
    endEventHandler = endEventHandler :+ handler
  }

  def run(pathToFile: String, stop : StopWordFilter, data: DataStorage, wordFreqCounter: WordFrequencyCounter): Unit = {
    stop.stopWords = loadEventHandler(0).load()
    data.data = loadEventHandler(1).load(pathToFile)

    doWorkEventHandler(0).produce_words(data.data, stop, data.wordEventHandler, wordFreqCounter.wordFreqs)
    endEventHandler(0).printFreqs(wordFreqCounter.wordFreqs)
  }
}