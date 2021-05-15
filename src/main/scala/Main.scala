import wfapp._
import stopwords._
import datastorage.DataStorage
import wfc.WordFrequencyCounter
object Main {
  def main(args: Array[String]) = {
    val wfapp = new WordFrequencyFramework()
    var stop = new StopWordFilter(wfapp)
    var dataStorage = new DataStorage(wfapp, stop)
    var wordFreqCounter = new WordFrequencyCounter(wfapp, dataStorage)
    wfapp.run("/home/gustavo/Documents/HollywoodStyle/src/main/scala/biblia-em-txt.txt", stop, dataStorage, wordFreqCounter)
  }
}