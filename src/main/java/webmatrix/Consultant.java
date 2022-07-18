package webmatrix;

public class Consultant {
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String commentaire;
	private int consultantId;
	private boolean isChangePassword;

	public boolean getIsChangePassword() {
		return isChangePassword;
	}

	public void setIsChangePassword(boolean isChangePassword) {
		this.isChangePassword = isChangePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Consultant [email=" + email + ", password=" + password + ", Nom=" + nom + ", Prenom=" + prenom
				+ ", Commentaire=" + commentaire + "]";
	}

	public int getSetConsultantId() {
		return consultantId;
	}

	public void setSetConsultantId(int setConsultantId) {
		this.consultantId = setConsultantId;
	}
}
