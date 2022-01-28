package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Modulo de conexao **/
	// Parametros de Conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "rootroot";

	// metodo de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// teste de conexao

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			// abrir conexao com o banco
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os paramentros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, contato.getNome()); // o numero 1 refere-se a primeira interrogacao (?)
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			// abrindo conexao com o banco de dados
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(read);
			// executar a query e salvar resultado na variavel rs
			ResultSet rs = pst.executeQuery();
			// o laco abaixo ira ser executado enquanto houver contatos na tabela
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			// encerrar conexao com o banco
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/
	// selecionar e pegar dados do contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			// abrindo conexao com o banco de dados
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(read2);
			// substituir a ? pelo id selecionado
			pst.setString(1, contato.getIdcon());
			// trazer as informacoes da query para a variavel rs
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variaveis retornadas da query para as variaveis da classe JavaBeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// alterar dados do contato
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome=?,fone=?,email=? where idcon=?";
		try {
			// abrindo conexao com o banco de dados
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
			// substituir interrogacoes pelo conteudo das variaveis do javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**CRUD DELETE**/
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon = ?";
		try {
			//abrir conexao com o banco
			Connection con = conectar();
			//preparar a query para o banco de dados
			PreparedStatement pst = con.prepareStatement(delete);
			//substituindo a interrogacao ? pelo idcon recebido
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
