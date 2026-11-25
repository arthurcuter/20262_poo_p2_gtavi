package br.com.fatec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO {
    public static boolean cadastrar(Partida p) {
        Connection conexao = null;
        try {
            conexao = ConnectionFactory.obterConexao();

            var sql = "INSERT INTO tb_partida (jogador, pontuacao) VALUES (?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, p.getJogador());
            ps.setInt(2, p.getPontuacao());

            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexao.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static List<Partida> listar() {
        var partidas = new ArrayList<Partida>();
        Connection conexao = null;

        try {
            conexao = ConnectionFactory.obterConexao();
            var sql = "SELECT * FROM tb_partida";
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) { // mapeamento objeto relacional
                var codigo = rs.getInt("codigo");
                var jogador = rs.getString("jogador");
                var pontuacao = rs.getInt("pontuacao");

                var p = Partida.builder()
                        .codigo(codigo).jogador(jogador).pontuacao(pontuacao)
                        .build();
                partidas.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return partidas;
    }

}
