package se.diversify.webroti.data

import collection.mutable.HashMap

/**A Repository of meetings */
object Repository {

  private val meetings = HashMap[String, Meeting]()

  /**
   * Create a new meeting
   * @return a new meeting
   */
  def createMeeting: Meeting = {
    val meeting = new Meeting
    meetings += (meeting.getId -> meeting)
    meeting
  }

  /**
   * Get a meeting given an id, or throws a IllegalArgumentException if the meeting was not found
   * @param id the id of the searched meeting
   * @return the meeting with the given id
   */
  def getMeeting(id: String): Meeting = meetings.getOrElse(id,
    throw new IllegalArgumentException("Meeting with id " + id + " can not be found"))
}

class Repository

