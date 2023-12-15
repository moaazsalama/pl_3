// TeacherActor.scala
package org.school.app.actors

import akka.actor.Actor
import org.school.app.Teacher
import org.school.app.dao.TeacherDAO

class TeacherActor extends Actor {
  var teachers: List[Teacher] = List.empty

  def receive: Receive = {
    case AddTeacher(teacher) =>
      TeacherDAO.addTeacher(teacher)
      teachers = teachers :+ teacher
      sender() ! teachers

    case RemoveTeacher(teacherId) =>
      TeacherDAO.removeTeacher(teacherId)
      teachers = teachers.filterNot(_.id == teacherId)
      sender() ! teachers
  }
}

case class AddTeacher(teacher: Teacher)
case class RemoveTeacher(teacherId: Int)
