package webmatrix;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class ConsultantDAO {
	private String url;
	private String userName;
	private String password;

	public ConsultantDAO() {
		url = "jdbc:mysql://localhost:3306/matrix";
		userName = "java";
		password = "FS0ZEHzh";
		
		// registering the jdbc driver here, your string to use
		// here depends on what driver you are using.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean validate(String email, String password) throws SQLException {
		boolean isValidPassword = false;

		String q = "SELECT validate_password(?, ?)";

		try (Connection connection = DriverManager.getConnection(this.url, this.userName, this.password);
				PreparedStatement p = connection.prepareStatement(q)) {
			p.setString(1, email);
			p.setString(2, password);

			try (ResultSet rs = p.executeQuery()) {
				while (rs.next()) {
					isValidPassword = rs.getBoolean(1);
				}
			}
		}
		return isValidPassword;
	}

	public Consultant getConsultant(String email) throws SQLException {
		Consultant consultant = new Consultant();

		String q = "SELECT Nom, Prenom, Commentaire, must_change_password "
				+ "FROM Consultant "
				+ "where email = ?";

		try (Connection connection = DriverManager.getConnection(this.url, this.userName, this.password);
				PreparedStatement p = connection.prepareStatement(q)) {
			p.setString(1, email);

			// execute the query, and get a java resultset
			try (ResultSet rs = p.executeQuery()) {

				// iterate through the java resultset
				while (rs.next()) {
					consultant.setNom(rs.getString("Nom"));
					consultant.setPrenom(rs.getString("Prenom"));
					consultant.setCommentaire(rs.getString("Commentaire"));
					consultant.setEmail(email);
					consultant.setIsChangePassword(rs.getBoolean("must_change_password"));
				}
			}
		}

		return consultant;
	}

	public void insertConsultant(Consultant consultant) throws SQLException {
		String q = "{CALL create_consultant(?,?,?,?,?)}";

		try (Connection connection = DriverManager.getConnection(this.url, this.userName, this.password);
				CallableStatement callable = connection.prepareCall(q);) {
			callable.setString(1, consultant.getNom());
			callable.setString(2, consultant.getPrenom());
			callable.setString(3, consultant.getEmail());
			callable.setString(4, consultant.getPassword());

			ResultSet rs = callable.executeQuery();
			consultant.setSetConsultantId(callable.getInt(5)); // index-based
		}
	}

	public boolean changePassword(String email, String oldPassword, String newPassword) throws SQLException, SQLSyntaxErrorException {
		String q = "{CALL change_password(?,?,?,?)}";

		try (Connection connection = DriverManager.getConnection(this.url, this.userName, this.password);
				CallableStatement callable = connection.prepareCall(q);
				) {
			callable.setString(1, email);
			callable.setString(2, oldPassword);
			callable.setString(3, newPassword);
			callable.executeQuery();
			return callable.getBoolean(4); // index-based
		}
	}
}
