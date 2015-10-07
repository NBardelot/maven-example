package web;


import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.HashTime;

@SuppressWarnings("serial")
@WebServlet("/version")
public class VersionServlet extends HttpServlet {
	private Properties props;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		props.load(getServletContext().getResourceAsStream("config.properties"));
		if (Boolean.getBoolean(props.getProperty("inclure.header.version"))) {
			resp.addHeader("x-version", props.getProperty("version"));
		}
		if (Boolean.getBoolean(props.getProperty("inclure.header.hashtime"))) {
			resp.addHeader("x-hashtime", new HashTime().hashTime());
		}
	}

}
