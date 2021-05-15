package objects
import scala.io.Source
import stopwords.StopWordFilter
import scala.collection.mutable.Map
import scala.util.matching.Regex
import scala.collection.immutable.ListMap

trait LoadEvent {
  def load(filename: String): String
  def load(): List[String]
}

trait DoWorkEvent {
  def produce_words(_data: String, _stopWordFilter: StopWordFilter, wordEventHandler: List[WordObject], map : Map[String, Int]): Unit
}

trait WordEvent {
  def incrementCount(word: String, wordFreqs: Map[String, Int])
}

trait EndWorkEvent {
  def printFreqs(_wordFreqs: Map[String, Int])
}

class LoadObject extends LoadEvent {
  override def load(pathToFile: String): String = {
    var string = Source.fromFile(pathToFile).getLines.mkString
    val pattern = "[^(a-zà-úA-zÀ-Ú)]+".r
    (pattern.replaceAllIn(string, " ")).toLowerCase()
  }
  override def load(): List[String] = {
    val filename = "/home/gustavo/Documents/HollywoodStyle/src/main/scala/stop_words.txt"
    var stopList = Source.fromFile(filename).getLines.toList
    stopList
  }

}

class DoWorkObject extends DoWorkEvent {

  override def produce_words(_data: String, stopWordFilter: StopWordFilter, wordEventHandler: List[WordObject], map : Map[String, Int]) {
    var data_str = _data.mkString
    for(word <- data_str.split(' ')) {
      if(!stopWordFilter.isStopWord(word)) {
        for(handler <- wordEventHandler) {
          handler.incrementCount(word, map)
        }
      }
    }
  }
}

class WordObject extends WordEvent {
  override def incrementCount(word: String, wordFreqs: Map[String, Int]): Unit = {
    if (wordFreqs.contains(word))
      wordFreqs(word) = wordFreqs(word) + 1
    else
      wordFreqs(word) = 1
  }
}

class EndObject extends EndWorkEvent {
  override def printFreqs(wordFreqs: Map[String, Int]) {
    val list = ListMap(wordFreqs.toSeq.sortWith(_._2 > _._2):_*)
    for((word, freq) <- list.take(10)) {
      println(word + " - " + freq)
    }
  }
}