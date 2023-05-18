package com.basejava.webapp.web;

import com.basejava.webapp.Config;
import com.basejava.webapp.model.ContactType;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends HttpServlet {
    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.getConfig().getStorage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer writer = response.getWriter();
        writer.write("<html>\n" +
                "                <body>\n" +
                "                <h2>Resumes Table</h2>\n" +
                "                <table border=\"2\">\n" +
                "                  <tbody>\n" +
                "                    <tr>\n" +
                "                      <th>Uuid</th>\n" +
                "                      <th>Full name</th>\n" +
                "                    </tr>\n");
        for (Resume resume : storage.getAllSorted()) {
            writer.write("<tr>\n" +
                    "                <td><a href=\"resume?uuid=" + resume.getUuid() + "\">" + resume.getFullName() + "</a></td>\n" +
                    "                <td>" + resume.getContact(ContactType.CELLPHONE) + "</td>\n" +
                    "        </tr>\n");
        }
        writer.write("</tbody>\n" +
                "                </table>\n" +
                "                </body>\n" +
                "                </html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
