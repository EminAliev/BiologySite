package servlets;

import models.Theme;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import services.ThemeService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AjaxServlet")
public class AjaxServlet extends HttpServlet {
    private ThemeService service = new ThemeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Theme> themes = service.listThemes();

        JSONArray ja = new JSONArray();
        for (Theme theme: themes) {
            ja.put(new JSONObject(theme));
        }
        JSONObject jo = new JSONObject();
        try {
            jo.put("objects", ja);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        response.setContentType("text/json");
        response.getWriter().write(jo.toString());

    }
}
