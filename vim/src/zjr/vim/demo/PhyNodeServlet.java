package zjr.vim.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zjr.vim.staticData.ThreadData;
import zjr.vim.thread.PhyNodeThread;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "PhyNodeServlet", urlPatterns = {"/phyNodeData"})
public class PhyNodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        JSONArray phyNodeData = ThreadData.phyNodeThread.getPhyNodeData();
        System.out.println(phyNodeData);
        ThreadData.phyNodeThread.phyNodeFlag = true;
        String phyNodeJson = phyNodeData.toString();
        OutputStream out = response.getOutputStream();
        out.write(phyNodeJson.getBytes("UTF-8"));
        out.flush();
    }
}
