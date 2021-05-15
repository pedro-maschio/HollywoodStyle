package stopwords
import objects._
import wfapp.WordFrequencyFramework

class StopWordFilter(wfapp: WordFrequencyFramework) {
  var stopWords: List[String] = _

  val loadObject = new LoadObject()
  wfapp.registerForLoadEvent(loadObject)

  def isStopWord(word: String): Boolean = {
    stopWords.contains(word)
  }

}