// ExamScheduleDAO.scala
package org.school.app.dao

import java.sql.{Connection, PreparedStatement, ResultSet}
import org.school.app.ExamSchedule

object ExamScheduleDAO {
  def addExamSchedule(examSchedule: ExamSchedule): Unit = {
    val connection: Connection = Database.getConnection
    val query = "INSERT INTO exam_schedules (course_id, date, time) VALUES (?, ?, ?)"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, examSchedule.courseId)
      preparedStatement.setString(2, examSchedule.date)
      preparedStatement.setString(3, examSchedule.time)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }

  def removeExamSchedule(courseId: Int): Unit = {
    val connection: Connection = Database.getConnection
    val query = "DELETE FROM exam_schedules WHERE course_id = ?"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, courseId)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }
}
