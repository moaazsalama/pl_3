// StudentDAO.scala
package org.school.app.dao

import org.school.app.Student

import java.sql.{Connection, PreparedStatement, ResultSet}


object StudentDAO {
  def addStudent(student: Student): Unit = {
    val connection: Connection = Database.getConnection
    val query = "INSERT INTO students (id, name, grade) VALUES (?, ?, ?)"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, student.id)
      preparedStatement.setString(2, student.name)
      preparedStatement.setString(3, student.grade)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }

  def removeStudent(studentId: Int): Unit = {
    val connection: Connection = Database.getConnection
    val query = "DELETE FROM students WHERE id = ?"

    try {
      val preparedStatement: PreparedStatement = connection.prepareStatement(query)
      preparedStatement.setInt(1, studentId)
      preparedStatement.executeUpdate()
    } finally {
      connection.close()
    }
  }
}
