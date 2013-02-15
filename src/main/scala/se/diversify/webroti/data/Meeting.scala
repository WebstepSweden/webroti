package se.diversify.webroti.data

import java.util.UUID
import reflect.BeanProperty
import collection.mutable.ListBuffer
import scala.collection.JavaConversions._

/** A meeting */
class Meeting {

  @BeanProperty
  val id = UUID.randomUUID().toString

  private val votes = new ListBuffer[Vote]()

  /**
   * Get the list of votes for this meeting
   * @return the list of votes for this meeting
   */
  def getVotes: java.util.List[Vote] = votes

  /**
   * Add a vote for this meeting
   * @param vote the new vote to add
   */
  def addVote(vote: Vote) {
    votes += vote
  }
}
