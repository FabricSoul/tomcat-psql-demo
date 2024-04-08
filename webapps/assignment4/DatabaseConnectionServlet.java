// MIT License

// Copyright (c) 2024 FabricSoul

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE. 

package webapps.assignment4;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class DatabaseConnectionServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        final String url = "jdbc:postgresql://db:5432/assignment4";
        final String user = "fabric";
        final String password = "1";
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            getServletContext().setAttribute("conn", conn);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Error connecting to the database", e);
        }
    }

    @Override
    public void destroy() {
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}