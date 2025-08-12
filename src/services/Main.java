package services;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

class User {
	private int id;
	private String nome;
	private String email;

	public User(int id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {

		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

		server.createContext("/users", new UsersHandler());
		server.setExecutor(null);
		server.start();

		System.out.println("http://localhost:8080/users");
	}

	//
	static class UsersHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {

			List<User> users = new ArrayList<>();
			users.add(new User(1, "Usuario", "Usuario@email.com"));
			users.add(new User(2, "Usuario", "Usuarion@email.com"));
			users.add(new User(3, "Usuario", "Usuario@email.com"));
			users.add(new User(4, "Usuario", "Usuario@email.com"));

			StringBuilder jsonBuilder = new StringBuilder();
			jsonBuilder.append("[");
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				jsonBuilder.append("{");
				jsonBuilder.append("\"id\": ").append(user.getId()).append(",");
				jsonBuilder.append("\"nome\": \"").append(user.getNome()).append("\",");
				jsonBuilder.append("\"email\": \"").append(user.getEmail()).append("\"");
				jsonBuilder.append("}");
				if (i < users.size() - 1) {
					jsonBuilder.append(",");
				}
			}
			jsonBuilder.append("]");

			String jsonResponse = jsonBuilder.toString();

			exchange.getResponseHeaders().set("Content-Type", "application/json");

			exchange.sendResponseHeaders(200, jsonResponse.length());

			OutputStream os = exchange.getResponseBody();
			os.write(jsonResponse.getBytes());
			os.close();
		}
	}
}
