// CourseDAO.scala
package org.school.app.dao

import java.sql.{Connection, PreparedStatement, ResultSet}
import org.school.app.Course

object CourseDAO {
  def addCourse(course: Course): Unit = {
    val connection: Connection = Database.getConnection
    val query = "INSERT INTO courses (id, name) VALUES (?, ?)"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, course.id)
      preparedStatement.setString(2, course.name)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }

  def removeCourse(courseId: Int): Unit = {
    val connection: Connection = Database.getConnection
    val query = "DELETE FROM courses WHERE id = ?"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, courseId)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }
}
