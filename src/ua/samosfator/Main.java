package ua.samosfator;

import ua.samosfator.stat.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String html = "<table style=\"width: 100%;\">";

        html += "<tr>";

        html += "<td>";
        html += "Ім’я";
        html += "</td>";

        html += "<td>";
        html += "Правки";
        html += "</td>";

        html += "<td>";
        html += "Бізнес-об’єкти";
        html += "</td>";

        html += "<td>";
        html += "POI";
        html += "</td>";

        html += "<td>";
        html += "Можливий приз";
        html += "</td>";

        html += "<td>";
        html += "Дата поч.";
        html += "</td>";

        html += "<td>";
        html += "Ост. оновл.";
        html += "</td>";

        html += "</tr>";

        for (User user : History.users) {
            html += "<tr>";

            html += "<td>";
            html += "<a href=\"https://www.google.com/mapmaker?gw=66&uid=" + user.getUid() + "\">" + user.getName() + "</a>";
            html += "</td>";

            html += "<td>";
            html += user.getStatistic()
                    .getLastStatsSnapshot()
                    .getTimePeriodStats()
                    .getTotalEdits()
                    -
                    user.getStatistic()
                            .getFirstStatsSnapshot()
                            .getTimePeriodStats()
                            .getTotalEdits();
            html += "</td>";

            html += "<td>";
            html += user.getStatistic()
                    .getLastStatsSnapshot()
                    .getDashboardStats()
                    .getBusinessListings()
                    -
                    user.getStatistic()
                            .getFirstStatsSnapshot()
                            .getDashboardStats()
                            .getBusinessListings();
            html += "</td>";

            html += "<td>";
            html += user.getStatistic()
                    .getLastStatsSnapshot()
                    .getDashboardStats()
                    .getPoi()
                    -
                    user.getStatistic()
                            .getFirstStatsSnapshot()
                            .getDashboardStats()
                            .getPoi();
            html += "</td>";

            html += "<td>";
            html += user.pretendsOnTShirt() ? "Футболка" : "";
            html += user.pretendsOnHoody() ? "Кофта" : "";
            html += "</td>";

            html += "<td>";
            html += user.getStatistic()
                    .getFirstStatsSnapshot()
                    .getUpdateTime();
            html += "</td>";

            html += "<td>";
            html += user.getStatistic()
                    .getLastStatsSnapshot()
                    .getUpdateTime();
            html += "</td>";

            html += "</tr>";
        }

        html += "</table>";

        resp.getWriter().println(html);
    }
}
