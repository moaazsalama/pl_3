// CourseActor.scala
package org.school.app.actors

import akka.actor.Actor
import org.school.app.Course
import org.school.app.dao.CourseDAO

class CourseActor extends Actor {

  var courses: List[Course] = List.empty

  def receive: Receive = {
    case AddCourse(course) =>
      CourseDAO.addCourse(course)

      courses = courses :+ course
      sender() ! courses

    case RemoveCourse(courseId) =>
      CourseDAO.removeCourse(courseId)
      courses = courses.filterNot(_.id == courseId)
      sender() ! courses
  }
}

case class AddCourse(course: Course)
case class RemoveCourse(courseId: Int)
