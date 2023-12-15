// ExamScheduleActor.scala
package org.school.app.actors

import akka.actor.Actor
import org.school.app.ExamSchedule
import org.school.app.dao.ExamScheduleDAO

class ExamScheduleActor extends Actor {
  var examSchedules: List[ExamSchedule] = List.empty

  def receive: Receive = {
    case AddExamSchedule(examSchedule) =>
      ExamScheduleDAO.addExamSchedule(examSchedule)
      examSchedules = examSchedules :+ examSchedule
      sender() ! examSchedules

    case RemoveExamSchedule(courseId) =>
      ExamScheduleDAO.removeExamSchedule(courseId)
      examSchedules = examSchedules.filterNot(_.courseId == courseId)
      sender() ! examSchedules
  }
}

case class AddExamSchedule(examSchedule: ExamSchedule)
case class RemoveExamSchedule(courseId: Int)
