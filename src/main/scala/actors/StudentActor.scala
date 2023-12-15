// StudentActor.scala
package org.school.app.actors
import akka.actor.Actor
import org.school.app.Student
import org.school.app.dao.StudentDAO
class StudentActor extends Actor {

  var students: List[Student] = List.empty
  val studentDAO =  StudentDAO
  def receive: Receive = {
    case AddStudent(student) =>
      studentDAO.addStudent(  student)

      students = students :+ student
      sender() ! students

    case RemoveStudent(studentId) =>
      studentDAO.removeStudent(studentId)
      students = students.filterNot(_.id == studentId)
      sender() ! students
  }
}

case class AddStudent(student: Student)
case class RemoveStudent(studentId: Int)
