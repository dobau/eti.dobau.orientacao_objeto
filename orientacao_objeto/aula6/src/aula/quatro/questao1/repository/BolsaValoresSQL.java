package aula.quatro.questao1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aula.quatro.questao1.exception.AcaoNotFoundException;
import aula.quatro.questao1.exception.RepositoryNotFoundException;
import aula.quatro.questao1.exception.TypeAcaoException;
import aula.quatro.questao1.factory.AcaoFactory;
import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.model.AcaoON;
import aula.quatro.questao1.model.AcaoPNA;
import aula.quatro.questao1.model.AcaoPNB;
import aula.quatro.questao1.model.AcaoType;
import aula.quatro.questao1.model.Status;

public class BolsaValoresSQL implements Repository {

	private Connection con;
	private String url = "jdbc:derby:bolsa;create=true";
	
	private final static String COLUMNS = "codigo, descricao, valorCompra, valorVenda, status, dividendo, voto, tipo";
	
	public BolsaValoresSQL() throws Exception {
		createConnection();
		createTables();
	}

	private void createTables() throws SQLException {
		Statement stmt = con.createStatement();
		if (!existsTable()) {
			stmt.execute("create table ACAO(codigo varchar(10), descricao varchar(255), valorCompra double, valorVenda double, status varchar(50), dividendo double, voto int, tipo varchar(50))");
		}
		stmt.close();
	}

	private boolean existsTable() {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("SELECT * FROM ( SELECT ROW_NUMBER() OVER() AS rownum, ACAO.* FROM ACAO ) AS tmp WHERE rownum <= 1");
			stmt.close();
			return true;
		} catch(SQLException e) {
			return false;
		}
	}

	private void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con = DriverManager.getConnection(url);
	}

	@Override
	protected void finalize() throws Throwable {
		dropTables();
		con.close();
		DriverManager.getConnection("jdbc:derby:bolsa;shutdown=true");
	}

	private void dropTables() throws SQLException {
		Statement stmt = con.createStatement();
		stmt.execute("drop table bolsa");
		stmt.close();
	}

	@Override
	public void add(Acao acao) {
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO ACAO(" + COLUMNS + ") VALUES(?,?,?,?,?,?,?,?)");
			fillDatas(pstmt, acao);
			
			if (acao instanceof AcaoON) {
				pstmt.setBoolean(7, ((AcaoON)acao).getResultadoVoto());
			}
			
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void fillDatas(PreparedStatement pstmt, Acao acao) throws SQLException {
		pstmt.setString(1, acao.getCodigo());
		pstmt.setString(2, acao.getDescricao());
		pstmt.setDouble(3, acao.getValorCompra());
		pstmt.setDouble(4, acao.getValorVenda());
		pstmt.setString(5, acao.getStatus().name());
		pstmt.setDouble(6, 0.0);
		pstmt.setBoolean(7, Boolean.FALSE);
		pstmt.setString(8, getTipo(acao).name());
	}

	@Override
	public void addPerToAll(Double per) {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE FROM ACAO SET valorVenda = (valorVenda * ?) / 100");
			pstmt.setDouble(1, per);

			pstmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Acao find(String codigo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT "+ COLUMNS +" FROM ACAO WHERE codigo = ?");
			pstmt.setString(1, codigo);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rsToAcao(rs);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	public List<Acao> getAll() {
		PreparedStatement pstmt = null;
		List<Acao> lista = new ArrayList<Acao>();
		try {
			pstmt = con.prepareStatement("SELECT "+ COLUMNS +" FROM ACAO");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lista.add(rsToAcao(rs));
			}
			
			rs.close();
			pstmt.close();

			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int remove(Acao acao) {
		return remove(acao.getCodigo());
	}

	@Override
	public int remove(String codigo) {
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM ACAO WHERE codigo = ?");
			pstmt.setString(1, codigo);

			int qtd = pstmt.executeUpdate();
			pstmt.close();
			
			return qtd;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private Acao rsToAcao(ResultSet rs) throws SQLException, RepositoryNotFoundException {
		String tipo = rs.getString("tipo");

		Acao acao = AcaoFactory.criaAcao(AcaoType.valueOf(tipo));
		acao.setCodigo(rs.getString("codigo"));
		acao.setDescricao(rs.getString("descricao"));
		acao.setValorCompra(rs.getDouble("valorCompra"));
		acao.setValorVenda(rs.getDouble("valorVenda"));
		acao.setStatus(rs.getString("status"));
		
		adicionaValoresExtras(acao, rs);

		return acao;
	}

	private void adicionaValoresExtras(Acao acao, ResultSet rs) {
	}

	private void adicionaValoresExtras(AcaoON acao, ResultSet rs) throws SQLException {
		acao.votar(rs.getBoolean("voto"));
	}

	private void adicionaValoresExtras(AcaoPNA acao, ResultSet rs) throws SQLException {
	}

	private void adicionaValoresExtras(AcaoPNB acao, ResultSet rs) throws SQLException {
		acao.atualizarDividendo(rs.getDouble("dividendo"));
	}

	@Override
	public void alterarDividendo(Double valor) {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE ACAO SET dividendo = ? WHERE tipo = ?");
			pstmt.setDouble(1, valor);
			pstmt.setString(2, AcaoType.ON.name());
	
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarValorVenda(String codigo, Double valorVenda)
			throws AcaoNotFoundException {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE ACAO SET valorVenda = ? WHERE codigo = ?");
			pstmt.setDouble(1, valorVenda);
			pstmt.setString(2, codigo);
	
			int qtd = pstmt.executeUpdate();
			if (qtd == 0) {
				throw new AcaoNotFoundException(codigo);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void comprarAcao(String codigo) throws AcaoNotFoundException {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE ACAO SET status = ?, valorCompra = valorVenda, valorVenda = 0.0 WHERE codigo = ?");
			pstmt.setString(1, Status.INDISPONIVEL.name());
			pstmt.setString(2,codigo);

			int qtd = pstmt.executeUpdate();
			if (qtd == 0) {
				throw new AcaoNotFoundException(codigo);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void disponibilizarVenda(String codigo, Double valorVenda)
	throws AcaoNotFoundException {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE ACAO SET status = ?, valorCompra = valorVenda, valorVenda = 0.0 WHERE codigo = ?");
			pstmt.setString(1, Status.INDISPONIVEL.name());
			pstmt.setString(2,codigo);
			
			int qtd = pstmt.executeUpdate();
			if (qtd == 0) {
				throw new AcaoNotFoundException(codigo);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void disponibilizarVenda(Acao acao, Double valorVenda)
			throws AcaoNotFoundException {
		disponibilizarVenda(acao.getCodigo(), valorVenda);
	}

	@Override
	public void realizarInvestimento(String codigo)
			throws AcaoNotFoundException, TypeAcaoException {
		
		try {
			Acao acao = find(codigo);
			if (acao != null) {
				
				if (acao instanceof AcaoPNA) {
					AcaoPNA acaoPN = (AcaoPNA) acao;
					
					Double valorVenda = acaoPN.getValorVenda();
					Double valorCompra = acaoPN.getValorCompra();
					
					// Lucro de compra é 10% do valor de compra da ação
					Double valorLucro = (valorCompra * 10/100) + valorCompra;
					
					if (valorVenda > valorLucro) {
						disponibilizarVenda(acao, valorVenda);
					} else {
						disponibilizarVenda(acao, valorLucro);
					}
				} else if (acao instanceof AcaoPNB) {
					AcaoPNB acaoPN = (AcaoPNB) acao;
					disponibilizarVenda(acaoPN, AcaoPNB.getDividendo());
				}
			} else {
				throw new AcaoNotFoundException(codigo);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void votar(String codigo, Boolean voto)
			throws AcaoNotFoundException, TypeAcaoException {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE ACAO SET voto = ? WHERE codigo = ? and tipo = ?");
			pstmt.setBoolean(1, voto);
			pstmt.setString(2, codigo);
			pstmt.setString(3, AcaoType.ON.name());
	
			int qtd = pstmt.executeUpdate();
			if (qtd == 0) {
				throw new AcaoNotFoundException(codigo);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private AcaoType getTipo(Acao acao) {
		if (acao instanceof AcaoON) {
			return AcaoType.ON;
		} else if (acao instanceof AcaoPNA) {
			return AcaoType.PNA;
		} else if (acao instanceof AcaoPNB) {
			return AcaoType.PNB;
		}

		return null;
	}

}
