// TeacherDAO.scala
package org.school.app.dao

import java.sql.{Connection, PreparedStatement, ResultSet}
import org.school.app.Teacher

object TeacherDAO {
  def addTeacher(teacher: Teacher): Unit = {
    val connection: Connection = Database.getConnection
    val query = "INSERT INTO teachers (id, name, subject) VALUES (?, ?, ?)"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, teacher.id)
      preparedStatement.setString(2, teacher.name)
      preparedStatement.setString(3, teacher.subject)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }

  def removeTeacher(teacherId: Int): Unit = {
    val connection: Connection = Database.getConnection
    val query = "DELETE FROM teachers WHERE id = ?"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, teacherId)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }
}
