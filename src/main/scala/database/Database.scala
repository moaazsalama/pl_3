// Database.scala
package org.school.app.dao

import java.sql.{Connection, DriverManager}

object Database {
  private val url = "jdbc:mysql://localhost:8889/school_management"
  private val driver = "com.mysql.cj.jdbc.Driver"
  private val username = "root"
  private val password = "root"

  // Establish a database connection
  def getConnection: Connection = {
    Class.forName(driver)
    DriverManager.getConnection(url, username, password)
  }
}
